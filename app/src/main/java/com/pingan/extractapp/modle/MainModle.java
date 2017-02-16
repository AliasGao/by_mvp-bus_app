package com.pingan.extractapp.modle;

import android.content.Context;

import com.pingan.common.bus.BusConfig;
import com.pingan.common.bus.ModuleCaller;
import com.pingan.common.mvp.BaseModel;
import com.pingan.extractapp.presenter.IMainPresenter;

public class MainModle extends BaseModel<IMainPresenter> {

    public MainModle(IMainPresenter iMainPresenter) {
        super(iMainPresenter);
    }

    public void sendGoDemoRequest(Context context) {
        ModuleCaller.ServiceRequest request = new ModuleCaller.ServiceRequest(context, BusConfig.Demo.GOTO_DEMOPAGE, ModuleCaller.CallType.SyncCall);
        ModuleCaller.callService(request);
    }
}
