package com.example.ai.myapplication2.ui.activity.index;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseActivity;
import com.example.ai.myapplication2.entity.TabBean;
import com.example.ai.myapplication2.ui.activity.fragment.SecondFragment;
import com.example.ai.myapplication2.ui.activity.index.component.DaggerIndexComponent;
import com.example.ai.myapplication2.ui.activity.index.contract.IndexContract;
import com.example.ai.myapplication2.ui.activity.index.module.IndexModule;
import com.example.ai.myapplication2.ui.activity.index.presenter.IndexPresenter;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xxlei
 * @Package com.example.ai.myapplication2.ui.activity.index
 * @Description: $description
 * @date 2017/09/26 14:31:52
 */

public class IndexActivity extends BaseActivity implements IndexContract.View {

    @Inject
    IndexPresenter mPresenter;
    @BindView(R.id.real_content)
    AutoFrameLayout realContent;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_index);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initData() {
        //给tabhost设置容器
        tabhost.setup(this,this.getSupportFragmentManager(),R.id.real_content);
        //初始化tabhost数据  TabBean
        TabBean bean1 = new TabBean("首页",R.drawable.tab_main_selector,SecondFragment.class);
        TabBean bean2 = new TabBean("工作台",R.drawable.tab_main_selector,SecondFragment.class);
        TabBean bean3 = new TabBean("个人中心",R.drawable.tab_main_selector,SecondFragment.class);
        List<TabBean> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        for (TabBean tabBean : list) {
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(tabBean.getTitle());
            tabSpec.setIndicator(creatTabView(tabBean));
            tabhost.addTab(tabSpec,tabBean.getFragment(),null);
        }

    }
    private View creatTabView(TabBean tabBean){
        View view = this.getLayoutInflater().inflate(R.layout.tab_host, null);
        TextView title = (TextView) view.findViewById(R.id.tv_title);
        ImageView img = (ImageView) view.findViewById(R.id.img_src);
        title.setText(tabBean.getTitle());
        img.setImageResource(tabBean.getResid());

        return view;
    }
    @Override
    protected void setupActivityComponent() {
        DaggerIndexComponent
                .builder()
                .appComponent(((AppConfig) getApplication()).getApplicationComponent())
                .indexModule(new IndexModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(IndexContract.IndexContractPresenter presenter) {
        mPresenter = (IndexPresenter) presenter;
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