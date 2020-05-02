package com.anfaas.doctorauthenticator.clientlib;

import org.json.JSONException;
import org.json.JSONObject;

public class DoctorData extends JSONObject {

    public DoctorData(String s) throws JSONException {
        super(s);
    }
    public String getDoctorName() throws JSONException {
        return String.valueOf(get("firstName"));
    }
    public String getRegistrationDate() throws JSONException {
        return String.valueOf(get("regDate"));
    }

    public String getParentName() throws JSONException {
        return String.valueOf(get("parentName"));
    }
    public String getBirthDate() throws JSONException {
        return String.valueOf(get("birthDateStr"));
    }
    public String getDegree() throws JSONException {
        return String.valueOf(get("doctorDegree"));
    }
    public String getUniversity() throws JSONException {
        return String.valueOf(get("university"));
    }
    public String getYearOfPassing() throws JSONException {
        return String.valueOf(get("yearOfPassing"));
    }
    public String getRegistrationNumber() throws JSONException {
        return String.valueOf(get("registrationNo"));
    }
    public String getStateCouncilName() throws JSONException {
        return String.valueOf(get("smcName"));
    }
    public String getAddress() throws JSONException {
        return String.valueOf(get("address"));
    }
}
