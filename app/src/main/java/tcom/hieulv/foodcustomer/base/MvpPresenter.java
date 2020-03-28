package tcom.hieulv.foodcustomer.base;

public interface MvpPresenter<V extends MvpView> {
    void Attach(V mvpView );
    void onDetach();
}
