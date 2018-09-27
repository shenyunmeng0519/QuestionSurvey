package com.zeacen.question.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/9/25.
 */

public class ResultBean implements Serializable {
    int id;
    String result;
    String tiaoli;
    int tizhiNum;

    public int getTizhiNum() {
        return tizhiNum;
    }

    public void setTizhiNum(int tizhiNum) {
        this.tizhiNum = tizhiNum;
    }

    public String getTiaoli() {

        return tiaoli;
    }

    public void setTiaoli(String tiaoli) {
        this.tiaoli = tiaoli;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
