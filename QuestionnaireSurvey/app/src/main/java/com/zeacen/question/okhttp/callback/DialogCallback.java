/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zeacen.question.okhttp.callback;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;
import com.zeacen.question.R;
import com.zeacen.question.utils.CustomToast;
import com.zeacen.question.utils.StringUtils;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：对于网络请求是否需要弹出进度对话框
 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private final Activity activity;
    private Dialog dialog;

    private void initDialog(Activity activity) {
        dialog = new Dialog(activity, R.style.Theme_Dialog_progress);
        dialog.setContentView(R.layout.alert_dialog_loading);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        ProgressBar progressView = (ProgressBar) dialog.findViewById(R.id.progressbar);
        /*AnimationDrawable drawable = (AnimationDrawable) progressView.getDrawable();
        drawable.start();*/
    }

    public DialogCallback(Activity activity) {
        super();
        this.activity = activity;
        initDialog(activity);
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onError(Response<T> response) {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        if (response.code()==500){
            CustomToast.showCustomToast(activity,
                   "服务器内部错误",
                    CustomToast.eLength.SHORT);
        }else if(response.code()==404){
            CustomToast.showCustomToast(activity,
                    "网络不给力，请稍后再试！",
                    CustomToast.eLength.SHORT);
        }else  if(response.code()==401){
            //清空用户信息
           // UserUtils.cleanUserInfo();
            CustomToast.showCustomToast(activity,
                    "您的账号已在别处登录，请重新登录!",
                    CustomToast.eLength.SHORT);
        }else if (StringUtils.NullToStr(response.getException().getMessage()).contains("No address")){
            CustomToast.showCustomToast(activity,
                    "请检查网络是否连接",
                    CustomToast.eLength.SHORT);
        }else if (StringUtils.NullToStr(response.getException().getMessage()).contains("Failed to connect")||response.getException().getMessage().contains("failed to connect")){
            CustomToast.showCustomToast(activity,
                    "连接服务器失败，请检查网络",
                    CustomToast.eLength.SHORT);
        }else {
            CustomToast.showCustomToast(activity,
                    response.getException().getMessage(),
                    CustomToast.eLength.SHORT);
        }
    }
}
