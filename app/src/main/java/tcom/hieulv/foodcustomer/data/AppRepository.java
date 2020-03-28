package tcom.hieulv.foodcustomer.data;

import tcom.hieulv.foodcustomer.data.preference.PreferenceHelper;

public abstract class AppRepository {
    private Integer otp;

    private String email;
    private PreferenceHelper preferenceHelper;

    public AppRepository(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;
    }

    public void setPreferenceHelper(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;
    }


    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getToken() {
        return preferenceHelper.getToken();

    }

    public void setToken(String token) {
        getPreferenceHelper().setToken(token);
    }


    public abstract void logOut();

    public PreferenceHelper getPreferenceHelper() {
        return preferenceHelper;
    }

}

