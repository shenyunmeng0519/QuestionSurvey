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

import com.google.gson.stream.JsonReader;
import com.lzy.okgo.convert.Converter;
import com.zeacen.question.okhttp.ResponsMedo;
import com.zeacen.question.okhttp.model.Convert;
import com.zeacen.question.utils.StringUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class JsonConvert<T> implements Converter<T> {

    private Type type;
    private Class<T> clazz;

    public JsonConvert() {
    }

    public JsonConvert(Type type) {
        this.type = type;
    }

    public JsonConvert(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象，生成onSuccess回调中需要的数据对象
     *
     */
    @Override
    public T convertResponse(Response response) throws Throwable {
        if (type == null) {
            if (clazz == null) {
                // 如果没有通过构造函数传进来，就自动解析父类泛型的真实类型（有局限性，继承后就无法解析到）
                Type genType = getClass().getGenericSuperclass();
                type = ((ParameterizedType) genType).getActualTypeArguments()[0];
            } else {
                return parseClass(response, clazz);
            }
        }

        if (type instanceof ParameterizedType) {
            return parseParameterizedType(response, (ParameterizedType) type);
        } else if (type instanceof Class) {
            return parseClass(response, (Class<?>) type);
        } else {
            return parseType(response, type);
        }
    }

    private T parseClass(Response response, Class<?> rawType) throws Exception {
        if (rawType == null) return null;
        ResponseBody body = response.body();
        if (body == null) return null;
        JsonReader jsonReader = new JsonReader(body.charStream());

        if (rawType == String.class) {
            //noinspection unchecked
            return (T) body.string();
        } else if (rawType == JSONObject.class) {
            //noinspection unchecked
            return (T) new JSONObject(body.string());
        } else if (rawType == JSONArray.class) {
            //noinspection unchecked
            return (T) new JSONArray(body.string());
        } else {
            T t = Convert.fromJson(jsonReader, rawType);
            response.close();
            return  t;
        }
    }

    private T parseType(Response response, Type type) throws Exception {
        if (type == null) return null;
        ResponseBody body = response.body();
        if (body == null) return null;
        JsonReader jsonReader = new JsonReader(body.charStream());

        // 泛型格式如下： new JsonCallback<任意JavaBean>(this)
        T t = Convert.fromJson(jsonReader, type);
        response.close();
        return t;
    }

    private T parseParameterizedType(Response response, ParameterizedType type) throws Exception {
        if (type == null) return null;
        ResponseBody body = response.body();
        if (body == null) return null;
        String result = response.body().string();
        JSONObject jsonObject = new JSONObject(result);
        ResponsMedo responsMedo = new ResponsMedo();

        responsMedo.setCode(response.code());
        if (responsMedo.getCode()==200){
            if(jsonObject.getBoolean("success")){//返回正确场合，保存JSON数据
                responsMedo.setStatus(true);
                responsMedo.setData(jsonObject);
                responsMedo.setDatas(result);
                responsMedo.setMassage(jsonObject.isNull("msg")?"": StringUtils.NullToStr(jsonObject.getString("msg")));
                responsMedo.setExperience(jsonObject.isNull("experience")?0: StringUtils.NullToInt(jsonObject.getInt("experience")));
                responsMedo.setRcount(jsonObject.isNull("rcount")?0: StringUtils.NullToInt(jsonObject.getInt("rcount")));
                responsMedo.setCode(200);
                response.close();
                return (T)responsMedo;
            }else{//返回错误场合，保存错误信息
                responsMedo.setStatus(false);
                responsMedo.setMassage(jsonObject.isNull("msg")?"":StringUtils.NullToStr(jsonObject.getString("msg")));
                responsMedo.setExperience(jsonObject.isNull("experience")?0: StringUtils.NullToInt(jsonObject.getInt("experience")));
                responsMedo.setAchieveTopLimit(jsonObject.isNull("achieveTopLimit")?false: StringUtils.NullToBoolean(jsonObject.getBoolean("achieveTopLimit")));
                responsMedo.setErrtype(jsonObject.isNull("errtype")? 0:StringUtils.NullToInt(jsonObject.getInt("errtype")));
                responsMedo.setData(jsonObject);
                responsMedo.setDatas(result);
                responsMedo.setCode(200);
                response.close();
                return (T)responsMedo;
            }
        }else  if(responsMedo.getCode()==401){
            //清空用户信息
          /*  UserUtils.cleanUserInfo();*/
            /*//跳转到首页
            CommonUtils.refreshMy();*/
            response.close();
            throw new IllegalStateException("您的账号已在别处登录，请重新登录!");
        }else{
            response.close();
            throw new IllegalStateException("网络不给力，请稍后再试！");
        }

    }
}
