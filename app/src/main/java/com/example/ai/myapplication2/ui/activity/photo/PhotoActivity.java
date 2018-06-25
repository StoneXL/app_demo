package com.example.ai.myapplication2.ui.activity.photo;

import android.os.Bundle;

import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseActivity;
import com.example.ai.myapplication2.ui.activity.photo.component.DaggerPhotoComponent;
import com.example.ai.myapplication2.ui.activity.photo.contract.PhotoContract;
import com.example.ai.myapplication2.ui.activity.photo.module.PhotoModule;
import com.example.ai.myapplication2.ui.activity.photo.presenter.PhotoPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.photo
 * @Description: $description
 * @date 2017/09/25 18:18:24
 */

public class PhotoActivity extends BaseActivity implements PhotoContract.View {

    @Inject
    PhotoPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
//        setContentView(R.layout.activity_photo);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupActivityComponent() {
       DaggerPhotoComponent
               .builder()
               .appComponent(((AppConfig) getApplication()).getApplicationComponent())
               .photoModule(new PhotoModule(this))
               .build()
               .inject(this);
    }
    @Override
    public void setPresenter(PhotoContract.PhotoContractPresenter presenter) {
        mPresenter = (PhotoPresenter) presenter;
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        progressDialog.hide();
    }

}