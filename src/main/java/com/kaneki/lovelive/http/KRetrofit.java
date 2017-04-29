package com.kaneki.lovelive.http;

import com.kaneki.lovelive.config.WeiboConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/28
 * @email yueqian@mogujie.com
 */
public class KRetrofit {
    private Retrofit retrofit;

    private volatile static KRetrofit kRetrofit;

    public static KRetrofit getInstance() {
        if (kRetrofit == null) {
            synchronized (KRetrofit.class) {
                if (kRetrofit == null) {
                    kRetrofit = new KRetrofit();
                }
            }
        }
        return kRetrofit;
    }

    private KRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(WeiboConfig.getValue("baseURL"))//★这里最后面必须能带“/”
                .addConverterFactory(GsonConverterFactory.create())//设置将json解析为javabean所用的方式
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
