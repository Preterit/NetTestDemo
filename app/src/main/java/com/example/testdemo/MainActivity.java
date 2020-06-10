package com.example.testdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.zfxf.network.NetworkSession;
import com.zfxf.network.entriy.BaseResponse;
import com.zfxf.network.entriy.TokenBean;
import com.zfxf.network.interfaces.IRequestCallBack;
import com.zfxf.network.net.DefaultRetrofitClient;
import com.zfxf.network.net.RequstHelper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRequestClicked(View view) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    getNewToken();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //用同步方法获取新的Token
    private String getNewToken() throws IOException {
        // 通过获取token的接口，同步请求接口
        String token = null;
        retrofit2.Response<BaseResponse<TokenBean>> response = DefaultRetrofitClient.getInstance()
                .getHttpApi()
                .refreshToken("singleman", "123456")
                .execute();
        BaseResponse<TokenBean> body = response.body();
        if (body != null) {
            TokenBean data = body.getData();
            if (data != null) {
                token = data.getToken();
                //这里进行接口 回调出去，让外部知道刷新好的token
                if (!TextUtils.isEmpty(token)) {
                    NetworkSession.get().getNetworkConfig().setNewToken(token);
                }
            }
        }
        return token;
    }

    public void test() throws IOException {
        Call<BaseResponse<TokenBean>> response = DefaultRetrofitClient.getInstance()
                .getHttpApi()
                .refreshToken("singleman", "123456");
        RequstHelper.postEnqueue(response, new IRequestCallBack<TokenBean>() {
            @Override
            public void success(TokenBean tokenBean) {

            }

            @Override
            public void onFailure(int code, String error) {

            }
        });
    }
}