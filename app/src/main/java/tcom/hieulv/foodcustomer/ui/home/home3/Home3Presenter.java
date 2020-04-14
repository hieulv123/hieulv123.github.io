package tcom.hieulv.foodcustomer.ui.home.home3;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.NewPassRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;
import tcom.hieulv.foodcustomer.model.response.ChangePassResponse;

public class Home3Presenter<V extends Home3MvpView, U extends LoginRepository> extends BasePresenter<V, U> implements Home3MvpPresenter {
    private String TAG = "Home3Presenter";

    public Home3Presenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void createNewPass(String password, String tokenRsEmail) {
        getMvpView().showLoading();
        APIController.getInstance().creatNewPw(new NewPassRequest(password, tokenRsEmail)).
                enqueue(new Callback<ChangePassResponse<Object>>() {
                    @Override
                    public void onResponse(Call<ChangePassResponse<Object>> call,
                                           Response<ChangePassResponse<Object>> response) {
                        getMvpView().hideLoading();

                        if (response.isSuccessful()) {
                            if (response.body().getData()!= null) {
                                Log.d(TAG, "onResponse: " + response);
                                ChangePassResponse data = response.body();
                                if (data.getCode() == 200) {
                                    getMvpView().onSuccess();
                                }else if (data.getCode()==400){
                                    getMvpView().onMakeError("Mật khẩu phải chứa ít nhất 6 kí tự");
                                }
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<ChangePassResponse<Object>> call, Throwable t) {
                        getMvpView().hideLoading();
                        Log.d(TAG, "onFailure: " + t.getMessage());

                    }
                });

    }
}
