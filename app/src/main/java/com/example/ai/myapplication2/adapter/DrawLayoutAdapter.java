package com.example.ai.myapplication2.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.entity.DrawLayoutEntity;

import java.util.List;

/**
 * @author xlei
 * @Date 2017/10/18.
 */

public class DrawLayoutAdapter extends BaseQuickAdapter<DrawLayoutEntity,BaseViewHolder> {


    public DrawLayoutAdapter(List<DrawLayoutEntity> data) {
        super(R.layout.item_drawlayout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DrawLayoutEntity item) {
        helper.setImageResource(R.id.img_view, item.getImgResid());
        helper.setText(R.id.tv_content, item.getContentText());

    }
}
