package tcom.hieulv.foodcustomer.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T>{
    @Expose
    @SerializedName("code")
    private int code ;
    @Expose
    @SerializedName("status")
    private boolean status;
    @Expose
    @SerializedName("message")
    private String message ;
    @Expose
    @SerializedName("data")
    private T data ;

    public int getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    public Object getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
