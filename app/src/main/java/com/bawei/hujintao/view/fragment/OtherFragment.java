package com.bawei.hujintao.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseFragment;
import com.bawei.hujintao.base.BasePresenter;

import butterknife.BindView;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:53
 */
public class OtherFragment extends BaseFragment {
    @BindView(R.id.other_name)
    TextView otherName;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int layoutId() {
        return R.layout.other;
    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        String key = getArguments().getString("key");
        otherName.setText(key);
    }

    public static OtherFragment getInstance(String value) {
        OtherFragment otherFragment = new OtherFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",value);
        otherFragment.setArguments(bundle);
        return otherFragment;
    }
}
