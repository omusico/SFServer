package com.miaoyou.platform.server.entity;

public class RecordcasetbWithBLOBs extends Recordcasetb {
    private String zhiyuqingkuang;

    private String chuyuanxiaojie;

    private String chuyuanyizhu;

    public String getZhiyuqingkuang() {
        return zhiyuqingkuang;
    }

    public void setZhiyuqingkuang(String zhiyuqingkuang) {
        this.zhiyuqingkuang = zhiyuqingkuang == null ? null : zhiyuqingkuang.trim();
    }

    public String getChuyuanxiaojie() {
        return chuyuanxiaojie;
    }

    public void setChuyuanxiaojie(String chuyuanxiaojie) {
        this.chuyuanxiaojie = chuyuanxiaojie == null ? null : chuyuanxiaojie.trim();
    }

    public String getChuyuanyizhu() {
        return chuyuanyizhu;
    }

    public void setChuyuanyizhu(String chuyuanyizhu) {
        this.chuyuanyizhu = chuyuanyizhu == null ? null : chuyuanyizhu.trim();
    }
}