package com.zju.medical.common.pojo.bo;

import lombok.Data;

import java.util.Date;

/**
 * 用于记录某个采集日期当天  adhd每种患病类型的用户数量
 * @author xiaoguo
 */
@Data
public class AdhdTypeDailyStatisticsBO extends AdhdTypeStatisticsBO{

    private Date collectDate;
}
