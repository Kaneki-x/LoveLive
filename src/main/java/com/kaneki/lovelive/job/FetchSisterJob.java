package com.kaneki.lovelive.job;

import com.kaneki.lovelive.cache.CacheCenter;
import com.kaneki.lovelive.http.KRetrofit;
import com.kaneki.lovelive.model.response.UserRsp;
import com.kaneki.lovelive.http.api.UserApi;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import retrofit2.Call;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/6
 * @email yueqian@mogujie.com
 */
public class FetchSisterJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        UserApi userApi = KRetrofit.getInstance().getRetrofit().create(UserApi.class);
        Call<UserRsp> userRspCall = userApi.show(CacheCenter.getInstance().getAccessToken(), 0);
    }
}
