package com.example.zhaoting.qiandao.module.test;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhaoting on 16/1/13.
 */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //返回值表明这次滑动我们要不要关心
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes& ViewCompat.SCROLL_AXIS_VERTICAL)!=0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy>child.getHeight()){
            hide(child);
        }else if (dy<0){
            show(child);
        }
    }

    private void show(View child) {
        child.setVisibility(View.VISIBLE);
    }

    private void hide(View child) {
        child.setVisibility(View.GONE);
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }
}
