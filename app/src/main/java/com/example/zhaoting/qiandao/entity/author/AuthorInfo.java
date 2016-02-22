package com.example.zhaoting.qiandao.entity.author;


import org.json.JSONObject;

/**
 * Created by zhaoting on 15/12/31.
 */
public  class AuthorInfo {
    private String face;
    private String name;
    private String sign;

    public AuthorInfo(JSONObject object) {
        if (object.has("username")) {
            this.name = object.optString("username", "");
        }
        if (object.has("avatar")) {
            this.face = object.optString("avatar", "");
        }
        if (object.has("signature")) {
            this.sign = object.optString("signature", "");
        }
    }
    public AuthorInfo(String face,String name,String sign){
        this.face=face;
        this.name=name;
        this.sign=sign;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
