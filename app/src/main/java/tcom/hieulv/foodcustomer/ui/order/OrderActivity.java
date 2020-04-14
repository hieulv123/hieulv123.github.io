package tcom.hieulv.foodcustomer.ui.order;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;
import tcom.hieulv.foodcustomer.ui.order.detailorder.DetailOrderFragment;

public class OrderActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void handleIntent(Intent intent) {

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void setUp() {
        addFragment(new DetailOrderFragment());

    }
    private void addFragment(Fragment fragment){
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_order,fragment).addToBackStack(null);
        ft.commit();
    }

    @Override
    public void showMessage(int resId) {

    }

}
