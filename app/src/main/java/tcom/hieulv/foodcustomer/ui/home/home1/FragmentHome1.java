package tcom.hieulv.foodcustomer.ui.home.home1;

import android.app.Dialog;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.customview.CustomToast;
import tcom.hieulv.foodcustomer.ui.home.home2.FragmentHome2;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentHome1 extends BaseFragment implements Home1MvpView {
    @BindView(R.id.edt_em_fg)
    EditText edtEmail;
    private Home1Presenter mPresenter;


    @Override
    protected void initPresenter() {
        mPresenter = new Home1Presenter<>(MyApplication.getInstance().getLoginRepository());
        mPresenter.Attach(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_forgotpw;
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.btn_config)
    void onClickButtonSendCode() {

        if (!CommonUntils.isEditTextEmpty(edtEmail)) {
//            CommonUntils.validateEmail(edtEmail);
            if (CommonUntils.validateEmail(edtEmail)) {

                mPresenter.onSendCodeToEmail(edtEmail.getText().toString().trim());
            }
        }

//            dialogConfig();
    }


    private void addFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login, fragment).addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onSendSuccess() {
        dialogConfig();
//        Toast.makeText(getActivity(),"Vui lòng kiểm tra Email của bạn",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSendFaild(List<String> error) {
        String erroR = String.valueOf(error);

    }

    @Override
    public void onSendFaild(String error) {
        Toast toast = CustomToast.makeText(getActivity(), error, CustomToast.LONG, 2, R.drawable.ic_error_24dp);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 0);
        toast.show();
    }

    public void dialogConfig() {
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_custom);
        TextView tvAccept = dialog.findViewById(R.id.tv_accept);
        tvAccept.setOnClickListener(v -> {
            addFragment(new FragmentHome2());
            dialog.dismiss();
        });
        dialog.show();
        dialog.setCancelable(false);


    }
    public void hideKeyboard(){
        View view = getActivity().getCurrentFocus();
    }
}
