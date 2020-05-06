package tcom.hieulv.foodcustomer.ui.home.food;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcom.hieulv.foodcustomer.base.BasePresenter;
import tcom.hieulv.foodcustomer.data.network.APIController;
import tcom.hieulv.foodcustomer.data.repository.LoginRepository;
import tcom.hieulv.foodcustomer.model.Datum;
import tcom.hieulv.foodcustomer.model.response.HotFoodResponse;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.ListRestaurant;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.NearRestaurantResponse;

public class HomePresenter<V extends HomeMvpView, U extends LoginRepository> extends BasePresenter<V, U>
        implements HomeMvpPresenter {
    public HomePresenter(U mRepository) {
        super(mRepository);
    }

    public List<Datum> listData = new ArrayList<>();
    public List<ListRestaurant> restaurantList = new ArrayList<>();

    @Override
    public void getHightLightFood(String token, String pageIndex, String pageSize) {
        getMvpView().showLoading();
        APIController.getInstance().getListFoodHot(token, pageSize, pageIndex)
                .enqueue(new Callback<HotFoodResponse>() {
                    @Override
                    public void onResponse(Call<HotFoodResponse> call, Response<HotFoodResponse> response) {
                        getMvpView().hideLoading();
                        if (response.isSuccessful() || response.body() != null) {
                            if (response.body().getCode() == 200) {
                                listData = response.body().getData().getData();
//                                getMvpView().getFoodSuccess("Get Image Successfully");
                                getMvpView().getHotFood(listData);


                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<HotFoodResponse> call, Throwable t) {
                        Log.e(getClass().getName(), t.toString());

                    }
                });

    }

    @Override
    public void getListRestaurantNear(String token, Integer belongToUser, String latitude,
                                      String longitude, String pageSize, String pageIndex) {
        APIController.getInstance().getListRestaurants(token, belongToUser, latitude, longitude,
                pageSize, pageIndex).enqueue(new Callback<NearRestaurantResponse>() {
            @Override
            public void onResponse(Call<NearRestaurantResponse> call, Response<NearRestaurantResponse> response) {
                if (response.isSuccessful() || response.body() != null) {
                    if (response.body().getCode() == 200) {
                        restaurantList = response.body().getData().getListRestaurants();
                        getMvpView().getListRestaurantsNear(restaurantList);


                    }
                }
            }

            @Override
            public void onFailure(Call<NearRestaurantResponse> call, Throwable t) {

            }
        });

    }
}
