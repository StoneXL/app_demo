package com.example.ai.myapplication2.ui.activity.fragment.presenter;
import android.support.annotation.NonNull;

import com.example.ai.myapplication2.R;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.entity.IndexFragmentBean;
import com.example.ai.myapplication2.ui.activity.fragment.contract.SecondContract;
import com.example.ai.myapplication2.ui.activity.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.fragment
 * @Description: presenter of SecondFragment
 * @date 2017/09/27 09:51:09
 */
public class SecondPresenter implements SecondContract.SecondContractPresenter{

    HttpAPIWrapper httpAPIWrapper;
    private final SecondContract.View mView;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public SecondPresenter(@NonNull HttpAPIWrapper httpAPIWrapper, @NonNull SecondContract.View view) {
        mView = view;
        this.httpAPIWrapper = httpAPIWrapper;
        mCompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        if (!mCompositeDisposable.isDisposed()) {
             mCompositeDisposable.dispose();
        }
    }
    @Override
    public void loadData() {
        List<IndexFragmentBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            IndexFragmentBean bean = new IndexFragmentBean();
            bean.setContent("送至：凯姆国际A1栋12.4");
            bean.setTitle("待抢单");
            bean.setImgtext("抢");
            bean.setTime("1980-09-09");
            list.add(i,bean);
        }
        mView.setAdapter(list);
    }


//    @Override
//    public void getUser(HashMap map) {
//        //mView.showProgressDialog();
//        Disposable disposable = httpAPIWrapper.getUser(map)
//                .subscribe(new Consumer<User>() {
//                    @Override
//                    public void accept(User user) throws Exception {
//                        //isSuccesse
//                        KLog.i("onSuccesse");
//                        mView.setText(user);
//                      //mView.closeProgressDialog();
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        //onError
//                        KLog.i("onError");
//                        throwable.printStackTrace();
//                      //mView.closeProgressDialog();
//                      //ToastUtil.show(mFragment.getActivity(), mFragment.getString(R.string.loading_failed_1));
//                    }
//                }, new Action() {
//                    @Override
//                    public void run() throws Exception {
//                        //onComplete
//                        KLog.i("onComplete");
//                    }
//                });
//        mCompositeDisposable.add(disposable);
//    }
}