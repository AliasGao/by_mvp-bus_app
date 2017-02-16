package com.pingan.demo.bus;

import android.content.Context;
import android.content.Intent;

import com.pingan.common.bus.BaseModuleController;
import com.pingan.demo.ui.DemoActivity;

public class DemoModuleController extends BaseModuleController {

    public void goDemoView(Context context,Object param) {
        context.startActivity(new Intent(context, DemoActivity.class));
    }

}
