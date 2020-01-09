package com.bawei.hujintao.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.contract.IInsertAddressContract;
import com.bawei.hujintao.model.bean.InsertAddBean;
import com.bawei.hujintao.presenter.InsertAddressPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsertAddressActivity extends BaseActivity<InsertAddressPresenter> implements IInsertAddressContract.IView {


    @BindView(R.id.in_name)
    EditText inName;
    @BindView(R.id.in_phone)
    EditText inPhone;
    @BindView(R.id.in_address)
    EditText inAddress;
    @BindView(R.id.in_you)
    EditText inYou;
    @BindView(R.id.in_bt)
    Button inBt;

    @Override
    protected InsertAddressPresenter providePresenter() {
        return new InsertAddressPresenter();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int layoutId() {
        return R.layout.activity_insert_address;
    }

    @Override
    public void onSuccess(InsertAddBean addressBean) {
        Toast.makeText(this, "" + addressBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Throwable throwable) {
        Log.e("xx", throwable.getMessage());
    }
    @OnClick(R.id.in_bt)
    public void onViewClicked() {
        String name = inName.getText().toString();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String phone = inPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String address = inAddress.getText().toString();
        if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String you = inYou.getText().toString();
        if (TextUtils.isEmpty(you)) {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        mPresenter.getAddressData(name, phone, address, you);
    }
}
