package tcom.hieulv.foodcustomer.ui.register;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.customview.CustomToast;
import tcom.hieulv.foodcustomer.model.request.NewPassRequest;
import tcom.hieulv.foodcustomer.ui.login.LoginActivity;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentRegister extends BaseFragment implements RegisterMvpView {
    RegisterPresenter mPresenter;
    DatePickerDialog picker;
    @BindView(R.id.edtmatkhau)
    EditText edtMatKhau;
    @BindView(R.id.edthoten)
    EditText edtHoten;
    @BindView(R.id.edtngaysinh)
    EditText edtNgaysinh;
    @BindView(R.id.edtsdt)
    EditText edtSdt;
    @BindView(R.id.edtemail)
    EditText edtEmail;
    @BindView(R.id.edtdiachi)
    EditText edtdiachi;
    @BindView(R.id.edtcmnd)
    EditText edtcmnd;
    @BindView(R.id.edtconfigmatkhau)
    EditText edtConfigPass;
    @BindView(R.id.tv_configmatkhau)
    TextView tvConfigPass;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.tv_hintName)
    TextView tvHintName;
    @BindView(R.id.tv_hintCmnd)
    TextView tvHintCmnd;
    @BindView(R.id.tv_hintPhone)
    TextView tvHintPhone;
    @BindView(R.id.tv_hintAddress)
    TextView tvHintAdress;
    @BindView(R.id.tv_hintEmailRg)
    TextView tvHintEmailRg;
    @BindView(R.id.tv_hintPasswordRg)
    TextView tvHintPasswordRg;
    @BindView(R.id.tv_hintConfigPasswordRg)
    TextView tvHintConfigPassWordRg;
    @BindView(R.id.tv_hintBirthday)
    TextView tvHintBirthday;
    @BindView(R.id.scrollview_parent)
    NestedScrollView scrollView;
    @BindView(R.id.layout_content)
    ConstraintLayout layoutContent;


    @Override
    protected void initPresenter() {
        mPresenter = new RegisterPresenter<>(MyApplication.getInstance().getLoginRepository());
        mPresenter.Attach(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void setUp(View view) {
        layoutContent.setClickable(true);
        layoutContent.setOnClickListener(v -> {
            if (!(v instanceof EditText)) {
                hideKeyBoard();
            }
        });
//        layoutContent.setFocusableInTouchMode(true);
        scrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener)
                (v, scrollX, scrollY, oldScrollX, oldScrollY) -> hideKeyBoard());
//        view1.setVisibility(View.INVISIBLE);
//        view2.setVisibility(View.INVISIBLE);
        datePickerDialog();
        hideShowPassWord(view1, view2, edtMatKhau, edtConfigPass);
        edtNgaysinh.setKeyListener(null);
        tvHintEditTextChange(edtHoten, tvHintName);
        tvHintEditTextChange(edtSdt, tvHintPhone);
        tvHintEditTextChange(edtcmnd, tvHintCmnd);
        tvHintEditTextChange(edtEmail, tvHintEmailRg);
        tvHintEditTextChange(edtdiachi, tvHintAdress);
        tvHintEditTextChange(edtNgaysinh, tvHintBirthday);
        edtMatKhau.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                tvHintPasswordRg.setVisibility(View.VISIBLE);
                view1.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvHintPasswordRg.setVisibility(View.INVISIBLE);
                view1.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtMatKhau.getText().toString().trim().isEmpty()) {
                    tvHintPasswordRg.setVisibility(View.VISIBLE);
//                    view1.setVisibility(View.INVISIBLE);
                } else {
                    tvHintPasswordRg.setVisibility(View.INVISIBLE);
                    view1.setVisibility(View.VISIBLE);

                }

            }
        });
        edtConfigPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                tvHintConfigPassWordRg.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvHintConfigPassWordRg.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtConfigPass.getText().toString().trim().isEmpty()) {
                    tvHintConfigPassWordRg.setVisibility(View.VISIBLE);
//                    view2.setVisibility(View.INVISIBLE);
                } else {
                    tvHintConfigPassWordRg.setVisibility(View.INVISIBLE);
                    view2.setVisibility(View.VISIBLE);

                }

            }
        });
    }

    @OnClick(R.id.btn_dangki)
    void onClickRegister() {
        String pass = edtMatKhau.getText().toString();
        String configpass = edtConfigPass.getText().toString();
        if (CommonUntils.isEditTextEmpty(edtMatKhau)) {
            view1.setVisibility(View.INVISIBLE);
        }
        if ( CommonUntils.isEditTextEmpty(edtConfigPass)){
            view2.setVisibility(View.INVISIBLE);
        }
        if (!CommonUntils.isEditTextEmpty(edtHoten)
                && !CommonUntils.isEditTextEmpty(edtNgaysinh)
                && !CommonUntils.isEditTextEmpty(edtcmnd)
                && !CommonUntils.isEditTextEmpty(edtSdt)
                && !CommonUntils.isEditTextEmpty(edtEmail)
                && !CommonUntils.isEditTextEmpty(edtdiachi)
                && !CommonUntils.isEditTextEmpty(edtMatKhau)
                && !CommonUntils.isEditTextEmpty(edtConfigPass)) {
            if (pass.equals(configpass)) {
                tvConfigPass.setTextColor(getResources().getColor(R.color.Black));
                if (CommonUntils.validateEmail(edtEmail)) {
                    mPresenter.onRegisterCustomer(edtHoten.getText().toString().trim(),
                            edtcmnd.getText().toString().trim(),
                            edtSdt.getText().toString().trim(),
                            edtEmail.getText().toString().trim(),
                            edtdiachi.getText().toString().trim(),
                            edtMatKhau.getText().toString().trim(),
                            edtNgaysinh.getText().toString().trim());
                }
            } else {
                tvConfigPass.setTextColor(getResources().getColor(R.color.textError));
            }
        }
    }

    @Override
    public void onRegisterCustomSuccess() {
        Toast toast = CustomToast.makeText(getActivity(), "Đăng kí tài khoản thành công",
                CustomToast.LONG, 1, R.drawable.ic_check_black_24dp);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 30, 0);
        toast.show();
        Intent login = new Intent(getActivity(), LoginActivity.class);
        startActivity(login);
        getActivity().finish();

    }

    @Override
    public void onRegisterCustomFaild(String message) {

    }

    @Override
    public void onRegisterCustomFaild(List<String> message) {
        String Message = String.valueOf(message);
        Toast toast = CustomToast.makeText(getActivity(), Message,
                CustomToast.LONG, 2, R.drawable.ic_error_24dp);
        toast.setGravity(Gravity.TOP | Gravity.CENTER, 10, 0);
        ;
        toast.show();

    }

    public void datePickerDialog() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        edtNgaysinh.setOnClickListener(v -> {
            picker = new DatePickerDialog(FragmentRegister.this.getActivity(),
                    (view, year1, monthOfYear, dayOfMonth) -> {

                        String month1 = monthOfYear >= 9 ? (monthOfYear + 1) + "" : "0" + (monthOfYear + 1);
                        String day1 = dayOfMonth >= 10 ? dayOfMonth + "" : "0" + dayOfMonth;
                        edtNgaysinh.setText(year1 + "-" + month1 + "-" + day1);

                    }, year, month, day);
            picker.show();


        });
    }

    @OnClick(R.id.ic_back)
    void onClickBack() {
        getActivity().onBackPressed();
    }

    @SuppressLint("ClickableViewAccessibility")
    public void hideShowPassWord(View view1, View view2, EditText editText1, EditText editText2) {
        view1.setOnClickListener(v -> {
            if (editText1.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                editText1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                editText1.setFocusable(true);
                view1.setBackgroundResource(R.drawable.ic_visibility_off_black_24dp);
            } else {
                view1.setBackgroundResource(R.drawable.ic_visibility_black_24dp);
                editText1.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }

        });
        view2.setOnClickListener(v -> {
            if (editText2.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())) {
                editText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                editText2.setFocusable(true);
                view2.setBackgroundResource(R.drawable.ic_visibility_off_black_24dp);
            } else {
                view2.setBackgroundResource(R.drawable.ic_visibility_black_24dp);
                editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
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
