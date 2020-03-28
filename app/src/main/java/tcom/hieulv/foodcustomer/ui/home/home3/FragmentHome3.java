package tcom.hieulv.foodcustomer.ui.home.home3;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import tcom.hieulv.foodcustomer.MyApplication;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.base.BaseFragment;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public class FragmentHome3 extends BaseFragment implements Home3MvpView{
    Home3Presenter home3Presenter ;
    @BindView(R.id.edt_newpass)
    EditText edtNewPass;

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
    void onClickConfig(){
        if (!CommonUntils.isEditTextEmpty(edtNewPass)) {
        String token = MyApplication.getInstance().getLoginRepository().getToken();
        home3Presenter.createNewPass(edtNewPass.getText().toString().trim(),token);
        }

    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), " Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onMakeError(String error) {

    }
}
