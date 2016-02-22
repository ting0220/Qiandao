package com.example.zhaoting.qiandao.module.author;

import android.content.Context;
import android.view.ViewGroup;

import com.example.zhaoting.qiandao.entity.author.AuthorInfo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by zhaoting on 15/12/31.
 */
public class AuthorAdapter extends RecyclerArrayAdapter<AuthorInfo>{
    private int mLayoutId;
    public AuthorAdapter(Context context,int layoutId) {
        super(context);
        mLayoutId=layoutId;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new AuthorViewHolder(parent, mLayoutId);
    }


}
