package tcom.hieulv.foodcustomer.ui.register;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
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
        datePickerDialog();

    }

    @OnClick(R.id.btn_dangki)
    void onClickRegister() {
        if (!CommonUntils.isEditTextEmpty(edtHoten)
                &&!CommonUntils.isEditTextEmpty(edtNgaysinh)
                &&!CommonUntils.isEditTextEmpty(edtcmnd)
                &&!CommonUntils.isEditTextEmpty(edtSdt)
                &&!CommonUntils.isEditTextEmpty(edtEmail)
                &&!CommonUntils.isEditTextEmpty(edtdiachi)
                &&!CommonUntils.isEditTextEmpty(edtMatKhau)){
            mPresenter.onRegisterCustomer(edtHoten.getText().toString().trim(),
                    edtcmnd.getText().toString().trim(),
                    edtSdt.getText().toString().trim(),
                    edtEmail.getText().toString().trim(),
                    edtdiachi.getText().toString().trim(),
                    edtMatKhau.getText().toString().trim(),
                    edtNgaysinh.getText().toString().trim());
        }
    }

    @Override
    public void onRegisterCustomSuccess() {
        Toast.makeText(getActivity(), "Đăng kí tài khoản thành công", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegisterCustomFaild(String message) {

    }
    public void datePickerDialog(){
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR) ;
        edtNgaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picker=  new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                                String month = monthOfYear >= 9 ? (monthOfYear + 1) + "" : "0" + (monthOfYear + 1);
                                String day = dayOfMonth >= 10 ? dayOfMonth + "" : "0" + dayOfMonth;
                                edtNgaysinh.setText(year + "-" + month + "-" + day);

                            }
                        },year,month,day);
                picker.show();

            }
        });
    }
    @OnClick(R.id.ic_back)
    void onClickBack(){
        getActivity().onBackPressed();
    }

}
