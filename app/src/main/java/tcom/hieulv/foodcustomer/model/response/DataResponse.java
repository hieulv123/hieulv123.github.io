package tcom.hieulv.foodcustomer.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataResponse implements Serializable {

    @Expose
    @SerializedName("token_reset_mail")
    private String tokenResetMail;
    @Expose
    @SerializedName("otp")
    private Integer otp ;

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    public String getTokenResetMail() {
        return tokenResetMail;
    }

    public void setTokenResetMail(String tokenResetMail) {
        this.tokenResetMail = tokenResetMail;
    }

}
