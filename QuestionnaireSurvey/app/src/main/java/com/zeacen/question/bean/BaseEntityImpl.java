package com.zeacen.question.bean;

import java.io.Serializable;

/**
 * 基类
* @ClassName: BaseEntityImpl 
* @Description: TODO
* @author cw
* @date 2016年5月11日 上午8:44:54
 */
public class BaseEntityImpl implements Serializable{
	private Page page;
	private String msg;
	private boolean success;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	
}
