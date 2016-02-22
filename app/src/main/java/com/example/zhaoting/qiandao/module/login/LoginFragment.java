package com.example.zhaoting.qiandao.module.login;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.module.activity.ActivityMainFragment;
import com.example.zhaoting.qiandao.utils.Utils;
import com.example.zhaoting.qiandao.utils.share.SharedPManager;
import com.example.zhy.changeskin.SkinManager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaoting on 16/1/8.
 */
public class LoginFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.id_et_account)
    EditText mIdEtAccount;
    @Bind(R.id.id_et_password)
    EditText mIdEtPassword;
    @Bind(R.id.id_tv_login)
    TextView mIdTvLogin;
    @Bind(R.id.id_tv_change_theme)
    TextView mIdTvChangeTheme;

    int mThemeId;


    @Override
    protected int getFragmentLayout() {
        SkinManager.getInstance().register(getActivity());
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this, mRootView);
        mIdTvLogin.setOnClickListener(this);
        mIdTvChangeTheme.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tv_login: {
                if (mIdEtAccount.getText().toString().equals("zhaoting") && mIdEtPassword.getText().toString().equals("111111")) {
                   replaceFragment(ActivityMainFragment.class);
                } else {
                    Utils.ToastShort(getResources().getString(R.string.login_error));

                }
            }
            break;
            case R.id.id_tv_change_theme:{
                if (SharedPManager.getTheme()==R.style.AppTheme_Day){
                    mThemeId=R.style.AppTheme_Night;
                    SkinManager.getInstance().changeSkin("night");
                }else{
                    mThemeId=R.style.AppTheme_Day;
                    SkinManager.getInstance().changeSkin("day");
                }
                SharedPManager.setTheme(mThemeId);
            }
            break;
        }
    }
}