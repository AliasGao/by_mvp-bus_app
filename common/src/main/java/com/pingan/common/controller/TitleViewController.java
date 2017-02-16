package com.pingan.common.controller;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pingan.common.R;

public class TitleViewController {

    private View mTitleView;

    public void init(View titleView, final Activity activity) {
        mTitleView = titleView;
        defaultInit(titleView, activity);
    }

    private void defaultInit(View titleView, final Activity activity) {

        setBackAction(titleView, new Runnable() {
            @Override
            public void run() {
                activity.finish();
            }
        });

        setBgColor(Color.WHITE);

        setRightView(activity.getResources().getDrawable(R.drawable.common_titile_right_arrow), View.VISIBLE, true, new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, "btn default onclick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public static void setBackAction(View view, final Runnable action) {
        view.findViewById(R.id.id_leftback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.run();
            }
        });
    }

    public void setVisibility(int visibility) {
        mTitleView.setVisibility(visibility);
    }



    public void setText(String text) {
        ((TextView) mTitleView.findViewById(R.id.id_titleText)).setText(text);
    }

    public void setBgColor(int color) {
        mTitleView.setBackgroundColor(color);
    }

    public void setRightView(Drawable drawable,int visibility,boolean isFirst, final Runnable action) {
        LinearLayout rightGroup = (LinearLayout) mTitleView.findViewById(R.id.id_rightArea);
        ImageView target = (ImageView) (isFirst ? rightGroup.findViewById(R.id.id_title_right_1) : rightGroup.findViewById(R.id.id_title_right_2));
        target.setVisibility(visibility);
        if (visibility != View.GONE) {
            target.setImageDrawable(drawable);
            target.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    action.run();
                }
            });
        }

    }
}
