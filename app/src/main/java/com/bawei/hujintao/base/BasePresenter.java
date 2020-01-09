package com.bawei.hujintao.base;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 4:44
 */
public abstract class BasePresenter <V>{
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();
}
