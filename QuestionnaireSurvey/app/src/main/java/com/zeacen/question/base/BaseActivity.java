package com.zeacen.question.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.lzy.okgo.OkGo;
import com.zeacen.question.app.AppActivityManager;
import com.zeacen.question.utils.UserUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/8/31.
 */

public abstract  class BaseActivity  extends AppCompatActivity {

    //用于打印log
    private final String TAG = "BaseActivity";
    protected AppActivityManager appActivityManager = AppActivityManager.getInstance();
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //页面加入activity管理器中
        appActivityManager.pushOneActivity(this);

        //设置在activity启动的时候输入法默认不开启
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        initRootView();
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();

    }
    /**
     * 初始化根布局文件
     */
    public abstract void initRootView();

    /**
     * 初始化控件
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

    /**
     * 初始化监听事件
     */
    public abstract void initListener();

    /**
     * 判断用户是否登陆过
     *
     * @return true 为登陆成功 false 为没有登陆过
     */
    protected boolean isLogin() {
        if (UserUtils.getUserId().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Activity销毁时，取消网络请求
        OkGo.getInstance().cancelTag(this);
    }



    public void startGoActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        this.startActivity(intent);
    }

    public void startGoActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }

        this.startActivity(intent);
    }

    public void startGoActivityThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        this.startActivity(intent);
        this.finish();
    }

    public void startGoActivityThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }

        this.startActivity(intent);
        this.finish();
    }

    public void startGoActivityForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        this.startActivityForResult(intent, requestCode);
    }

    protected void startGoActivityForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }

        this.startActivityForResult(intent, requestCode);
    }


}