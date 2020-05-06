package tcom.hieulv.foodcustomer.customview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import tcom.hieulv.foodcustomer.R;

public class CustomToast extends Toast {
    public static int LONG =7000 ;
    public static int SHORT =4000;
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public CustomToast(Context context) {
        super(context);
    }
    public static Toast makeText(Context context,String message,int duration,int type,int imageResource ){
        Toast toast= new Toast(context);
        toast.setDuration(duration);
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_toast,null,false);
        TextView l1 = (TextView) layout.findViewById(R.id.toast_text);
        ConstraintLayout linearLayout = (ConstraintLayout) layout.findViewById(R.id.toast_type);
        ImageView img1 = (ImageView) layout.findViewById(R.id.toast_icon) ;
        l1.setText(message);
        if (type ==1){
            linearLayout.setBackgroundResource(R.drawable.success_shape);
            img1.setImageResource(R.drawable.vector_outline);
        } else if (type ==2){
            linearLayout.setBackgroundResource(R.drawable.error_shape);
            img1.setImageResource(R.drawable.vector_outline);
        }
        toast.setView(layout);
        return toast ;
    }
}
