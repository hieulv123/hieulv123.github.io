package tcom.hieulv.foodcustomer.ui.splash;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;
import tcom.hieulv.foodcustomer.model.response.CheckRespone;

public class SplashPresenter<V extends SplashMvpView, U extends LoginRepository> extends BasePresenter<V, U> implements
        SplashMvpPresenter {


    private String TAG = "Splash";

    public SplashPresenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void checkToken(String token) {
        getMvpView().showLoading();
        APIController.getInstance().checkTokenValid(token).enqueue(
                new Callback<BaseResponse<List<String>>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<List<String>>> call, Response<BaseResponse<List<String>>> response) {
                        getMvpView().hideLoading();
                        if (response.isSuccessful() && response.body().getData() != null) {

                            if (response.body().getCode() == 200) {
                                getMvpView().checkTokenSuccess();
                            } else {
                                getMvpView().checkTokenFaild();
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<BaseResponse<List<String>>> call, Throwable t) {
                        getMvpView().hideLoading();
                        Log.d(TAG, "onFailure: " + t.getMessage());

                    }
                }
        );

    }


}
