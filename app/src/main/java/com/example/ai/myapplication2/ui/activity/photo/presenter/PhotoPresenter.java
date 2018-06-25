package com.example.ai.myapplication2.ui.activity.photo.presenter;

import android.support.annotation.NonNull;

import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.photo.PhotoActivity;
import com.example.ai.myapplication2.ui.activity.photo.contract.PhotoContract;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.photo
 * @Description: presenter of PhotoActivity
 * @date 2017/09/25 18:18:24
 */
public class PhotoPresenter implements PhotoContract.PhotoContractPresenter{

    HttpAPIWrapper httpAPIWrapper;
    private final PhotoContract.View mView;
    private CompositeDisposable mCompositeDisposable;
    private PhotoActivity mActivity;

    @Inject
    public PhotoPresenter(@NonNull HttpAPIWrapper httpAPIWrapper, @NonNull PhotoContract.View view, PhotoActivity activity) {
        mView = view;
        this.httpAPIWrapper = httpAPIWrapper;
        mCompositeDisposable = new CompositeDisposable();
        this.mActivity = activity;
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
//                      //ToastUtil.show(mActivity, mActivity.getString(R.string.loading_failed_1));
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