package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SfplansmsHistorytb implements Serializable {
    private Long smsplanId;

    private Long patientid;

    private String smscontext;

    private String smstypeName;

    private Integer plantype;

    private Integer status;

    private Integer planfreq;

    private Integer plannumber;

    private Date plannexttime;

    private Integer userId;

    private String remark;

    private String zujima;

    private Integer deleteFlag;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private String updateperson;

    private String ext1;

    private String ext2;

    private String ext3;

    public Long getSmsplanId() {
        return smsplanId;
    }

    public void setSmsplanId(Long smsplanId) {
        this.smsplanId = smsplanId;
    }

    public Long getPatientid() {
        return patientid;
    }

    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    public String getSmscontext() {
        return smscontext;
    }

    public void setSmscontext(String smscontext) {
        this.smscontext = smscontext == null ? null : smscontext.trim();
    }

    public String getSmstypeName() {
        return smstypeName;
    }

    public void setSmstypeName(String smstypeName) {
        this.smstypeName = smstypeName == null ? null : smstypeName.trim();
    }

    public Integer getPlantype() {
        return plantype;
    }

    public void setPlantype(Integer plantype) {
        this.plantype = plantype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPlanfreq() {
        return planfreq;
    }

    public void setPlanfreq(Integer planfreq) {
        this.planfreq = planfreq;
    }

    public Integer getPlannumber() {
        return plannumber;
    }

    public void setPlannumber(Integer plannumber) {
        this.plannumber = plannumber;
    }

    public Date getPlannexttime() {
        return plannexttime;
    }

    public void setPlannexttime(Date plannexttime) {
        this.plannexttime = plannexttime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getZujima() {
        return zujima;
    }

    public void setZujima(String zujima) {
        this.zujima = zujima == null ? null : zujima.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }
}