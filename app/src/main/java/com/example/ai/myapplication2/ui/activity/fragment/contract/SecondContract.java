package com.example.ai.myapplication2.ui.activity.fragment.contract;

import com.example.ai.myapplication2.entity.IndexFragmentBean;
import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;

import java.util.List;

/**
 * @author xlei
 * @Package The contract for SecondFragment
 * @Description: $description
 * @date 2017/09/27 09:51:09
 */
public interface SecondContract {
    interface View extends BaseView<SecondContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();

        void setAdapter(List<IndexFragmentBean> list);
    }

    interface SecondContractPresenter extends BasePresenter {
        //        /**
//         *
//         */
//        void getBusinessInfo(Map map);
        void loadData();
    }
}