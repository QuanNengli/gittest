package com.lzq.springmvc.service;

import com.lzq.springmvc.bean.StudentBean;

public interface UserService {
    StudentBean selectById(int id);
}
