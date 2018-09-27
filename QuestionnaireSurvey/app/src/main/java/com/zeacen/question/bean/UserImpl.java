package com.zeacen.question.bean;

/**
 * 用户实体
* @ClassName: UserImpl 
* @Description: TODO
* @author cw
* @date 2016年5月10日 下午8:16:39
 */
public class UserImpl extends BaseEntityImpl {
	String nickname;
	String userheadpath;
	boolean isRecall;//是否进行老用户回流弹窗

	public boolean isRecall() {
		return isRecall;
	}

	public void setRecall(boolean recall) {
		isRecall = recall;
	}

	public String getUserheadpath() {
		return userheadpath;
	}

	public void setUserheadpath(String userheadpath) {
		this.userheadpath = userheadpath;
	}

	public String getNickname() {

		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	private int userid;
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private String passwd;
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
