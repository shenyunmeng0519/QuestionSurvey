package com.zeacen.question.app;

import android.content.Context;

import java.lang.Thread.UncaughtExceptionHandler;


/**
 * UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * 需要在Application中注册，为了要在程序启动器就监控整个程序。
 */
public class CrashHandler implements UncaughtExceptionHandler {
	public static final String TAG = "CrashHandler";
	//系统默认的UncaughtException处理类
	private UncaughtExceptionHandler mDefaultHandler;
	//CrashHandler实例
	private static CrashHandler instance;
	//用来存储设备信息和异常信息
	//用于格式化日期,作为日志文件名的一部分
	/** 保证只有一个CrashHandler实例 */
	private CrashHandler() {
	}
	/** 获取CrashHandler实例 ,单例模式 */
	public static CrashHandler getInstance() {
		if (instance == null)
			instance = new CrashHandler();
		return instance;
	}
	/**
	 * 初始化
	 */
	public void init(Context context) {
		//获取系统默认的UncaughtException处理器
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		//设置该CrashHandler为程序的默认处理器    
		Thread.setDefaultUncaughtExceptionHandler(this);
	}
	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		//AppActivityManager.getInstance().finishAllActivity();
    	//android.os.Process.killProcess(android.os.Process.myPid());
    	//System.exit(1);
		
		//有异常场合
		//CommonUtils.clearFragmentTimeAll();
        //如果系统提供了默认的异常处理器，则交给系统去结束我们的程序，否则就由我们自己结束自己  
        if (mDefaultHandler != null) {  
        	mDefaultHandler.uncaughtException(thread, ex);  
        } else {  
        	android.os.Process.killProcess(android.os.Process.myPid());
        	System.exit(1);
        }
	}
}