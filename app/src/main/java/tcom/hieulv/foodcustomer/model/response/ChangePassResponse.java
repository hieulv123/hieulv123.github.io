package tcom.hieulv.foodcustomer.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChangePassResponse<T> {
    @Expose
    @SerializedName("code")
    private int code ;
    @Expose
    @SerializedName("status")
    private boolean status;
    @Expose
    @SerializedName("message")
    private List<String> message =null ;
    @Expose
    @SerializedName("data")
    private T data ;
    public int getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    public List<String> getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

}
