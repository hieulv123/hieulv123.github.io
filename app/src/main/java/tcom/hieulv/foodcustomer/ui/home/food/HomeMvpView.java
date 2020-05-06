package tcom.hieulv.foodcustomer.ui.home.food;

import java.util.List;

import tcom.hieulv.foodcustomer.base.MvpView;
import tcom.hieulv.foodcustomer.model.Datum;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.ListRestaurant;

public interface HomeMvpView extends MvpView {
    @Override
    void onError(String message);
    void getFoodSuccess(String message);
    void getHotFood(List<Datum> images);
    void getListRestaurantsNear(List<ListRestaurant> listRestaurants) ;
}
