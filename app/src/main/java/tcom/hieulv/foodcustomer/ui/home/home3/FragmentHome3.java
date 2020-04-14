package tcom.hieulv.foodcustomer.ui.home.home3;

import android.view.Gravity;
import android.view.View;
import android.widget.Button;
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
import tcom.hieulv.foodcustomer.customview.CustomToast;
import tcom.hieulv.foodcustomer.ui.login.FragmentLogin;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentHome3 extends BaseFragment implements Home3MvpView {
    Home3Presenter home3Presenter;
    @BindView(R.id.edt_newpass)
    EditText edtNewPass;
    @BindView(R.id.edt_confignewpass)
    EditText edtReinPass;
    @BindView(R.id.btn_sendcode)
    Button btnSendCode;

    @Override
    protected void initPresenter() {
        home3Presenter = new Home3Presenter<>(MyApplication.getInstance().getLoginRepository());
        home3Presenter.Attach(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fargment_forgotpw2;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.btn_sendcode)
    void onClickConfig() {
        String pass1 = edtNewPass.getText().toString().trim();
        String pass2 = edtReinPass.getText().toString().trim();

        if (!pass1.equals(pass2)) {
            onMakeError("Nhập lại mật khẩu không đúng");

        } else {


            if (!CommonUntils.isEditTextEmpty(edtNewPass) && !CommonUntils.isEditTextEmpty(edtReinPass)) {
                String token = MyApplication.getInstance().getLoginRepository().getToken();
                home3Presenter.createNewPass(edtNewPass.getText().toString().trim(), token);
            } else {
                btnSendCode.setEnabled(false);
            }
        }

    }

    @Override
    public void onSuccess() {
        Toast toast = CustomToast.makeText(getActivity(), "Thay đổi mật khẩu thành công",
                CustomToast.LONG, 1, R.drawable.ic_check_black_24dp);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 0);
        toast.show();
        addFragment(new FragmentLogin());

    }

    @Override
    public void onMakeError(String error) {
        Toast toast = CustomToast.makeText(getActivity(), error,
                CustomToast.LONG, 2, R.drawable.ic_error_24dp);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 0);
        toast.show();


    }
    private void addFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login, fragment).addToBackStack(null);
        ft.commit();
    }
}
