package com.lzq.springmvc.controller;

import com.lzq.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RESTFullController {
    @RequestMapping(value = "/api/user/{id}" ,method = RequestMethod.DELETE)
    public String testDelete(@PathVariable("id") Integer id){
        System.out.println("根据id进行删除用户id是："+id);
        return "ok";
    }
    @RequestMapping(value = "/api/user",method = RequestMethod.PUT)
    public String testPut(User user){
        System.out.println("正在修改用户信息。。。"+user);
        return "ok";
    }
    @RequestMapping(value = "/api/user",method = RequestMethod.POST)
    public String testPost(User user){
        System.out.println("正在保存用户信息。。。"+user);
        return "ok";
    }
    @RequestMapping(value = "/api/user/{id}" ,method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id){
        System.out.println("根据用户id查询信息，用户id是："+id);
        return "ok";
    }
}
