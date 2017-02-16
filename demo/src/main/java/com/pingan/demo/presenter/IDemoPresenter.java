package com.pingan.demo.presenter;


import com.pingan.common.mvp.IPresenter;
import com.pingan.demo.model.DemoBean;
import com.pingan.demo.ui.DemoView;

public interface IDemoPresenter extends IPresenter<DemoView> {
    void showEmpty();
    void showData(DemoBean bean);
    void getData();
}
