package com.example.ai.myapplication2.ui.activity.main;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.adapter.DrawLayoutAdapter;
import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseActivity;
import com.example.ai.myapplication2.ui.activity.fragment.SecondFragment;
import com.example.ai.myapplication2.ui.activity.main.component.DaggerMainComponent;
import com.example.ai.myapplication2.ui.activity.main.contract.MainContract;
import com.example.ai.myapplication2.ui.activity.main.module.MainModule;
import com.example.ai.myapplication2.ui.activity.main.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.main
 * @Description: $description
 * @date 2017/10/17 11:11:46
 */

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    DrawLayoutAdapter mDrawLayoutAdapter;
    @Inject
    MainPresenter mPresenter;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbarBusiness)
    Toolbar mToolbarBusiness;
    @BindView(android.R.id.tabs)
    TabLayout mTabs;

    @BindView(R.id.mypage_pager)
    ViewPager mMypagePager;
    @BindView(R.id.img_head)
    ImageView mImgHead;
    @BindView(R.id.tv_name)
    TextView mTvName;
    @BindView(R.id.view_line)
    View mViewLine;
    @BindView(R.id.framelayout)
    FrameLayout mFramelayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_shezhi)
    TextView mTvShezhi;
    @BindView(R.id.tv_tuichu)
    TextView mTvTuichu;
    private ProgressDialog progressDialog;
    private List<Fragment> mFragmentList;
    private List<String> mListTitle;




    @Override
    protected void initView() {
       setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        needFront=true;
         getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        progressDialog = new ProgressDialog(this);
        setSupportActionBar(mToolbarBusiness);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbarBusiness, R.string.nav_open, R.string.nav_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mDrawLayoutAdapter);
        mListTitle = new ArrayList<>();
        mListTitle.add("待抢单");
        mListTitle.add("待取货");
        mListTitle.add("待送达");
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new FirstFragment());
        mFragmentList.add(new SecondFragment());
       mFragmentList.add(new ThirdFragment());
        MainPagerAdapter pagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mMypagePager.setOffscreenPageLimit(2);
        mMypagePager.setAdapter(pagerAdapter);
        mTabs.setupWithViewPager(mMypagePager);


    }


    @Override
    protected void initData() {

    }


    @Override
    protected void setupActivityComponent() {
        DaggerMainComponent
                .builder()
                .appComponent(((AppConfig) getApplication()).getApplicationComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(MainContract.MainContractPresenter presenter) {
        mPresenter = (MainPresenter) presenter;
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        progressDialog.dismiss();
    }


    class MainPagerAdapter extends FragmentPagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mListTitle.get(position);
        }
    }
}