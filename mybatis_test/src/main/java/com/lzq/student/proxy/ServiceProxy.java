package com.lzq.student.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ServiceProxy {
    public static void main(String[] args) throws InterruptedException {
        //目标对象
        ServiceInterface target=new SumImpl();
        //代理对象
        ServiceInterface o = (ServiceInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimeInvocationHandler(target) {
        });
        //调用代理对象的代理方法
        o.sum(1,2);
    }

}
