package com.kaneki.lovelive.http.api;

import com.kaneki.lovelive.model.response.AccessTokenRsp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/28
 * @email yueqian@mogujie.com
 */
public interface Oauth2Service {

    @GET("oauth2/access_token")
    Call<AccessTokenRsp> accessToken(@Path("client_id") String client_id, @Path("client_secret") String client_secret,
                                      @Path("grant_type") String grant_type, @Path("code") String code, @Path("redirect_uri") String redirect_uri);
}
