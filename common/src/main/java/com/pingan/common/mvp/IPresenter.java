package com.pingan.common.mvp;

public interface IPresenter<V extends IView> {
    IPresenter attachView(V view);
    void detachView();
}
