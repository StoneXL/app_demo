package com.example.ai.myapplication2.ui.activity.home;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.ui.activity.home.component.DaggerHomeComponent;
import com.example.ai.myapplication2.ui.activity.home.contract.HomeContract;
import com.example.ai.myapplication2.ui.activity.home.module.HomeModule;
import com.example.ai.myapplication2.ui.activity.home.presenter.HomePresenter;
import com.example.ai.myapplication2.adapter.HostAdapter;
import com.example.ai.myapplication2.application.AppConfig;
import com.example.ai.myapplication2.base.BaseActivity;
import com.example.ai.myapplication2.entity.Host;
import com.example.ai.myapplication2.util.ToastUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.home
 * @Description: $description
 * @date 2017/09/18 10:44:16
 */

public class HomeActivity extends BaseActivity implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    HomePresenter mPresenter;
    @Inject
    HostAdapter hostAdapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private View nodataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nodataView = this.getLayoutInflater().inflate(R.layout.empty_view, (ViewGroup) recyclerView.getParent(), false);
        hostAdapter.setEmptyView(nodataView);
        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(hostAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        itemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);
        hostAdapter.enableSwipeItem();
        hostAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
                canvas.drawText("删除",dX/2,dY/2,new Paint());
                canvas.drawColor(ContextCompat.getColor(HomeActivity.this, R.color.colorAccent));
            }
        });

        recyclerView.setAdapter(hostAdapter);
        swipeRefresh.setOnRefreshListener(this);
        mPresenter.loadHost();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setupActivityComponent() {
        DaggerHomeComponent
                .builder()
                .appComponent(((AppConfig) getApplication()).getApplicationComponent())
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setPresenter(HomeContract.HomeContractPresenter presenter) {
        mPresenter = (HomePresenter) presenter;
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show();
    }

    @Override
    public void closeProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void loadHostSucces(List<Host.DataBean> list) {
        swipeRefresh.setRefreshing(false);
        hostAdapter.setNewData(list);


    }

    @Override
    public void loadHostFail() {
        swipeRefresh.setRefreshing(false);
        ToastUtil.show(this,"加载失败");
    }

    @Override
    public void setAdapter() {
      //  hostAdapter.setNewData();
    }

    @Override
    public void onRefresh() {
        mPresenter.loadHost();
    }
}