package com.example.zhaoting.qiandao.module.activity;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhaoting on 16/1/14.
 * child是我们设置behavior的View
 */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    int offsetTotal = 0;
    boolean scrolling = false;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /*这里的返回值表明这次滑动我们要不要关心，当返回true的时候表示会关心
    * 一般我们会看到（nestedScrollAxes&ViewCompat.SCROLL_AXIS_VERTICAL）!=0  表示我们会关心竖直方向的滑动*/
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    /*让view滑动起来*/
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        offset(child, dyConsumed);
    }

    /**
     * 向上移动，dy为正
     * 1、假如我们移动的高度小于top的高度
     * 得到最开始的top值，为0
     * 移动后的top值为－dy
     * top=-dy
     * top=-dy
     * off
     */
    private void offset(View child, int dy) {
        int old = offsetTotal;
        int top = offsetTotal - dy;
        top = Math.max(top, -child.getHeight());
        top = Math.min(top, 0);
        offsetTotal = top;
        if (old == offsetTotal) {
            scrolling = false;
            return;
        }
        int delta = offsetTotal - old;
        child.offsetTopAndBottom(delta);
        scrolling = true;
    }
}
