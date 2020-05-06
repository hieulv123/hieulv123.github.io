package tcom.hieulv.foodcustomer.ui.home.food;

public interface HomeMvpPresenter {
    void getHightLightFood(String token,String pageIndex,String pageSize);
    void getListRestaurantNear(String token ,Integer belongToUser,String latitude,String longitude,
                               String pageSize,String pageIndex) ;

}
