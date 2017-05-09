package com.kaneki.lovelive.job;

import com.kaneki.lovelive.cache.CacheCenter;
import com.kaneki.lovelive.http.KRetrofit;
import com.kaneki.lovelive.model.entity.LoveSister;
import com.kaneki.lovelive.model.response.UserRsp;
import com.kaneki.lovelive.http.api.UserApi;
import com.kaneki.lovelive.service.LoveSisterService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/6
 * @email yueqian@mogujie.com
 */
public class FetchSisterJob extends QuartzJobBean {

    @Autowired
    private LoveSisterService loveSisterService;

    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        final UserApi userApi = KRetrofit.getInstance().getRetrofit().create(UserApi.class);
        Call<UserRsp> userRspCall = userApi.show(CacheCenter.getInstance().getAccessToken(), 0);
        userRspCall.enqueue(new Callback<UserRsp>() {
            public void onResponse(Call<UserRsp> call, Response<UserRsp> response) {
                if (response.isSuccessful()) {
                    UserRsp userRsp = response.body();
                    LoveSister loveSister = new LoveSister();
                    loveSister.setUid(userRsp.getId());
                    loveSister.setScreen_name(userRsp.getScreen_name());
                    loveSister.setFollowers_count(userRsp.getFollowers_count());
                    loveSister.setProfile_image_url(userRsp.getProfile_image_url());
                    loveSister.setSince_set_id(0);
                    loveSister = loveSisterService.addNewSister(loveSister);
                }
            }

            public void onFailure(Call<UserRsp> call, Throwable throwable) {

            }
        });
    }
}
