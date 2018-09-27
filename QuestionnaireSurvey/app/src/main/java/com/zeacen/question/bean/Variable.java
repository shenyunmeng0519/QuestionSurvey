package com.zeacen.question.bean;

import java.io.Serializable;

public class Variable implements Serializable {
    /**  */
    private Integer variableid;

    /** 变量名 */
    private String vname;

    /** 变量值 */
    private String vvalue;

    /** 是否放入前端模板变量 */
    private boolean setfrontvar;

    /** 描述 */
    private String vdiscretion;

    private static final long serialVersionUID = 1L;

    /**
     * 获取[]
     * @return variableid
     */
    public Integer getVariableid() {
        return variableid;
    }

    /**
     * 设置[]
     * @param variableid
     */
    public void setVariableid(Integer variableid) {
        this.variableid = variableid;
    }

    /**
     * 获取[变量名]
     * @return vname
     */
    public String getVname() {
        return vname;
    }

    /**
     * 设置[变量名]
     * @param vname
     */
    public void setVname(String vname) {
        this.vname = vname == null ? null : vname.trim();
    }

    /**
     * 获取[变量值]
     * @return vvalue
     */
    public String getVvalue() {
        return vvalue;
    }

    /**
     * 设置[变量值]
     * @param vvalue
     */
    public void setVvalue(String vvalue) {
        this.vvalue = vvalue == null ? null : vvalue.trim();
    }
 

    public boolean isSetfrontvar() {
		return setfrontvar;
	}

	public void setSetfrontvar(boolean setfrontvar) {
		this.setfrontvar = setfrontvar;
	}

	/**
     * 获取[描述]
     * @return vdiscretion
     */
    public String getVdiscretion() {
        return vdiscretion;
    }

    /**
     * 设置[描述]
     * @param vdiscretion
     */
    public void setVdiscretion(String vdiscretion) {
        this.vdiscretion = vdiscretion == null ? null : vdiscretion.trim();
    }
}