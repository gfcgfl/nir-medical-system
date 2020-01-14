package com.zju.medical.dao.mapper;

import com.zju.medical.common.pojo.xdo.ClinicalInfoDO;
import com.zju.medical.common.pojo.xdo.ClinicalInfoDOExample;
import com.zju.medical.common.pojo.xdo.ClinicalInfoDOWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiaoguo
 */
@Repository
public interface ClinicalInfoMapper {
    long countByExample(ClinicalInfoDOExample example);

    int deleteByExample(ClinicalInfoDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClinicalInfoDOWithBLOBs record);

    int insertSelective(ClinicalInfoDOWithBLOBs record);

    List<ClinicalInfoDOWithBLOBs> selectByExampleWithBLOBs(ClinicalInfoDOExample example);

    List<ClinicalInfoDO> selectByExample(ClinicalInfoDOExample example);

    ClinicalInfoDOWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClinicalInfoDOWithBLOBs record, @Param("example") ClinicalInfoDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ClinicalInfoDOWithBLOBs record, @Param("example") ClinicalInfoDOExample example);

    int updateByExample(@Param("record") ClinicalInfoDO record, @Param("example") ClinicalInfoDOExample example);

    int updateByPrimaryKeySelective(ClinicalInfoDOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ClinicalInfoDOWithBLOBs record);

    int updateByPrimaryKey(ClinicalInfoDO record);
}