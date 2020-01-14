package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.BloodOxygenDO;
import com.zju.medical.common.pojo.xdo.BloodOxygenDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodOxygenMapper {
    long countByExample(BloodOxygenDOExample example);

    int deleteByExample(BloodOxygenDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BloodOxygenDO record);

    int insertSelective(BloodOxygenDO record);

    List<BloodOxygenDO> selectByExample(BloodOxygenDOExample example);

    BloodOxygenDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BloodOxygenDO record, @Param("example") BloodOxygenDOExample example);

    int updateByExample(@Param("record") BloodOxygenDO record, @Param("example") BloodOxygenDOExample example);

    int updateByPrimaryKeySelective(BloodOxygenDO record);

    int updateByPrimaryKey(BloodOxygenDO record);
}