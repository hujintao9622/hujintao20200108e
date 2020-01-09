package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.IAddressContract;
import com.bawei.hujintao.model.AddressModel;
import com.bawei.hujintao.model.bean.AddressBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 8:56
 */
public class AddressPresenter extends BasePresenter<IAddressContract.IView> implements IAddressContract.IPresenter {

    private AddressModel addressModel;

    @Override
    protected void initModel() {
        addressModel = new AddressModel();
    }

    @Override
    public void getAddressData() {
        addressModel.getAddressData(new IAddressContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(AddressBean addressBean) {
                view.onSuccess(addressBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
