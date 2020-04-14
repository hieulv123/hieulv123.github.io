package tcom.hieulv.foodcustomer.ui.login;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.LoginRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;

public class LoginPresenter<V extends LoginMvpView, U extends LoginRepository> extends BasePresenter<V, U> implements
        LoginMvpPresenter {
    private final String TAG = "TTTTT";

    public LoginPresenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onLoginByEmail(final String email, String password) {
        getMvpView().showLoading();
        APIController.getInstance().loginByEmail(new LoginRequest(email, password))
                .enqueue(new Callback<BaseResponse<Object>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<Object>> call, Response<BaseResponse<Object>> response) {
                        if (response.isSuccessful()&& response.body().getData()!=null) {
                            getMvpView().hideLoading();
                            Log.d(TAG, "onResponse: " + response);
                            BaseResponse data = response.body();
                            if (data.getCode() == 200) {
                                getMvpView().onLoginSuccess();

                            } else {
                                getMvpView().onLoginError("Tài khoản đăng nhập không hợp lệ");
                                Log.d(TAG, "onResponse:faild" + response);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<Object>> call, Throwable t) {
                        getMvpView().onLoginError("Bạn phải nhập Email và Password");
                        getMvpView().hideLoading();
                        Log.e(TAG, t.getMessage());


                    }
                });
    }

    @Override
    public void onCreateAccount() {

    }

    @Override
    public void onForgotPassword() {

    }
}
