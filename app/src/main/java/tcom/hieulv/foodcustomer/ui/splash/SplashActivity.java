package tcom.hieulv.foodcustomer.ui.splash;

import android.content.Intent;

import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;
import tcom.hieulv.foodcustomer.ui.home.food.ActivityHome;
import tcom.hieulv.foodcustomer.ui.login.LoginActivity;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class SplashActivity extends BaseActivity implements SplashMvpView {
    private SplashPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void initPresenter() {
        mPresenter = new SplashPresenter(MyApplication.getInstance().getLoginRepository());
        mPresenter.Attach(this);


    }

    @Override
    protected void setUp() {

        checkTokenValid();


    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void checkTokenSuccess() {
        Intent success = new Intent(this, ActivityHome.class);
        startActivity(success);
        finish();


    }

    @Override
    public void checkTokenFaild() {
        goToLogin();
    }

    public void checkTokenValid() {
        String tokenLogin = MyApplication.getInstance().getLoginRepository().getToken();
        if (!tokenLogin.equals("")) {
            mPresenter.checkToken(tokenLogin);
        }else {
            goToLogin();
        }

    }

    private void goToLogin() {
        Intent faild = new Intent(this, LoginActivity.class);
        startActivity(faild);
        finish();
    }
}
