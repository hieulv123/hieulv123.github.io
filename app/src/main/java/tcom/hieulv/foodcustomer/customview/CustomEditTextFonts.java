package tcom.hieulv.foodcustomer.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

import tcom.hieulv.foodcustomer.R;
import tcom.hieulv.foodcustomer.util.Constants;
import tcom.hieulv.foodcustomer.util.FontCache;

public class CustomEditTextFonts extends AppCompatEditText {
    public EditText et;
    private int currentColor = Color.BLACK;
    private String typeFont = Constants.DEFAULT_FONT;

    public CustomEditTextFonts(Context context) {
        super(context);
    }

    public CustomEditTextFonts(Context context, AttributeSet attrs) {
        super(context, attrs);
        currentColor = getCurrentTextColor();
        try {
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.CustomTextViewFonts, 0, 0);

            typeFont = a.getString(R.styleable.CustomTextViewFonts_font_type);

            setTypeface(Typeface.createFromAsset(context.getAssets(), typeFont));
            a.recycle();
        } catch (Exception ex) {
            try {
                setTypeface(Typeface.createFromAsset(context.getAssets(), Constants.DEFAULT_FONT));
            } catch (Exception ex1) {
                setTypeface(Typeface.DEFAULT);
            }
        }
    }

    public void setTypeFont(Context context, String typeFont) {
        this.typeFont = typeFont;
        setTypeface(FontCache.getTypeface(context, typeFont));
    }

    public String getTypeFont() {
        return typeFont;
    }
}


//    @Override
//    public void setError(CharSequence error, Drawable icon) {
//        setCompoundDrawables(null, null, icon, null);
//    }
////
////    et = (CustomEditTextFonts) finby
////
////    findViewById(R.id .);
////
////    errorIcon =
////
////    getResources().
////
////    getDrawable(R.drawable .);
////    errorIcon.setBounds(new
////
////    Rect(0,0,errorIcon.getIntrinsicWidth(),errorIcon.
////
////    getIntrinsicHeight()));
////       et.setError(null,errorIcon);
//
//}
