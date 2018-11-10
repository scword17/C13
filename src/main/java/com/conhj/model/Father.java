package com.conhj.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Father implements Serializable {
    private String fid;
    private Set<Son> Sons=new HashSet<>();
    private String fname;

    public Set<Son> getSons() {
        return Sons;
    }

    public void setSons(Set<Son> sons) {
        Sons = sons;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }
}