package com.example.ai.myapplication2.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.entity.IndexFragmentBean;

import java.util.List;



/**
 * @author Yuan.Y.Q
 * @Date 2017/9/27.
 */

public class IndexFragmentAdapter extends BaseQuickAdapter<IndexFragmentBean,BaseViewHolder> {

    public IndexFragmentAdapter( @Nullable List<IndexFragmentBean> data) {
        super(R.layout.item_index_fragment, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, IndexFragmentBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_imgtext, item.getImgtext());
    }
}
