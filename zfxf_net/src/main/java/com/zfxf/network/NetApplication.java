package com.zfxf.network;

import android.app.Application;

import androidx.annotation.Nullable;

import com.zfxf.network.interfaces.INetworkCallback;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public abstract class NetApplication extends Application implements INetworkCallback {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public String getDeviceId() {
        return "设备id";
    }

    @Override
    public String getToken() {
        return "Token";
    }

    @Override
    public void refreshToken(@Nullable String newToken) {

    }

}
