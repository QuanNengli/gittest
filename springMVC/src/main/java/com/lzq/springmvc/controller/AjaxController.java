//package com.lzq.springmvc.controller;
//
//import com.lzq.springmvc.bean.User;
//import com.sun.deploy.net.HttpResponse;
//import org.springframework.http.HttpRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
//@Controller
//public class AjaxController {
//    @RequestMapping(value = "/ajax",method = RequestMethod.POST)
//    @ResponseBody
//    public String ajax(@RequestBody User user){
//        System.out.println(user);
//        return "ok";
//    }
//    @RequestMapping("/hello")
//    @ResponseBody
//    public User hello() {
//        User user=new User(1122L,"zhangsan",1,"zhangsan.qq.com");
//        return user;
//    }
////    @RequestMapping("/hello")
////    public void hello(HttpServletResponse response) throws IOException {
////        PrintWriter out=response.getWriter();
////        out.print("hello ajax");
////    }
//}
