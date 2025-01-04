package com.lzq.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@ComponentScan({"com.lzq.springmvc.dao","com.lzq.springmvc.service.impl"})
@PropertySource("classpath:jdbc.properties")
@Import({DataSourceConfig.class,MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
