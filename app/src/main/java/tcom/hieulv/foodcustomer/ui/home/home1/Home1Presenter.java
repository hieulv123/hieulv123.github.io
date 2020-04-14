package tcom.hieulv.foodcustomer.ui.home.home1;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.response.SendToEmailResponse;

public class Home1Presenter<V extends Home1MvpView, U extends LoginRepository> extends BasePresenter<V, U>
        implements Home1MvpPresenter {
    private String TAG = "Home1Presenter";
    private List<String> message;

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
                    if (response.body().getData() != null)
                        if (response.body().getCode() == 200) {
                            SendToEmailResponse data = response.body();
                            getMvpView().onSendSuccess();
                            getRepository().setToken(data.getData().getTokenResetMail());
                            getRepository().setOtp(data.getData().getOtp());
                            Log.d(TAG, "token send to email" + getRepository().getToken() + getRepository().getOtp());
                        }  if (response.body().getCode() == 400) {
                            message = response.body().getMessage();
//                            getMvpView().onSendFaild(message);
                            getMvpView().onSendFaild("Email chưa được đăng kí");
                        }
                    Log.d(TAG, "onResponse: " + response);
                }
            }

            @Override
            public void onFailure(Call<SendToEmailResponse> call, Throwable t) {
                getMvpView().hideLoading();
                Log.d(TAG, "onFailure: +failddddddddddd");

            }
        });

    }

}
