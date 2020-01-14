package com.zju.medical.common.pojo.bo;

import lombok.Data;

@Data
public class DataStaticsBO {

    //未进行标注的数据
    private int unlabelData;

    //注意缺陷型
    private int adhdI;

    //多动冲动型
    private int adhdHI;

    //混合型
    private int adhdC;

    //正常型
    private int normal;

    public DataStaticsBO(int unlabelData, int adhdI, int adhdHI, int adhdC, int normal){
        this.unlabelData = unlabelData;
        this.adhdI = adhdI;
        this.adhdHI = adhdHI;
        this.adhdC = adhdC;
        this.normal = normal;
    }
}
