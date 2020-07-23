package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/response")
public class ResponseController {
   @RequestMapping("/testReturnString")
   public String testReturnString(Model model){
        System.out.println("testReturnString");
       User user = new User();
       user.setUsername("lisi");
       user.setAge("22");
       model.addAttribute("user",user);
       return "resp";
    }

    @RequestMapping("/testReturnVoid")
    public void testReturnVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testReturnVoid");
        //请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/resp.jsp").forward(request,response);
        //重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        return;
    }

    @RequestMapping("/testReturnModelAndView")
    public ModelAndView testReturnModelAndView(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("wangwei");
        user.setAge("22");
        mv.addObject("user",user);
        mv.setViewName("resp");
        return mv;
    }

    @RequestMapping("/testRedirectAndDispatcher")
    public String testRedirectAndDispatcher(){
        System.out.println("testRedirectAndDispatcher");
//        return "forward:/WEB-INF/pages/resp.jsp";
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testJson")
    public @ResponseBody User testJson(@RequestBody User user){
        System.out.println("response/testJson");
        user.setUsername("wangyuanyuan");
        user.setAge("30");
        return user;
    }

}
