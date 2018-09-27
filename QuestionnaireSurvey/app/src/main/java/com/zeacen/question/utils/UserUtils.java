package com.zeacen.question.utils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.CookieStore;
import com.zeacen.question.app.AppApplication;
import com.zeacen.question.bean.ConfigManage;
import com.zeacen.question.bean.User;

import java.util.List;

public class UserUtils {

	public static final String certificationmark = "certificationmark";//认证标识
	public static final String contactmobile = "contactMobile";//联系电话
	public static final String mobile = "mobile";//注册电话
	public static final String userid = "userid";//用户ID
	public static final String nickname = "nickname";//用户昵称
	public static final String userheadpath = "userheadpath";//用户头像
	public static final String realname = "realname";//用户真实名称
	public static final String idcard = "idcard";//用户身份证号码
	public static final String card = "card";//用户会员卡卡号
	public static final String jifen = "jifen"; //积分
	public static final String openid = "openid"; //取得第三方登录后的openid
	public static final String loginSource = "loginSource"; //取得第三方登录后的openid
	public static final String sex = "sex"; //用户生日
	public static final String birthday = "birthday"; //用户性别
	public static final String ugname = "ugname"; //用户性别
	public static final String dynamictype = "dynamictype"; //动态隐私设置
	public static final String posttype = "posttype"; //发帖隐私设置
	public static final String ishead = "ishead"; //是否拥有修改头像权限0无，1有
	public static final String isnickname = "isnickname"; //是否拥有修改昵称的权限0无，1有
	public static final String nearviewtype = "nearviewtype"; //附近的人权限设置0不显示1显示





	/**
	 * 保存用户信息
	 * @param user
	 */
	public static void saveUser(User user){

	}

	/**
	 * 取得登录用户ID
	* <p>Title: getUserId</p>
	* @author cw
	* @date 2016年6月25日 下午3:14:29
	* @return String
	* <p>Description: </p>
	* @return
	*
	 */
	public static String getUserId() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(userid))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(userid));
		}
		return "";
	}
	/**
	 * 取得登录用户手机号
	 * @return
	 *
	 */
	public static String getMobile() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(mobile))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(mobile));
		}
		return "";
	}
	/**
	 * 取得登录用户后台传的带*的手机号
	 * @return
	 *
	 */
	public static String getTwoMobile() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(mobile))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(mobile));
		}
		return "";
	}
	/**
	 * 取得登录用户生日
	 * @return
	 *
	 */
	public static String getBirthday() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(birthday))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(birthday));
		}
		return "";
	}
	/**
	 * 取得登录用户头像路径
	 * @return
	 *
	 */
	public static String getUserheadpath() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(userheadpath))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(userheadpath));
		}
		return "";
	}
	/**
	 * 取得登录用户性别
	 * @return
	 *
	 */
	public static String getSex() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(sex))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(sex));
		}
		return "";
	}
	/**
	 * 取得登录用户昵称
	 * @return
	 *
	 */
	public static String getNickname() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(nickname))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(nickname));
		}
		return "";
	}
	/**
	 * 取得登录用户等级
	 * @return
	 *
	 */
	public static String getUgname() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(ugname))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(ugname));
		}
		return "";
	}
	/**
	 * 动态隐私设置
	 * @return
	 *
	 */
	public static String getDynamictype() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(dynamictype))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(dynamictype));
		}
		return "";
	}
	/**
	 * 发帖隐私设置
	 * @return
	 *
	 */
	public static String getPosttype() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(posttype))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(posttype));
		}
		return "";
	}
	/**
	 * 是否拥有修改头像权限
	 * @return
	 *
	 */
	public static String getIshead() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(ishead))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(ishead));
		}
		return "";
	}
	/**
	 * 是否拥有修改昵称的权限
	 * @return
	 *
	 */
	public static String getIsnickname() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(isnickname))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(isnickname));
		}
		return "";
	}
	/**
	 * 附近的人权限设置
	 * @return
	 *
	 */
	public static String getNearviewtype() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(nearviewtype))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(nearviewtype));
		}
		return "";
	}

	/**
	 * 取得第三方登录后的openid
	 * @return
	 *
	 */
	public static String getOpenId() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(openid))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(openid));
		}
		return "";
	}
	/**
	 * 取得第三方登录后的loginSource
	 * @return
	 *
	 */
	public static String getloginSource() {
		String loginSource2 = ConfigUtils.getConfigManage().getConfigValue(loginSource);
		if (StringUtils.isNotEmpty(loginSource2)) {
			if (loginSource2.equals("QQ")) {
				return "1";
			} else if (loginSource2.equals("Wechat")) {
				return "2";
			}
			return "";
		}
		return "";
	}
	/**
	 * 取得登录用户会员卡号
	 * @return
	 *
	 */
	public static String getCard() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(card))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(card));
		}
		return "";
	}

	/**
	 *取得认证状态
	 * @return
	 */
	public static String getCertificationmark() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(certificationmark))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(certificationmark));
		}
		return "0";
	}

	/**
	 * 取得分享链接
	 *
	 * @return
	 *
	 */
	public static String getJifen() {
		if (StringUtils.isNotEmpty(ConfigUtils.getConfigManage().getConfigValue(jifen))) {
			return StringUtils.NullToStr(ConfigUtils.configManage.getConfigValue(jifen));
		}
		return "0";
	}
	/**
	 * 清空用户信息
	* <p>Title: cleanUserInfo</p>
	* @author cw
	* @date 2016年7月1日 下午1:00:20
	* @return void
	* <p>Description: </p>
	*
	 */
	public static void cleanUserInfo(){
		ConfigManage configManage = ConfigManage.getManage(AppApplication.getApp().getSQLHelper());
		//清空用户信息
		configManage.clearAllCache();
		//清空cookie中用户信息
		CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
		cookieStore.removeAllCookie();
	}
	/**
	 * 计算用户资料完整度方法
	 * */
	public static String getInfoDegree(List<String> list) {
		int sum = 0;
		if (list.size() > 0) {
			// 遍历权重配置文件，获取权重
			for (int i = 0; i < list.size(); i++) {
				sum += 20;
			}
		}
		// 返回计算后的权重
		return sum + "%";
	}
}
