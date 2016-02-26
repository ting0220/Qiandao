package com.example.zhaoting.qiandao.entity.novel;

import android.graphics.Bitmap;

import com.example.zhaoting.qiandao.utils.Utils;

import org.json.JSONObject;

/**
 * Created by zhaoting on 16/2/25.
 */
public class NovelInfo {
    private String title;
    private int guid;
    private String banner;
    private Bitmap bitmap;

    public NovelInfo(JSONObject object) {
        if (object.has("title")) {
            this.title = object.optString("title", "");
        }
        if (object.has("novel_guid")) {
            this.guid = object.optInt("novel_guid", 0);
        }
        if (object.has("banner")) {
            this.banner = object.optString("banner", "");
        }
        if (object.has("banner")) {
            this.banner = object.optString("banner", "");

            bitmap = Utils.urlToBitmap(banner);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
