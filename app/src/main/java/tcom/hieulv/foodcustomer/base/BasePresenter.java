package tcom.hieulv.foodcustomer.base;

import tcom.hieulv.foodcustomer.data.AppRepository;

public class BasePresenter<V extends MvpView, U extends AppRepository> implements MvpPresenter<V> {
    private final String TAG = "Presenter";
    private V mMvpView;
    private U mRepository ;

    public BasePresenter(U mRepository) {
        this.mRepository = mRepository;
    }

    public U getRepository() {
        return mRepository;
    }

    @Override
    public void Attach(V mvpView) {
        mMvpView = mvpView ;

    }


    @Override
    public void onDetach() {
    mMvpView = null;

    }
    public boolean isViewAttached(){ return  mMvpView!= null; }
    public V getMvpView(){return mMvpView;}

    public void checkViewAttached(){
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }
    public static class MvpViewNotAttachedException extends RuntimeException{
        MvpViewNotAttachedException(){
            super("please call Presenter.onAttach(MvpView) before" +
                    "requesting data to the Presenter");
        }
    }

}
