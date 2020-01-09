package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.model.bean.CartBean;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:29
 */
public class CartModel implements IHomeContract.IModel {
    @Override
    public void getCartData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().cartData("157853091893213107","13107")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        iModelCallback.onSuccess(cartBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
