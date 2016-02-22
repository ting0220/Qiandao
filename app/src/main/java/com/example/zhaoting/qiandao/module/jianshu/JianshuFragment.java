package com.example.zhaoting.qiandao.module.jianshu;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;

import butterknife.Bind;

/**
 * Created by zhaoting on 16/1/19.
 */
public class JianshuFragment extends BaseFragment {
    @Bind(R.id.id_read)
    TextView mRead;
    @Bind(R.id.id_report)
    TextView mReport;
    @Bind(R.id.id_activity)
    TextView mActivity;
    @Bind(R.id.id_inform)
    TextView mInform;
    @Bind(R.id.id_market)
    ImageView mMarket;
    @Bind(R.id.activity_main_view)
    RelativeLayout mRelativeLayout;
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main_jianshu;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }

    private void resetButtons(){
        Drawable drawableRead=getActivity().getResources().getDrawable(R.drawable.drawer_read);
        drawableRead.setBounds(0,0,drawableRead.getMinimumWidth(),drawableRead.getMinimumHeight());
        mRead.setCompoundDrawables(null,null,null,drawableRead);
        mRead.setTextColor(getActivity().getResources().getColor(R.color.black_day));

        Drawable drawableReport=getActivity().getResources().getDrawable(R.drawable.drawer_report);
        drawableReport.setBounds(0,0,drawableRead.getMinimumWidth(),drawableRead.getMinimumHeight());
        mReport.setCompoundDrawables(null,null,null,drawableReport);
        mReport.setTextColor(getActivity().getResources().getColor(R.color.black_day));

        Drawable drawableActivity=getActivity().getResources().getDrawable(R.drawable.drawer_activity);
        drawableActivity.setBounds(0,0,drawableRead.getMinimumWidth(),drawableRead.getMinimumHeight());
        mActivity.setCompoundDrawables(null,null,null,drawableActivity);
        mActivity.setTextColor(getActivity().getResources().getColor(R.color.black_day));

        Drawable drawableInform=getActivity().getResources().getDrawable(R.drawable.drawer_inform);
        drawableInform.setBounds(0,0,drawableRead.getMinimumWidth(),drawableRead.getMinimumHeight());
        mInform.setCompoundDrawables(null,null,null,drawableRead);
        mInform.setTextColor(getActivity().getResources().getColor(R.color.black_day));
    }
}
