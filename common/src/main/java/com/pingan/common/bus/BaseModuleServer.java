package com.pingan.common.bus;


import android.content.Context;

public abstract class BaseModuleServer<P extends BaseModuleController> {

    private P mController;

    public BaseModuleServer() {
        mController = createController();
    }

    protected abstract P createController();

    protected P getController() {
        return mController;
    }

    public static abstract class AsyncCallListener {
        abstract void onAsyncCallResponse();
    }

    //同步请求接口
    public abstract void onSyncCall(Context context, String bizName, Object params);

    //异步请求接口
    public abstract void onAsyncCall(Context context, String bizName, Object params, AsyncCallListener listener);

}
