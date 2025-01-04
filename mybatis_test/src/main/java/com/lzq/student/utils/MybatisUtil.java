package com.lzq.student.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    private MybatisUtil(){

    }
    static {
        try {
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  SqlSession openSession(){
        if (threadLocal.get() == null) {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return threadLocal.get();
    }
    public static void close(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
        threadLocal.remove();
    }

}
