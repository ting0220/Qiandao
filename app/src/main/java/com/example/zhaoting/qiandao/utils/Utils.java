package com.example.zhaoting.qiandao.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.zhaoting.qiandao.utils.share.SharedPManager;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by zhaoting on 16/1/7.
 */
public class Utils {
    private static Context mApplicationContext;

    public static void init(Application app) {
        mApplicationContext = app.getApplicationContext();
    }

    public static void ToastShort(String text) {
        Toast.makeText(mApplicationContext, text, Toast.LENGTH_SHORT).show();
    }

    public static void ToastLong(String text) {
        Toast.makeText(mApplicationContext, text, Toast.LENGTH_LONG).show();
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = mApplicationContext.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = mApplicationContext.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    /**
     * 关闭键盘
     */
    public static void closeInputMethod(Activity act) {
        View view = act.getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) mApplicationContext
                    .getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 获取app版本号
     */
    public static int getAppVersionCode() {
        try {
            PackageManager mPackageManager = mApplicationContext.getPackageManager();
            PackageInfo mPackageInfo = mPackageManager.getPackageInfo(mApplicationContext.getPackageName(), 0);
            return mPackageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }

    }

    /**
     * 获取app版本名
     */
    public static String getAppVersionName() {
        try {
            PackageManager mPackageManager = mApplicationContext.getPackageManager();
            PackageInfo mPackageInfo = mPackageManager.getPackageInfo(mApplicationContext.getPackageName(), 0);
            return mPackageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断是否是wifi连接
     */
    public static boolean isWifi() {
        ConnectivityManager manager = (ConnectivityManager) mApplicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return networkInfo.isConnected();
        //networkInfo.isAvailable()看网络是否可用，但是可能没有连接上
    }

    /**
     * 判断是否是数据网络连接
     */
    public static boolean isMobile() {
        ConnectivityManager manager = (ConnectivityManager) mApplicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo.isConnected();
    }

    /**
     * 判断网络是否连接
     */
    public static boolean isNetConnected() {
        boolean isConnected = isMobile() || isWifi();
        return isConnected;
    }

    /**
     * 唯一标示符，UUID
     *
     * @return
     */
    public static String getDeviceId() {
        String deviceId = SharedPManager.getDeviceId();
        if (deviceId == null) {
            deviceId = java.util.UUID.randomUUID().toString();
            SharedPManager.setDeviceId(deviceId);
        }
        return deviceId;
    }

    /**
     * url转换成bitmap
     */
    public static Bitmap urlToBitmap(String s) {
        try {
            URL url = new URL(s);
            URLConnection conn =url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream baos = new BufferedInputStream(is);
            return BitmapFactory.decodeStream(baos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
