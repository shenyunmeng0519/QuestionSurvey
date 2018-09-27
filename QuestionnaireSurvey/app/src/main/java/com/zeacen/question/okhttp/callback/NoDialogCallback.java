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

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.zeacen.question.utils.CustomToast;
import com.zeacen.question.utils.UserUtils;

public abstract class NoDialogCallback<T> extends JsonCallback<T> {

    private Context context;

    public NoDialogCallback(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onError(Response<T> response) {
        if (response.code()==500){
            CustomToast.showCustomToast(context,
                   "服务器内部错误",
                    CustomToast.eLength.SHORT);
        }else if(response.code()==404){
            CustomToast.showCustomToast(context,
                    "网络不给力，请稍后再试！",
                    CustomToast.eLength.SHORT);
        }else  if(response.code()==401){
            //清空用户信息
            UserUtils.cleanUserInfo();
            CustomToast.showCustomToast(context,
                    "您的账号已在别处登录，请重新登录!",
                    CustomToast.eLength.SHORT);
        }else {
            if (!response.getException().getMessage().startsWith("Socket"))
            CustomToast.showCustomToast(context,
                    response.getException().getMessage(),
                    CustomToast.eLength.SHORT);
        }
    }
}
