package com.lzq.springmvc.config;

import com.lzq.springmvc.interceptor.Interceptor1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;


import java.util.List;
import java.util.Properties;

//指定该类是个配置类，可以当配置文件使用
@Configuration
@ComponentScan({"com.lzq.springmvc.controller","com.lzq.springmvc.dao"})
//开启注解驱动
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    //配置视图解析器
    @Bean
    public ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setOrder(1);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);//缓存 否则无法看到实时的页面数据
        return templateResolver;
    }

    /**
     * 创建模板引擎，并为其注入模板解析器
     *
     * @return SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);//注入模板解析器
        return templateEngine;
    }

    /**
     * 注册thymeleaf视图解析器，并为其注入模板引擎
     *
     * @return ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");//未设置，服务端传到页面上的中文数据将会 => ???
        return viewResolver;
    }
    //开启默认spring处理，静态资源访问
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置异常处理器

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("java.lang.Exception","tip");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        simpleMappingExceptionResolver.setExceptionAttribute("e");
        resolvers.add(simpleMappingExceptionResolver);
    }
    //配置拦截器

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        Interceptor1 interceptor1 = new Interceptor1();
        registry.addInterceptor(interceptor1).addPathPatterns("/**").excludePathPatterns("/test");
    }
    //view-controller

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("ok");
    }
}
