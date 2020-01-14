package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.StroopTaskDO;
import com.zju.medical.common.pojo.xdo.StroopTaskDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StroopTaskMapper {
    long countByExample(StroopTaskDOExample example);

    int deleteByExample(StroopTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StroopTaskDO record);

    int insertSelective(StroopTaskDO record);

    List<StroopTaskDO> selectByExample(StroopTaskDOExample example);

    StroopTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StroopTaskDO record, @Param("example") StroopTaskDOExample example);

    int updateByExample(@Param("record") StroopTaskDO record, @Param("example") StroopTaskDOExample example);

    int updateByPrimaryKeySelective(StroopTaskDO record);

    int updateByPrimaryKey(StroopTaskDO record);
}