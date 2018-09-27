package com.zeacen.question.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/15.
 */
public class TiZhiDetail implements Serializable{
    String name;
    int id;

    List<Question> questions;

    String quesitionId;

    public String getQuesitionId() {
        return quesitionId;
    }

    public void setQuesitionId(String quesitionId) {
        this.quesitionId = quesitionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
