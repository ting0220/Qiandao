package com.example.zhaoting.qiandao.model.author;


import com.example.zhaoting.qiandao.model.OnListener;

/**
 * Created by zhaoting on 16/1/5.
 */
public interface AuthorModel {
    void getAuthor(OnListener listener, int limit, int offset);
}
