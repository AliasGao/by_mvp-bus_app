package com.pingan.common.bus;


public class ModuleClientBean {
    private String moduleName;
    private String modulePackage;
    private String moduleClientName;

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    public void setModuleClientName(String moduleClientName) {
        this.moduleClientName = moduleClientName;
    }

    public String getModuleName() {

        return moduleName;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public String getModuleClientName() {
        return moduleClientName;
    }

    public String getModuleAllClassName() {
        return modulePackage +"."+ moduleClientName;
    }

    public ModuleClientBean(String moduleName, String modulePackage, String moduleClientName) {
        this.moduleName = moduleName;
        this.modulePackage = modulePackage;
        this.moduleClientName = moduleClientName;
    }
}
