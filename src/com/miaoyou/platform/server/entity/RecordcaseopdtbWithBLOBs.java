package com.miaoyou.platform.server.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordcaseopdtbWithBLOBs extends Recordcaseopdtb implements Serializable{
    private String zhushu;

    private String bingshi;

    private String chati;

    private String jiancha;

    private String yizhu;

    private String guoqushi;

    private String yaowuguominshi;

    public String getZhushu() {
        return zhushu;
    }

    public void setZhushu(String zhushu) {
        this.zhushu = zhushu == null ? null : zhushu.trim();
    }

    public String getBingshi() {
        return bingshi;
    }

    public void setBingshi(String bingshi) {
        this.bingshi = bingshi == null ? null : bingshi.trim();
    }

    public String getChati() {
        return chati;
    }

    public void setChati(String chati) {
        this.chati = chati == null ? null : chati.trim();
    }

    public String getJiancha() {
        return jiancha;
    }

    public void setJiancha(String jiancha) {
        this.jiancha = jiancha == null ? null : jiancha.trim();
    }

    public String getYizhu() {
        return yizhu;
    }

    public void setYizhu(String yizhu) {
        this.yizhu = yizhu == null ? null : yizhu.trim();
    }

    public String getGuoqushi() {
        return guoqushi;
    }

    public void setGuoqushi(String guoqushi) {
        this.guoqushi = guoqushi == null ? null : guoqushi.trim();
    }

    public String getYaowuguominshi() {
        return yaowuguominshi;
    }

    public void setYaowuguominshi(String yaowuguominshi) {
        this.yaowuguominshi = yaowuguominshi == null ? null : yaowuguominshi.trim();
    }
}