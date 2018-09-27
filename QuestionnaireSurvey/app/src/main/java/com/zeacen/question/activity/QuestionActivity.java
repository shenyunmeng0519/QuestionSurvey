package com.zeacen.question.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zeacen.question.R;
import com.zeacen.question.base.BaseActivity;
import com.zeacen.question.bean.Question;
import com.zeacen.question.bean.ResultBean;
import com.zeacen.question.bean.TiZhiDetail;
import com.zeacen.question.comm.StrokeTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/9/14.
 */

public class QuestionActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.tv_num)
    StrokeTextView tv_num;
    @BindView(R.id.tv_timu)
    TextView tv_timu;
    @BindView(R.id.rl_shang)
    RelativeLayout rl_shang;
    @BindView(R.id.rl_xia)
    RelativeLayout rl_xia;
    @BindView(R.id.tv_xia)
    TextView tv_xia;

    private int corrent; // 当前题目位置
    private List<Question> list = new ArrayList<>();
    ImageView[] mImageView = new ImageView[5];
    TextView[] mTextView = new TextView[5];
    private List<ResultBean> result_List = new ArrayList<>();
    String name = "";

    private int count; //题目总数
    // 数据源 假数据
    private String resultJosn = "{\"result\":\"1\",\"type\":\"1\",\"data\":[{\"type\":\"平和\",\"eid\":\"1\",\"problem\":\"您精力充沛吗？\",\"trueanswer\":\"B\",\"isChecked\":\"-1\"" +
            "}," +
            "{\"type\":\"平和\",\"eid\":\"2\",\"problem\":\"您容易疲乏吗？\",\"trueanswer\":\"C\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"3\",\"problem\":\"您说话声音无力吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"4\",\"problem\":\"您感到闷闷不乐吗？\",\"trueanswer\":\"B\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"5\",\"problem\":\"您比一般人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？\",\"trueanswer\":\"D\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"6\",\"problem\":\"您能适应外界自然和社会环境的变化吗？\",\"trueanswer\":\"C\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"7\",\"problem\":\"您容易失眠吗？\",\"trueanswer\":\"B\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"平和\",\"eid\":\"8\",\"problem\":\"您容易忘事（健忘）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"9\",\"problem\":\"你容易疲乏吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"10\",\"problem\":\"您容易气短（呼吸短促，接不上气）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"11\",\"problem\":\"您容易心慌吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"12\",\"problem\":\" 您容易头晕或站起时晕眩吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"13\",\"problem\":\"  您比别人容易患感冒吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"14\",\"problem\":\"  您喜欢安静、懒得说话吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"15\",\"problem\":\"  您说话声音无力吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气虚\",\"eid\":\"16\",\"problem\":\"  您活动量就容易出虚汗吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"17\",\"problem\":\"  您手脚发凉吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"18\",\"problem\":\"  您胃脘部、背部或腰膝部怕冷吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"19\",\"problem\":\"  您感到怕冷、衣服比别人穿得多吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"20\",\"problem\":\"  您比一般人承受不了寒冷（冬天的寒冷，夏天的冷空调、电扇等）？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"21\",\"problem\":\"  您比别人容易患感冒吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"22\",\"problem\":\"  您吃（喝）凉的东西会感到不舒服或者怕吃（喝）凉东西吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阳虚\",\"eid\":\"23\",\"problem\":\"  你受凉或吃（喝）凉的东西后，容易腹泻（拉肚子）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"24\",\"problem\":\"  您感到手脚心发热吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"25\",\"problem\":\"  您感觉身体、脸上发热吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"26\",\"problem\":\"  您皮肤或口唇干吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"27\",\"problem\":\"  您口唇的颜色比一般人红吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"28\",\"problem\":\"  您容易便秘或大便干燥吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"29\",\"problem\":\"  您面部两潮红或偏红吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"30\",\"problem\":\"  您感到眼睛干涩吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"阴虚\",\"eid\":\"31\",\"problem\":\"  您活动量稍大就容易出虚汗吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"32\",\"problem\":\"  您感到胸闷或腹部胀满吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"33\",\"problem\":\"  您感到身体学生不轻松或不爽快吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"34\",\"problem\":\"  您腹部肥满松软吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"35\",\"problem\":\"  您有额部油脂分泌多的现象吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"36\",\"problem\":\"  您上眼睑比别人肿（仍轻微隆起的现象）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"37\",\"problem\":\"  您嘴里有黏黏的感觉吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"38\",\"problem\":\"  您平时痰多，特别是咽喉部总感到有痰堵着吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"痰湿\",\"eid\":\"39\",\"problem\":\"  您舌苔厚腻或有舌苔厚厚的感觉吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"40\",\"problem\":\"  您面部或鼻部有油腻感或者油亮发光吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"41\",\"problem\":\"  你容易生痤疮或疮疖吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"42\",\"problem\":\"  您感到口苦或嘴里有异味吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"43\",\"problem\":\"  您大使黏滞不爽、有解不尽的感觉吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"44\",\"problem\":\"  您小便时尿道有发热感、尿色浓（深）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"湿热\",\"eid\":\"45\",\"problem\":\"  您的阴囊部位潮湿吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"46\",\"problem\":\"  您的皮肤在不知不觉中会出现青紫瘀斑（皮下出血）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"47\",\"problem\":\"  您两颧部有细微红丝吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"48\",\"problem\":\"  您身体上有哪里疼痛吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"49\",\"problem\":\"  您面色晦黯或容易出现褐斑吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"50\",\"problem\":\"  您容易有黑眼圈吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +

            "{\"type\":\"血瘀\",\"eid\":\"51\",\"problem\":\"  您容易忘事（健忘）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"血瘀\",\"eid\":\"52\",\"problem\":\"  您口唇颜色偏黯吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"53\",\"problem\":\"  您感到闷闷不乐吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"54\",\"problem\":\"  您容易精神紧张、焦虑不安吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"55\",\"problem\":\"  您多愁善感、感情脆弱吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"56\",\"problem\":\"  您容易感到害怕或受到惊吓吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"57\",\"problem\":\"  您胁肋部或乳房腹痛吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"58\",\"problem\":\"  您无缘无故叹气吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"59\",\"problem\":\"  您咽喉部有异物感，且吐之不出、咽之不下吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"气郁\",\"eid\":\"60\",\"problem\":\"  您容易忘事（健忘）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"61\",\"problem\":\"  您没有感冒时也会打喷嚏吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"62\",\"problem\":\"  您没有感冒时也会鼻塞、流鼻涕吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"63\",\"problem\":\"  您有因季节变化、温度变化或异味等原因而咳喘的现象吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"64\",\"problem\":\"  您容易过敏（对药物、食物、气味、花粉或在季节交替、气候变化时）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"65\",\"problem\":\"  您的皮肤容易起荨麻疹（风团、风疹块、风疙瘩）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"66\",\"problem\":\"  您的因过敏出现过紫癜（紫红色瘀点、瘀斑）吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}," +
            "{\"type\":\"特禀\",\"eid\":\"67\",\"problem\":\"  您的皮肤一抓就红，并出现抓痕吗？\",\"trueanswer\":\"A\",\"isChecked\":\"-1\""+"}"+ "]}\n";
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

        /*list.add(question1);
        list.add(question2);
        list.add(question3);
        list.add(question4);
        list.add(question5);
        list.add(question6);
        list.add(question7);

        count = list.size();*/
        // 初始化数据
        initDate();
        count = list.size();
    }
    private void initDate() {
        try {

            JSONObject resultJson = new JSONObject(resultJosn);
            JSONArray arrayJson = resultJson.optJSONArray("data");

            for (int i=0;i<arrayJson.length();i++){
                JSONObject subObject = arrayJson.getJSONObject(i);


                Question q_quesition = new Question();
                q_quesition.setId(Integer.parseInt(subObject.getString("eid")));//体质的id
                q_quesition.setTitle(subObject.getString("problem"));//体质
                q_quesition.setTizhi(subObject.getString("type"));
                q_quesition.setSelectedAnswerId(Integer.parseInt(subObject.getString("isChecked")));

                list.add(q_quesition);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initData() {
        corrent = 0;
        tv_timu.setText(corrent + 1 + "、" + list.get(corrent).getTitle());
        tv_num.setText("【"+1+"/"+list.size()+"】");
        CheckSelect();
    }

    private void CheckSelect() {
        //检查选中
        mTextView[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[0].setVisibility(View.VISIBLE);
                mTextView[0].setTextColor(getResources().getColor(R.color.cs_ffffff));
                list.get(corrent).setSelectedAnswerId(0);
                if (list.get(corrent).getTizhi().equals("平和")){
                    if (list.get(corrent).getTitle().equals("您容易疲乏吗？")||list.get(corrent).getTitle().equals("您说话声音无力吗？")
                            ||list.get(corrent).getTitle().equals("您感到闷闷不乐吗？")||list.get(corrent).getTitle().equals("您比一般人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？")
                            ||list.get(corrent).getTitle().equals("您容易失眠吗？")||list.get(corrent).getTitle().equals("您容易忘事（健忘）吗？")){
                        list.get(corrent).setAnswerNum(5);
                    }else {
                        list.get(corrent).setAnswerNum(1);
                    }
                }else {
                    list.get(corrent).setAnswerNum(1);
                }
            }
        });
        mTextView[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[1].setVisibility(View.VISIBLE);
                mTextView[1].setTextColor(getResources().getColor(R.color.cs_ffffff));
                list.get(corrent).setSelectedAnswerId(1);
                if (list.get(corrent).getTizhi().equals("平和")){
                    if (list.get(corrent).getTitle().equals("您容易疲乏吗？")||list.get(corrent).getTitle().equals("您说话声音无力吗？")
                            ||list.get(corrent).getTitle().equals("您感到闷闷不乐吗？")||list.get(corrent).getTitle().equals("您比一般 人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？")
                            ||list.get(corrent).getTitle().equals("您容易失眠吗？")||list.get(corrent).getTitle().equals("您容易忘事（健忘）吗？")){
                        list.get(corrent).setAnswerNum(4);
                    }else {
                        list.get(corrent).setAnswerNum(2);
                    }
                }else {
                    list.get(corrent).setAnswerNum(2);
                }
            }
        });
        mTextView[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[2].setVisibility(View.VISIBLE);
                mTextView[2].setTextColor(getResources().getColor(R.color.cs_ffffff));
                list.get(corrent).setSelectedAnswerId(2);
                list.get(corrent).setAnswerNum(3);

            }
        });
        mTextView[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[3].setVisibility(View.VISIBLE);
                mTextView[3].setTextColor(getResources().getColor(R.color.cs_ffffff));
                list.get(corrent).setSelectedAnswerId(3);
                if (list.get(corrent).getTizhi().equals("平和")){
                    if (list.get(corrent).getTitle().equals("您容易疲乏吗？")||list.get(corrent).getTitle().equals("您说话声音无力吗？")
                            ||list.get(corrent).getTitle().equals("您感到闷闷不乐吗？")||list.get(corrent).getTitle().equals("您比一般 人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？")
                            ||list.get(corrent).getTitle().equals("您容易失眠吗？")||list.get(corrent).getTitle().equals("您容易忘事（健忘）吗？")){
                        list.get(corrent).setAnswerNum(2);
                    }else {
                        list.get(corrent).setAnswerNum(4);
                    }
                }else {
                    list.get(corrent).setAnswerNum(4);
                }

            }
        });
        mTextView[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<5;i++) {
                    mImageView[i].setVisibility(View.GONE);
                    mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                }
                mImageView[4].setVisibility(View.VISIBLE);
                mTextView[4].setTextColor(getResources().getColor(R.color.cs_ffffff));
                list.get(corrent).setSelectedAnswerId(4);
                if (list.get(corrent).getTizhi().equals("平和")){
                    if (list.get(corrent).getTitle().equals("您容易疲乏吗？")||list.get(corrent).getTitle().equals("您说话声音无力吗？")
                            ||list.get(corrent).getTitle().equals("您感到闷闷不乐吗？")||list.get(corrent).getTitle().equals("您比一般 人耐受不了寒冷（冬天的寒冷，夏天的冷空调、电扇）吗？")
                            ||list.get(corrent).getTitle().equals("您容易失眠吗？")||list.get(corrent).getTitle().equals("您容易忘事（健忘）吗？")){
                        list.get(corrent).setAnswerNum(1);
                    }else {
                        list.get(corrent).setAnswerNum(5);
                    }
                }else {
                    list.get(corrent).setAnswerNum(5);
                }

            }
        });
    }

    @Override
    public void initListener() {
        rl_shang.setOnClickListener(this);
        rl_xia.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_shang:
                if (corrent > 0) {
                    corrent--;
                    tv_num.setText("【"+(corrent+ 1)+"/"+list.size()+"】");
                    tv_timu.setText(corrent + 1 +". " + list.get(corrent).getTitle());
                    //设置选中
                    for(int i=0;i<5;i++) {
                        mImageView[i].setVisibility(View.GONE);
                        mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));
                        if (list.get(corrent).getSelectedAnswerId() == i){
                            mImageView[i].setVisibility(View.VISIBLE);
                            mTextView[i].setTextColor(getResources().getColor(R.color.cs_ffffff));
                        }
                    }
                    tv_xia.setText("下一题");

                }
                break;
            case R.id.rl_xia:
                //checkAnswer();
                if (corrent < count -1) {
                    corrent++;
                    tv_num.setText("【"+(corrent+ 1)+"/"+list.size()+"】");
                    tv_timu.setText(corrent + 1 +". " + list.get(corrent).getTitle());
                    for(int i=0;i<5;i++) {
                        mImageView[i].setVisibility(View.GONE);
                        mTextView[i].setTextColor(getResources().getColor(R.color.cs_333333));

                        if (list.get(corrent).getSelectedAnswerId() == i){
                            mImageView[i].setVisibility(View.VISIBLE);
                            mTextView[i].setTextColor(getResources().getColor(R.color.cs_ffffff));

                        }
                    }
                    if (corrent == count - 1){
                        //提示已是最后一题
                        tv_xia.setText("  完成");
                    }
                }else if(corrent == count - 1){
                    checkAnswer();
                }
                break;
        }
    }
    int pingheNum = 0,qixuNum = 0,yangxuNum = 0,yinxuNum = 0,tanshiNum = 0,shireNum = 0,xuyuNum = 0,qiyuNum = 0,tebinNUm = 0,
    pingheZhuan = 0,qixuZhuan = 0,yangxuZhuan = 0,yinxuZhuan = 0,tanshiZhuan = 0,shireZhuan = 0,xuyuZhuan = 0,qiyuZhuan = 0,tebinZhuan = 0;
    String[] tizhi = new String[]{"平和","气虚","阳虚","阴虚","痰湿","湿热","血瘀","气郁","特禀"};
    String pinghe = "",qixu = "",yangxu = "",yinxu = "",tanshi = "",shire = "",xuyu = "",qiyu = "",tebin = "";
    String result = "",jieguo01 = "",jieguo02 = "";
    String[] res = new String[]{};
    /**
     * 检查最后数据
     * */
    private void checkAnswer() {
        Gson gson = new Gson();
        String a = gson.toJson(list);
        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getTizhi().equals("平和")){
                pingheNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("气虚")){
                qixuNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("阳虚")){
                yangxuNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("阴虚")){
                yinxuNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("痰湿")){
                tanshiNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("湿热")){
                shireNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("血瘀")){
                xuyuNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("气郁")){
                qiyuNum += list.get(i).getAnswerNum();
            }else if (list.get(i).getTizhi().equals("特禀")){
                tebinNUm += list.get(i).getAnswerNum();
            }
        }
        pingheZhuan = ((pingheNum-8)*100/(8*4));
        qixuZhuan = ((qixuNum-8)*100/(8*4));
        yangxuZhuan = ((yangxuNum-7)*100/(7*4));
        yinxuZhuan = ((yinxuNum-8)*100/(8*4));
        tanshiZhuan = ((tanshiNum-8)*100/(8*4));
        shireZhuan = ((shireNum-6)*100/(6*4));
        xuyuZhuan = ((xuyuNum-7)*100/(7*4));
        qiyuZhuan = ((qiyuNum-8)*100/(8*4));
        tebinZhuan = ((tebinNUm-7)*100/(7*4));

        if (pingheZhuan>59&&qixuZhuan<30&&yangxuZhuan<30
                &&yinxuZhuan<30&&tanshiZhuan<30
                &&shireZhuan<30&&xuyuZhuan<30
                &&qiyuZhuan<30&&tebinZhuan<30){
            pinghe = "是平和质";
            jieguo01 = pinghe;
        }else if (pingheZhuan>59&&qixuZhuan<40&&yangxuZhuan<40
                &&yinxuZhuan<40&&tanshiZhuan<40
                &&shireZhuan<40&&xuyuZhuan<40
                &&qiyuZhuan<40&&tebinZhuan<40){
            pinghe = "基本是平和质";
            jieguo01 = pinghe;

        }else {
            pinghe = "";


        if (qixuZhuan>39){
            qixu = "是气虚质";
            jieguo01 = qixu;
        }else if (qixuZhuan<30){
            qixu = "";
        }else {
            qixu = "倾向是气虚质";
            jieguo02 = qixu;
        }
        if (yangxuZhuan>39){
            if (qixu.isEmpty()) {
                yangxu = "是阳虚质";
            }else {
                yangxu = ",是阳虚质";
            }
            jieguo01 = jieguo01+yangxu;
        }else if (yangxuZhuan<30){
            yangxu = "";
        }else {
            if (qixu.isEmpty()) {
                yangxu = "倾向是阳虚质";
            }else {
                yangxu = ",倾向是阳虚质";

            }
            jieguo02 = jieguo02+yangxu;

        }
        if (yinxuZhuan>39){
            if (qixu.isEmpty()&&yangxu.isEmpty()) {
                yinxu = "是阴虚质";
            }else {
                yinxu = ",是阴虚质";

            }
            jieguo01 = jieguo01+yinxu;

        }else if (yinxuZhuan<30){
            yinxu = "";
        }else {
            if (qixu.isEmpty()&&yangxu.isEmpty()) {
                yinxu = "倾向是阴虚质";
            }else {
                yinxu = ",倾向是阴虚质";

            }
            jieguo02 = jieguo02+yinxu;

        }
        if (tanshiZhuan>39){
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()) {
                tanshi = "是痰湿质";
            }else {
                tanshi = ",是痰湿质";
            }
            jieguo01 = jieguo01+tanshi;

        }else if (tanshiZhuan<30){
            tanshi = "";
        }else {
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()) {
                tanshi = "倾向是痰湿质";
            }else {
                tanshi = ",倾向是痰湿质";

            }
            jieguo02 = jieguo02+tanshi;

        }
        if (shireZhuan>39){
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()) {
                shire = "是湿热质";
            }else {
                shire = ",是湿热质";
            }
            jieguo01 = jieguo01+shire;

        }else if (shireZhuan<30){
            shire = "";
        }else {
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()) {
                shire = "倾向是湿热质";
            }else {
                shire = ",倾向是湿热质";

            }
            jieguo02 = jieguo02+shire;

        }
        if (xuyuZhuan>39){
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()&&shire.isEmpty()) {
                xuyu = "是血瘀质";
            }else {
                xuyu = ",是血瘀质";
            }
            jieguo01 = jieguo01+xuyu;

        }else if (xuyuZhuan<30){
            xuyu = "";
        }else {
            if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()&&shire.isEmpty()) {
                xuyu = "倾向是血瘀质";
            }else {
                xuyu = ",倾向是血瘀质";

            }
            jieguo02 = jieguo02+xuyu;

        }
            if (qiyuZhuan>39){
                if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()
                        &&shire.isEmpty()&&xuyu.isEmpty()) {
                    qiyu = "是气郁质";
                }else {
                    qiyu = ",是气郁质";

                }
                jieguo01 = jieguo01+qiyu;

            }else if (qiyuZhuan<30){
                qiyu = "";
            }else {
                if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()
                        &&shire.isEmpty()&&xuyu.isEmpty()) {
                    qiyu = "倾向是气郁质";
                }else {
                    qiyu = ",倾向是气郁质";

                }
                jieguo02 = jieguo02+qiyu;

            }
            if (tebinZhuan>39){
                if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()
                        &&shire.isEmpty()&&xuyu.isEmpty()&&qiyu.isEmpty()) {
                    tebin = "是特禀质";
                }else {
                    tebin = ",是特禀质";

                }
                jieguo01 = jieguo01+tebin;

            }else if (tebinZhuan<30){
                tebin = "";
            }else {
                if (qixu.isEmpty()&&yangxu.isEmpty()&&yinxu.isEmpty()&&tanshi.isEmpty()
                        &&shire.isEmpty()&&xuyu.isEmpty()&&qiyu.isEmpty()) {
                    tebin = "倾向是特禀质";
                }else {
                    tebin = ",倾向是特禀质";

                }
                jieguo02 = jieguo02+tebin;

            }
        }

        Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("userid", 10);
        intent.putExtra("result", jieguo01);
        intent.putExtra("jieguo02", jieguo02);
        intent.putExtra("jieguo01", jieguo01);

        startActivity(intent);
    }

}
