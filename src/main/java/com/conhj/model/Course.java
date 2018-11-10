package com.conhj.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable {
    private String cno;

    private String cname;

    private Set<Student> stus=new HashSet<>();

    public Set<Student> getStus() {
        return stus;
    }

    public void setStus(Set<Student> stus) {
        this.stus = stus;
    }

    private String cpno;

    private Short ccredit;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCpno() {
        return cpno;
    }

    public void setCpno(String cpno) {
        this.cpno = cpno == null ? null : cpno.trim();
    }

    public Short getCcredit() {
        return ccredit;
    }

    public void setCcredit(Short ccredit) {
        this.ccredit = ccredit;
    }
}