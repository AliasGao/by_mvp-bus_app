package com.pingan.common.bus;


import android.content.Context;

public class ModuleCaller {

    public static class ServiceRequest {
        public Context context;
        public String targetBizName;
        public Object param;
        public BaseModuleServer.AsyncCallListener listener;
        public CallType callType;

        public ServiceRequest(Context context, String targetBizName, Object param, BaseModuleServer.AsyncCallListener listener, CallType callType) {
            this.context = context;
            this.targetBizName = targetBizName;
            this.param = param;
            this.listener = listener;
            this.callType = callType;
        }

        public ServiceRequest( Context context,String targetBizName, CallType callType) {
            this.callType = callType;
            this.context = context;
            this.targetBizName = targetBizName;
        }
    }
    public enum CallType {
        AsyncCall , SyncCall
    }

    public static void callService(ServiceRequest request) {

        switch (request.callType) {
            case AsyncCall:
                BusServer.aSyncCallServer(request.context,request.targetBizName,request.param,request.listener);
                break;
            case SyncCall:
                BusServer.syncCallServer(request.context,request.targetBizName,request.param);
                break;
        }
    }


}
