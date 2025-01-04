package com.lzq.student.proxy;

public class SumImpl implements ServiceInterface {
    @Override
    public int sum(int a, int b) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(a+b);
        return a+b;
    }
}
