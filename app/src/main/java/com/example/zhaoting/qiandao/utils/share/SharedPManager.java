package com.example.zhaoting.qiandao.utils.share;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.zhaoting.qiandao.R;


/**
 * Created by zhaoting on 15/11/10.
 */
public class SharedPManager {
    private static Context mContext;

    public static void init(Application app) {
        mContext = app.getApplicationContext();
    }

    public static SharedPreferences getSharedPreferences() {
        return mContext.getSharedPreferences("volley", Context.MODE_PRIVATE);
    }

    /**
     * UUID
     */
    public static void setDeviceId(String value) {
        getSharedPreferences().edit().putString("deviceId", value).commit();
    }

    public static String getDeviceId() {
        return getSharedPreferences().getString("deviceId", null);
    }

    /**
     * theme
     */
    public static void setTheme(int theme) {
        getSharedPreferences().edit().putInt("theme", theme).commit();
    }

    public static int getTheme() {
        return getSharedPreferences().getInt("theme", R.style.AppTheme_Day);
    }


}
