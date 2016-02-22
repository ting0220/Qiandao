package com.example.zhaoting.qiandao.activities;

import android.os.Bundle;

import com.example.zhaoting.qiandao.R;
import com.example.zhaoting.qiandao.app.BaseActivity;
import com.example.zhaoting.qiandao.module.activity.ActivityMainFragment;
import com.example.zhaoting.qiandao.module.login.LoginFragment;
import com.example.zhy.changeskin.SkinManager;

public class MainActivity extends BaseActivity {

    //    private DrawerLayout drawer;
//    private NavigationView navigationView;
    private LoginFragment mLoginFragment;
    private ActivityMainFragment mActivityMainFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SkinManager.getInstance().register(this);

//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

//        mLoginFragment = (LoginFragment) obtainFragment(LoginFragment.class);
        mActivityMainFragment= newInstanceFragment(ActivityMainFragment.class);
        changeFragment(mActivityMainFragment);
//        navigationView.setCheckedItem(R.id.drawer_activity);

    }

    @Override
    public int getFragmentContainerId() {
        return R.id.activity_main_view;
    }


//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.drawer_read: {
//            }
//            break;
//            case R.id.drawer_activity: {
////                item.setChecked(true);
////                addHideFragment(mActivityMainFragment);
//            }
//            break;
//            case R.id.drawer_market: {
//            }
//            break;
//            case R.id.drawer_author: {
////                item.setChecked(true);
////                AuthorFragment mAuthorAuthorFragment = (AuthorFragment) obtainFragment(AuthorFragment.class);
////                addHideFragment(mAuthorAuthorFragment);
//            }
//            break;
//            case R.id.drawer_report: {
//            }
//            break;
//            case R.id.drawer_info: {
//            }
//            break;
//        }
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SkinManager.getInstance().unregister(this);
    }
}
