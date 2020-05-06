package tcom.hieulv.foodcustomer.ui.order;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.adapter.AdapterFragment;
import tcom.hieulv.foodcustomer.adapter.RestaurantAdapter;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.ui.home.food.AdapterNearRestaurant;
import tcom.hieulv.foodcustomer.ui.order.detailorder.DetailOrderFragment;

public class FragmentOrder extends BaseFragment  {
    @BindView(R.id.pager_order)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;

    }

    @Override
    protected void setUp(View view) {
        viewPager.setAdapter( new AdapterFragment(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }


}

