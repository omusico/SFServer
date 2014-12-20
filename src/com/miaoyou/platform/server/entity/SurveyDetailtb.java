package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyDetailtb implements Serializable {
    private Long surverydetailId;

    private String surverydetailName;

    private String surverydetailRemark;

    private String surverydetailAnswer;

    private String zujima;

    private Integer deleteFlag;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private String updateperson;

    private String ext1;

    private String ext2;

    private String ext3;

    public Long getSurverydetailId() {
        return surverydetailId;
    }

    public void setSurverydetailId(Long surverydetailId) {
        this.surverydetailId = surverydetailId;
    }

    public String getSurverydetailName() {
        return surverydetailName;
    }

    public void setSurverydetailName(String surverydetailName) {
        this.surverydetailName = surverydetailName == null ? null : surverydetailName.trim();
    }

    public String getSurverydetailRemark() {
        return surverydetailRemark;
    }

    public void setSurverydetailRemark(String surverydetailRemark) {
        this.surverydetailRemark = surverydetailRemark == null ? null : surverydetailRemark.trim();
    }

    public String getSurverydetailAnswer() {
        return surverydetailAnswer;
    }

    public void setSurverydetailAnswer(String surverydetailAnswer) {
        this.surverydetailAnswer = surverydetailAnswer == null ? null : surverydetailAnswer.trim();
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