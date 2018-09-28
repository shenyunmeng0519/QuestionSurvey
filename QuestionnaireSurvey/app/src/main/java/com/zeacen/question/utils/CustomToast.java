package com.zeacen.question.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zeacen.question.R;

public class CustomToast {

    public enum eLength {
        LONG, SHORT
    }

    private static Toast mToast;

    public static void showCustomToast(Context mContext, String text, eLength eLengthTemp) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, (eLengthTemp == eLength.LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT));
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showNewCustomToast(Context mContext, String text, eLength eLengthTemp) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, Html.fromHtml(text), (eLengthTemp == eLength.LONG ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT));
        } else {
            mToast.setText(Html.fromHtml(text));
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static void showToast(Context mContext,String info) {
        Toast   toast = new Toast(mContext);
        LayoutInflater inflater = LayoutInflater
                .from(mContext);
        View view = inflater.inflate(R.layout.my_toast, null);
        TextView textView = (TextView) view.findViewById(R.id.text);

        textView.setText(info);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }


}
