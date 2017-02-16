package com.pingan.common.bus;

import android.content.Context;
import android.support.v4.util.ArrayMap;

import com.pingan.common.utils.LogUtil;
import com.pingan.common.utils.StringUtil;

import java.lang.reflect.Constructor;
import java.util.Map;

public class BusServer {

    private static Map<String, BaseModuleServer> sClientMap = new ArrayMap<>();

    public static void syncCallServer(Context context, String targetBizName, Object param) {
        callServer(context, targetBizName, param, null);
    }

    public static void aSyncCallServer(Context context, String targetBizName, Object param, BaseModuleServer.AsyncCallListener listener) {
        callServer(context, targetBizName, param, listener);
    }

    private static void callServer(Context context, String targetBizName, Object param, BaseModuleServer.AsyncCallListener listener){
        BaseModuleServer server = findClient(getModuleName(targetBizName));
        if (server == null) {
            LogUtil.d("debug", "No server found with bizName :"+targetBizName);
            return;
        }
        if (listener == null)
            server.onSyncCall(context, targetBizName, param);
        else
            server.onAsyncCall(context, targetBizName, param, listener);
    }

    //同时只允许单线程执行 , 防止对象被重复反射创建
    private static synchronized BaseModuleServer findClient(String moduleName) {
        if (moduleName == null)
            return null;
        BaseModuleServer client = sClientMap.get(moduleName);
        if (client == null)
           client = register(moduleName);
        return client;
    }

    public static BaseModuleServer register(String moduleName) {
        Map<String, ModuleClientBean> clientMap = ModuleClientFactory.getModuleClientMap();
        BaseModuleServer clientObj = null;
        ModuleClientBean client = clientMap.get(moduleName);
        if (client == null || client.getModuleAllClassName() == null)
            return null;
        try {
            Class<?> clientObjClass = Class.forName(client.getModuleAllClassName());
            Constructor<?> constructor = clientObjClass.getConstructor();
            clientObj = (BaseModuleServer) constructor.newInstance();
            sClientMap.put(client.getModuleName(), clientObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientObj;
    }

    public static String getModuleName(String targeBizName) {
        if (StringUtil.getCharCount(targeBizName,'/') == 1) {
            return targeBizName.split("/")[0];
        }
        throw new IllegalArgumentException("非法的bizName格式, (module/biz)");
    }
}
