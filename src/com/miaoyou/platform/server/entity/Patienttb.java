package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patienttb implements Serializable {
    private Long patientid;

    private String name;

    private String nianling;

    private String xingbie;

    private String zhengjianhaoma;

    private String telphone;

    private String address;

    private String phone;

    private String ophone;

    private String oname;

    private String orelationship;

    private String zhuyuancishu;

    private String suifangbeizhu;

    private String zujima;

    private Integer deleteFlag;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private String updateperson;

    private String ext1;

    private String ext2;

    private String ext3;

    private String menzhencishu;

    public Long getPatientid() {
        return patientid;
    }

    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNianling() {
        return nianling;
    }

    public void setNianling(String nianling) {
        this.nianling = nianling == null ? null : nianling.trim();
    }

    public String getXingbie() {
        return xingbie;
    }

    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }

    public String getZhengjianhaoma() {
        return zhengjianhaoma;
    }

    public void setZhengjianhaoma(String zhengjianhaoma) {
        this.zhengjianhaoma = zhengjianhaoma == null ? null : zhengjianhaoma.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOphone() {
        return ophone;
    }

    public void setOphone(String ophone) {
        this.ophone = ophone == null ? null : ophone.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getOrelationship() {
        return orelationship;
    }

    public void setOrelationship(String orelationship) {
        this.orelationship = orelationship == null ? null : orelationship.trim();
    }

    public String getZhuyuancishu() {
        return zhuyuancishu;
    }

    public void setZhuyuancishu(String zhuyuancishu) {
        this.zhuyuancishu = zhuyuancishu == null ? null : zhuyuancishu.trim();
    }

    public String getSuifangbeizhu() {
        return suifangbeizhu;
    }

    public void setSuifangbeizhu(String suifangbeizhu) {
        this.suifangbeizhu = suifangbeizhu == null ? null : suifangbeizhu.trim();
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

    public String getMenzhencishu() {
        return menzhencishu;
    }

    public void setMenzhencishu(String menzhencishu) {
        this.menzhencishu = menzhencishu == null ? null : menzhencishu.trim();
    }
}