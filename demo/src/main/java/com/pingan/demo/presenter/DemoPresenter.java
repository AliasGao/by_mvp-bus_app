package com.pingan.demo.presenter;

import com.pingan.common.mvp.IPresenter;
import com.pingan.demo.model.DemoBean;
import com.pingan.demo.model.DemoModel;
import com.pingan.demo.ui.DemoView;


public class DemoPresenter implements IDemoPresenter {

    private DemoView mView;

    private DemoModel mModel;

    public DemoPresenter() {
        mModel = new DemoModel(this);
    }

    @Override
    public IPresenter attachView(DemoView view) {
        mView = view;
        return this;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void showEmpty() {
        mView.showEmpty();
    }

    @Override
    public void showData(DemoBean bean) {
        mView.showData(bean);
    }

    @Override
    public void getData() {
        mModel.doBusiness();
    }

}
