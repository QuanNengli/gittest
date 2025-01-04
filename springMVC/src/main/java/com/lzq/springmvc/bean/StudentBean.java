package com.lzq.springmvc.bean;

public class StudentBean {
    private Integer sid;
    private String sname;
    private Integer cid;

    @Override
    public String toString() {
        return "StudentBean{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", cid=" + cid +
                '}';
    }

    public StudentBean(Integer sid, String sname, Integer cid) {
        this.sid = sid;
        this.sname = sname;
        this.cid = cid;
    }

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public StudentBean() {
    }
}
