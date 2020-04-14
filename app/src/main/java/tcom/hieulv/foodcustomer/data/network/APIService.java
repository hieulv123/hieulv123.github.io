package tcom.hieulv.foodcustomer.data.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tcom.hieulv.foodcustomer.model.request.LoginRequest;
import tcom.hieulv.foodcustomer.model.request.NewPassRequest;
import tcom.hieulv.foodcustomer.model.request.RegisterRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;
import tcom.hieulv.foodcustomer.model.response.ChangePassResponse;
import tcom.hieulv.foodcustomer.model.response.DataResponse;
import tcom.hieulv.foodcustomer.model.response.NewPassResponse;
import tcom.hieulv.foodcustomer.model.response.SendToEmailResponse;

public interface APIService {
    @POST("login_byEmail")
    Call<BaseResponse<Object>> loginByEmail(@Body LoginRequest loginRequest);

    @GET("send_otp_to_mail")
    Call<SendToEmailResponse> sendCodeToEmail(@Query("email")String email) ;//cho nay ne// call api trên postman đi, neeys ko được là do code

    @GET("check_otp_mail")
        Call<NewPassResponse> sendCodeConfig(@Query("otp")String otp,@Query("token_reset_mail")String tokenReset);
    @POST("reset_password")
    Call<ChangePassResponse<Object>> creatNewPw(@Body NewPassRequest newPassRequest) ;
    @POST("register")
    Call<BaseResponse<Object>> regiterCustomer(@Body RegisterRequest registerRequest);

}
