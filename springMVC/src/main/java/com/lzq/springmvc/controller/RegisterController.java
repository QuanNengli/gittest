package com.lzq.springmvc.controller;

import com.lzq.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = {"session","x"})
public class RegisterController {
    @RequestMapping("/a")
    public String a(){
        //return "forward:/b";
        return "redirect:/b";
    }
    @RequestMapping("/b")
    public String b(){
        return "other";
    }
    @RequestMapping("/testSession")
    public ModelAndView testSession(){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("session","测试使用@sessionAttributes注解共享session域");
        modelAndView.addObject("x","我是x");
        modelAndView.setViewName("ok");

        return modelAndView;
    }
    @RequestMapping("/c")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/register")
    public String ok(User user,
                     @CookieValue(value = "id",required = false,defaultValue = "111")
                     String id)
    {
        System.out.println(user);
        System.out.println(id);
        return "ok";


    }
}
