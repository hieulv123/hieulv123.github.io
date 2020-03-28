package tcom.hieulv.foodcustomer.ui.login;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface LoginMvpView extends MvpView {
    void onLoginSuccess();
    void onLoginError(String message) ;


}

