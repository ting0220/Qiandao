package com.example.zhaoting.qiandao.module.jianshu.find;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.module.jianshu.find.article.ArticleFragment;
import com.example.zhaoting.qiandao.module.jianshu.find.article.ArticleFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.BindString;

/**
 * Created by zhaoting on 16/1/19.
 */
public class FindFragment extends BaseFragment implements View.OnClickListener{
    @Bind(R.id.id_tb_find)
    TabLayout mTabLayout;
    @Bind(R.id.id_iv_search)
    ImageView mSearch;
    @Bind(R.id.id_vp_find)
    ViewPager mViewPager;
    List<BaseFragment> mFragments = new ArrayList<>();
    ArticleFragmentPagerAdapter mAdapter;
    @BindString(R.string.article) String article;
    @BindString(R.string.special_topic) String specialTopic;
    String[] mTitles={article,specialTopic};

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initViews() {
        mFragments.add(newInstance(getFragmentManager(),ArticleFragment.class,ArticleFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),ArticleFragment.class,ArticleFragment.class.getName()));
        mAdapter=new ArticleFragmentPagerAdapter(getActivity().getSupportFragmentManager(),mFragments,mTitles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {

    }
}
