package com.zeacen.question.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeacen.question.R;
import com.zeacen.question.base.BaseActivity;
import com.zeacen.question.comm.StrokeTextView;
import com.zeacen.question.comm.StrokeTextView2;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/9/14.
 */

public class ResultActivity extends BaseActivity {
    /*@BindView(R.id.tv_jieguo01)
    TextView tv_jieguo01;
    @BindView(R.id.tv_jieguo02)
    TextView tv_jieguo02;*/
    @BindView(R.id.tv_jieguo03)
    StrokeTextView2 tv_jieguo03;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.iv_fangan)
    ImageView iv_fangan;

    String name = "",jieguo = "",jieguo01 = "",jieguo02 = "";
    @Override
    public void initRootView() {
        setContentView(R.layout.activity_result);
    }

    @Override
    public void initView() {
        name = getIntent().getExtras().getString("name");
        jieguo01 = getIntent().getExtras().getString("jieguo01");
        jieguo02 = getIntent().getExtras().getString("jieguo02");
        jieguo = jieguo01+jieguo02;
    }

    @Override
    public void initData() {
        //tv_jieguo01.setText(jieguo);
        //tv_jieguo02.setText(jieguo);
        tv_jieguo03.setText(jieguo);
        tv_name.setText(name);
        /*final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                finish();
                t.cancel();
            }
        }, 15000);*/
    }

    @Override
    public void initListener() {
        iv_fangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, ResultDetailActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("userid", 10);
                intent.putExtra("detail", jieguo);
                startActivity(intent);
            }
        });
    }
}
