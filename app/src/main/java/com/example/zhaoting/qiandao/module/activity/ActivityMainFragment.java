package com.example.zhaoting.qiandao.module.activity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseFragment;
import com.example.zhaoting.qiandao.module.author.AuthorFragment;
import com.example.zhaoting.qiandao.module.tag.TagGridFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhaoting on 16/1/5.
 */
public class ActivityMainFragment extends BaseFragment implements View.OnClickListener {


    @Bind(R.id.id_tv_registration)
    TextView mIdTvRegistration;
    @Bind(R.id.id_tv_information)
    TextView mIdTvInformation;
    @Bind(R.id.id_tv_management)
    TextView mIdTvManagement;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_activity_main;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this, mRootView);
        mIdTvRegistration.setOnClickListener(this);
        mIdTvInformation.setOnClickListener(this);
        mIdTvManagement.setOnClickListener(this);
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
            case R.id.id_tv_registration: {
                replaceFragment(CameraFragment.class);
            }
            break;
            case R.id.id_tv_information: {
                replaceFragment(AuthorFragment.class);
            }
            break;
            case R.id.id_tv_management: {
                replaceFragment(TagGridFragment.class);
            }
            break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!ActivityMainFragment.this.isHidden()) {
            Log.i("tag", ActivityMainFragment.this.getClass().getSimpleName() + "true");
        } else {
            Log.i("tag", ActivityMainFragment.this.getClass().getSimpleName() + "false");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("tag", ActivityMainFragment.this.getClass().getSimpleName() + "false");
    }

//    public void deleteFile(File file) {
//        if (file.isDirectory()) {
//            File[] childFile = file.listFiles();
//            if (childFile == null || childFile.length == 0) {
//                file.delete();
//                return;
//            }
//            for (int i = 0; i < childFile.length; i++) {
//                if (!childFile[i].getAbsolutePath().equals(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music")) {
//                    deleteFile(childFile[i]);
//                }
//            }
//
//            file.delete();
//        }
//        if (file.isFile()) {
//            file.delete();
//            return;
//        }
//    }

}
