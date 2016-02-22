package com.example.zhaoting.qiandao.module.jianshu.find.article;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zhaoting.qiandao.app.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoting on 16/1/19.
 */
public class ArticleFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments = new ArrayList<>();
    private String[] mTitles;


    public ArticleFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments, String[] titles) {
        super(fm);
        this.mTitles = titles;
        this.mFragments = fragments;
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
