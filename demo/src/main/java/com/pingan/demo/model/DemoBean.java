package com.pingan.demo.model;

public class DemoBean {

    public DemoBean(String msg) {
        this.demoMsg = msg;
    }

    public String getDemoMsg() {
        return demoMsg;
    }

    public void setDemoMsg(String demoMsg) {
        this.demoMsg = demoMsg;
    }

    private String demoMsg;

}
