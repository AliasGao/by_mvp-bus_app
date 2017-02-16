package com.pingan.common.bus;

import android.support.v4.util.ArrayMap;

import java.util.Map;

public class ModuleClientFactory {

    static Map<String, ModuleClientBean> sModuleMap = new ArrayMap<>();

    static {
        sModuleMap.put("demo", new ModuleClientBean(BusConfig.Demo.MODULE_NAME, "com.pingan.demo.bus", "DemoModuleServer"));
        sModuleMap.put("main", new ModuleClientBean(BusConfig.Main.MODULE_NAME, "com.pingan.extractapp.bus", "MainServer"));
    }

    public static Map<String, ModuleClientBean> getModuleClientMap() {
        return sModuleMap;
    }

}
