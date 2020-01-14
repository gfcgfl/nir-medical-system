package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.vo.DoctorVO;
import com.zju.medical.common.pojo.xdo.DoctorDO;
import com.zju.medical.common.pojo.xdo.DoctorDOExample;
import com.zju.medical.common.result.ResultCodeEnum;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.dao.mapper.DoctorMapper;
import com.zju.medical.service.DoctorLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class DoctorLoginServiceImpl implements DoctorLoginService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public ReturnResult<Integer> login(String username, String password) {
        DoctorDOExample example = new DoctorDOExample();
        DoctorDOExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<DoctorDO> doctorDoList = doctorMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(doctorDoList)){
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, 1);
        }
        DoctorDO doctorDO = doctorDoList.get(0);
        if (!doctorDO.getPassword().equals(password)){
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, 1);
        }
        return new ReturnResult<>(ResultCodeEnum.SUCCESS, 0);
    }

    @Override
    public ReturnResult<List<DoctorDO>> selectList() {
        try{
            DoctorDOExample doctorDOExample = new DoctorDOExample();
            //获取全部的医生用户数据
            List<DoctorDO> doctorDOList = doctorMapper.selectByExample(doctorDOExample);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, doctorDOList);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Boolean> addUser(DoctorVO doctorVO) {
        try{
            DoctorDO doctorDO = new DoctorDO();
            doctorDO.setUsername(doctorVO.getUsername());
            doctorDO.setPassword(doctorVO.getPassword());
            doctorMapper.insert(doctorDO);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, Boolean.TRUE);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Boolean> deleteUserById(Integer id) {
        try{
            doctorMapper.deleteByPrimaryKey(id);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, Boolean.TRUE);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }
}
