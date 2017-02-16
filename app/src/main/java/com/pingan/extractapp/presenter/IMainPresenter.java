package com.pingan.extractapp.presenter;

import android.content.Context;

import com.pingan.common.mvp.IPresenter;
import com.pingan.extractapp.ui.MainView;

public interface IMainPresenter extends IPresenter<MainView> {
    void sendGoDemoRequest(Context context);
}
