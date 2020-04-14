package tcom.hieulv.foodcustomer.ui.register;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.RegisterRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;

public class RegisterPresenter<V extends RegisterMvpView, U extends LoginRepository> extends BasePresenter<V, U>
        implements RegisterMvpPresenter {
    private String TAG = "RegisterPresenter";
    List<String> message ;

    public RegisterPresenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onRegisterCustomer(String fullName, String passPort, String phone, String email,
                                   String address, String password, String birthday) {
        getMvpView().showLoading();
        APIController.getInstance().regiterCustomer(new RegisterRequest(fullName, passPort, phone,
                email, address, password, birthday)).enqueue(new Callback<BaseResponse<Object>>() {
            @Override
            public void onResponse(Call<BaseResponse<Object>> call, Response<BaseResponse<Object>> response) {
                if (response.isSuccessful()) {
                    getMvpView().hideLoading();
                    BaseResponse data = response.body();
                    if (data.getCode() == 200) {
                        getMvpView().onRegisterCustomSuccess();
                    }else if (data.getCode()==400){
                        message = data.getMessage();
                    getMvpView().onRegisterCustomFaild(message);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<Object>> call, Throwable t) {
                getMvpView().hideLoading();
                getMvpView().onRegisterCustomFaild(message);
                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}
