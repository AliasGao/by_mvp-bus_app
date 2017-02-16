package com.pingan.demo.bus;


import android.content.Context;

import com.pingan.common.bus.BaseModuleServer;
import com.pingan.common.bus.BusConfig;

public class DemoModuleServer extends BaseModuleServer<DemoModuleController> {

    @Override
    protected DemoModuleController createController() {
        return new DemoModuleController();
    }

    @Override
    public void onSyncCall(Context context, String bizName, Object params) {
        DemoModuleController controller = getController();
        switch (bizName) {
            case BusConfig.Demo.GOTO_DEMOPAGE:
                controller.goDemoView(context,params);
                break;
        }
    }

    @Override
    public void onAsyncCall(Context context, String bizName, Object params, BaseModuleServer.AsyncCallListener listener) {

    }
}
