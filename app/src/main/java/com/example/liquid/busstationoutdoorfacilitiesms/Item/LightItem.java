package com.example.liquid.busstationoutdoorfacilitiesms.Item;

public class LightItem {

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getZhandian() {
        return zhandian;
    }

    public void setZhandian(String zhandian) {
        this.zhandian = zhandian;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    private String bianhao;
     private String zhandian;
     private String zhuangtai;

    public LightItem(String bianhao, String zhandian, String zhuangtai) {
        this.bianhao = bianhao;
        this.zhandian = zhandian;
        this.zhuangtai = zhuangtai;
    }
}
