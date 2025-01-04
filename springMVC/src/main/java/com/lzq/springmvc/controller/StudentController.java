package com.lzq.springmvc.controller;

import com.lzq.springmvc.bean.StudentBean;
import com.lzq.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user2")
public class StudentController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    @GetMapping("/{id}")
    public StudentBean selectById(@PathVariable("id") int id) {
        StudentBean studentBean = userService.selectById(id);
        return studentBean;

    }
}
