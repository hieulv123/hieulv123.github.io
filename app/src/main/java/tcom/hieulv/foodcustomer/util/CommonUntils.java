package tcom.hieulv.foodcustomer.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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

        }
        return false;
    }
}
