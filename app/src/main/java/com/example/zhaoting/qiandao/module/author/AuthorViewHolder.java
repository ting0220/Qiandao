package com.example.zhaoting.qiandao.module.author;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.entity.author.AuthorInfo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by zhaoting on 15/12/31.
 */
public class AuthorViewHolder extends BaseViewHolder<AuthorInfo> {
    private TextView mTv_name;
    private ImageView mIv_face;
    private TextView mTv_sign;

    public AuthorViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        mTv_name = $(R.id.person_name);
        mTv_sign = $(R.id.person_sign);
        mIv_face = $(R.id.person_face);
    }


    @Override
    public void setData(AuthorInfo data) {
        super.setData(data);
        Glide.with(getContext())
                .load(data.getFace())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .dontTransform()
                .dontAnimate()
                .into(mIv_face);
        mTv_sign.setText(data.getSign());
        mTv_name.setText(data.getName());
    }
}
