package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.SnapTaskDO;
import com.zju.medical.common.pojo.xdo.SnapTaskDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnapTaskMapper {
    long countByExample(SnapTaskDOExample example);

    int deleteByExample(SnapTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SnapTaskDO record);

    int insertSelective(SnapTaskDO record);

    List<SnapTaskDO> selectByExample(SnapTaskDOExample example);

    SnapTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SnapTaskDO record, @Param("example") SnapTaskDOExample example);

    int updateByExample(@Param("record") SnapTaskDO record, @Param("example") SnapTaskDOExample example);

    int updateByPrimaryKeySelective(SnapTaskDO record);

    int updateByPrimaryKey(SnapTaskDO record);
}