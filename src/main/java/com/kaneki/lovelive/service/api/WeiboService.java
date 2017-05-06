package com.kaneki.lovelive.service.api;

import com.kaneki.lovelive.model.response.UserTimelineRsp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/6
 * @email yueqian@mogujie.com
 */
public interface WeiboService {

    @GET("2/statuses/user_timeline.json")
    Call<UserTimelineRsp> userTimeline(@Path("access_token") String access_token, @Path("uid") long uid,
                                       @Path("since_id") long since_id, @Path("count") int count,
                                       @Path("page") int page, @Path("feature") int feature,
                                       @Path("trim_user") int trim_user);
}
