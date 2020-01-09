package com.bawei.hujintao.model;

import com.bawei.hujintao.contract.IInsertAddressContract;
import com.bawei.hujintao.model.bean.InsertAddBean;
import com.bawei.hujintao.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 9:30
 */
public class InsertAddressModel implements IInsertAddressContract.IModel {

    @Override
    public void getAddressData(String name, String phone, String address, String you, IModelCallback iModelCallback) {
        NetUtil.getInstance().getApi().insertAddress("157853091893213107","13107",name,phone,address,you)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InsertAddBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InsertAddBean insertAddBean) {
                        iModelCallback.onSuccess(insertAddBean);
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
