package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/param")
public class ParamController {
    @RequestMapping("/testParam")
    public String testParams(String username,String age){
        System.out.println(username+"----"+age);
        return "success";
    }

    @RequestMapping("/testDomainParam")
    public String testDomainParams(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/testCollectionParam")
    public String testCollectionParams(Account account){
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/testUser")
    public String testUser(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServletApi")
    public String testServletApi(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }
}
