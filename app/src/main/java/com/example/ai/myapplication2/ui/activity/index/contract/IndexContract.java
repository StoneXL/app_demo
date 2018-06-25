package com.example.ai.myapplication2.ui.activity.index.contract;

import com.example.ai.myapplication2.ui.activity.base.BasePresenter;
import com.example.ai.myapplication2.ui.activity.base.BaseView;
/**
 * @author xxlei
 * @Package The contract for IndexActivity
 * @Description: $description
 * @date 2017/09/26 14:31:52
 */
public interface IndexContract {
    interface View extends BaseView<IndexContractPresenter> {
        /**
         *
         */
        void showProgressDialog();

        /**
         *
         */
        void closeProgressDialog();
    }

    interface IndexContractPresenter extends BasePresenter {
//        /**
//         *
//         */
//        void getBusinessInfo(Map map);
    }
}