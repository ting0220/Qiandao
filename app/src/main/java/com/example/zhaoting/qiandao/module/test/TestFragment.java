package com.example.zhaoting.qiandao.module.test;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.module.activity.UserAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/13.
 */
public class TestFragment extends BaseFragment {
    @Bind(R.id.id_easyRecyclerView)
    EasyRecyclerView mEasyRecyclerView;
    @Bind(R.id.id_colla)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    UserAdapter mAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.bt_fragment_test;
    }

    @Override
    protected void initViews() {

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mEasyRecyclerView.setLayoutManager(manager);
        mAdapter = new UserAdapter();
        mEasyRecyclerView.setAdapter(mAdapter);
        mCollapsingToolbarLayout.setTitle("Title");

    }

    @Override
    protected void initDatas() {

    }
}
