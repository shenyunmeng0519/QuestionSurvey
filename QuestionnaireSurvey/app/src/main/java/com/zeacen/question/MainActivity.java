package com.zeacen.question;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.zeacen.question.activity.InstructionActivity;
import com.zeacen.question.activity.Question2Activity;
import com.zeacen.question.activity.Question3Activity;
import com.zeacen.question.activity.QuestionActivity;
import com.zeacen.question.activity.ResultActivity;
import com.zeacen.question.activity.ResultDetailActivity;
import com.zeacen.question.app.AppApplication;
import com.zeacen.question.base.BaseActivity;
import com.zeacen.question.bean.ConfigManage;
import com.zeacen.question.bean.T;
import com.zeacen.question.bean.User;
import com.zeacen.question.bean.UserImpl;
import com.zeacen.question.constant.YYGConstant;
import com.zeacen.question.okhttp.ResponsMedo;
import com.zeacen.question.okhttp.callback.DialogCallback;
import com.zeacen.question.okhttp.callback.NoDialogCallback;
import com.zeacen.question.utils.CustomToast;
import com.zeacen.question.utils.StringUtils;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText et_phone;
    @BindView(R.id.tv_login)
    TextView tv_login;
    @BindView(R.id.tv_tishi)
    TextView tv_tishi;

    @Override
    public void initRootView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        et_phone.addTextChangedListener(new TextWatcher() {
            private CharSequence temp;
            private int editStart;
            private int editEnd;
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                temp = charSequence;
            }

            @Override
            public void afterTextChanged(Editable editable) {
                editStart = et_phone.getSelectionStart();
                editEnd = et_phone.getSelectionEnd();
                /*if (temp.toString().trim().length() > 0) {
                    if (temp.toString().trim().length() > 11) {// 限制长度
                        CustomToast.showCustomToast(MainActivity.this, "输入的手机号已经超过了限制！", CustomToast.eLength.SHORT);
                        editable.delete(editStart - 1, editEnd);
                        int tempSelection = editStart;
                        et_phone.setText(editable);
                        et_phone.setSelection(tempSelection);
                    }
                }*/
            }
        });
    }

    @Override
    public void initData() {

    }
    String phone_num = "";
    @Override
    public void initListener() {
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone_num = et_phone.getText().toString().trim();
                if (!phone_num.isEmpty()){
                    putFuwu(phone_num);
                }
            }
        });
    }
    /**
     *
     * 提交后台*/
    private void putFuwu(String substring) {
        Intent intent = new Intent(MainActivity.this, InstructionActivity.class);
        intent.putExtra("name", substring);
        startActivity(intent);
        /*Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
        intent.putExtra("name", "张扬");
        intent.putExtra("userid", 10);
        startActivity(intent);*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                et_phone.getText().clear();
            }
        }, 2000);//3秒后执行Runnable中的run方法

       /* OkGo.<ResponsMedo<T>>post(YYGConstant.FASTLOGIN)
                .tag(this)
                .params("phone", substring)
                .execute(new DialogCallback<ResponsMedo<T>>(this) {
                    @Override
                    public void onSuccess(Response<ResponsMedo<T>> response) {
                        ResponsMedo<T> responsMedo = response.body();

                        if (responsMedo.isStatus()) {// 请求成功
                            // 解析接口返回字符串
                            Gson gson = new Gson();
                            UserImpl goodsClassesList = gson.fromJson(responsMedo.getDatas(), UserImpl.class);
                            User user = goodsClassesList.getUser();

                            Intent intent = new Intent(MainActivity.this,Question2Activity.class);
                            intent.putExtra("name", "张扬");
                            intent.putExtra("userid", 10);

                            startActivity(intent);
                        } else {
                            CustomToast.showCustomToast(MainActivity.this, responsMedo.getMassage(), CustomToast.eLength.SHORT);
                        }
                    }

                });*/
    }
}
