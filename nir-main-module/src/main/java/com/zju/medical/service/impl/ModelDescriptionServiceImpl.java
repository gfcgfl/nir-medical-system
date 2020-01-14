package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.bo.AdhdTypeDailyStatisticsBO;
import com.zju.medical.common.pojo.bo.AdhdTypeStatisticsBO;
import com.zju.medical.dao.mapper.UserMapper;
import com.zju.medical.service.ModelDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class ModelDescriptionServiceImpl implements ModelDescriptionService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 统计每一种adhd类型的用户的数目
     * @return
     */
    @Override
    public AdhdTypeStatisticsBO countEveryAdhdType() {

        AdhdTypeStatisticsBO adhdTypeStatisticsBo = userMapper.countEveryAdhdType();

        return adhdTypeStatisticsBo;
    }

    /**
     * 统计每一个采集日期当天 每一种adhd类型的用户的数目
     */
    @Override
    public List<AdhdTypeDailyStatisticsBO> countDailyEveryAdhdType() {
        return userMapper.countDailyEveryAdhdType();
    }
}
