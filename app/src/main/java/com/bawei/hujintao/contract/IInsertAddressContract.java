package com.bawei.hujintao.contract;
import com.bawei.hujintao.model.bean.InsertAddBean;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/9 0009 上午 8:52
 */
public interface IInsertAddressContract {
    interface IView{
        void onSuccess(InsertAddBean addressBean);
        void onFailure(Throwable throwable);
    }
    interface IPresenter{
        void getAddressData(String name,String phone,String address,String you);
    }
    interface IModel{
        void getAddressData(String name,String phone,String address,String you,IModelCallback iModelCallback);
        interface IModelCallback{
            void onSuccess(InsertAddBean addressBean);
            void onFailure(Throwable throwable);
        }
    }
}
