package com.example.zhaoting.qiandao.utils.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by zhaoting on 15/12/30.
 */
public class LruBitmapCathe extends LruCache<String,Bitmap> implements ImageLoader.ImageCache{

    private static int getDefaultLruCacheSize() {
        final int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize=maxMemory/8;
        return cacheSize;
    }

    public LruBitmapCathe(){
        this(getDefaultLruCacheSize());
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes()*value.getHeight()/1024;
    }

    public LruBitmapCathe(int maxSize) {
        super(maxSize);
    }

    @Override
    public Bitmap getBitmap(String s) {
        return get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        put(s,bitmap);
    }
}
