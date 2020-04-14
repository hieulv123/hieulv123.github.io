package tcom.hieulv.foodcustomer.ui.order.shipping;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.adapter.RestaurantAdapter;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.model.ItemRestauran;

public class FragmentShipping extends BaseFragment {
    @BindView(R.id.rcyc_shipping)
    RecyclerView rcrShipping;
    RecyclerView.Adapter adapter;
    List<ItemRestauran> item;

    @Override

    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shipping;
    }

    @Override
    protected void setUp(View view) {
        item = new ArrayList<>();
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        item.add(new ItemRestauran(R.drawable.img_restaurant));
        adapter = new RestaurantAdapter(item, getActivity());
        rcrShipping.setAdapter(adapter);
    }
}
