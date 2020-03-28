package tcom.hieulv.foodcustomer.ui.home.home3;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.request.NewPassRequest;
import tcom.hieulv.foodcustomer.model.response.BaseResponse;

public class Home3Presenter<V extends Home3MvpView ,U extends LoginRepository> extends BasePresenter<V,U>implements Home3MvpPresenter{
    private String TAG ="Home3Presenter";

    public Home3Presenter(U mRepository) {
        super(mRepository);
    }

    @Override
    public void createNewPass(String password, String tokenRsEmail) {
        getMvpView().showLoading();
        APIController.getInstance().creatNewPw(new NewPassRequest(password,tokenRsEmail)).
                enqueue(new Callback<BaseResponse<Object>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<Object>> call, Response<BaseResponse<Object>> response) {
                        getMvpView().hideLoading();
                        if (response.isSuccessful()){
                            Log.d(TAG, "onResponse: "+response);
                            BaseResponse data = response.body();
                            if (data.getCode()==200){
                                getMvpView().onSuccess();
                            }
                            getMvpView().onMakeError("token chưa đúng");

                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<Object>> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());

                    }
                });

    }
}
