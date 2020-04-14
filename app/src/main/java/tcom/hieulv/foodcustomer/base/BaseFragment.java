package tcom.hieulv.foodcustomer.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import tcom.hieulv.foodcustomer.util.CommonUntils;

public abstract class BaseFragment extends Fragment implements MvpView {
    private BaseActivity mActivity;
    private Unbinder mUnBinder;
    private View containerView;
    private ProgressDialog mProgressDialog;
    LinearLayout container;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() == 0) {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
        containerView = inflater.inflate(getLayoutId(), container, false);
        mUnBinder = ButterKnife.bind(this, containerView);
        setListener(containerView);
        initPresenter();
        return containerView;
    }

    private void setListener(View view) {
        view.setClickable(true);
        view.setOnTouchListener((v, event) -> {
            if (!(v instanceof EditText))
                BaseFragment.this.hideKeyBoard();
            return true;
        });
        view.setFocusableInTouchMode(true);

    }


    protected abstract void initPresenter();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        handleArguments(getArguments());
        setUp(view);
    }

    private void handleArguments(Bundle arguments) {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    protected abstract int getLayoutId();


    protected abstract void setUp(View view);

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public Unbinder getUnbinder() {
        return mUnBinder;
    }

    public void setUnbinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUntils.showLoadingDialog(this.getContext());

    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }


    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }

    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected interface CallBack {
        void onFragmentAttached();

        void onFragmentDetached(String tag);

    }

    public void hideKeyBoard() {
        View view = getActivity().getCurrentFocus();
        if ((view != null)) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
