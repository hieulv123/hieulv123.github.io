package tcom.hieulv.foodcustomer.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {
    @SerializedName("full_name")
    @Expose
    private String fullname;
    @SerializedName("passport")
    @Expose
    private String passport;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String address;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("birthday")
    @Expose
    private String birthday;

    public RegisterRequest(String fullname, String passport, String phone, String email, String address, String password, String birthday) {
        this.fullname = fullname;
        this.passport = passport;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
        this.birthday = birthday;
    }
}
