package com.kaneki.lovelive.http.api;

import com.kaneki.lovelive.model.response.UserRsp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/5/6
 * @email yueqian@mogujie.com
 */
public interface UserService {

    @GET("2/users/show.json")
    Call<UserRsp> show(@Path("access_token") String access_token, @Path("uid") long uid);
}
