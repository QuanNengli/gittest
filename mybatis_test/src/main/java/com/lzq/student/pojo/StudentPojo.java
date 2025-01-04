package com.lzq.student.pojo;

public class StudentPojo {
    private Integer sid;
    private String sname;
    private ClassPojo classPojo;



    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public ClassPojo getClassPojo() {
        return classPojo;
    }

    public void setClassPojo(ClassPojo classPojo) {
        this.classPojo = classPojo;
    }

    @Override
    public String toString() {
        return "StudentPojo{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", classPojo=" + classPojo +
                '}';
    }

    public StudentPojo(Integer sid, String sname, ClassPojo classPojo) {
        this.sid = sid;
        this.sname = sname;
        this.classPojo = classPojo;
    }

    public StudentPojo() {
    }
}
