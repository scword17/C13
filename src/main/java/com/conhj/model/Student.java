package com.conhj.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable {
    private String sno;

    private Set<Course> courses=new HashSet<>();

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    private String sname;

    private String sex;

    private Short sage;

    private String sdept;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getSage() {
        return sage;
    }

    public void setSage(Short sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept == null ? null : sdept.trim();
    }
}