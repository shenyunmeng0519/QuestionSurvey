package com.zeacen.question.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;


import com.zeacen.question.MainActivity;

import java.util.List;
import java.util.Stack;

/**
 * Activity管理器
* @ClassName: AppActivityManager 
* @Description: TODO
* @author chenwei
* @date 2016年4月13日 下午2:48:35 
*
 */
public class AppActivityManager {

	private static AppActivityManager instance;
	private Stack<Activity> activityStack;// activity栈

	private AppActivityManager() {
	}

	// 单例模式
	public static AppActivityManager getInstance() {
		if (instance == null) {
			instance = new AppActivityManager();
		}
		return instance;
	}

	// 把一个activity压入栈中
	public void pushOneActivity(Activity actvity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(actvity);
		//Log.d("MyActivityManager ", "size = " + activityStack.size());
	}

	// 获取栈顶的activity，先进后出原则
	public Activity getLastActivity() {
		return activityStack.lastElement();
	}
	
	
	//查找指定Activity 
	public Activity getActivity(Class clsss) {
		if (activityStack != null) {
			for(int i =0;i<activityStack.size();i++){
				Activity activityTemp = activityStack.get(i);
				if(activityTemp.getClass().equals(clsss)){
					return activityTemp;
				}
			}
		}
		return null;
	}
	
	
	//删除指定Activity 
	public void removeActivity(Class clsss) {
		if (activityStack != null) {
			for(int i =0;i<activityStack.size();i++){
				Activity activityTemp = activityStack.get(i);
				if(activityTemp.getClass().equals(clsss)){
					popOneActivity(activityTemp);
					break;
				}
			}
		}
	}
	
	//删除最后Activity
	public void removeLastActivity(Class clsss){
		Activity activity = getLastActivity();
		if(activity.getClass().equals(clsss)){
			popOneActivity(activity);
		}
	}

	

	// 移除一个activity
	public void popOneActivity(Activity activity) {
		if (activityStack != null && activityStack.size() > 0) {
			if (activity != null) {
				activity.finish();
				activityStack.remove(activity);
				activity = null;
			}

		}
	}

	// 退出所有activity
	public void finishAllActivity() {
		if (activityStack != null) {
			while (activityStack.size() > 0) {
				Activity activity = getLastActivity();
				if (activity == null)
					break;
				popOneActivity(activity);
			}
		}
	}

	// 退出所有activity,除了主页面
	public MainActivity finishNotMainActivity(){
		MainActivity mainActivity = null;
		if (activityStack != null) {
			while (activityStack.size() > 0) {
				Activity activity = getLastActivity();
				if (activity == null)
					break;
				else if(activity.getClass().equals(MainActivity.class)){
					mainActivity = (MainActivity)activity;
					break;
				}
				popOneActivity(activity);
			}
		}
		return mainActivity;
	}
	
	
	public boolean isActivityExist(Class clsss){
		if (activityStack != null) {
			for(int i =0;i<activityStack.size();i++){
				Activity activityTemp = activityStack.get(i);
				if(activityTemp.getClass().equals(clsss)){
					return true;
				}
			}
		}
		return false;
	}

	
	 /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        	
        }
    }
	/**
	 * 判断一个Activity是否正在运行
	 * @param pkg
	 * @param cls
	 * @param context
	 * @return
	 */
	public static boolean isClsRunning(String pkg, String cls, Context context) {
		ActivityManager am =(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
		ActivityManager.RunningTaskInfo task = tasks.get(0);
		if (task != null) {
			return TextUtils.equals(task.topActivity.getPackageName(), pkg) && TextUtils.equals(task.topActivity.getClassName(), cls);
		}
		return false;
	}
}
