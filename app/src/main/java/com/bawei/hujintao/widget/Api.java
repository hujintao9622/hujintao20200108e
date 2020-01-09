package com.bawei.hujintao.widget;

import com.bawei.hujintao.model.bean.AddressBean;
import com.bawei.hujintao.model.bean.CartBean;
import com.bawei.hujintao.model.bean.InsertAddBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 6:08
 */
public interface Api {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartBean> cartData(@Header("sessionId")String sid,@Header("userId")String uid);
    @GET("small/user/verify/v1/receiveAddressList")
    Observable<AddressBean> addData(@Header("sessionId")String sid,@Header("userId")String uid);
    @FormUrlEncoded
    @POST("small/user/verify/v1/addReceiveAddress")
    Observable<InsertAddBean> insertAddress(@Header("sessionId")String sid, @Header("userId")String uid, @Field("realName")String name,@Field("phone")String phone,@Field("address")String address,@Field("zipCode")String you);
}
