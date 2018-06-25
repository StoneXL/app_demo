package com.example.ai.myapplication2.ui.activity.home.presenter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ai.myapplication2.ui.activity.home.HomeActivity;
import com.example.ai.myapplication2.ui.activity.home.contract.HomeContract;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.entity.Host;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


/**
 * @author xlei
 * @Package com.example.ai.myapplication2.ui.activity.home
 * @Description: presenter of HomeActivity
 * @date 2017/09/18 10:44:16
 */
public class HomePresenter implements HomeContract.HomeContractPresenter{

    HttpAPIWrapper httpAPIWrapper;
    private final HomeContract.View mView;
    private CompositeDisposable mCompositeDisposable;
    private HomeActivity mActivity;

    @Inject
    public HomePresenter(@NonNull HttpAPIWrapper httpAPIWrapper, @NonNull HomeContract.View view, HomeActivity activity) {
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
private int flag=1;
    @Override
    public void loadHost() {
        mView.showProgressDialog();
        String uuid = mActivity.getSharedPreferences("defult", Context.MODE_PRIVATE).getString("UUID", "");
        Map<String, String> map = new HashMap<>();
        map.put("uuid",uuid);
        Log.e("uuid",uuid);
        Disposable disposable = httpAPIWrapper.getHost(map).subscribe(new Consumer<Host>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Host host) throws Exception {
                List<Host.DataBean> data = host.getData();
                if (flag==1)
                { data.clear();
                flag++;}
                mView.closeProgressDialog();
                mView.loadHostSucces(data);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                mView.closeProgressDialog();
                mView.loadHostFail();
            }
        });
        mCompositeDisposable.add(disposable);
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