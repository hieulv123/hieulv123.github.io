package tcom.hieulv.foodcustomer.ui.home.home2;

import java.util.List;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface Home2MvpView extends MvpView {
    void sendCodeConfigSuccess();

    void sendCodeConfigError(String error);

    void sendCodeConfigError(List<String> message);
}

