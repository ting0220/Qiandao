package com.example.zhaoting.qiandao.widget;

import android.widget.AbsListView;

/**
 * Created by zhaoting on 16/2/2.
 */
public abstract class EndlessScroll implements AbsListView.OnScrollListener {
    /*The minimum amount of items to have below your current scroll position before loading more*/
    private int visibleThreshold = 1;

    /* The total number of items in the dataset after the last load*/
    private int previousTotalItemCount = 0;

    /*True if we are still waiting for the last set of data to load*/
    private boolean loading = true;

    public EndlessScroll() {
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
// Don't take any action on changed
    }

    /**
     * @param view
     * @param firstVisibleItem 当前界面第一个可见的item
     * @param visibleItemCount 当前页面的可见的item的数量
     * @param totalItemCount   总共的item的数量
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //当有刷新的行为时需要把所有的重置
        if (totalItemCount < previousTotalItemCount) {
            this.previousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                this.loading = true;
            }
        }

        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false;
            previousTotalItemCount = totalItemCount;
        }
        //firstVisibleItem相当于之前加载的item数量的多少
        if (!loading && (totalItemCount - visibleItemCount) < (firstVisibleItem + visibleThreshold)) {
            onLoadMore();
            loading = true;
        }
    }

    public abstract void onLoadMore();
}
