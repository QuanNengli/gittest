package com.lzq.student.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {
    private Object target;

    public TimeInvocationHandler() {
    }

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin=System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-begin)+"毫秒");
        return invoke;
    }
}
