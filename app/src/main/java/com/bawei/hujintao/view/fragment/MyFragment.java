package com.bawei.hujintao.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.view.activity.AddressActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:53
 */
public class MyFragment extends BaseFragment {
    @BindView(R.id.bt_jump)
    TextView btJump;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layoutId() {
        return R.layout.my;
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.bt_jump)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), AddressActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }
}
