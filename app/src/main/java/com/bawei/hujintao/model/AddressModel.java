package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IAddressContract;
import com.bawei.hujintao.model.bean.AddressBean;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 8:52
 */
public class AddressModel implements IAddressContract.IModel {
    @Override
    public void getAddressData(IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().addData("157853091893213107","13107")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddressBean addressBean) {
                        iModelCallback.onSuccess(addressBean);
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
