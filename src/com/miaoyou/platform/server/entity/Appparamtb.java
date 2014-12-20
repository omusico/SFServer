package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Appparamtb implements Serializable {
    private Integer appparamId;

    private String appparamType;

    private String appparamName;

    private Integer appparamPid;

    private String appparamDesc;

    private Integer systemparam;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private String updateperson;

    public Integer getAppparamId() {
        return appparamId;
    }

    public void setAppparamId(Integer appparamId) {
        this.appparamId = appparamId;
    }

    public String getAppparamType() {
        return appparamType;
    }

    public void setAppparamType(String appparamType) {
        this.appparamType = appparamType == null ? null : appparamType.trim();
    }

    public String getAppparamName() {
        return appparamName;
    }

    public void setAppparamName(String appparamName) {
        this.appparamName = appparamName == null ? null : appparamName.trim();
    }

    public Integer getAppparamPid() {
        return appparamPid;
    }

    public void setAppparamPid(Integer appparamPid) {
        this.appparamPid = appparamPid;
    }

    public String getAppparamDesc() {
        return appparamDesc;
    }

    public void setAppparamDesc(String appparamDesc) {
        this.appparamDesc = appparamDesc == null ? null : appparamDesc.trim();
    }

    public Integer getSystemparam() {
        return systemparam;
    }

    public void setSystemparam(Integer systemparam) {
        this.systemparam = systemparam;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson == null ? null : createperson.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateperson() {
        return updateperson;
    }

    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson == null ? null : updateperson.trim();
    }
}