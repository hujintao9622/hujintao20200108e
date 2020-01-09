package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.IInsertAddressContract;
import com.bawei.hujintao.model.InsertAddressModel;
import com.bawei.hujintao.model.bean.InsertAddBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 9:32
 */
public class InsertAddressPresenter extends BasePresenter<IInsertAddressContract.IView> implements IInsertAddressContract.IPresenter {

    private InsertAddressModel insertAddressModel;

    @Override
    protected void initModel() {
        insertAddressModel = new InsertAddressModel();
    }

    @Override
    public void getAddressData(String name, String phone, String address, String you) {
        insertAddressModel.getAddressData(name, phone, address, you, new IInsertAddressContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(InsertAddBean addressBean) {
                view.onSuccess(addressBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
