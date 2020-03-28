package tcom.hieulv.foodcustomer.ui.home.home1;

import android.app.Dialog;
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
import tcom.hieulv.foodcustomer.ui.home.home2.FragmentHome2;

public class FragmentHome1 extends BaseFragment implements Home1MvpView {
    @BindView(R.id.edt_em_fg)
     EditText edtEmail;
    private Home1Presenter  mPresenter ;


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
    void onClickButtonSendCode(){
        mPresenter.onSendCodeToEmail(edtEmail.getText().toString().trim());
        dialogConfig();



    }
    public void dialogConfig(){
        Dialog dialog = new Dialog( getActivity());
        dialog.setContentView(R.layout.dialog_custom);
         TextView tvAccept =  dialog.findViewById(R.id.tv_accept);
         tvAccept.setOnClickListener( v ->{
             addFragment(new FragmentHome2());
             dialog.hide();
         });
        dialog.show();



    }
    private void addFragment(Fragment fragment){
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_login,fragment).addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onSendSuccess() {
        Toast.makeText(getActivity(),"Vui lòng kiểm tra Email của bạn",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onSendFaild(String error) {

    }
}
