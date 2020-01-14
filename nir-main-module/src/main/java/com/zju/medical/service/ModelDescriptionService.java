package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.AdhdTypeDailyStatisticsBO;
import com.zju.medical.common.pojo.bo.AdhdTypeStatisticsBO;

import java.util.List;

/**
 * @author xiaoguo
 */
public interface ModelDescriptionService {

    /**
     * 统计每一种adhd类型的用户的数目
     * @return
     */
    AdhdTypeStatisticsBO countEveryAdhdType();

    /**
     * 统计每一个采集日期当天 每一种adhd类型的用户的数目
     */
    List<AdhdTypeDailyStatisticsBO> countDailyEveryAdhdType();
}
