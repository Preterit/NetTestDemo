package com.zfxf.network.net;


import com.zfxf.network.entriy.BaseResponse;
import com.zfxf.network.interfaces.IRequestCallBack;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public class RequstHelper {

    public static <T> void postEnqueue(Call<BaseResponse<T>> responseCall, IRequestCallBack<T> callback) {
        try {
            Response<BaseResponse<T>> execute = responseCall.execute();
            BaseResponse<T> baseResponse = execute.body();
            if (baseResponse != null && baseResponse.getCode() == 200) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
