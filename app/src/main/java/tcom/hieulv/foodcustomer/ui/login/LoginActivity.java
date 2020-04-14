package tcom.hieulv.foodcustomer.ui.login;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.base.MvpView;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class LoginActivity extends BaseActivity implements LoginMvpView {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void setUp() {
        addFragment(new FragmentLogin());

    }

    @Override
    public void showMessage(int resId) {

    }

    private void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame_login, fragment);
        ft.commit();
    }

    @Override
    public void showMessage(String message) {
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginError(String message) {

    }
}

