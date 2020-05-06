package tcom.hieulv.foodcustomer.ui.home.food;

import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.customview.CustomToast;
import tcom.hieulv.foodcustomer.model.Datum;
import tcom.hieulv.foodcustomer.model.ItemHeader;
import tcom.hieulv.foodcustomer.model.response.nearrestaurant.ListRestaurant;
import tcom.hieulv.foodcustomer.ui.combo.FragmentCombo;

public class FragmentHome extends BaseFragment implements HomeMvpView {
    @BindView(R.id.recycle_home)
    RecyclerView recyclerViewHome;
    @BindView(R.id.rcv_hightlight_food)
    RecyclerView rvHightlightFood;
    @BindView(R.id.rv_nearRestaurants)
    RecyclerView rvNearRestaurants;
    RecyclerView.Adapter adapter;
    List<ItemHeader> data;
    List<Datum> imagesHotFood = new CopyOnWriteArrayList<>();
    List<ListRestaurant> nearRestaurants = new ArrayList<>();
    HomePresenter homePresenter;
    @BindView(R.id.content_home)
    ConstraintLayout contentHome;
    @BindView(R.id.scrollview_home)
    NestedScrollView scrollviewHome;
    private String pageIndex = "1";
    private String pageSize = "10";
    private LinearLayout LinearLayout;

    @Override
    protected void initPresenter() {
        homePresenter = new HomePresenter(MyApplication.getInstance().getLoginRepository());
        homePresenter.Attach(this);

    }

    @OnClick({R.id.img_navigationView})
    void onClickHumberger() {
        ((ActivityHome) getActivity()).openDrawer();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setUp(View view) {
        contentHome.setClickable(true);
        contentHome.setOnClickListener(v -> {
            if (!(v instanceof EditText)) {
                hideKeyBoard();
            }
        });
        scrollviewHome.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)
                (v, scrollX, scrollY, oldScrollX, oldScrollY) -> hideKeyBoard());
        data = new ArrayList<>();
        data.add(new ItemHeader(R.drawable.item_header));
        data.add(new ItemHeader(R.drawable.item_header));
        data.add(new ItemHeader(R.drawable.item_header));
        data.add(new ItemHeader(R.drawable.item_header));
        adapter = new AdapterHeader(getActivity(), data);
        recyclerViewHome.setAdapter(adapter);
        getHigtLightFood();


    }

    private void getHigtLightFood() {
        String token = MyApplication.getInstance().getLoginRepository().getToken();
        homePresenter.getHightLightFood(token, pageIndex, pageSize);
        homePresenter.getListRestaurantNear(token, 0, null, null, "10", "1");

    }


    @Override
    public void onError(String message) {
        super.onError(message);
    }

    @Override
    public void getFoodSuccess(String message) {
        Toast toast = CustomToast.makeText(getActivity(), message, CustomToast.SHORT, 1, R.drawable.vector_outline);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 10);
        toast.show();


    }

    @Override
    public void getHotFood(List<Datum> images) {
//        imagesHotFood = new ArrayList<>();
        imagesHotFood = images;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);
        rvHightlightFood.setLayoutManager(layoutManager);
        rvHightlightFood.setAdapter(new AdapterHightLightFood(getActivity(), imagesHotFood));


    }

    @Override
    public void getListRestaurantsNear(List<ListRestaurant> listRestaurants) {
        nearRestaurants.addAll(listRestaurants);
        rvNearRestaurants.setAdapter(new AdapterNearRestaurant(getActivity(), nearRestaurants));

    }

    @OnClick(R.id.tv_search)
    public void onClickSearch() {
        addFragment(new FragmentCombo());
    }
    public void addFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_frame,fragment).addToBackStack(null).commit();


    }
}
