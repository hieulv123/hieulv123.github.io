package tcom.hieulv.foodcustomer.ui.combo;

import android.view.View;

import butterknife.OnClick;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;

public class FragmentCombo extends BaseFragment {
    @Override
    protected void initPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_combo;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.img_backSearch)
    public void onClick() {
        getActivity().onBackPressed();
    }
}
