package com.zfxf.network.interfaces;

import androidx.annotation.Nullable;

/**
 * Date:2020/6/3
 * author:lwb
 * Desc:
 */
public interface INetworkCallback {

    /**
     * 获取BaseUrl
     *
     * @return
     */
    String getBaseUrl();

    /**
     * 获取deviceId
     * @return
     */
    String getDeviceId();

    /**
     * 获取外界的token
     *
     * @return
     */
    String getToken();

    /**
     * 刷新外面的token
     * 这个方法会在 TokenInterceptor 中调用到
     *
     * @param newToken
     */
    void refreshToken(@Nullable String newToken);
}
