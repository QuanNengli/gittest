package com.lzq.springmvc.dao;

import com.lzq.springmvc.bean.StudentBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
StudentBean selectByid(@Param("id") int id);
}
