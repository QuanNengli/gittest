package com.lzq.student.dao;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFactory implements FactoryBean<Date> {
    private String date;

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(date);
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
