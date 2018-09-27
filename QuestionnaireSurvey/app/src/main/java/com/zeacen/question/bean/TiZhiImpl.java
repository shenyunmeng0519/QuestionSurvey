package com.zeacen.question.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/15.
 */
public class TiZhiImpl implements Serializable{
    String name;
    int id;
    List <TiZhiDetail> tizhiBean;

    public List<TiZhiDetail> getTizhiBean() {
        return tizhiBean;
    }

    public void setTizhiBean(List<TiZhiDetail> tizhiBean) {
        this.tizhiBean = tizhiBean;
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
}
