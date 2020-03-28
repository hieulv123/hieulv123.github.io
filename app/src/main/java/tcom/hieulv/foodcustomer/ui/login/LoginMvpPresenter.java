package tcom.hieulv.foodcustomer.ui.login;

public interface LoginMvpPresenter {
    void onLoginByEmail(String email ,String password);
    void onCreateAccount() ;
    void onForgotPassword();
}
