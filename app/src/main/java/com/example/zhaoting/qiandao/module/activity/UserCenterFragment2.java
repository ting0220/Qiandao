package com.example.zhaoting.qiandao.module.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/12.
 */
public class UserCenterFragment2 extends BaseFragment {
    @Bind(R.id.id_recyclerView)
    EasyRecyclerView mEasyRecyclerView;
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_user_center2;
    }

    @Override
    protected void initViews() {
        mEasyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mEasyRecyclerView.setAdapter();
    }

    @Override
    protected void initDatas() {

    }
}
