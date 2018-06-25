package com.example.ai.myapplication2.ui.activity.index.presenter;
import android.support.annotation.NonNull;
import com.example.ai.myapplication2.data.api.HttpAPIWrapper;
import com.example.ai.myapplication2.ui.activity.index.contract.IndexContract;
import com.example.ai.myapplication2.ui.activity.index.IndexActivity;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author xxlei
 * @Package com.example.ai.myapplication2.ui.activity.index
 * @Description: presenter of IndexActivity
 * @date 2017/09/26 14:31:52
 */
public class IndexPresenter implements IndexContract.IndexContractPresenter{

    HttpAPIWrapper httpAPIWrapper;
    private final IndexContract.View mView;
    private CompositeDisposable mCompositeDisposable;
    private IndexActivity mActivity;

    @Inject
    public IndexPresenter(@NonNull HttpAPIWrapper httpAPIWrapper, @NonNull IndexContract.View view, IndexActivity activity) {
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