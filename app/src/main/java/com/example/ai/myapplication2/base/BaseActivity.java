package com.example.ai.myapplication2.base;

import com.example.ai.myapplication2.view.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.util.ToastUtil;
import com.example.ai.myapplication2.util.UIUtils;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * @author Yuan.Y.Q
 * @Date 2017/9/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Toolbar mToolbar;
    private AutoRelativeLayout rootLayout;
    public boolean needFront = false;   //toolBar 是否需要显示在最上层的标识
    public ProgressDialog progressDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        progressDialog = new ProgressDialog(this);
        initToolbar();
        setupActivityComponent();
        initView();
        initData();

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbarBusiness);
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(UIUtils.getDisplayWidth(this), UIUtils.getStatusBarHeight(this)*3);
        mToolbar.setLayoutParams(layoutParams);
        mToolbar.setPadding(0, (int) (UIUtils.getStatusBarHeight(this) * 0.6), 0, 0);
        mToolbar.setTitleMarginTop((int) (UIUtils.getStatusBarHeight(this) * 0.55));
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }
    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (AutoRelativeLayout) findViewById(R.id.root_layout);
        if (rootLayout == null) {
            return;
        }
        if (needFront) {
            mToolbar.setBackgroundColor(getResources().getColor(R.color.color_00000000));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rootLayout.addView(view, params);
            mToolbar.bringToFront();
        } else {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.addRule(RelativeLayout.BELOW, R.id.toolbarBusiness);
            rootLayout.addView(view, params);
        }
        initToolbar();
    }


    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 初始化dagger2
     */
    protected abstract void setupActivityComponent();
    protected <T>void  startActivty(Class<T> clazz){
        Intent intent = new Intent(this, clazz);
        try {
            startActivity(intent);
        } catch (Exception e) {
            ToastUtil.show(this, "敬请期待！");
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
