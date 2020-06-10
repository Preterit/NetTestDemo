package com.zfxf.network.interfaces;

import com.zfxf.network.entriy.BaseResponse;
import com.zfxf.network.entriy.TokenBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public interface NetworkApi {
    String BASEURL = "https://wanandroid.com/";

    @POST("user/login")
    @FormUrlEncoded
    Call<BaseResponse<TokenBean>> refreshToken(@Field("username") String username, @Field("password") String paw);
}
