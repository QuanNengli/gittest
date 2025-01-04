package com.lzq.springmvc.service.impl;

import com.lzq.springmvc.bean.StudentBean;
import com.lzq.springmvc.dao.UserMapper;
import com.lzq.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;
    @Override
    public StudentBean selectById(int id) {
        return userMapper.selectByid(id);
    }
}
