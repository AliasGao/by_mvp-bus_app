package com.pingan.demo.model;


import com.pingan.common.mvp.BaseModel;
import com.pingan.demo.presenter.IDemoPresenter;

public class DemoModel extends BaseModel<IDemoPresenter> {

    public DemoModel(IDemoPresenter demoPresenter) {
        super(demoPresenter);
    }

    public void doBusiness() {
        getPresenter().showData(mockData());
    }

    private DemoBean mockData(){
        return new DemoBean("mock data");
    }


}
