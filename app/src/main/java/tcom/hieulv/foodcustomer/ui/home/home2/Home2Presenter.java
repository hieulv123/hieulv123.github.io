package tcom.hieulv.foodcustomer.ui.home.home2;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.response.NewPassResponse;

public class Home2Presenter<V extends Home2MvpView, U extends LoginRepository> extends BasePresenter<V, U> implements Home2MvpPresenter {
    private String TAG = "Home2Presenter";
    List<String> message;

    public Home2Presenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onSendCodeConfig(String otp, String tokenReset) {
        getMvpView().showLoading();
        APIController.getInstance().sendCodeConfig(otp, tokenReset).enqueue(new Callback<NewPassResponse>() {
            @Override
            public void onResponse(Call<NewPassResponse> call, Response<NewPassResponse> response) {
                if (response.isSuccessful()) {
                    getMvpView().hideLoading();
                    if (response.body().getData() != null) {

                        Log.d(TAG, "onResponse: " + response);
                        NewPassResponse data = response.body();
                        getRepository().setToken(data.getData().getTokenResetMail());

                        if (data.getCode() == 200) {
                            getMvpView().sendCodeConfigSuccess();
                        } else if (response.body().getCode() == 400) {
                            message = response.body().getMessage();
                            getMvpView().sendCodeConfigError(message);

                        }
                    }
                } else {
                    getMvpView().sendCodeConfigError("otp không đúng hoặc quá thời gian chờ");
                }

            }

            @Override
            public void onFailure(Call<NewPassResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: +faildddddđ");

            }
        });
    }
}
