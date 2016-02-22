package com.example.zhaoting.qiandao.module.activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.entity.author.AuthorInfo;
import com.example.zhaoting.qiandao.model.OnListener;
import com.example.zhaoting.qiandao.model.author.AuthorModel;
import com.example.zhaoting.qiandao.model.author.AuthorModelImpl;
import com.example.zhaoting.qiandao.module.author.AuthorAdapter;
import com.example.zhaoting.qiandao.utils.Utils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/12.
 */
public class UserCenterFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener,SwipeRefreshLayout.OnRefreshListener,OnListener {
    @Bind(R.id.id_user_rv)
    EasyRecyclerView mRecyclerView;


    private AuthorModel mAuthorModel;
    private AuthorAdapter adapter;
    private int offset = 0;
    private int total = 0;
    private ArrayList<AuthorInfo> mAuthorArrayList = new ArrayList<>();
    private static int LIMIT = 10;
    private Handler mHandler = new Handler();


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_user_center;
    }

    @Override
    protected void initViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initDatas() {
        mAuthorModel = new AuthorModelImpl();
        adapter = new AuthorAdapter(getActivity(), R.layout.item_author);
        mRecyclerView.setAdapter(adapter);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resumeMore();
            }
        });
        onRefresh();
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utils.isNetConnected()) {
                    if (offset < total) {
                        mAuthorModel.getAuthor(UserCenterFragment.this, LIMIT, offset);
                    } else {
                        adapter.stopMore();
                    }
                } else {
                    adapter.pauseMore();
                }
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        if (Utils.isNetConnected()) {
            offset = 0;
            adapter.clear();
            mAuthorModel.getAuthor(this, LIMIT, offset);
        } else {
            mRecyclerView.showEmpty();
        }
    }

    @Override
    public void onSuccess(String s) {
        we(s);
    }

    public void we(String s) {
        try {
            JSONObject obj = new JSONObject(s);
            JSONObject cursor = obj.getJSONObject("cursor");
            total = cursor.getInt("total");
            JSONArray data = obj.getJSONArray("data");
            if (total == 0 || TextUtils.isEmpty(data.toString())) {

            } else {
                mAuthorArrayList.clear();
                for (int i = 0; i < data.length(); i++) {
                    AuthorInfo author = new AuthorInfo(data.getJSONObject(i));
                    mAuthorArrayList.add(author);
                }
                offset = offset + data.length();
                if (mAuthorArrayList.size() > 0) {
                    adapter.addAll(mAuthorArrayList);
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.pauseMore();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError() {

    }
}
