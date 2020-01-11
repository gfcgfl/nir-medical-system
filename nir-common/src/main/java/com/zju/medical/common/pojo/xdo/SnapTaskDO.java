package com.zju.medical.common.pojo.xdo;

import java.util.Date;

public class SnapTaskDO {
    private Integer id;

    private Integer userId;

    private Integer snapParentScore;

    private Integer snapTeacherScore;

    private Date createTime;

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

    public Integer getSnapParentScore() {
        return snapParentScore;
    }

    public void setSnapParentScore(Integer snapParentScore) {
        this.snapParentScore = snapParentScore;
    }

    public Integer getSnapTeacherScore() {
        return snapTeacherScore;
    }

    public void setSnapTeacherScore(Integer snapTeacherScore) {
        this.snapTeacherScore = snapTeacherScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}