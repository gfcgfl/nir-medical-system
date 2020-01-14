package com.zju.medical.common.pojo.xdo;

import java.util.Date;

/**
 * @author xiaoguo
 */
public class ClinicalInfoDO {
    private Integer id;

    private Integer userId;

    private Integer symptomTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSymptomTime() {
        return symptomTime;
    }

    public void setSymptomTime(Integer symptomTime) {
        this.symptomTime = symptomTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}