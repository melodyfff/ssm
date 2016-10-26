package com.xinchen.ssm.quartz.service;

import java.io.Serializable;

/**
 * Created by ChenXin on 2016/10/26.
 */
public class PageTrigger implements Serializable {

    private String name;
    private String group;
    private String expression;
    private String status;
    private String desc;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getExpression() {
        return expression;
    }
    public void setExpression(String expression) {
        this.expression = expression;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}

