package com.bawei.hujintao.presenter;

import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.model.CartModel;
import com.bawei.hujintao.model.bean.CartBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 6:23
 */
public class CartPresenter extends BasePresenter<IHomeContract.IView> implements IHomeContract.IPresenter {

    private CartModel cartModel;

    @Override
    protected void initModel() {
        cartModel = new CartModel();
    }

    @Override
    public void getCartData() {
        cartModel.getCartData(new IHomeContract.IModel.IModelCallback() {
            @Override
            public void onSuccess(CartBean cartBean) {
                view.onSuccess(cartBean);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.onFailure(throwable);
            }
        });
    }
}
