package com.conhj.model;

import java.io.Serializable;

public class Son implements Serializable {
    private String id;
    private Father father;

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    private String sname;

    private String fid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }
}