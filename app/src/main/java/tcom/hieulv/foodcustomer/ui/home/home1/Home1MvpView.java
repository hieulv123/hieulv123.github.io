package tcom.hieulv.foodcustomer.ui.home.home1;

import java.util.List;

import tcom.hieulv.foodcustomer.base.MvpView;

public interface Home1MvpView extends MvpView{
    void onSendSuccess();
    void onSendFaild(List<String> error);
    void onSendFaild(String error);
}
