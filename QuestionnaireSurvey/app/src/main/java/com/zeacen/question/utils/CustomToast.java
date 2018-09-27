package com.zeacen.question.utils;

import android.content.Context;
import android.text.Html;
import android.widget.Toast;

public class CustomToast {
	
	public enum eLength{
		LONG,SHORT
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
}
