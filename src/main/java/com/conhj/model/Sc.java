package com.conhj.model;

import java.io.Serializable;

public class Sc extends ScKey implements Serializable {
    private Short grade;

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }
}