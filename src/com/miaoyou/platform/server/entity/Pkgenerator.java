package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pkgenerator implements Serializable {
    private Integer id;

    private String targettable;

    private String pkcolumnname;

    private Long initialvalue;

    private Long allocationsize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargettable() {
        return targettable;
    }

    public void setTargettable(String targettable) {
        this.targettable = targettable == null ? null : targettable.trim();
    }

    public String getPkcolumnname() {
        return pkcolumnname;
    }

    public void setPkcolumnname(String pkcolumnname) {
        this.pkcolumnname = pkcolumnname == null ? null : pkcolumnname.trim();
    }

    public Long getInitialvalue() {
        return initialvalue;
    }

    public void setInitialvalue(Long initialvalue) {
        this.initialvalue = initialvalue;
    }

    public Long getAllocationsize() {
        return allocationsize;
    }

    public void setAllocationsize(Long allocationsize) {
        this.allocationsize = allocationsize;
    }
}