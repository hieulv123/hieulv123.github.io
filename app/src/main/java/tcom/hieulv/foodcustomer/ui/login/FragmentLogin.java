package tcom.hieulv.foodcustomer.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
import tcom.hieulv.foodcustomer.ui.home.food.ActivityHome;
import tcom.hieulv.foodcustomer.ui.home.home1.FragmentHome1;
import tcom.hieulv.foodcustomer.ui.register.FragmentRegister;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentLogin extends BaseFragment implements LoginMvpView {
    private LoginPresenter mPresenter;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassWord;
    @BindView(R.id.view5)
    public View view5;
    @BindView(R.id.tv_hintEmail)
    TextView tvHintEmail;
    @BindView(R.id.tv_hintPassword)
    TextView tvHintPassword;
    private String typeapp = "customer";

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
        hideShowPassWord(view5, edtPassWord);
        tvHintEditTextChange(edtEmail, tvHintEmail);
        edtPassWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                tvHintPassword.setVisibility(View.VISIBLE);
                view5.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvHintPassword.setVisibility(View.INVISIBLE);
                view5.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtPassWord.getText().toString().trim().isEmpty()) {
                    tvHintPassword.setVisibility(View.VISIBLE);
//                    view5.setVisibility(View.INVISIBLE);
                } else {
                    tvHintPassword.setVisibility(View.INVISIBLE);
                    view5.setVisibility(View.VISIBLE);

                }

            }
        });


    }



    @OnClick(R.id.tv_creatacc)
    void onCreatAccount() {
        addFragment(new FragmentRegister());

    }

    @OnClick(R.id.tv_forgot_password)
    void onClickForgotPassWord() {
        addFragment(new FragmentHome1());
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login, fragment).addToBackStack(null);
        ft.commit();
    }

    @OnClick(R.id.btn_logemail)
    void onClickLogEmail() {
        if (CommonUntils.isEditTextEmpty(edtPassWord)) {
            view5.setVisibility(View.INVISIBLE);
        }
        if (!CommonUntils.isEditTextEmpty(edtEmail) && !CommonUntils.isEditTextEmpty(edtPassWord)) {
            if (CommonUntils.validateEmail(edtEmail)) {
                mPresenter.onLoginByEmail(
                        edtEmail.getText().toString().trim(),
                        edtPassWord.getText().toString().trim(),
                        typeapp
                );
            }


        }


    }


    @Override
    public void onLoginSuccess() {
//        Toast toast = CustomToast.makeText(getActivity(), "Đăng nhập thành công",
//                CustomToast.SHORT, 1, R.drawable.vector_outline);
//        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 10);
//        toast.show();
//        showMessage("Đăng nhập thành công");
        Intent home = new Intent(getActivity(), ActivityHome.class);
        startActivity(home);
        getActivity().finish();


    }

    @Override
    public void onLoginError(String message) {
//        onError(message);
        Toast toast = CustomToast.makeText(getActivity(), message,
                CustomToast.SHORT, 2, R.drawable.vector_outline);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 10);
        toast.show();

    }



    @SuppressLint("ClickableViewAccessibility")
    public void hideShowPassWord(View view, EditText editText) {
        view5.setOnClickListener(v -> {
            if (editText.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                editText.setFocusable(true);
                view5.setBackgroundResource(R.drawable.ic_visibility_off_black_24dp);
            } else {
                view5.setBackgroundResource(R.drawable.ic_visibility_black_24dp);
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }

        });
    }

    private void tvHintEditTextChange(EditText editText, TextView textView) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editText.getText().toString().trim().isEmpty()) {
                    textView.setVisibility(View.VISIBLE);
                } else {
                    textView.setVisibility(View.INVISIBLE);

                }

            }
        });

    }


}
