package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.ReyTaskDO;
import com.zju.medical.common.pojo.xdo.ReyTaskDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReyTaskMapper {
    long countByExample(ReyTaskDOExample example);

    int deleteByExample(ReyTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReyTaskDO record);

    int insertSelective(ReyTaskDO record);

    List<ReyTaskDO> selectByExample(ReyTaskDOExample example);

    ReyTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReyTaskDO record, @Param("example") ReyTaskDOExample example);

    int updateByExample(@Param("record") ReyTaskDO record, @Param("example") ReyTaskDOExample example);

    int updateByPrimaryKeySelective(ReyTaskDO record);

    int updateByPrimaryKey(ReyTaskDO record);
}