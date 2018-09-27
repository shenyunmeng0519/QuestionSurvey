package com.zeacen.question.okhttp;

import org.json.JSONObject;

public class ResponsMedo<T> {
	private boolean status;//code:true成功 false失败
	private String massage;
	private int code;//0:错误 1:成功 401重新登录
	private int experience;
	private String datas;
	private int type;
	private JSONObject data;
	private String certificationmark;//认证标识 0：没有认证 1：已经认证
	private boolean isRegister ;//判断是否需要绑定手机号，第三方登录的时候用
	private boolean achieveTopLimit;
	private int errtype;// 2:表示有两个按钮 1表示有一个按钮
	private  int rcount;
	private  long nowtime;

	public long getNowtime() {
		return nowtime;
	}

	public void setNowtime(long nowtime) {
		this.nowtime = nowtime;
	}

	public ResponsMedo(){
		
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public String getCertificationmark() {
		return certificationmark;
	}

	public void setCertificationmark(String certificationmark) {
		this.certificationmark = certificationmark;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public JSONObject getData() {
		return data;
	}

	public void setData(JSONObject data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public boolean isRegister() {
		return isRegister;
	}

	public void setRegister(boolean isRegister) {
		this.isRegister = isRegister;
	}

	public boolean isAchieveTopLimit() {
		return achieveTopLimit;
	}

	public void setAchieveTopLimit(boolean achieveTopLimit) {
		this.achieveTopLimit = achieveTopLimit;
	}

	public int getErrtype() {
		return errtype;
	}

	public void setErrtype(int errtype) {
		this.errtype = errtype;
	}
}
