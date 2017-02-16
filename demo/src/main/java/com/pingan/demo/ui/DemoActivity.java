package com.pingan.demo.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pingan.common.mvp.BaseActivity;
import com.pingan.demo.R;
import com.pingan.demo.R2;
import com.pingan.demo.model.DemoBean;
import com.pingan.demo.presenter.DemoPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class DemoActivity extends BaseActivity<DemoPresenter> implements DemoView {

    @BindView(R2.id.id_demoText)
    TextView mTextView;

    @BindView(R2.id.id_demoBtn)
    Button mBtn;

    @OnClick(R2.id.id_demoBtn)
    void onClick(View view) {
        getPresenter().getData();
    }

    @Override
    protected void childInit() {
        setTitleText("Demo Module");
        setTitleRightBtn(getResources().getDrawable(R.drawable.common_title_right_add), View.VISIBLE, true, new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DemoActivity.this, "Demo Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected DemoPresenter createPresenter() {
        return new DemoPresenter();
    }

    @Override
    protected int getChildLayoutId() {
        return R.layout.demo_activity_demo;
    }

    @Override
    public void showEmpty() {}

    @Override
    public void showData(DemoBean bean) {
        mTextView.setText(bean.getDemoMsg());
    }

    @Override
    public void showProgress() {}

    @Override
    public void dismissProgress() {}
}
