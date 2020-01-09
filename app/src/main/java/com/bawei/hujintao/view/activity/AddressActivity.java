package com.bawei.hujintao.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.contract.IAddressContract;
import com.bawei.hujintao.model.bean.AddressBean;
import com.bawei.hujintao.presenter.AddressPresenter;
import com.bawei.hujintao.view.adapter.AddressAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity<AddressPresenter> implements IAddressContract.IView {
    @BindView(R.id.address_add)
    Button addressAdd;
    @BindView(R.id.address_rv)
    RecyclerView addressRv;

    @Override
    protected AddressPresenter providePresenter() {
        return new AddressPresenter();
    }

    @Override
    protected void initData() {
        mPresenter.getAddressData();
    }

    @Override
    protected void initView() {
        addressRv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_address;
    }

    @Override
    public void onSuccess(AddressBean addressBean) {
        List<AddressBean.ResultBean> result = addressBean.getResult();
        //设置适配器
        AddressAdapter addressAdapter = new AddressAdapter(result);
        addressRv.setAdapter(addressAdapter);
    }

    @Override
    public void onFailure(Throwable throwable) {

    }
    @OnClick(R.id.address_add)
    public void onViewClicked() {
        Intent intent = new Intent(AddressActivity.this,InsertAddressActivity.class);
        startActivity(intent);
        finish();
    }
}
