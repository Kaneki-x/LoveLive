package com.kaneki.lovelive.cache;

import com.kaneki.lovelive.http.KRetrofit;
import retrofit2.Retrofit;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/29
 * @email yueqian@mogujie.com
 */
public class CacheCenter {

    private String accessToken;
    private String uid;

    private CacheCenter() {
    }

    private volatile static CacheCenter cacheCenter;

    public static CacheCenter getInstance() {
        if (cacheCenter == null) {
            synchronized (KRetrofit.class) {
                if (cacheCenter == null) {
                    cacheCenter = new CacheCenter();
                }
            }
        }
        return cacheCenter;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
