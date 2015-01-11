package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recordcaseopdtb implements Serializable {
    private Long recordcaseid;

    private Long patientid;

    private String keshi;

    private String menzhenhao;

    private Date menzhenriqi;

    private String menzhenzhengduan;

    private Date chuyuanriqi;

    private String menzhenyisheng;

    private String bingliezhuangtai;

    private String zujima;

    private Integer deleteFlag;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private String updateperson;

    private String ext1;

    private String ext2;

    private String ext3;

    public Long getRecordcaseid() {
        return recordcaseid;
    }

    public void setRecordcaseid(Long recordcaseid) {
        this.recordcaseid = recordcaseid;
    }

    public Long getPatientid() {
        return patientid;
    }

    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    public String getKeshi() {
        return keshi;
    }

    public void setKeshi(String keshi) {
        this.keshi = keshi == null ? null : keshi.trim();
    }

    public String getMenzhenhao() {
        return menzhenhao;
    }

    public void setMenzhenhao(String menzhenhao) {
        this.menzhenhao = menzhenhao == null ? null : menzhenhao.trim();
    }

    public Date getMenzhenriqi() {
        return menzhenriqi;
    }

    public void setMenzhenriqi(Date menzhenriqi) {
        this.menzhenriqi = menzhenriqi;
    }

    public String getMenzhenzhengduan() {
        return menzhenzhengduan;
    }

    public void setMenzhenzhengduan(String menzhenzhengduan) {
        this.menzhenzhengduan = menzhenzhengduan == null ? null : menzhenzhengduan.trim();
    }

    public Date getChuyuanriqi() {
        return chuyuanriqi;
    }

    public void setChuyuanriqi(Date chuyuanriqi) {
        this.chuyuanriqi = chuyuanriqi;
    }

    public String getMenzhenyisheng() {
        return menzhenyisheng;
    }

    public void setMenzhenyisheng(String menzhenyisheng) {
        this.menzhenyisheng = menzhenyisheng == null ? null : menzhenyisheng.trim();
    }

    public String getBingliezhuangtai() {
        return bingliezhuangtai;
    }

    public void setBingliezhuangtai(String bingliezhuangtai) {
        this.bingliezhuangtai = bingliezhuangtai == null ? null : bingliezhuangtai.trim();
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