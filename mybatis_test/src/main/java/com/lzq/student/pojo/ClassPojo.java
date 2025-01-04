package com.lzq.student.pojo;

public class ClassPojo {
    private Integer cid;
    private String cname;

    @Override
    public String toString() {
        return "ClassPojo{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public ClassPojo(Integer cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public ClassPojo() {
    }
}
