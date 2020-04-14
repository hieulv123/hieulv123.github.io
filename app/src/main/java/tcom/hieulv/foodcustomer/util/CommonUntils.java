package tcom.hieulv.foodcustomer.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

import tcom.hieulv.foodcustomer.R;

public class CommonUntils {
    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();
        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }

    public static void collapseHorizontal(final View v, Animation.AnimationListener listener) {
        final int initialWith = v.getMeasuredWidth();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);

                } else {
                    v.getLayoutParams().width = initialWith - (int) (initialWith * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        //1dp/ms
        a.setDuration((int) (initialWith / v.getContext().getResources().getDisplayMetrics().density));
        if (listener != null) {
            a.setAnimationListener(listener);
        }
        v.startAnimation(a);

    }

    public static void expandHorizontal(final View v, final int width, Animation.AnimationListener listener) {
        v.measure(width, ViewGroup.LayoutParams.MATCH_PARENT);
        final int targetWidth = v.getMeasuredWidth();
        v.setVisibility(View.VISIBLE);

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.getLayoutParams().width = width;
                } else {
                    v.getLayoutParams().width = (int) (targetWidth * interpolatedTime);

                }
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }

        };
        //1dp/ms
        a.setDuration((int)(targetWidth/v.getContext().getResources().getDisplayMetrics().density));
        if (listener!=null){
            a.setAnimationListener(listener);
        }
        v.startAnimation(a);
    }
    public static String formatVNDnumber(double value){
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        formatter.applyPattern("#,###,###,###");
        String number =formatter.format(value);
        return number + "đ";
    }
//    public static String formatVNDNumberWithoutCurrency(double value){
//        DecimalFormat formatter =(DecimalFormat) NumberFormat.getInstance(Locale.US);
//
//    }
    public static boolean isEditTextEmpty(EditText editText){
        if ("".equals(editText.getText().toString().trim())){
            editText.setError("Vui lòng nhập đủ thông tin");
            return true;
        }
        return false;
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean validateEmail(EditText edtEmail) {
        String email = edtEmail.getText().toString().trim();
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        if (Pattern.matches(regex, email)) {
            return true;
        }
        edtEmail.setError("Email không hợp lệ");
        return false;
    }
    public static void showCustomToast(Activity activity, String message, int duration) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) activity.findViewById(R.id.toast_layout_root));


        TextView text = layout.findViewById(R.id.text);
        if (message != null) {
            text.setText(message);
            Toast toast = new Toast(activity.getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, -270);
            toast.setDuration(duration);
            toast.setView(layout);
            toast.show();
        }
    }

}
