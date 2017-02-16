package com.pingan.common.mvp;


public interface IView<P extends IPresenter> {
    void showProgress();
    void dismissProgress();
}
