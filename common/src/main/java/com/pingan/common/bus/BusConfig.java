package com.pingan.common.bus;

public class BusConfig {
    public static class Main {
        public static final String MODULE_NAME = "main";
        public static final String VIEW_DEMOPAGE = "homepage";

        public static final String GOTO_HOMEPAGE = MODULE_NAME +"/"+VIEW_DEMOPAGE;
    }
    public static class Demo {
        public static final String MODULE_NAME = "demo";
        public static final String VIEW_DEMOPAGE = "demopage";

        public static final String GOTO_DEMOPAGE = MODULE_NAME +"/"+VIEW_DEMOPAGE;
    }
}
