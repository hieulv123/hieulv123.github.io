package tcom.hieulv.foodcustomer.ui.login;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.LoginRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;
import tcom.hieulv.foodcustomer.model.response.DataLoginResponse;

public class LoginPresenter<V extends LoginMvpView, U extends LoginRepository> extends BasePresenter<V, U> implements
        LoginMvpPresenter {
    private final String TAG = "TTTTT";


    public LoginPresenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onLoginByEmail(final String email, String password, String typeapp) {
        getMvpView().showLoading();
        APIController.getInstance().loginByEmail(new LoginRequest(email, password, typeapp))
                .enqueue(new Callback<BaseResponse<DataLoginResponse>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<DataLoginResponse>> call, Response<BaseResponse<DataLoginResponse>> response) {
                        if (response.isSuccessful() && response.body().getData() != null) {
                            getMvpView().hideLoading();
                            Log.d(TAG, "onResponse: " + response);
                            BaseResponse data = response.body();
                            if (data.getCode() == 200) {
                                getMvpView().onLoginSuccess();
                                getRepository().setToken(response.body().getData().getToken());


                            } else {
                                getMvpView().onLoginError("Tài khoản đăng nhập không hợp lệ");
//                                Log.d(TAG, "onResponse:faild" + response);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<DataLoginResponse>> call, Throwable t) {
                        getMvpView().onLoginError("Server not response");
                        getMvpView().hideLoading();
                        Log.e(TAG, t.getMessage());


                    }
                });
    }



}
