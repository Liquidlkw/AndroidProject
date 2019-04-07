package com.example.liquid.busstationoutdoorfacilitiesms.Item;

public class MessageItem {
    private int id;
    private String renwu;
    private String pingpai;
    private String zhandian;
    private String fangxiang;
    private String renwujindu;
    private int renwujingdu_pic;

    public MessageItem(int id,String renwu, String pingpai, String zhandian, String fangxiang, String renwujindu, int renwujingdu_pic, int image) {
        this.id = id;
        this.renwu = renwu;
        this.pingpai = pingpai;
        this.zhandian = zhandian;
        this.fangxiang = fangxiang;
        this.renwujindu = renwujindu;
        this.renwujingdu_pic = renwujingdu_pic;
        this.image = image;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRenwu() {
        return renwu;
    }

    public void setRenwu(String renwu) {
        this.renwu = renwu;
    }

    public String getPingpai() {
        return pingpai;
    }

    public void setPingpai(String pingpai) {
        this.pingpai = pingpai;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int image;

    public String getZhandian() {
        return zhandian;
    }

    public void setZhandian(String zhandian) {
        this.zhandian = zhandian;
    }

    public String getFangxiang() {
        return fangxiang;
    }

    public void setFangxiang(String fangxiang) {
        this.fangxiang = fangxiang;
    }

    public String getRenwujindu() {
        return renwujindu;
    }

    public void setRenwujindu(String renwujindu) {
        this.renwujindu = renwujindu;
    }

    public int getRenwujingdu_pic() {
        return renwujingdu_pic;
    }

    public void setRenwujingdu_pic(int renwujingdu_pic) {
        this.renwujingdu_pic = renwujingdu_pic;
    }


}
