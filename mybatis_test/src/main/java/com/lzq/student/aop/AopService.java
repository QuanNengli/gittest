package com.lzq.student.aop;


import org.springframework.stereotype.Service;

@Service
public class AopService {
    public void a(){
        System.out.println("我是a方法");
        try{
            throw new RuntimeException("模拟异常发生");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
