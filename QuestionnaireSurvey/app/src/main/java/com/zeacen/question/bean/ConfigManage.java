package com.zeacen.question.bean;

import android.content.ContentValues;
import android.database.SQLException;


import com.zeacen.question.dao.SQLHelper;
import com.zeacen.question.service.ConfigService;
import com.zeacen.question.service.impl.ConfigServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigManage {
	public static ConfigManage configManage;
	
	/**
	 * 默认的用户选择信息列表
	 * */
	public static List<User> defaultUserNews;

	private ConfigService configService;
	/** 判断数据库中是否存在用户数据 */
	private boolean newsExist = false;
	static {
		defaultUserNews = new ArrayList<User>();
	}

	private ConfigManage(SQLHelper paramDBHelper) throws SQLException {
		if (configService == null)
			configService = new ConfigServiceImpl(paramDBHelper.getContext());
		return;
	}

	/**
	 * 初始化频道管理类
	 * @param paramDBHelper
	 * @throws SQLException
	 */
	public static ConfigManage getManage(SQLHelper dbHelper)throws SQLException {
		if (configManage == null)
			configManage = new ConfigManage(dbHelper);
		return configManage;
	}
	
	/**
	 * 获取其他的频道
	 * @return 数据库存在用户配置 ? 数据库内的用户选择频道 : 默认用户选择频道 ;
	 */
	public String getConfigValue(String configName) {
		
		Map mapConfig = configService.viewConfig(SQLHelper.CONFIGNAME + "= ?",new String[] { configName });
		if (mapConfig != null ) {
			return mapConfig.get(SQLHelper.CONFIGVALUE)==null?"":mapConfig.get(SQLHelper.CONFIGVALUE).toString();
		}
		return "";
	}
	
	/**
	 * 获取其他的频道
	 * @return 数据库存在用户配置 ? 数据库内的用户选择频道 : 默认用户选择频道 ;
	 */
	public void addConfig(String configName, String value) {
		configService.addConfig(configName,value);

	}
	
	/**
	 * 获取其他的频道
	 * @return 数据库存在用户配置 ? 数据库内的用户选择频道 : 默认用户选择频道 ;
	 */
	public void updateConfigValue(String configName, String value) {
		Map mapConfig = configService.viewConfig(SQLHelper.CONFIGNAME + "= ?",new String[] { configName });
		if(mapConfig==null || mapConfig.isEmpty()){//创建
			addConfig(configName,value);
		}else{//更新
			ContentValues cv = new ContentValues();
			cv.put(SQLHelper.CONFIGVALUE, value);
			configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {configName});
		}
	}
	
	public void clearAllCache(){
	
		ContentValues cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"userid"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"ugid"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"nickname"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"mobile"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"password"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"securekey"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"userheadpath"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"addtime"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"lastlogintime"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"logintime"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"ipaddress"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"gold"});
		
		cv = new ContentValues();
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"device"});
		cv = new ContentValues();
		
		cv.put(SQLHelper.CONFIGVALUE, "");
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"devicecode"});
		cv = new ContentValues();
		
		cv.put(SQLHelper.CONFIGVALUE, "");//支付方式
		configService.updateConfig(cv, SQLHelper.CONFIGNAME + " = ?", new String[] {"payPlatform"});
		configService.clearAllCache();
		
	}
}
