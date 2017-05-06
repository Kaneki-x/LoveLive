package com.kaneki.lovelive.controller;

import com.kaneki.lovelive.cache.CacheCenter;
import com.kaneki.lovelive.config.WeiboConfig;
import com.kaneki.lovelive.http.KRetrofit;
import com.kaneki.lovelive.model.response.AccessTokenRsp;
import com.kaneki.lovelive.service.api.Oauth2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yueqian
 * @Desctription
 * @date 2017/4/28
 * @email yueqian@mogujie.com
 */
@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    /**
     */
    @RequestMapping(value = "/authorize")
    public ModelAndView loginPageIndex() {
        return new ModelAndView("redirect:" + WeiboConfig.getValue("authorize_url") + "?client_id=" + WeiboConfig.getValue("client_id") + "&redirect_uri=" + WeiboConfig.getValue("redirect_url"));
    }

    /**
     */
    @RequestMapping(value = "/default")
    public void loginPageIndex(HttpServletRequest request) {
        String code = request.getParameter("code");
        Oauth2Service oauth2Service = KRetrofit.getInstance().getRetrofit().create(Oauth2Service.class);
        Call<AccessTokenRsp> call = oauth2Service.accessToken(WeiboConfig.getValue("client_id"), WeiboConfig.getValue("client_secret"),
                "authorization_code", code, WeiboConfig.getValue("redirect_url"));
        call.enqueue(new Callback<AccessTokenRsp>() {
            public void onResponse(Call<AccessTokenRsp> call, Response<AccessTokenRsp> response) {
                AccessTokenRsp accessTokenRsp = response.body();
                CacheCenter.getInstance().setAccessToken(accessTokenRsp.getAccess_token());
                CacheCenter.getInstance().setUid(accessTokenRsp.getUid());
            }

            public void onFailure(Call<AccessTokenRsp> call, Throwable throwable) {

            }
        });
    }
}
