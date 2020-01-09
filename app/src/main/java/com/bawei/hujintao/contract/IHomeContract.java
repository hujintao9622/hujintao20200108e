package com.bawei.hujintao.contract;

import com.bawei.hujintao.model.bean.CartBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:29
 */
public interface IHomeContract {
    interface IView{
        void onSuccess(CartBean cartBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getCartData();
    }
    interface IModel{
        void getCartData(IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(CartBean cartBean);
            void onFailure(Throwable throwable);
        }
    }
}
