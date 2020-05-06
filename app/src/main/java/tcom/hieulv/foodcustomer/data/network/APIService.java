package tcom.hieulv.foodcustomer.data.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import tcom.hieulv.foodcustomer.model.request.LoginRequest;
import tcom.hieulv.foodcustomer.model.request.NewPassRequest;
import tcom.hieulv.foodcustomer.model.request.RegisterRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;
import tcom.hieulv.foodcustomer.model.response.ChangePassResponse;
import tcom.hieulv.foodcustomer.model.response.DataLoginResponse;
import tcom.hieulv.foodcustomer.model.response.HotFoodResponse;
import tcom.hieulv.foodcustomer.model.response.NewPassResponse;
import tcom.hieulv.foodcustomer.model.response.SendToEmailResponse;
import tcom.hieulv.foodcustomer.model.response.combo.ComboResponse;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.NearRestaurantResponse;

public interface APIService {
    @POST("login_byEmail")
    Call<BaseResponse<DataLoginResponse>> loginByEmail(@Body LoginRequest loginRequest);

    @GET("send_otp_to_mail")
    Call<SendToEmailResponse> sendCodeToEmail(@Query("email") String email);//cho nay ne// call api trên postman đi, neeys ko được là do code

    @GET("check_otp_mail")
    Call<NewPassResponse> sendCodeConfig(@Query("otp") String otp, @Query("token_reset_mail") String tokenReset);

    @POST("reset_password")
    Call<ChangePassResponse<Object>> creatNewPw(@Body NewPassRequest newPassRequest);

    @POST("register")
    Call<BaseResponse<Object>> regiterCustomer(@Body RegisterRequest registerRequest);

    @GET("get_list_food_hot")
    Call<HotFoodResponse> getListFoodHot(@Header("token") String token, @Query("pageSize")
            String pageSize, @Query("pageIndex") String pageIndex);

    @GET("restaurant/get_list_restaurants")
    Call<NearRestaurantResponse> getListRestaurants(@Header("token") String token,
                                                    @Query("belongsToUser") Integer belongstoUser,
                                                    @Query("latitude") String latitude,
                                                    @Query("longitude") String longitude,
                                                    @Query("pageSize") String pageSize,
                                                    @Query("pageIndex") String pageIndex);

    @GET("check_token_valid")
    Call<BaseResponse<List<String>>> checkTokenValid(@Header("token") String token);

    @GET("get_list_combo")
    Call<ComboResponse> getListComboFood(@Header("token") String token, @Query("restaurant_id") Integer restaurantId,
                                         @Query("pageSize") String pageSize, @Query("pageIndex") String pageIndex);
}
