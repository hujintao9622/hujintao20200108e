package com.bawei.hujintao.view.activity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.hujintao.R;
import com.bawei.hujintao.base.BaseActivity;
import com.bawei.hujintao.base.BasePresenter;
import com.bawei.hujintao.view.fragment.CartFragment;
import com.bawei.hujintao.view.fragment.HomeFragment;
import com.bawei.hujintao.view.fragment.MyFragment;
import com.bawei.hujintao.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.ma_vp)
    ViewPager maVp;
    @BindView(R.id.ma_rg)
    RadioGroup maRg;
    private List<Fragment>list=new ArrayList<>();
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment fenlei = OtherFragment.getInstance("分类");
        OtherFragment faxian = OtherFragment.getInstance("发现");
        CartFragment cartFragment = new CartFragment();
        MyFragment myFragment = new MyFragment();
        list.add(homeFragment);
        list.add(fenlei);
        list.add(faxian);
        list.add(cartFragment);
        list.add(myFragment);
        maVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    @Override
    protected void initView() {
        maVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                maRg.check(maRg.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        maRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.ma_rb1:{
                        maVp.setCurrentItem(0);
                    }break;
                    case R.id.ma_rb2:{
                        maVp.setCurrentItem(1);
                    }break;
                    case R.id.ma_rb3:{
                        maVp.setCurrentItem(2);
                    }break;
                    case R.id.ma_rb4:{
                        maVp.setCurrentItem(3);
                    }break;
                    case R.id.ma_rb5:{
                        maVp.setCurrentItem(4);
                    }break;
                }
            }
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}
