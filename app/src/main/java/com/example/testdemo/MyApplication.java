package com.example.testdemo;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.zfxf.network.NetworkConfig;
import com.zfxf.network.NetworkSession;
import com.zfxf.network.interfaces.NetworkApi;
import com.zfxf.network.interfaces.INetworkCallback;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public class MyApplication extends Application implements INetworkCallback {
    private NetworkConfig build;

    @Override
    public void onCreate() {
        super.onCreate();

        if (build == null) {
            build = new NetworkConfig.Builder()
                    .setNetworkCallback(this)
                    .build();
        }
        NetworkSession.init(this, BuildConfig.DEBUG, build);
    }

    @Override
    public String getBaseUrl() {
        return NetworkApi.BASEURL;
    }

    @Override
    public String getDeviceId() {
        return null;
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public void refreshToken(@Nullable String newToken) {
        Toast.makeText(this, "" + newToken, Toast.LENGTH_SHORT).show();
    }
}
