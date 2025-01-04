package com.lzq.student.mapper;

import com.lzq.student.pojo.StudentPojo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from t_stu where sid=#{sid}")
    @Results({
            @Result(column = "sid",property = "sid"),
            @Result(column = "sname",property = "sname"),
            @Result(column = "cid",property = "classPojo.cid")
    })
    StudentPojo selectByid(Integer sid);
    List<StudentPojo> selectPage();
    StudentPojo selectBySept(@Param("sid") Integer sid);
    List<StudentPojo> selectStu();

}
