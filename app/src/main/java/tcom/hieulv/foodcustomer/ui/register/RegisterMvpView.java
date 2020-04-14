package tcom.hieulv.foodcustomer.ui.register;

import java.util.List;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface RegisterMvpView extends MvpView {
    void onRegisterCustomSuccess();
    void onRegisterCustomFaild(String message);
    void onRegisterCustomFaild(List<String> message);
}
