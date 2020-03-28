package tcom.hieulv.foodcustomer.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPassRequest {
    @Expose
    @SerializedName("password")
    private String password ;
    @Expose
    @SerializedName("token_reset_mail")
    private String token_ResetMail ;

    public NewPassRequest(String password, String token_ResetMail) {
        this.password = password;
        this.token_ResetMail = token_ResetMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken_ResetMail() {
        return token_ResetMail;
    }

    public void setToken_ResetMail(String token_ResetMail) {
        this.token_ResetMail = token_ResetMail;
    }
}
