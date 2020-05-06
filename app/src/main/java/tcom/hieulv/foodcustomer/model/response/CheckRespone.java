package tcom.hieulv.foodcustomer.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CheckRespone{
    @Expose
    @SerializedName("code")
    private int code ;
    @Expose
    @SerializedName("status")
    private boolean status;
    @Expose
    @SerializedName("message")
    private Object message =null ;
    @Expose
    @SerializedName("data")
    private Object data ;

    public int getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    public Object getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
