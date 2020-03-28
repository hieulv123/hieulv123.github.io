package tcom.hieulv.foodcustomer.ui.register;

public interface RegisterMvpPresenter {
    void onRegisterCustomer(String fullName,String passPort,String phone ,String email,
                            String address,String password,String birthday);
}
