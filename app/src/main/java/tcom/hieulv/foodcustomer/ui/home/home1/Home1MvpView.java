package tcom.hieulv.foodcustomer.ui.home.home1;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface Home1MvpView extends MvpView{
    void onSendSuccess();
    void onSendFaild(String error);
}
