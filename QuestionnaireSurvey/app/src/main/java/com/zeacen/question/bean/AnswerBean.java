package com.zeacen.question.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/17.
 */
public class AnswerBean implements Serializable{
    int answerNum;
    String tizhiName;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTizhiName() {

        return tizhiName;
    }

    public void setTizhiName(String tizhiName) {
        this.tizhiName = tizhiName;
    }

    public int getAnswerNum() {

        return answerNum;
    }

    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }
}
