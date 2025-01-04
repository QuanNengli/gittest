package com.lzq.student.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.lzq.student.dao","com.lzq.student.services","com.lzq.student.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class SpringConfig {
}
