package com.bawei.hujintao.view.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.contract.IHomeContract;
import com.bawei.hujintao.model.bean.CartBean;
import com.bawei.hujintao.presenter.CartPresenter;
import com.bawei.hujintao.view.adapter.CartAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:53
 */
public class CartFragment extends BaseFragment<CartPresenter> implements IHomeContract.IView {

    @BindView(R.id.cart_lv)
    ExpandableListView cartLv;
    @BindView(R.id.cart_ch)
    CheckBox cartCh;
    @BindView(R.id.cart_price)
    TextView cartPrice;
    @BindView(R.id.cart_bt)
    Button cartBt;
    private CartAdapter cartAdapter;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layoutId() {
        return R.layout.cart;
    }

    @Override
    protected CartPresenter providePresenter() {
        return new CartPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getCartData();
    }

    @Override
    public void onSuccess(CartBean cartBean) {
        List<CartBean.ResultBean> result = cartBean.getResult();
        cartAdapter = new CartAdapter(result);
        cartAdapter.setOnCliceListener(new CartAdapter.OnClickListener() {
            @Override
            public void OnClick() {
                cartPrice.setText("￥"+cartAdapter.getSumPrice());
                cartBt.setText("去结算("+cartAdapter.getSumNumBer()+")");
                cartCh.setChecked(cartAdapter.getCheckIsChecked());
            }
        });
        cartLv.setAdapter(cartAdapter);
        for (int i = 0; i < result.size(); i++) {
            cartLv.expandGroup(i);
        }
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e("cart", throwable.getMessage());
    }

    @OnClick(R.id.cart_ch)
    public void onViewClicked() {
        //获取状态
        boolean checkIsChecked = cartAdapter.getCheckIsChecked();
        checkIsChecked=!checkIsChecked;
        cartAdapter.changeCheckIsChecked(checkIsChecked);
        cartPrice.setText("￥"+cartAdapter.getSumPrice());
        cartBt.setText("去结算("+cartAdapter.getSumNumBer()+")");
        cartCh.setChecked(cartAdapter.getCheckIsChecked());
    }
}
