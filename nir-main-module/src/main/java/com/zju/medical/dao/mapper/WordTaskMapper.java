package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.WordTaskDO;
import com.zju.medical.common.pojo.xdo.WordTaskDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordTaskMapper {
    long countByExample(WordTaskDOExample example);

    int deleteByExample(WordTaskDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WordTaskDO record);

    int insertSelective(WordTaskDO record);

    List<WordTaskDO> selectByExample(WordTaskDOExample example);

    WordTaskDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WordTaskDO record, @Param("example") WordTaskDOExample example);

    int updateByExample(@Param("record") WordTaskDO record, @Param("example") WordTaskDOExample example);

    int updateByPrimaryKeySelective(WordTaskDO record);

    int updateByPrimaryKey(WordTaskDO record);
}