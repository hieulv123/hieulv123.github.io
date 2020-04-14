package tcom.hieulv.foodcustomer.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import tcom.hieulv.foodcustomer.ui.order.received.FragmentReceived;
import tcom.hieulv.foodcustomer.ui.order.shipping.FragmentShipping;

public class AdapterFragment extends FragmentPagerAdapter {
    public AdapterFragment(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentShipping();
            default:
                return new FragmentReceived();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Đang giao";
            default:
                return "Đã nhận";
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }
}
