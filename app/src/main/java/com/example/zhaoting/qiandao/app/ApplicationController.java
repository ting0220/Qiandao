package com.example.zhaoting.qiandao.app;

import android.app.Application;

import com.example.zhaoting.qiandao.utils.Utils;
import com.example.zhaoting.qiandao.utils.share.SharedPManager;
import com.example.zhaoting.qiandao.utils.volley.Volley;
import com.example.zhy.changeskin.SkinManager;


/**
 * Created by zhaoting on 15/11/9.

 */
public class ApplicationController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        SharedPManager.init(this);
        Volley.init(this);
        Utils.init(this);
        SkinManager.getInstance().init(this);
    }

}
