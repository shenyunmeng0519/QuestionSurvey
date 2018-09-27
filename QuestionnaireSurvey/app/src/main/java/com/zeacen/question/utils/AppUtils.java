package com.zeacen.question.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * 跟App相关的辅助类
 *
 * @author chenwei
 * @ClassName: AppUtils
 * @Description: TODO
 * @date 2016年4月7日 下午1:10:11
 */
public class AppUtils {

    /**
     * 获取友盟信息
     * <p>Title: getMetaData</p>
     *
     * @param context
     * @return
     * @author cw
     * @date 2016年7月21日 上午9:12:44
     */
    public static String getUmengMetaData(Context context) {
        ApplicationInfo appInfo;
        String msg = "";
        try {
            appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            msg = appInfo.metaData.getString("UMENG_CHANNEL");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return msg;
    }

    /**
     * 取得当前应用的名称
     * <p>
     * Title: getAppName
     * </p>
     *
     * @param context
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:21:08
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取得当前应用的版本名称
     * <p>
     * Title: getVersionName
     * </p>
     *
     * @param context
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:20:47
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 取得当前应用的版本号
     * <p>
     * Title: getVersionCode
     * </p>
     *
     * @param context
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:20:19
     */
    public static int getVersionCode(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 判断服务器上版本号是否大于当前版本号
     * <p>
     * Title: compareVersionCode
     * </p>
     *
     * @param context
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:27:52
     */
    public static boolean compareVersionCode(Context context) {
        // 取得当前版本号
        int currentVersionCode = getVersionCode(context);
        // 取得服务器上版本号
        int serverVersionCode = StringUtils.NullToInt(ConfigUtils.getConfigValueByName("android_version_code"));
        // 当服务器上版本号大于当前版本号返回true
        return serverVersionCode > currentVersionCode;

    }

    /**
     * 判断是否强制更新
     * <p>
     * Title: isForceUpgrade
     * </p>
     *
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:30:28
     */
    public static boolean isForceUpgrade() {
        int android_force_upgrade = StringUtils.NullToInt(ConfigUtils.getConfigValueByName("android_force_upgrade"));
        return android_force_upgrade == 1;
    }

    /**
     * 获取七牛云下载地址
     * <p>
     * Title: getAndroidDownloadUrl
     * </p>
     *
     * @return
     * @author cw
     * @date 2016年6月14日 上午9:31:37
     */
    public static String getAndroidDownloadUrl() {
        return StringUtils.NullToStr(ConfigUtils.getConfigValueByName("android_download_from_qiniu"));
        // return StringUtils.NullToStr(ConfigUtils.getConfigValueByName("android_download"));
    }

    /**
     * 获取渠道下载地址
     * <p>Title: getAndroidDownloadUrlChannel</p>
     *
     * @return
     * @author cw
     * @date 2016年8月10日 下午4:44:21
     */
    public static String getAndroidDownloadUrlChannel(Context mContext) {
        String channelId = getUmengMetaData(mContext);
        String url = getAndroidDownloadUrl();
        if (StringUtils.isNotEmpty(channelId)) {
            String urlTemp = url.substring(0, url.lastIndexOf("/") + 1) + channelId + ".apk";
            //判断连接是否存在
           /* boolean bExist = CommonUtils.isUrlExist(urlTemp);
            if (bExist) {
                url = urlTemp;
            }*/
        }
        return url;
    }

    /**
     * 获取升级提示的文字
     * <p>
     * Title: getUpgradeInfo
     * </p>
     *
     * @return
     * @author cw
     * @date 2016年6月22日 上午9:27:46
     */
    public static String getUpgradeInfo() {
        return StringUtils.NullToStr(ConfigUtils.getConfigValueByName("android_upgrade_info"));
    }

    /**
     * 判断是否是新版本
     * <p>
     * Title: isNewVersion
     * </p>
     *
     * @return
     * @author cw
     * @date 2016年6月30日 上午11:00:32
     */
    public static boolean isNewVersion(Context context, String strNewVersionName) {
        String strVersionName = getVersionName(context);
        if (StringUtils.isNotEmpty(strVersionName) && StringUtils.isNotEmpty(strNewVersionName)) {
            int iVersionName = Integer.parseInt(strVersionName.replace(".", ""));
            int iNewVersionName = Integer.parseInt(strNewVersionName.replace(".", ""));
            if (iNewVersionName > iVersionName) {
                return true;
            }
        }
        return false;

    }

    /**
     * 判断app是否安装
     *
     * @param context
     * @param uri
     * @return
     */
    public static boolean isAppInstalled(Context context, String uri) {
        PackageManager pm = context.getPackageManager();
        boolean installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }

}
