package com.pingan.common.mvp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pingan.common.R;
import com.pingan.common.controller.TitleViewController;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView<P> {

    private P mPresenter;
    private TitleViewController mTitleViewController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitleViewController = new TitleViewController();
        mPresenter = (P) createPresenter().attachView(this);
        initView();
        childInit();
    }

    private void initView() {
        hideActionBar();
        setContentView(getContentView());
        ButterKnife.bind(this);
    }

    protected P getPresenter() {
        return mPresenter;
    }

    protected abstract P createPresenter();

    protected abstract int getChildLayoutId();

    protected void childInit() {}

    protected void setTitleText(String string) {
        mTitleViewController.setText(string);
    }

    protected void setTitleBgColoer(int color) {mTitleViewController.setBgColor(color);}

    protected void setTitleVisibility(int visibility) {mTitleViewController.setVisibility(visibility);}

    protected void setTitleRightBtn(Drawable drawable,int visibility,boolean isFirst,Runnable runnable) {mTitleViewController.setRightView(drawable,visibility,isFirst,runnable);}

    private void hideActionBar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
    }

    private View getContentView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View contentView = inflater.inflate(R.layout.common_activity_base, null);
        inflater.inflate(getChildLayoutId(), (ViewGroup) contentView.findViewById(R.id.id_baseContent));
        mTitleViewController.init(contentView.findViewById(R.id.id_title), this);
        return contentView;
    }

}
