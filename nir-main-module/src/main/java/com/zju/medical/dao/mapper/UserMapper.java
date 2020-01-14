package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.bo.AdhdTypeDailyStatisticsBO;
import com.zju.medical.common.pojo.bo.AdhdTypeStatisticsBO;
import com.zju.medical.common.pojo.xdo.UserDO;
import com.zju.medical.common.pojo.xdo.UserDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    long countByExample(UserDOExample example);

    int deleteByExample(UserDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    List<UserDO> selectByExample(UserDOExample example);

    UserDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

    AdhdTypeStatisticsBO countEveryAdhdType();

    List<AdhdTypeDailyStatisticsBO> countDailyEveryAdhdType();
}