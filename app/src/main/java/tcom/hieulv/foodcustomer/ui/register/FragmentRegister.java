package tcom.hieulv.foodcustomer.ui.register;

import android.app.DatePickerDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.customview.CustomToast;
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
                &&!CommonUntils.isEditTextEmpty(edtNgaysinh)){
//                &&!CommonUntils.isEditTextEmpty(edtcmnd)
//                &&!CommonUntils.isEditTextEmpty(edtSdt)
//                &&!CommonUntils.isEditTextEmpty(edtEmail)
//                &&!CommonUntils.isEditTextEmpty(edtdiachi)
//                &&!CommonUntils.isEditTextEmpty(edtMatKhau)){
            mPresenter.onRegisterCustomer(edtHoten.getText().toString().trim(),
                    edtcmnd.getText().toString().trim(),
                    edtSdt.getText().toString().trim(),
                    edtEmail.getText().toString().trim(),
                    edtdiachi.getText().toString().trim(),
                    edtMatKhau.getText().toString().trim(),
                    edtNgaysinh.getText().toString().trim());
        }else{
//            Toast.makeText(getActivity(),"Bạn phải nhập đủ thông tin",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRegisterCustomSuccess() {
        Toast toast = CustomToast.makeText(getActivity(),"Đăng kí tài khoản thành công",
                CustomToast.LONG,1,R.drawable.ic_check_black_24dp);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,30,0);;
        toast.show();
    }

    @Override
    public void onRegisterCustomFaild(String message) {

    }

    @Override
    public void onRegisterCustomFaild(List<String> message) {
        String Message = String.valueOf(message);
        Toast toast = CustomToast.makeText(getActivity(),Message,
                CustomToast.LONG,2,R.drawable.ic_error_24dp);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,30,0);;
        toast.show();

    }

    public void datePickerDialog(){
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR) ;
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
    void onClickBack(){
        getActivity().onBackPressed();
    }

}
