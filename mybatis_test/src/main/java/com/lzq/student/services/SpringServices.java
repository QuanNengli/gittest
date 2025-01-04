package com.lzq.student.services;

import com.lzq.student.dao.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpringServices {
    @Resource(name = "user")
    private User user;

    public SpringServices() {
    }

    public SpringServices(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void saveUser(){
        user.insert();
    }
}
