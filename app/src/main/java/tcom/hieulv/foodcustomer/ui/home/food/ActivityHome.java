package tcom.hieulv.foodcustomer.ui.home.food;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseActivity;
import tcom.hieulv.foodcustomer.customview.CustomTextViewFonts;
import tcom.hieulv.foodcustomer.ui.login.LoginActivity;
import tcom.hieulv.foodcustomer.ui.order.OrderActivity;

public class ActivityHome extends BaseActivity {
    @BindView(R.id.draw_layout)
    DrawerLayout dl;
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    @BindView(R.id.tv_logout)
    CustomTextViewFonts tvLogout;
    @BindView(R.id.img_addressUser)
    ImageView imgAddressUser;



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

    public void openDrawer() {
        dl.openDrawer(nav_view);
    }
    public  void closeDrawer(){
        dl.closeDrawer(nav_view);
    }


    @Override
    public void showMessage(int resId) {

    }

    public void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @OnClick({R.id.tv_logout, R.id.tv_order})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.tv_order:
                Intent order = new Intent(this, OrderActivity.class);
                startActivity(order);
                closeDrawer();
                break;
            case R.id.tv_logout:
                Intent login = new Intent(this, LoginActivity.class);
                startActivity(login);
                finish();
               MyApplication.getInstance().getLoginRepository().setToken("");

        }
    }


}
