package com.zeacen.question.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.zeacen.question.R;
import com.zeacen.question.base.BaseActivity;
import com.zeacen.question.bean.AnswerBean;
import com.zeacen.question.bean.Question;
import com.zeacen.question.bean.T;
import com.zeacen.question.bean.TiZhiDetail;
import com.zeacen.question.bean.TiZhiImpl;
import com.zeacen.question.bean.User;
import com.zeacen.question.bean.UserImpl;
import com.zeacen.question.constant.YYGConstant;
import com.zeacen.question.okhttp.ResponsMedo;
import com.zeacen.question.okhttp.callback.DialogCallback;
import com.zeacen.question.utils.CustomToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/9/14.
 */

public class Question2Activity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_timu)
    TextView tv_timu;
    @BindView(R.id.rl_shang)
    RelativeLayout rl_shang;
    @BindView(R.id.rl_xia)
    RelativeLayout rl_xia;
    @BindView(R.id.tv_xia)
    TextView tv_xia;

    private List<Question> list = new ArrayList<>();
    private List<Question> list2 = new ArrayList<>();
    private List<Question> list3 = new ArrayList<>();
    private List<Question> list4 = new ArrayList<>();

    private List<TiZhiDetail> tiZhiList = new ArrayList<>();
    ImageView[] mImageView = new ImageView[5];
    TextView[] mTextView = new TextView[5];
    String name = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void initRootView() {
        setContentView(R.layout.activity_question);
    }

    @Override
    public void initView() {
        name = getIntent().getExtras().getString("name");

        mImageView[0] = (ImageView) findViewById(R.id.iv_xuanze01);
        mImageView[1] = (ImageView) findViewById(R.id.iv_xuanze02);
        mImageView[2] = (ImageView) findViewById(R.id.iv_xuanze03);
        mImageView[3] = (ImageView) findViewById(R.id.iv_xuanze04);
        mImageView[4] = (ImageView) findViewById(R.id.iv_xuanze05);
        mTextView[0] = (TextView) findViewById(R.id.tv_xuanze01);
        mTextView[1] = (TextView) findViewById(R.id.tv_xuanze02);
        mTextView[2] = (TextView) findViewById(R.id.tv_xuanze03);
        mTextView[3] = (TextView) findViewById(R.id.tv_xuanze04);
        mTextView[4] = (TextView) findViewById(R.id.tv_xuanze05);

        Question question1 = new Question();
        question1.setTitle("您精力充沛吗？");
        question1.setId(1);
        question1.setSelectedAnswerId(-1);
        question1.setTizhi("平和");

        Question question2 = new Question();
        question2.setTitle("您容易疲乏吗？");
        question2.setId(2);
        question2.setSelectedAnswerId(-1);
        question2.setTizhi("平和");

        Question question3 = new Question();
        question3.setTitle("您说话声音无力吗？");
        question3.setId(3);
        question3.setSelectedAnswerId(-1);
        question3.setTizhi("平和");

        Question question4 = new Question();
        question4.setTitle("您感到闷闷不乐吗？");
        question4.setId(4);
        question4.setSelectedAnswerId(-1);
        question4.setTizhi("气虚");

        Question question5 = new Question();
        question5.setTitle("您比一般人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？");
        question5.setId(5);
        question5.setSelectedAnswerId(-1);
        question5.setTizhi("气虚");

        Question question6 = new Question();
        question6.setTitle("您能适应外界自然和社会环境的变化吗？");
        question6.setId(6);
        question6.setSelectedAnswerId(-1);
        question6.setTizhi("气虚");

        Question question7 = new Question();
        question7.setTitle("您容易失眠吗？");
        question7.setId(7);
        question7.setSelectedAnswerId(-1);
        question7.setTizhi("气虚");

        Question question8 = new Question();
        question8.setTitle("您容易头晕或站起时晕眩吗？");
        question8.setId(8);
        question8.setSelectedAnswerId(-1);
        question8.setTizhi("气虚");

        Question question9 = new Question();
        question9.setTitle("您喜欢安静、懒得说话吗？");
        question9.setId(9);
        question9.setSelectedAnswerId(-1);
        question9.setTizhi("气虚");

        Question question10 = new Question();
        question10.setTitle("您说话声音无力吗？");
        question10.setId(10);
        question10.setSelectedAnswerId(-1);
        question10.setTizhi("气虚");

        list.add(question1);
        list.add(question2);
        list.add(question3);
        list2.add(question4);
        list2.add(question5);
        list3.add(question6);
        list3.add(question7);
        list4.add(question8);
        list4.add(question9);
        list4.add(question10);

        TiZhiDetail mTiZhiDetail = new TiZhiDetail();
        mTiZhiDetail.setName(tizhiMap[0]);
        mTiZhiDetail.setId(0);
        mTiZhiDetail.setQuestions(list);

        TiZhiDetail mTiZhiDetail2 = new TiZhiDetail();
        mTiZhiDetail2.setName(tizhiMap[1]);
        mTiZhiDetail2.setId(1);
        mTiZhiDetail2.setQuestions(list2);

        TiZhiDetail mTiZhiDetail3 = new TiZhiDetail();
        mTiZhiDetail3.setName(tizhiMap[2]);
        mTiZhiDetail3.setId(2);
        mTiZhiDetail3.setQuestions(list3);

        TiZhiDetail mTiZhiDetail4 = new TiZhiDetail();
        mTiZhiDetail4.setName(tizhiMap[3]);
        mTiZhiDetail4.setId(3);
        mTiZhiDetail4.setQuestions(list4);

        tiZhiList.add(mTiZhiDetail);
        tiZhiList.add(mTiZhiDetail2);
        tiZhiList.add(mTiZhiDetail3);
        tiZhiList.add(mTiZhiDetail4);

    }

    @Override
    public void initData() {
        tv_timu.setText(1 + "、 " + tiZhiList.get(0).getQuestions().get(0).getTitle());

        CheckSelect();
    }

    private void CheckSelect() {
        //检查选中
        mTextView[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[0].setVisibility(View.VISIBLE);
                mTextView[0].setTextColor(getResources().getColor(R.color.cs_ffffff));
                SetSelectData(0);
            }
        });
        mTextView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[1].setVisibility(View.VISIBLE);
                mTextView[1].setTextColor(getResources().getColor(R.color.cs_ffffff));
                SetSelectData(1);
            }
        });
        mTextView[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[2].setVisibility(View.VISIBLE);
                mTextView[2].setTextColor(getResources().getColor(R.color.cs_ffffff));
                SetSelectData(2);
            }
        });
        mTextView[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[3].setVisibility(View.VISIBLE);
                mTextView[3].setTextColor(getResources().getColor(R.color.cs_ffffff));
                SetSelectData(3);
            }
        });
        mTextView[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[4].setVisibility(View.VISIBLE);
                mTextView[4].setTextColor(getResources().getColor(R.color.cs_ffffff));
                SetSelectData(4);
            }
        });
    }

    /**
     * 按钮选择后设置List数据
     */
    private void SetSelectData(int xuanze) {
        if (tizhiNum == 0) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum00).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum00).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 1) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum01).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum01).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 2) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum02).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum02).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 3) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum03).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum03).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 4) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum04).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum04).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 5) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum05).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum05).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 6) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum06).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum06).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 7) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum07).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum07).setAnswerNum(xuanze + 1);

        } else if (tizhiNum == 8) {
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum08).setSelectedAnswerId(xuanze);
            tiZhiList.get(tizhiNum).getQuestions().get(tiMuNum08).setAnswerNum(xuanze + 1);

        }
    }

    @Override
    public void initListener() {
        rl_shang.setOnClickListener(this);
        rl_xia.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_shang:
                ClickShang();

                break;
            case R.id.rl_xia:
                ClickXia();

                break;
        }
    }

    int tizhiNum = 0;
    int tiMuNum00 = 0;
    int tiMuNum01 = 0;
    int tiMuNum02 = 0;
    int tiMuNum03 = 0;
    int tiMuNum04 = 0;
    int tiMuNum05 = 0;
    int tiMuNum06 = 0;
    int tiMuNum07 = 0;
    int tiMuNum08 = 0;
    int tizhiLength = 0;
    int questionLength = 0;

    /**
     * 点击下一题逻辑
     */
    private void ClickXia() {
        questionLength = tiZhiList.get(tizhiNum).getQuestions().size();
        tizhiLength = tiZhiList.size();
        if (tizhiNum == 0) {
            if (tiMuNum00 < questionLength - 1) {
                tiMuNum00++;
                SetTiMu(tiMuNum00);
                SetCheck(tiMuNum00);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum01);
                SetCheck(tiMuNum01);
            }
        } else if (tizhiNum == 1) {
            if (tiMuNum01 < questionLength - 1) {
                tiMuNum01++;
                SetTiMu(tiMuNum01);
                SetCheck(tiMuNum01);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum02);
                SetCheck(tiMuNum02);
            }
        } else if (tizhiNum == 2) {
            if (tiMuNum02 < questionLength - 1) {
                tiMuNum02++;
                SetTiMu(tiMuNum02);
                SetCheck(tiMuNum02);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum03);
                SetCheck(tiMuNum03);
            }
        } else if (tizhiNum == 3) {
            if (tiMuNum03 < questionLength - 1) {
                tiMuNum03++;
                SetTiMu(tiMuNum03);
                SetCheck(tiMuNum03);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum04);
                SetCheck(tiMuNum04);
            }else if (tizhiNum==tizhiLength-1){
                checkAnswer();
            }
        } else if (tizhiNum == 4) {
            if (tiMuNum04 < questionLength - 1) {
                tiMuNum04++;
                SetTiMu(tiMuNum04);
                SetCheck(tiMuNum04);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum05);
                SetCheck(tiMuNum05);
            }
        } else if (tizhiNum == 5) {
            if (tiMuNum05 < questionLength - 1) {
                tiMuNum05++;
                SetTiMu(tiMuNum05);
                SetCheck(tiMuNum05);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum06);
                SetCheck(tiMuNum06);
            }
        } else if (tizhiNum == 6) {
            if (tiMuNum06 < questionLength - 1) {
                tiMuNum06++;
                SetTiMu(tiMuNum06);
                SetCheck(tiMuNum06);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum07);
                SetCheck(tiMuNum07);
            }
        } else if (tizhiNum == 7) {
            if (tiMuNum07 < questionLength - 1) {
                tiMuNum07++;
                SetTiMu(tiMuNum07);
                SetCheck(tiMuNum07);
            } else if (tizhiNum < tizhiLength - 1) {
                tizhiNum++;
                SetTiMu(tiMuNum08);
                SetCheck(tiMuNum08);
            }
        } else if (tizhiNum == 8) {
            if (tiMuNum08 < questionLength - 1) {
                tiMuNum08++;
                SetTiMu(tiMuNum08);
                SetCheck(tiMuNum08);
                if (tiMuNum08 == questionLength - 1) {
                    //提示已是最后一题
                    tv_xia.setText("  完成");
                }
            } else if (tizhiNum == tizhiLength - 1) {
                checkAnswer();
            }

        }
        if (tizhiNum == tizhiLength - 1) {
            if (tiMuNum03 == questionLength - 1) {
                tv_xia.setText("  完成");
            }
        }
        CheckTizhi();
    }

    /**
     * 设置题目显示
     */
    private void SetTiMu(int num) {
        tv_timu.setText(num + 1 + "、 " + tiZhiList.get(tizhiNum).getQuestions().get(num).getTitle());
    }

    /**
     * 点击上一题逻辑
     */
    private void ClickShang() {
        if (tizhiNum == 0) {
            if (tiMuNum00 > 0) {
                tiMuNum00--;
                SetTiMu(tiMuNum00);
                SetCheck(tiMuNum00);
            }
        } else if (tizhiNum == 1) {
            if (tiMuNum01 > 0) {
                tiMuNum01--;
                SetTiMu(tiMuNum01);
                SetCheck(tiMuNum01);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum00);
                SetCheck(tiMuNum00);
            }
        } else if (tizhiNum == 2) {
            if (tiMuNum02 > 0) {
                tiMuNum02--;
                SetTiMu(tiMuNum02);
                SetCheck(tiMuNum02);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum01);
                SetCheck(tiMuNum01);
            }
        } else if (tizhiNum == 3) {
            if (tiMuNum03 > 0) {
                tiMuNum03--;
                SetTiMu(tiMuNum03);
                SetCheck(tiMuNum03);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum02);
                SetCheck(tiMuNum02);
            }
        } else if (tizhiNum == 4) {
            if (tiMuNum04 > 0) {
                tiMuNum04--;
                SetTiMu(tiMuNum04);
                SetCheck(tiMuNum04);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum03);
                SetCheck(tiMuNum03);
            }
        } else if (tizhiNum == 5) {
            if (tiMuNum05 > 0) {
                tiMuNum05--;
                SetTiMu(tiMuNum05);
                SetCheck(tiMuNum05);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum04);
                SetCheck(tiMuNum04);
            }
        } else if (tizhiNum == 6) {
            if (tiMuNum06 > 0) {
                tiMuNum06--;
                SetTiMu(tiMuNum06);
                SetCheck(tiMuNum06);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum05);
                SetCheck(tiMuNum05);
            }
        } else if (tizhiNum == 7) {
            if (tiMuNum07 > 0) {
                tiMuNum07--;
                SetTiMu(tiMuNum07);
                SetCheck(tiMuNum07);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum06);
                SetCheck(tiMuNum06);
            }
        } else if (tizhiNum == 8) {
            if (tiMuNum08 > 0) {
                tiMuNum08--;
                SetTiMu(tiMuNum08);
                SetCheck(tiMuNum08);
            } else {
                tizhiNum--;
                SetTiMu(tiMuNum07);
                SetCheck(tiMuNum07);
            }
        }
        if (tv_xia.getText().equals("  完成"))
            tv_xia.setText("下一题");

        CheckTizhi();
    }

    /**
     * 选项设置选中
     */
    private void SetCheck(int postion) {
        for (int i = 0; i < 5; i++) {
            mImageView[i].setVisibility(View.GONE);
            mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
            if (tiZhiList.get(tizhiNum).getQuestions().get(postion).getSelectedAnswerId() == i) {
                mImageView[i].setVisibility(View.VISIBLE);
                mTextView[i].setTextColor(getResources().getColor(R.color.cs_ffffff));
            }
        }
    }

    int pingheNum = 0, qixuNum = 0;
    String[] tizhiMap = new String[]{"平和", "气虚", "阳虚", "阴虚", "痰湿", "湿热", "血瘀", "气郁", "特禀"};
    List<AnswerBean> answerList = new ArrayList<>();

    /**
     * 检查最后数据
     */
    private void checkAnswer() {
        for (int i = 0; i < tiZhiList.size(); i++) {
            pingheNum = 0;
            for (int j = 0; j < tiZhiList.get(i).getQuestions().size(); j++) {
                pingheNum += tiZhiList.get(i).getQuestions().get(j).getAnswerNum();
            }
            AnswerBean answerBean = new AnswerBean();
            answerBean.setAnswerNum(pingheNum);
            answerBean.setTizhiName(tiZhiList.get(i).getName());
            answerList.add(answerBean);
        }
        Gson gson = new Gson();
        String a = gson.toJson(answerList);

        loadData();
    }

    /**
     * 请求后台
     */
    private void loadData() {
        Intent intent = new Intent(Question2Activity.this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("userid", 10);
        intent.putExtra("result", "是痰湿质，是淤血质，是特禀质，倾向是阴虚质");
        startActivity(intent);
        finish();

        /*OkGo.<ResponsMedo<T>>post(YYGConstant.FASTLOGIN)
                .tag(this)
                .params("phone", "")
                .execute(new DialogCallback<ResponsMedo<T>>(this) {
                    @Override
                    public void onSuccess(Response<ResponsMedo<T>> response) {
                        ResponsMedo<T> responsMedo = response.body();

                        if (responsMedo.isStatus()) {// 请求成功
                            // 解析接口返回字符串
                            Gson gson = new Gson();
                            UserImpl goodsClassesList = gson.fromJson(responsMedo.getDatas(), UserImpl.class);
                            User user = goodsClassesList.getUser();

                            Intent intent = new Intent(Question2Activity.this, ResultActivity.class);
                            intent.putExtra("name", name);
                            intent.putExtra("userid", 10);
                            intent.putExtra("result", "");

                            startActivity(intent);
                        } else {
                            CustomToast.showCustomToast(Question2Activity.this, responsMedo.getMassage(), CustomToast.eLength.SHORT);
                        }
                    }

                });*/
    }

    /**
     * 检查体质
     */
    private void CheckTizhi() {
       /* if (tiZhiList.get(tizhiNum).getName().equals("平和")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_pinghe));
        } else if (tiZhiList.get(tizhiNum).getName().equals("气虚")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_qixu));
        } else if (tiZhiList.get(tizhiNum).getName().equals("阳虚")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_yangxu));
        } else if (tiZhiList.get(tizhiNum).getName().equals("阴虚")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_yinxu));
        } else if (tiZhiList.get(tizhiNum).getName().equals("痰湿")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_tanshi));
        } else if (tiZhiList.get(tizhiNum).getName().equals("湿热")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_shire));
        } else if (tiZhiList.get(tizhiNum).getName().equals("血瘀")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_xueyu));
        } else if (tiZhiList.get(tizhiNum).getName().equals("气郁")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_qiyu));
        } else if (tiZhiList.get(tizhiNum).getName().equals("特禀")) {
            iv_tizhi.setImageDrawable(getResources().getDrawable(R.mipmap.ic_tebin));
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Question2 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
