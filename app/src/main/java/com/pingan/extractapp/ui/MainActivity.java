package com.pingan.extractapp.ui;

import android.view.View;
import android.widget.TextView;

import com.pingan.common.mvp.BaseActivity;
import com.pingan.extractapp.R;
import com.pingan.extractapp.presenter.IMainPresenter;
import com.pingan.extractapp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<IMainPresenter> implements MainView {

    @BindView(R.id.id_mainText)
    TextView mTv;

    @BindView(R.id.id_mainBtn)
    TextView mBtn;

    @OnClick(R.id.id_mainBtn)
    void onClick(View view) {
        getPresenter().sendGoDemoRequest(this);
    }

    @Override
    protected void childInit() {
        setTitleText("Main Module");
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getChildLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    public void showProgress() {}

    @Override
    public void dismissProgress() {}
}
