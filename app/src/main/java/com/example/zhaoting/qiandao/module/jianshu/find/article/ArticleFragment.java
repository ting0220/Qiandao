package com.example.zhaoting.qiandao.module.jianshu.find.article;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.module.author.AuthorFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/19.
 */
public class ArticleFragment extends BaseFragment {
    @Bind(R.id.id_tb_article)
    TabLayout mTabLayout;
    @Bind(R.id.id_vp_article)
    ViewPager mViewPager;
    ArticleFragmentPagerAdapter mAdapter;
    List<BaseFragment> mFragments = new ArrayList<>();
    String[] titles = {"热门", "新上榜", "连载", "生活家", "世间事", "@IT", "视频", "七嘴八舌", "电影", "经典", "读图", "市集", "七日热门", "三十日热门"};

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initViews() {
        mTabLayout.setTabTextColors(R.color.black_day, R.color.orange_day);
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));
        mFragments.add(newInstance(getFragmentManager(),AuthorFragment.class,AuthorFragment.class.getName()));

        mAdapter = new ArticleFragmentPagerAdapter(getActivity().getSupportFragmentManager(), mFragments, titles);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void initDatas() {

    }
}
