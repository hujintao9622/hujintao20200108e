package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.AddressBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 8:52
 */
public interface IAddressContract {
    interface IView{
        void onSuccess(AddressBean addressBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getAddressData();
    }
    interface IModel{
        void getAddressData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(AddressBean addressBean);
            void onFailure(Throwable throwable);
        }
    }
}
