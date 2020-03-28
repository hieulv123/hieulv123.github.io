package tcom.hieulv.foodcustomer.ui.home.home2;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface Home2MvpView extends MvpView {
    void sendCodeConfigSuccess();
    void sendCodeConfigError(String error);
}
