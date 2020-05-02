package com.anfaas.doctorauthenticator;

public class doctorModel {
    String name;
    String regid;

    public doctorModel(String name, String regid) {
        this.name = name;
        this.regid = regid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
