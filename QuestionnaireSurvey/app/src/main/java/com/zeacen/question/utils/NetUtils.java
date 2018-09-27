package com.zeacen.question.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * 跟网络相关的工具类
 * 
 * @ClassName: NetUtils
 * @Description: TODO
 * @author chenwei
 * @date 2016年4月7日 下午1:10:52
 *
 */
public class NetUtils {

	/**
	 * 判断是否联网
	 * <p>
	 * Title: isNetworkAvailable
	 * </p>
	 * 
	 * @author cw
	 * @date 2016年5月11日 上午9:58:49
	 * @return boolean
	 *         <p>
	 *         Description:
	 *         </p>
	 * @param context
	 * @return
	 *
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm == null) {
		} else {
			NetworkInfo[] info = cm.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 判断GPS是否打开
	 * <p>
	 * Title: isGpsEnabled
	 * </p>
	 * 
	 * @author cw
	 * @date 2016年5月11日 上午9:58:39
	 * @return boolean
	 *         <p>
	 *         Description:
	 *         </p>
	 * @param context
	 * @return
	 *
	 */
	public static boolean isGpsEnabled(Context context) {
		LocationManager lm = ((LocationManager) context.getSystemService(Context.LOCATION_SERVICE));
		List<String> accessibleProviders = lm.getProviders(true);
		return accessibleProviders != null && accessibleProviders.size() > 0;
	}

	/**
	 * 判断WIFI是否打开
	 * <p>
	 * Title: isWifiEnabled
	 * </p>
	 * 
	 * @author cw
	 * @date 2016年5月11日 上午9:58:28
	 * @return boolean
	 *         <p>
	 *         Description:
	 *         </p>
	 * @param context
	 * @return
	 *
	 */
	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null
				&& mgrConn.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED)
				|| mgrTel.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}

	/**
	 * 判断是否是3G网络
	 * <p>
	 * Title: is3rd
	 * </p>
	 * 
	 * @author cw
	 * @date 2016年5月11日 上午9:58:16
	 * @return boolean
	 *         <p>
	 *         Description:
	 *         </p>
	 * @param context
	 * @return
	 *
	 */
	public static boolean is3rd(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		return networkINfo != null && networkINfo.getType() == ConnectivityManager.TYPE_MOBILE;
	}

	/**
	 * 判断是wifi还是3g网络,用户的体现性在这里了，wifi就可以建议下载或者在线播放。
	 * <p>
	 * Title: isWifi
	 * </p>
	 * 
	 * @author cw
	 * @date 2016年5月11日 上午9:58:04
	 * @return boolean
	 *         <p>
	 *         Description:
	 *         </p>
	 * @param context
	 * @return
	 *
	 */
	public static boolean isWifi(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkINfo = cm.getActiveNetworkInfo();
		return networkINfo != null && networkINfo.getType() == ConnectivityManager.TYPE_WIFI;
	}

	/**
	 * 打开网络设置界面
	 */
	public static void openSetting(Activity activity) {
		Intent intent = new Intent("/");
		ComponentName cm = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
		intent.setComponent(cm);
		intent.setAction("android.intent.action.VIEW");
		activity.startActivityForResult(intent, 0);
	}

}
