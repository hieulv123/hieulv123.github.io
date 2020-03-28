package tcom.hieulv.foodcustomer.ui.login;

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
import tcom.hieulv.foodcustomer.ui.home.home1.FragmentHome1;
import tcom.hieulv.foodcustomer.ui.register.FragmentRegister;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentLogin extends BaseFragment implements LoginMvpView {
    private LoginPresenter mPresenter ;
    @BindView(R.id.edt_email)
    EditText edtEmail ;
    @BindView(R.id.edt_password)
    EditText edtPassWord ;
    @Override
    protected void initPresenter() {
        mPresenter = new LoginPresenter<>(MyApplication.getInstance().getLoginRepository());
        mPresenter.Attach(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void setUp(View view) {

    }
    @OnClick(R.id.tv_creatacc)
    void onCreatAccount(){
        addFragment(new FragmentRegister()  );

    }
    @OnClick(R.id.tv_forgot_password)
    void onClickForgotPassWord(){
        addFragment(new FragmentHome1());
    }
    private void addFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login,fragment).addToBackStack(null);
        ft.commit();
    }
    @OnClick(R.id.btn_logemail)
    void onClickLogEmail(){
        if (!CommonUntils.isEditTextEmpty(edtEmail)||!CommonUntils.isEditTextEmpty(edtPassWord)) {
            mPresenter.onLoginByEmail(
                    edtEmail.getText().toString().trim(),
                    edtPassWord.getText().toString().trim()
            );
        }


    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(getActivity(), "LoginByEmail Succesfully", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(getActivity(), "Faildddddddd", Toast.LENGTH_SHORT).show();

    }
}