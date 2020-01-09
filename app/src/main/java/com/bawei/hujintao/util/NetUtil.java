package com.bawei.hujintao.util;

import android.widget.ImageView;

import com.bawei.hujintao.R;
import com.bawei.hujintao.widget.Api;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2020/1/8 0008 下午 5:05
 */
public class NetUtil {
    //单例封装
    private static final String baseUrl="http://172.17.8.100/";
    private final Api api;

    private NetUtil(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }
    private static final class SingleHolder{
        private static final NetUtil NET_UTIL=new NetUtil();
    }

    public Api getApi() {
        return api;
    }
    public void getPhoto(String bit, ImageView img){
        Glide.with(img).load(bit)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(img);
    }
}
