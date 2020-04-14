package tcom.hieulv.foodcustomer.ui.home.food;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;

public class ActivityHome extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void setUp() {
        addFragment(new FragmentHome());

    }

    @Override
    public void showMessage(int resId) {

    }
    public void addFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_frame,fragment).addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
