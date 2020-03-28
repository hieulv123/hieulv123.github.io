package tcom.hieulv.foodcustomer.ui.home.home1;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.response.SendToEmailResponse;

public class Home1Presenter<V extends Home1MvpView, U extends LoginRepository> extends BasePresenter<V, U> implements Home1MvpPresenter {
    private String TAG = "Home1Presenter";

    public Home1Presenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onSendCodeToEmail(String email) {
        getMvpView().showLoading();
        APIController.getInstance().sendCodeToEmail(email).enqueue(new Callback<SendToEmailResponse>() {
            @Override
            public void onResponse(Call<SendToEmailResponse> call, Response<SendToEmailResponse> response) {
                getMvpView().hideLoading();
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response);
                    SendToEmailResponse data = response.body();
                    if (data.getCode() == 200) {
                        getMvpView().onSendSuccess();
                    }
                    getRepository().setToken(data.getData().getTokenResetMail());
                    getRepository().setOtp(data.getData().getOtp());
                    Log.d(TAG, "token send to email" + getRepository().getToken()+getRepository().getOtp());
                } else {
                    getMvpView().onSendFaild("Email không hợp lệ");
                }
            }

            @Override
            public void onFailure(Call<SendToEmailResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: +failddddddddddd");

            }
        });

    }
}
