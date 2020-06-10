package com.zfxf.network.net;


import com.zfxf.network.entriy.BaseResponse;
import com.zfxf.network.interfaces.IRequestCallBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public class RequstHelper {

    public static <T> void postEnqueue(Call<BaseResponse<T>> responseCall, final IRequestCallBack<T> callback) {

        responseCall.enqueue(new Callback<BaseResponse<T>>() {
            @Override
            public void onResponse(Call<BaseResponse<T>> call, Response<BaseResponse<T>> response) {
                if (response != null) {
                    BaseResponse<T> body = response.body();
                    callback.success(body.getData());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<T>> call, Throwable t) {

            }
        });

    }
}
