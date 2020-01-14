package com.zju.medical.dao.mapper;


import com.zju.medical.common.pojo.xdo.DoctorDO;
import com.zju.medical.common.pojo.xdo.DoctorDOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorMapper {
    long countByExample(DoctorDOExample example);

    int deleteByExample(DoctorDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DoctorDO record);

    int insertSelective(DoctorDO record);

    List<DoctorDO> selectByExample(DoctorDOExample example);

    DoctorDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DoctorDO record, @Param("example") DoctorDOExample example);

    int updateByExample(@Param("record") DoctorDO record, @Param("example") DoctorDOExample example);

    int updateByPrimaryKeySelective(DoctorDO record);

    int updateByPrimaryKey(DoctorDO record);
}