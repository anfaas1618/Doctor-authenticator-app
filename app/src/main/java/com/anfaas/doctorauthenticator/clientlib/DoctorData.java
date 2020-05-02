package com.anfaas.doctorauthenticator.clientlib;

import org.json.JSONException;
import org.json.JSONObject;

public class DoctorData extends JSONObject {
    public String getDoctorName() throws JSONException {
        return getString("firstName");
    }
    public String getRegistrationDate() throws JSONException {
        return getString("regDate");
    }

    public String getParentName() throws JSONException {
        return getString("parentName");
    }
    public String getBirthDate() throws JSONException {
        return getString("birthDateStr");
    }
    public String getDegree() throws JSONException {
        return getString("doctorDegree");
    }
    public String getUniversity() throws JSONException {
        return getString("university");
    }
    public String getYearOfPassing() throws JSONException {
        return getString("yearOfPassing");
    }
    public String getRegistrationNumber() throws JSONException {
        return getString("registrationNo");
    }
    public String getStateCouncilName() throws JSONException {
        return getString("smcName");
    }
    public String getAddress() throws JSONException {
        return getString("address");
    }
}
