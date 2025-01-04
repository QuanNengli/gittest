package com.lzq.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class FirstController {
    @RequestMapping("/test")
    public String hehe() {
        return "Fist";
    }
    @RequestMapping(value = {"/haha","/hello"},method = RequestMethod.GET,params = {"username","password"})
    public String haha() {
        return "other";
    }
}
