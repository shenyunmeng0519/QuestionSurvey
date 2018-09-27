package com.zeacen.question.utils;

import android.graphics.Paint;
import android.widget.TextView;


import com.zeacen.question.app.AppApplication;
import com.zeacen.question.bean.ConfigManage;
import com.zeacen.question.constant.YYGConstant;

import java.text.NumberFormat;


public class ConfigUtils {


	public static ConfigManage configManage;

	public synchronized static ConfigManage getConfigManage() {
		if (configManage == null) {
			configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		}
		return configManage;
	}
	//支付文字说明
	public static String pay_description;
	//图片服务器地址
	public static String global_image_server;
	//七牛云图片服务器地址
	public static String qiniu_image_server;
	//客服电话
	public static String mobile;
	//是否支持第三方登录
	public static String global_third_party_login;
	//是否显示邀请好友
	public static String global_is_invitation;
	//玩法多少秒以后不能买
	public static String global_countDown;
	//百度推送需要的ID
	public static String global_channelId;
	//商品详情页面分享文字
	public static String global_weixin_share_content;
	//购买完毕后是否提示绑定手机号
	public static String promptBindMobile;
	//购买完毕后提示文字
	public static String bindMobileContent;
	//三方后台key
	private static String KEY = "3e3e7h6gof4dltja2b0qg5vlb07gb1qy";
	public static String download_page_url;//分享链接
	public static String share_picture;//分享图片链接
	public static String show_nearby_gz;//开启首页关注部分附近的人功能 1是0否
	public static String show_nearby_tj;//开启首页推荐部分附近的人功能 1是0否
	public static String share_title;//签到分享标题
	public static String share_content;//签到分享文案
	public static String mall_image_server;//商城资源服务器图片地址
	//鲜花
	public static String global_gold_name;
	public static String tabs_change;//0.圈子 1.商城
	/**
	 * 修改配置表字段信息
	 * <p>
	 * Title: setConfigValueByName
	 * </p>
	 *
	 * @param strName
	 * @param strValue
	 * @return void
	 * <p>
	 * Description:
	 * </p>
	 * @author cw
	 * @date 2016年5月28日 上午10:23:58
	 */
	public static void setConfigValueByName(String strName, String strValue) {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		configManage.updateConfigValue(strName, StringUtils.NullToStr(strValue));
	}

	/**
	 * 获取配置表字段信息
	 * <p>
	 * Title: getConfigValueByName
	 * </p>
	 *
	 * @param strName
	 * @return
	 * @author cw
	 * @date 2016年5月28日 上午10:23:46
	 */
	public static String getConfigValueByName(String strName) {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		if (StringUtils.isNotEmpty(configManage.getConfigValue(strName))) {
			return StringUtils.NullToStr(configManage.getConfigValue(strName));
		}
		return "";
	}

