package com.zeacen.question.cache;




import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 
 * @author cw
 * 
 */
public class CacheManager { 
	
	private static CacheManager CacheManager;
	public Map<String,Object> globalCacheData = new ConcurrentHashMap<String,Object>();//基础数据信息缓存
	//public Map<String,BaiduPush> globalPushData = new ConcurrentHashMap<String,BaiduPush>();//推送数据信息缓存

	private CacheManager() {}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	synchronized static public CacheManager getInstance() {
		if (CacheManager == null)
			CacheManager = new CacheManager();
		return CacheManager;
	}

	
	
	public static final String WX_APP_ID = "WX_APP_ID";//微信APPID
	public static final String PUSH_KEY = "PUSH_KEY";//推送ID
	public static final String IS_PUSH_NOTIFI_CLICK = "IS_PUSH_NOTIFI_CLICK";//推送是否可以点击
	public static final String PUSH_TYPE = "PUSH_TYPE";//推送标志
}