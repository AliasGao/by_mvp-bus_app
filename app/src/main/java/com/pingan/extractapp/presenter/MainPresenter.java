package com.pingan.extractapp.presenter;

import android.content.Context;

import com.pingan.common.mvp.IPresenter;
import com.pingan.extractapp.modle.MainModle;
import com.pingan.extractapp.ui.MainView;

public class MainPresenter implements IMainPresenter {

    private MainView mView ;
    private MainModle mModle;

    public MainPresenter() {
        mModle = new MainModle(this);
    }

    @Override
    public IPresenter attachView(MainView view) {
        mView = view;
        return this;
    }

    @Override
    public void detachView() {
        mView = null;
    }


    @Override
    public void sendGoDemoRequest(Context context) {
        mModle.sendGoDemoRequest(context);
    }
}
