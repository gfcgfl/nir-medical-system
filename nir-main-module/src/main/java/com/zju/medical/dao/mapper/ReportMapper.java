package com.zju.medical.dao.mapper;

import com.zju.medical.common.pojo.xdo.ReportDO;
import com.zju.medical.common.pojo.xdo.ReportDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportMapper {
    long countByExample(ReportDOExample example);

    int deleteByExample(ReportDOExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(ReportDO record);

    int insertSelective(ReportDO record);

    List<ReportDO> selectByExample(ReportDOExample example);

    ReportDO selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") ReportDO record, @Param("example") ReportDOExample example);

    int updateByExample(@Param("record") ReportDO record, @Param("example") ReportDOExample example);

    int updateByPrimaryKeySelective(ReportDO record);

    int updateByPrimaryKey(ReportDO record);
}