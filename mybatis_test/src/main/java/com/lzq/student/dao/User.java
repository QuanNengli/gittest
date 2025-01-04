package com.lzq.student.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import java.util.Date;
@Repository
public class User {
    private Date birth;

    @Override
    public String toString() {
        return "User{" +
                "birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    private static final Logger logger= LoggerFactory.getLogger(User.class);
    public User() {
    }

    public void insert(){
        //System.out.println("正在向数据库插入数据");
        logger.info("user的insert方法正在执行");
    }
}
