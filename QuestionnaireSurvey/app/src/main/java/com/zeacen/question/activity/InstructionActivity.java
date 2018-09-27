package com.zeacen.question.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zeacen.question.R;
import com.zeacen.question.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/9/20.
 */

public class InstructionActivity extends BaseActivity{
    @BindView(R.id.rl_kaishi)
    RelativeLayout rl_kaishi;
    @BindView(R.id.tv_neirong)
    TextView tv_neirong;
    String name = "";
    @Override
    public void initRootView() {
        setContentView(R.layout.activity_instruction);
    }

    @Override
    public void initView() {
        name = getIntent().getExtras().getString("name");
        rl_kaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InstructionActivity.this,QuestionActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("userid", 10);
                startActivity(intent);
            }
        });
        tv_neirong.setText("中医体质是指人体生命过程中，在先天禀赋和后天获得的基础上所形成的形态结构、生理功能和心理状态方面综合的、相对稳定的固有特质。是人类在生长、发育过程中所形成的与自然、社会环境相适应的人体个性特征。"

                +"\n"+"中医体质量化辨识与调养指导旨在为体质辨识及与中医体质相关疾病的防治、养生保健、健康管理提供依据，体现了中医学“治未病”的思想，是“治未病”的有效方法和重要途径，有利于实施个体化诊疗，有利于提高国民健康素质，对于防治慢性非传染性疾病具有现代医学所不可替代的重要作用。");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
