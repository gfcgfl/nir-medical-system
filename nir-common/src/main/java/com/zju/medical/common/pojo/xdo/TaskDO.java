package com.zju.medical.common.pojo.xdo;

import java.util.Date;

/**
 * @author xiaoguo
 */
public class TaskDO {

    /**
     * 字段的解释 见数据库表，  太麻烦了不想写了
     */
    private Integer id;

    private Integer userId;

    private Integer reySiScore;

    private Integer reyDiScore;

    private Integer reySdScore;

    private Integer reyDdScore;

    private Integer aWordTime;

    private Integer aWordMis;

    private Integer bWordTime;

    private Integer bWordMis;

    private Integer stroopTimeA;

    private Integer stroopMisA;

    private Integer stroopTimeB;

    private Integer stroopMisB;

    private Integer stroopTimeC;

    private Integer stroopMisC;

    private Integer stroopTimeD;

    private Integer stroopMisD;

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

    public Integer getReySiScore() {
        return reySiScore;
    }

    public void setReySiScore(Integer reySiScore) {
        this.reySiScore = reySiScore;
    }

    public Integer getReyDiScore() {
        return reyDiScore;
    }

    public void setReyDiScore(Integer reyDiScore) {
        this.reyDiScore = reyDiScore;
    }

    public Integer getReySdScore() {
        return reySdScore;
    }

    public void setReySdScore(Integer reySdScore) {
        this.reySdScore = reySdScore;
    }

    public Integer getReyDdScore() {
        return reyDdScore;
    }

    public void setReyDdScore(Integer reyDdScore) {
        this.reyDdScore = reyDdScore;
    }

    public Integer getaWordTime() {
        return aWordTime;
    }

    public void setaWordTime(Integer aWordTime) {
        this.aWordTime = aWordTime;
    }

    public Integer getaWordMis() {
        return aWordMis;
    }

    public void setaWordMis(Integer aWordMis) {
        this.aWordMis = aWordMis;
    }

    public Integer getbWordTime() {
        return bWordTime;
    }

    public void setbWordTime(Integer bWordTime) {
        this.bWordTime = bWordTime;
    }

    public Integer getbWordMis() {
        return bWordMis;
    }

    public void setbWordMis(Integer bWordMis) {
        this.bWordMis = bWordMis;
    }

    public Integer getStroopTimeA() {
        return stroopTimeA;
    }

    public void setStroopTimeA(Integer stroopTimeA) {
        this.stroopTimeA = stroopTimeA;
    }

    public Integer getStroopMisA() {
        return stroopMisA;
    }

    public void setStroopMisA(Integer stroopMisA) {
        this.stroopMisA = stroopMisA;
    }

    public Integer getStroopTimeB() {
        return stroopTimeB;
    }

    public void setStroopTimeB(Integer stroopTimeB) {
        this.stroopTimeB = stroopTimeB;
    }

    public Integer getStroopMisB() {
        return stroopMisB;
    }

    public void setStroopMisB(Integer stroopMisB) {
        this.stroopMisB = stroopMisB;
    }

    public Integer getStroopTimeC() {
        return stroopTimeC;
    }

    public void setStroopTimeC(Integer stroopTimeC) {
        this.stroopTimeC = stroopTimeC;
    }

    public Integer getStroopMisC() {
        return stroopMisC;
    }

    public void setStroopMisC(Integer stroopMisC) {
        this.stroopMisC = stroopMisC;
    }

    public Integer getStroopTimeD() {
        return stroopTimeD;
    }

    public void setStroopTimeD(Integer stroopTimeD) {
        this.stroopTimeD = stroopTimeD;
    }

    public Integer getStroopMisD() {
        return stroopMisD;
    }

    public void setStroopMisD(Integer stroopMisD) {
        this.stroopMisD = stroopMisD;
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

    @Override
    public String toString() {
        return "TaskDO{" +
                "id=" + id +
                ", userId=" + userId +
                ", reySiScore=" + reySiScore +
                ", reyDiScore=" + reyDiScore +
                ", reySdScore=" + reySdScore +
                ", reyDdScore=" + reyDdScore +
                ", aWordTime=" + aWordTime +
                ", aWordMis=" + aWordMis +
                ", bWordTime=" + bWordTime +
                ", bWordMis=" + bWordMis +
                ", stroopTimeA=" + stroopTimeA +
                ", stroopMisA=" + stroopMisA +
                ", stroopTimeB=" + stroopTimeB +
                ", stroopMisB=" + stroopMisB +
                ", stroopTimeC=" + stroopTimeC +
                ", stroopMisC=" + stroopMisC +
                ", stroopTimeD=" + stroopTimeD +
                ", stroopMisD=" + stroopMisD +
                ", snapParentScore=" + snapParentScore +
                ", snapTeacherScore=" + snapTeacherScore +
                ", createTime=" + createTime +
                '}';
    }
}