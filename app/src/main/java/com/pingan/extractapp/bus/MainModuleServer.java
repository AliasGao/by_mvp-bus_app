package com.pingan.extractapp.bus;

import android.content.Context;

import com.pingan.common.bus.BaseModuleServer;

public class MainModuleServer extends BaseModuleServer<MainController> {
    @Override
    protected MainController createController() {
        return new MainController();
    }

    @Override
    public void onSyncCall(Context context, String bizName, Object params) {

    }

    @Override
    public void onAsyncCall(Context context, String bizName, Object params, AsyncCallListener listener) {

    }
}
