package com.lzq;

import com.lzq.student.aop.AopService;
import com.lzq.student.config.SpringConfig;
import com.lzq.student.dao.DateSource;
import com.lzq.student.dao.DateSource2;
import com.lzq.student.dao.User;
import com.lzq.student.mapper.StudentMapper;
import com.lzq.student.pojo.StudentPojo;
import com.lzq.student.services.SpringServices;
import com.lzq.student.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import com.github.pagehelper.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.lang.reflect.Method;
import java.util.List;

public class stuTest {
    @Test
    public void testNoXml(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        AopService aopService = applicationContext.getBean("aopService", AopService.class);
        aopService.a();
    }
    @Test
    public void testAop(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AopService aopService = applicationContext.getBean("aopService", AopService.class);
        aopService.a();
    }
    @Test
    public void testConfig(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringServices springServices = annotationConfigApplicationContext.getBean("springServices", SpringServices.class);
        springServices.saveUser();
    }
    @Test
    public void testMecth(){
        try {
            Class<?> aClass = Class.forName("com.lzq.student.dao.User");
            Method toString = aClass.getMethod("toString");
            Object o = aClass.newInstance();
            Object invoke = toString.invoke(o);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDate(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        User student1 = applicationContext.getBean("student1", User.class);
        System.out.println(student1);
    }
    @Test
    public void testPro(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        StudentPojo pro = applicationContext.getBean("pro", StudentPojo.class);
        System.out.println(pro);
    }
    @Test
    public void testBytype(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        SpringServices byType = applicationContext.getBean("byType", SpringServices.class);
        byType.saveUser();
    }
    @Test
    public void testByname(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        SpringServices byNmae = applicationContext.getBean("byName", SpringServices.class);
        byNmae.saveUser();
    }
    @Test
    public void testUtil(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        DateSource dateSource1 = applicationContext.getBean("dateSource1", DateSource.class);
        System.out.println(dateSource1);
        DateSource2 dateSource2 = applicationContext.getBean("dateSource2", DateSource2.class);
        System.out.println(dateSource2);
    }
    @Test
    public void testPCU(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        StudentPojo stuP = applicationContext.getBean("stuP", StudentPojo.class);
        System.out.println(stuP);
        StudentPojo stuC = applicationContext.getBean("stuC", StudentPojo.class);
        System.out.println(stuC);

    }
    @Test
    public void testSet(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        SpringServices userServices= applicationContext.getBean("UserServices", SpringServices.class);
        userServices.saveUser();

    }
    @Test
    public void testLog(){
        Logger logger = LoggerFactory.getLogger(stuTest.class);
        logger.info("我是一条info信息");

    }
    @Test
    public void testSpringBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Object studentBean = applicationContext.getBean("StudentBean");
        System.out.println(studentBean);
    }
    @Test
    public void testSelectByid(){
        SqlSession sqlSession = MybatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        StudentPojo studentPojo = mapper.selectByid(1);
        System.out.println(studentPojo);
        sqlSession.close();
    }
    @Test
    public void testSelectPage(){
        SqlSession sqlSession = MybatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int pageNum=1;
        int pageSize=2;
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        List<StudentPojo> studentPojos = mapper.selectPage();
        for (StudentPojo studentPojo : studentPojos) {
            System.out.println(studentPojo);
        }
        //获取分页信息
        PageInfo<StudentPojo> studentPojoPageInfo = new PageInfo<StudentPojo>(studentPojos, 2);
        System.out.println(studentPojoPageInfo);
        //PageInfo{pageNum=1, pageSize=2, size=2, startRow=1, endRow=2, total=3, pages=2,
        // list=Page{count=true, pageNum=1, pageSize=2, startRow=0, endRow=2, total=3, pages=2, reasonable=false, pageSizeZero=false}
        // [StudentPojo{sid=1, sname='张三', classPojo=null},
        // StudentPojo{sid=2, sname='李四', classPojo=null}],
        // prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=2, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}


    }
    @Test
    public void testSelectBySept(){
        SqlSession sqlSession = MybatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        StudentPojo studentPojo = mapper.selectBySept(1);
        MybatisUtil.close(sqlSession);
        System.out.println(studentPojo.getSname());
        System.out.println(studentPojo.getClassPojo().getCname());
    }
    @Test
    public void testSelectStu(){
        SqlSession sqlSession = MybatisUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentPojo> studentPojos = mapper.selectStu();
        MybatisUtil.close(sqlSession);
        for (StudentPojo studentPojo : studentPojos) {
            System.out.println(studentPojo);
        }
    }
}
