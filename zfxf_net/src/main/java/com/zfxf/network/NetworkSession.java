package com.zfxf.network;

import android.content.Context;

/**
 * @author :  lwb
 * Date: 2020/6/10
 * Desc:
 */
public class NetworkSession {
    private static NetworkConfig mNetworkConfig;
    private static boolean isAppDebug;
    private static Context mContext;

    private NetworkSession() {
    }

    public static NetworkSession get() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final NetworkSession INSTANCE = new NetworkSession();
    }

    public static void init(Context context, boolean isDebug, NetworkConfig networkConfig) {
        mContext = context.getApplicationContext();
        isAppDebug = isDebug;
        mNetworkConfig = networkConfig;
    }

    public NetworkConfig getNetworkConfig() {
        return mNetworkConfig;
    }

    public Context getContext() {
        return mContext;
    }

    public static boolean isDebug() {
        return isAppDebug;
    }


}
