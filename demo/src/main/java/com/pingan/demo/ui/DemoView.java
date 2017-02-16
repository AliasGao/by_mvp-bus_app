package com.pingan.demo.ui;


import com.pingan.common.mvp.IView;
import com.pingan.demo.model.DemoBean;
import com.pingan.demo.presenter.DemoPresenter;

public interface DemoView extends IView<DemoPresenter> {

    void showEmpty();
    void showData(DemoBean bean);
}
