package tcom.hieulv.foodcustomer.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.CallBack {
    public static final int NO_LAYOUT = -1;
    private ProgressDialog mProgressDialog;
    private Unbinder mUnbinder;
    private boolean doubleBackToExitPressesdOnce = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() == NO_LAYOUT) {
            return;
        }
        setContentView(getLayoutId());
        initPresenter();
        setUnbinder(ButterKnife.bind(this));
        handleIntent(getIntent());
        setUp();

    }

    protected abstract int getLayoutId();

    protected abstract void handleIntent(Intent intent);

    protected abstract void initPresenter();

    protected abstract void setUp();

    public void setUnbinder(Unbinder Unbinder) {
        this.mUnbinder = Unbinder;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean haspermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == getPackageManager().PERMISSION_GRANTED;
    }


    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUntils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }

    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        }else {
            showSnackBar("Đã có lỗi xảy ra");
        }

    }

    private  void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.content),
                message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));

    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            showSnackBar(message);
        }
    }


    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        hideLoading();
        super.onBackPressed();
    }
}
