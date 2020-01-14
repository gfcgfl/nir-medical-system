package com.zju.medical.common.pojo.bo;


import lombok.Data;

/**
 * 用于记录adhd每种患病类型的数量
 * @author xiaoguo
 */

@Data
public class AdhdTypeStatisticsBO {

    /**
     * 正常用户的数目
     */
    private Integer adhdNormal;
    /**
     * ADHD-I 注意缺陷型  用户的数目
     */
    private Integer adhdI;
    /**
     * ADHD-HI 多动冲动型 用户的数目
     */
    private Integer adhdHI;
    /**
     * ADHD-C 混合型 用户的数目
     */
    private Integer adhdC;

    //所有用户总数
    private Integer all;

}
