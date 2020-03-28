package tcom.hieulv.foodcustomer.ui.register;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.RegisterRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;

public class RegisterPresenter<V extends RegisterMvpView,U extends LoginRepository> extends BasePresenter<V,U>
        implements RegisterMvpPresenter {
    private String TAG="RegisterPresenter";

    public RegisterPresenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void onRegisterCustomer(String fullName, String passPort, String phone, String email,
                                   String address, String password, String birthday) {
        getMvpView().showLoading();
        APIController.getInstance().regiterCustomer(new RegisterRequest(fullName,passPort,phone,
                email,address,password,birthday)).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                if (response.isSuccessful()){
                    getMvpView().hideLoading();
                    BaseResponse data = response.body();
                    if (data.getCode()==200){
                        getMvpView().onRegisterCustomSuccess();
                    }
                    getMvpView().onRegisterCustomFaild("Đăng kí tài khoản bị lỗi");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });
    }
}