	/**
	 * 商品详情分享内容
	 * <p>Title: getPlayActionCountDown</p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年8月19日 上午9:27:02
	 */
	public static String getWeixinShareContent(String gname) {
		String global_weixin_share_content = ConfigUtils.global_weixin_share_content;
		if (StringUtils.isNotEmpty(global_weixin_share_content))
			return global_weixin_share_content.replace("@", gname);
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			global_weixin_share_content = configManage.getConfigValue("mall_weixin_share_content");
			if (StringUtils.isNotEmpty(global_weixin_share_content)) {
				ConfigUtils.global_weixin_share_content = global_weixin_share_content;
				return global_weixin_share_content.replace("@", gname);
			} else {
				return YYGConstant.WEIXIN_SHARE_CONTENT;
			}
		}
	}



	/**
	 * 客服工作时间和客服电话
	 * <p>Title: getCustomerTimeAndtelephone</p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年7月12日 上午9:14:57
	 */
	public static String[] getCustomerTimeAndtelephone() {
		String[] arryReturn = new String[2];

		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String customer_work_time = StringUtils.NullToStr(configManage.getConfigValue("mall_customer_work_time"));
		String customer_telephone = StringUtils.NullToStr(configManage.getConfigValue("mall_customer_telephone"));

		arryReturn[0] = customer_work_time;
		arryReturn[1] = customer_telephone;

		return arryReturn;
	}
	/**
	 * 获取系统会有客服电话
	 * <p>Title: getTelephone</p>
	 *
	 * @return
	 * @author vip
	 * @date 2017年8月3日 上午9:14:13
	 */
	public static String getTelephone() {
		String mobile = ConfigUtils.mobile;
		if (StringUtils.isNotEmpty(mobile))
			return mobile;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			mobile = configManage.getConfigValue("customer_service_phone");
			if (StringUtils.isNotEmpty(mobile)) {
				ConfigUtils.mobile = mobile;
				return mobile;
			} else {
				return "";
			}
		}
	}

	/**
	 * 获取第三方登录
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static String getThirdPartyLogin() {
		String imageSever = ConfigUtils.global_third_party_login;
		if (StringUtils.isNotEmpty(imageSever))
			return imageSever;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			imageSever = configManage.getConfigValue("third_party_login");
			if (StringUtils.isNotEmpty(imageSever)) {
				ConfigUtils.global_third_party_login = imageSever;
				return imageSever;
			} else {
				return "";
			}
		}
	}

	/**
	 * 获取鲜花名称
	 * <p>
	 * Title: getGoldName
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:05:15
	 */
	public static String getGoldName() {
		String global_gold_name = ConfigUtils.global_gold_name;
		if (StringUtils.isNotEmpty(global_gold_name))
			return global_gold_name;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			global_gold_name = configManage.getConfigValue("mall_gold_name");
			if (StringUtils.isNotEmpty(global_gold_name)) {
				ConfigUtils.global_gold_name = global_gold_name;
				return global_gold_name;
			} else {
				return YYGConstant.GOLD;
			}
		}
	}
	/**
	 * 获取图片地址
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static String getImageServer() {
		String imageSever2 = ConfigUtils.global_image_server;
		if (StringUtils.isNotEmpty(imageSever2)) {
			return imageSever2;
		}else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			imageSever2 = configManage.getConfigValue("image_server");
			if (StringUtils.isNotEmpty(imageSever2)) {
				ConfigUtils.global_image_server = imageSever2;
				return imageSever2;
			} else {
				return YYGConstant.BASE_URL.replace("www", "image");
			}
		}
	}
	/**
	 * 获取会购图片地址
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static String getHuiGouImageServer() {
		String imageSever2 = ConfigUtils.mall_image_server;
		if (StringUtils.isNotEmpty(imageSever2)) {
			return imageSever2;
		}else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			imageSever2 = configManage.getConfigValue("mall_image_server");
			if (StringUtils.isNotEmpty(imageSever2)) {
				ConfigUtils.mall_image_server = imageSever2;
				return imageSever2;
			} else {
				return YYGConstant.VG_BASE_URL.replace("www", "image");
			}
		}
		//return "http://testmallimage.welife1948.com/";
	}
	/**
	 * 获取七牛云图片地址
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static String getQiniu_image_server() {
		String imageSever = ConfigUtils.qiniu_image_server;
		if (StringUtils.isNotEmpty(imageSever)) {
			return imageSever;
		}else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			imageSever = configManage.getConfigValue("qiniu_image_server");
			if (StringUtils.isNotEmpty(imageSever)) {
				ConfigUtils.qiniu_image_server = imageSever;
				return imageSever;
			} else {
				return YYGConstant.BASE_URL.replace("www", "image");
			}
		}
	}
	/**
	 * 获取开启首页推荐部分附近的人功能 1是0否
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static boolean getNearbyTui() {
		String show_nearby_tj = ConfigUtils.show_nearby_tj;
		if (StringUtils.isNotEmpty(show_nearby_tj))
			return "1".equals(show_nearby_tj) ? true : false;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			show_nearby_tj = configManage.getConfigValue("show_nearby_tj");
			if (StringUtils.isNotEmpty(show_nearby_tj)) {
				ConfigUtils.show_nearby_tj = show_nearby_tj;
				return "1".equals(show_nearby_tj) ? true : false;
			} else {
				return false;
			}
		}
	}
	/**
	 * 获取开启首页关注部分附近的人功能 1是0否
	 * <p>
	 * Title: getImageServer
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:03:56
	 */
	public static boolean getNearbyGuan() {
		String show_nearby_gz = ConfigUtils.show_nearby_gz;
		if (StringUtils.isNotEmpty(show_nearby_gz))
			return "1".equals(show_nearby_gz) ? true : false;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			show_nearby_gz = configManage.getConfigValue("show_nearby_gz");
			if (StringUtils.isNotEmpty(show_nearby_gz)) {
				ConfigUtils.show_nearby_gz = show_nearby_gz;
				return "1".equals(show_nearby_gz) ? true : false;
			} else {
				return false;
			}
		}
	}
	/**
	 * 我的页面是否显示邀请好友
	 * <p>Title: isShowInvitation</p>
	 * @author sym
	 *
	 */
	public static boolean isShowInvitation() {
		String is_invitation = ConfigUtils.global_is_invitation;
		if (StringUtils.isNotEmpty(is_invitation))
			return "1".equals(is_invitation) ? true : false;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			is_invitation = configManage.getConfigValue("isShowInvitation");
			if (StringUtils.isNotEmpty(is_invitation)) {
				ConfigUtils.global_is_invitation = is_invitation;
				return "1".equals(is_invitation) ? true : false;
			} else {
				return YYGConstant.IS_INVITATION;
			}
		}
	}


	/**
	 * 支付的使用说明文字
	 * <p>
	 * Title: getGoldName
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:05:15
	 */
	public static String getPaydescription() {
		String pay_description = ConfigUtils.pay_description;
		if (StringUtils.isNotEmpty(pay_description))
			return pay_description;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			pay_description = configManage.getConfigValue("pay_description");
			if (StringUtils.isNotEmpty(pay_description)) {
				ConfigUtils.pay_description = pay_description;
				return pay_description;
			} else {
				return "";
			}
		}
	}
	/**
	 * 百度推送ID
	 * <p>
	 * Title: getChannelid
	 * </p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年6月20日 下午6:05:15
	 */
	public static String getChannelid() {
		String channelId = ConfigUtils.global_channelId;
		if (StringUtils.isNotEmpty(channelId))
			return channelId;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			channelId = configManage.getConfigValue(YYGConstant.CHANNELID);
			if (StringUtils.isNotEmpty(channelId)) {
				ConfigUtils.global_channelId = channelId;
				return channelId;
			} else {
				return "";
			}
		}
	}




	/**
	 * 购买完毕后是否提示绑定手机号码
	 * @return
	 */
	public static String getBindMobileContent(){
		if(StringUtils.isEmpty(promptBindMobile))
			promptBindMobile = getConfigValueByName("promptBindMobile");
		if("1".equals(promptBindMobile)){
			if(StringUtils.isEmpty(bindMobileContent))
				bindMobileContent = getConfigValueByName("bindMobileContent");
			return bindMobileContent;
		}
		return "";
	}
	public static String getNumber(int length, int digits){
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(digits);
		nf.setMinimumIntegerDigits(digits);
		return nf.format(length);
	}
	/**
	 * 签到分享标题
	 */
	public static String getQianShare_title() {
		String share_title = ConfigUtils.share_title;
		if (StringUtils.isNotEmpty(share_title))
			return share_title;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			share_title = configManage.getConfigValue("share_title");
			if (StringUtils.isNotEmpty(share_title)) {
				ConfigUtils.share_title = share_title;
				return share_title;
			} else {
				return "";
			}
		}
	}
	/**
	 * 签到分享标题
	 */
	public static String getQianShare_content() {
		String share_content = ConfigUtils.share_content;
		if (StringUtils.isNotEmpty(share_content))
			return share_content;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			share_content = configManage.getConfigValue("share_content");
			if (StringUtils.isNotEmpty(share_title)) {
				ConfigUtils.share_content = share_content;
				return share_content;
			} else {
				return "";
			}
		}
	}
	/***
	 * 条形码生成方法
	 * *//*
	public static Bitmap dd(String str){
		Bitmap bmp = null;
		try {
			if (str != null && !"".equals(str)) {
				bmp = CreateOneDCode(str);
			}
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return bmp;
	}
	public static Bitmap CreateOneDCode(String content) throws WriterException {
		// 生成一维条码,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
		BitMatrix matrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.CODE_128, 500, 200);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		int[] pixels = new int[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (matrix.get(x, y)) {
					pixels[y * width + x] = 0xff000000;
				}
			}
		}

		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		// 通过像素数组生成bitmap,具体参考api
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}*/
	/**
	 * TextView 换行
	 * */
	public static String autoSplitText(final TextView tv) {
		final String rawText = tv.getText().toString(); //原始文本
		final Paint tvPaint = tv.getPaint(); //paint，包含字体等信息
		final float tvWidth = tv.getWidth() - tv.getPaddingLeft() - tv.getPaddingRight(); //控件可用宽度

		//将原始文本按行拆分
		String[] rawTextLines = rawText.replaceAll("\r", "").split("\n");
		StringBuilder sbNewText = new StringBuilder();
		for (String rawTextLine : rawTextLines) {
			if (tvPaint.measureText(rawTextLine) <= tvWidth) {
				//如果整行宽度在控件可用宽度之内，就不处理了
				sbNewText.append(rawTextLine);
			} else {
				//如果整行宽度超过控件可用宽度，则按字符测量，在超过可用宽度的前一个字符处手动换行
				float lineWidth = 0;
				for (int cnt = 0; cnt != rawTextLine.length(); ++cnt) {
					char ch = rawTextLine.charAt(cnt);
					lineWidth += tvPaint.measureText(String.valueOf(ch));
					if (lineWidth <= tvWidth) {
						sbNewText.append(ch);
					} else {
						sbNewText.append("\n");
						lineWidth = 0;
						--cnt;
					}
				}
			}
			sbNewText.append("\n");
		}

		//把结尾多余的\n去掉
		if (!rawText.endsWith("\n")) {
			sbNewText.deleteCharAt(sbNewText.length() - 1);
		}

		return sbNewText.toString();
	}
	/**
	 * 获取分享链接
	 *
	 */
	public static String getSharedUrl() {
		String download_page_url = ConfigUtils.download_page_url;
		if (StringUtils.isNotEmpty(download_page_url))
			return download_page_url;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			download_page_url = configManage.getConfigValue("download_page_url");
			if (StringUtils.isNotEmpty(download_page_url)) {
				ConfigUtils.download_page_url = download_page_url;
				return download_page_url;
			} else {
				//return YYGConstant.SHAREURL;
				return "";
			}
		}
	}
	/**
	 * 获取分享图片链接
	 *
	 */
	public static String getSharedImgUrl() {
			return "image/share.png";
	}
	/**
	 * 虚拟卡中奖详情页面"支付宝余额"按钮是否显示,1是0否
	 * <p>Title: isShowAlipay</p>
	 *
	 * @return
	 * @author cw
	 * @date 2016年7月21日 下午12:46:47
	 */
	public static boolean isShowAlipay() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String alipay_cash_btn_show = StringUtils.NullToStr(configManage.getConfigValue("mall_alipay_cash_btn_show"));
		return "1".equals(alipay_cash_btn_show);
	}
	/**
	 * 邀请好友活动，分享至微信好友标题文案
	 * */
	public static String getInvitefriend_wechat_title() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String invitefriend_wechat_title = StringUtils.NullToStr(configManage.getConfigValue("invitefriend_wechat_title"));
		return invitefriend_wechat_title;
	}
	/**
	 * 邀请好友活动，分享至微信好友 内容文案
	 * */
	public static String getInvitefriend_wechat_content() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String invitefriend_wechat_content = StringUtils.NullToStr(configManage.getConfigValue("invitefriend_wechat_content"));
		return invitefriend_wechat_content;
	}
	/**
	 * 邀请好友活动，分享至朋友圈 标题文案
	 * */
	public static String getInvitefriend_friendcircle_title() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String invitefriend_friendcircle_title = StringUtils.NullToStr(configManage.getConfigValue("invitefriend_friendcircle_title"));
		return invitefriend_friendcircle_title;
	}
	/**
	 * 邀请好友活动，分享至联系人文案part1
	 * */
	public static String getInvitefriend_contact_one() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String invitefriend_contact_one = StringUtils.NullToStr(configManage.getConfigValue("invitefriend_contact_one"));
		return invitefriend_contact_one;
	}
	/**
	 * 邀请好友文案，分享至联系人文案part2
	 * */
	public static String getInvitefriend_contact_two() {
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		String invitefriend_contact_two = StringUtils.NullToStr(configManage.getConfigValue("invitefriend_contact_two"));
		return invitefriend_contact_two;
	}

	/**
	 * 是否开启商城首页
	 * */
	public static boolean ShangCheng() {
		String tabs_change = ConfigUtils.tabs_change;
		if (StringUtils.isNotEmpty(tabs_change))
			return "1".equals(tabs_change) ? true : false;
		else {
			ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
			tabs_change = configManage.getConfigValue("tabs_change");
			if (StringUtils.isNotEmpty(tabs_change)) {
				ConfigUtils.tabs_change = tabs_change;
				return "1".equals(tabs_change) ? true : false;
			} else {
				return false;
			}
		}
	}

}
