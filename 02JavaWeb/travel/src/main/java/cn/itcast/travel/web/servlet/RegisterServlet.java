package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registUserServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //验证验证码：
        String captcha = request.getParameter("check");
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        //字符串比较使用equals方法
        if(captcha==null || !checkcode_server.equalsIgnoreCase(captcha)){
            ResultInfo resultInfo = new ResultInfo();
            ObjectMapper mapper = new ObjectMapper();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码错误");
            response.setContentType("application/json;charset=utf-8");
            String json = mapper.writeValueAsString(resultInfo);
            response.getWriter().write(json);
            return;
        }


        //1.获取客户端数据
        Map<String, String[]> map = request.getParameterMap();
        //2.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.Service注册
        UserService userService = new UserServiceImpl();
        boolean flag = userService.registerUser(user);

        //4.返回数据
        ResultInfo resultInfo = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        if(flag){
            resultInfo.setFlag(true);
        }else{
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败");
        }

        response.setContentType("application/json;charset=utf-8");
        String json = mapper.writeValueAsString(resultInfo);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
