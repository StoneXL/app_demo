package com.example.ai.myapplication2.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.application.AppComponent;
import com.example.ai.myapplication2.entity.Host;

import java.util.List;


/**
 * @author Yuan.Y.Q
 * @Date 2017/9/19.
 */

public class HostAdapter extends BaseItemDraggableAdapter<Host.DataBean,BaseViewHolder> {


    public HostAdapter(List<Host.DataBean> data) {
        super(R.layout.host_list_item,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Host.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_xiangmu, dataBean.getZhujiXiangmuName())
                .setText(R.id.tv_zhujiming, dataBean.getZhujiShebeiName())
                .setText(R.id.tv_mac, dataBean.getZhujiMac())
                .setText(R.id.tv_fangwu, dataBean.getZhujiXiangmuName() + dataBean.getZhujiLoudong() + "栋" + dataBean.getZhujiDanyuan() + "单元" + dataBean.getZhujiFanghao() + "号");
        baseViewHolder.addOnClickListener(R.id.xiugai)
                .addOnClickListener(R.id.fangqu_liebiao);
        BadgeView badgeView = new BadgeView(mContext);
        badgeView.setTargetView(baseViewHolder.getView(R.id.tv_mac));
        badgeView.setBadgeCount(1);
        badgeView.setBackgroundColor(ContextCompat.getColor(mContext,R.color.blue));
        badgeView.setBadgeGravity(Gravity.TOP|Gravity.RIGHT);

    }
}
