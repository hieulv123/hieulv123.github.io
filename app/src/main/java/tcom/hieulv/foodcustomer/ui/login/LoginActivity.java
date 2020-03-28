package tcom.hieulv.foodcustomer.ui.login;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class LoginActivity extends BaseActivity {


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
        ft.replace(R.id.frame_login, fragment);
        ft.commit();
    }

}

