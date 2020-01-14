package com.zju.medical.common.pojo.xdo;

import java.util.Date;

public class BloodOxygenDO {
    private Integer id;

    private Integer userId;

    private Date createTime;

    private String dataPath1;

    private String dataPath2;

    private String dataPath3;

    private String dataPath4;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDataPath1() {
        return dataPath1;
    }

    public void setDataPath1(String dataPath1) {
        this.dataPath1 = dataPath1 == null ? null : dataPath1.trim();
    }

    public String getDataPath2() {
        return dataPath2;
    }

    public void setDataPath2(String dataPath2) {
        this.dataPath2 = dataPath2 == null ? null : dataPath2.trim();
    }

    public String getDataPath3() {
        return dataPath3;
    }

    public void setDataPath3(String dataPath3) {
        this.dataPath3 = dataPath3 == null ? null : dataPath3.trim();
    }

    public String getDataPath4() {
        return dataPath4;
    }

    public void setDataPath4(String dataPath4) {
        this.dataPath4 = dataPath4 == null ? null : dataPath4.trim();
    }
}