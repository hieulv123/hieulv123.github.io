package tcom.hieulv.foodcustomer.ui.order.received;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.adapter.RestaurantAdapter;
import tcom.hieulv.foodcustomer.base.BaseFragment;

public class FragmentReceived extends BaseFragment {
    @BindView(R.id.rcyc_received)
    RecyclerView rcrReceived ;
    RestaurantAdapter adapter ;
    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_received;
    }

    @Override
    protected void setUp(View view) {

    }
}
