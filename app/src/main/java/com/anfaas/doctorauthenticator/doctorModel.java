package com.anfaas.doctorauthenticator;

public class doctorModel {
    String name;
    String regid;
    String parent_name;
    String RegDate;
    String birthDateStr;
    String doctorDegree;

    public doctorModel(String name, String regid, String parent_name, String regDate, String birthDateStr, String doctorDegree) {
        this.name = name;
        this.regid = regid;
        this.parent_name = parent_name;
        RegDate = regDate;
        this.birthDateStr = birthDateStr;
        this.doctorDegree = doctorDegree;
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public String getBirthDateStr() {
        return birthDateStr;
    }

    public void setBirthDateStr(String birthDateStr) {
        this.birthDateStr = birthDateStr;
    }

    public String getDoctorDegree() {
        return doctorDegree;
    }

    public void setDoctorDegree(String doctorDegree) {
        this.doctorDegree = doctorDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
