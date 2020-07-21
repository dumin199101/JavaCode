package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value="msg")
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("accept-language") String value){
        System.out.println(value);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute方法执行");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public User showUser(){
        System.out.println("showUser方法执行");
        User user = new User();
        user.setUsername("zhansan");
        user.setAge("22");
        user.setDate(new Date());
        return user;
    }

    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute("user") User user){
        System.out.println("testModelAttribute2方法执行");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser2(Map<String,User> map){
        System.out.println("showUser2方法执行");
        User user = new User();
        user.setUsername("zhansan");
        user.setAge("22");
        user.setDate(new Date());
        map.put("user",user);

    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes");
        model.addAttribute("msg","hello,world");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap model){
        System.out.println("getSessionAttributes");
        String msg = (String) model.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes");
        status.setComplete();
        return "success";
    }
}
