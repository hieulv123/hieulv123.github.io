package tcom.hieulv.foodcustomer.ui.home.home2;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.ui.home.home1.Home1Presenter;
import tcom.hieulv.foodcustomer.ui.home.home3.FragmentHome3;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentHome2 extends BaseFragment implements Home2MvpView {
    @BindView(R.id.et_otp)
    EditText edtOtp;
    private Home2Presenter mPresenter;
    public Home1Presenter home1Presenter;

    @Override
    protected void initPresenter() {
        home1Presenter = new Home1Presenter<>(MyApplication.getInstance().getLoginRepository());
        mPresenter = new Home2Presenter<>(MyApplication.getInstance().getLoginRepository());
        mPresenter.Attach(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_inputcode;
    }

    @Override
    protected void setUp(View view) {

    }


    private void addFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login, fragment).addToBackStack(null);
        ft.commit();
    }

    @OnClick(R.id.btn_config)
    void sendOtpConfig() {
        if ((!CommonUntils.isEditTextEmpty(edtOtp))) {
            String token = MyApplication.getInstance().getLoginRepository().getToken();
            Integer otp = MyApplication.getInstance().getLoginRepository().getOtp();
            String Otp = String.valueOf(otp);

            if (edtOtp.getText().toString().equals(Otp)) {
                mPresenter.onSendCodeConfig(edtOtp.getText().toString().trim(), token);
                Toast.makeText(getActivity(), "Code true", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentHome3());
            }else {
                Toast.makeText(getActivity(), "Mã xác nhận chưa đúng", Toast.LENGTH_SHORT).show();

            }

        }

    }

    @Override
    public void sendCodeConfigSuccess() {
        Toast.makeText(getActivity(), "Send Code Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendCodeConfigError(String error) {

    }
}
