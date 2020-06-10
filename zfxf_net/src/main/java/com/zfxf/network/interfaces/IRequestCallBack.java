package com.zfxf.network.interfaces;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public interface IRequestCallBack<T> {
    void success(T t);

    void onFailure(int code, String error);
}
