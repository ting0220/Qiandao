package com.example.zhaoting.qiandao.module.jianshu.find;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.zhaoting.qiandao.app.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoting on 16/1/19.
 */
public class FindFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments = new ArrayList<>();

    public FindFragmentPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
