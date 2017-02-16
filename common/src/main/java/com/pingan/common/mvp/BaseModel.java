package com.pingan.common.mvp;


public abstract class BaseModel<P extends IPresenter> {


    private P mPresenter;

    public BaseModel(P p){
        mPresenter = p;
    }

    public P getPresenter() {
        return mPresenter;
    }


}
