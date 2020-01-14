package com.zju.medical.service.impl;


import com.zju.medical.common.pojo.bo.AdhdTypeStatisticsBO;
import com.zju.medical.common.pojo.bo.DataStaticsBO;
import com.zju.medical.common.pojo.xdo.*;
import com.zju.medical.common.result.ResultCodeEnum;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.dao.mapper.*;
import com.zju.medical.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xiaoguo
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Autowired
    private ClinicalInfoMapper clinicalInfoMapper;

    @Autowired
    private ReyTaskMapper reyTaskMapper;

    @Autowired
    private SnapTaskMapper snapTaskMapper;

    @Autowired
    private StroopTaskMapper stroopTaskMapper;

    @Autowired
    private WordTaskMapper wordTaskMapper;

    /**
     * 添加用户
     * @param userDo
     * @return
     */
    @Override
    public ReturnResult<Integer> saveUser(UserDO userDo) {
        try{
            Date date = new Date();
            userDo.setCreateTime(date);
            userDo.setUpdateTime(date);
            userMapper.insertSelective(userDo);
            int userId = userDo.getId();

            //添加数据关联路径至数据库中
            String dataPath1 = userId + "xx1";
            String dataPath2 = userId + "xx2";
            String dataPath3 = userId + "xx3";
            BloodOxygenDO bloodOxygenDO = new BloodOxygenDO();
            bloodOxygenDO.setCreateTime(new Date());
            bloodOxygenDO.setDataPath1(dataPath1);
            bloodOxygenDO.setDataPath2(dataPath2);
            bloodOxygenDO.setDataPath3(dataPath3);
            bloodOxygenDO.setUserId(userId);
            bloodOxygenMapper.insertSelective(bloodOxygenDO);

            return new ReturnResult<>(ResultCodeEnum.SUCCESS, userId);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }


    /**
     * 获取所有的用户的数据
     * @return
     */
    @Override
    public List<UserDO> listAllUsers() {
        UserDOExample example = new UserDOExample();
        example.setOrderByClause("id DESC");
        return userMapper.selectByExample(example);
    }

    @Override
    public ReturnResult<List<UserDO>> listUsersByCondition(String number, String dateStart, String dateEnd) {
        try{
            UserDOExample example = new UserDOExample();
            UserDOExample.Criteria criteria = example.createCriteria();
            if (!number.equals("undefined") || StringUtils.isEmpty(number)){
                criteria.andHNumberEqualTo(Integer.valueOf(number));
            }
            if ((!dateStart.equals("undefined") || StringUtils.isEmpty(dateStart) &&
                    (!dateEnd.equals("undefined") || StringUtils.isEmpty(dateEnd)))){

                DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = format1.parse(dateStart);
                DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date2 = format2.parse(dateEnd);
                criteria.andCreateTimeBetween(date1, date2);
            }
            example.setOrderByClause("id DESC");
            List<UserDO> userDOS = userMapper.selectByExample(example);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, userDOS);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    /**根据用户id更新
     * @param userDo
     * @param userId
     */
    @Override
    public void updateUserByUserId(UserDO userDo, Integer userId) {

        //userDo.setId(userId)
        userDo.setId(null);
        //null的话createTime就不会修改
        userDo.setCreateTime(null);

        userDo.setUpdateTime(new Date());
        UserDOExample example = new UserDOExample();
        UserDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);
        userMapper.updateByExampleSelective(userDo, example);
    }

    @Override
    public UserDO selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public ReturnResult<DataStaticsBO> fetchStaticsData() {
        try{
            //统计数据的返回
            AdhdTypeStatisticsBO adhdTypeStatisticsBO = userMapper.countEveryAdhdType();
            int unlabel = adhdTypeStatisticsBO.getAll() - adhdTypeStatisticsBO.getAdhdNormal() - adhdTypeStatisticsBO.getAdhdC()
                    - adhdTypeStatisticsBO.getAdhdHI() - adhdTypeStatisticsBO.getAdhdI();
            DataStaticsBO dataStaticsVO = new DataStaticsBO(unlabel, adhdTypeStatisticsBO.getAdhdI(), adhdTypeStatisticsBO.getAdhdHI(),
                    adhdTypeStatisticsBO.getAdhdC(), adhdTypeStatisticsBO.getAdhdNormal());

            return new ReturnResult<>(ResultCodeEnum.SUCCESS, dataStaticsVO);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> updateAdhdTypeById(int adhdType, int userId) {
        try{
            UserDOExample example = new UserDOExample();
            UserDOExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(userId);
            UserDO userDO = new UserDO();
            userDO.setAdhdType(adhdType);
            int result = userMapper.updateByExampleSelective(userDO, example);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, result);
        }catch(Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }

    }

    @Override
    public ReturnResult<Integer> deleteById(int id, int userId) {
        try{

            // 先删除rey表
            ReyTaskDOExample reyTaskDOExample = new ReyTaskDOExample();
            ReyTaskDOExample.Criteria criteria1 = reyTaskDOExample.createCriteria();
            criteria1.andUserIdEqualTo(userId);
            reyTaskMapper.deleteByExample(reyTaskDOExample);
            // 删除snap表
            SnapTaskDOExample snapTaskDOExample = new SnapTaskDOExample();
            SnapTaskDOExample.Criteria criteria2 = snapTaskDOExample.createCriteria();
            criteria2.andUserIdEqualTo(userId);
            snapTaskMapper.deleteByExample(snapTaskDOExample);
            // 删除stroop
            StroopTaskDOExample stroopTaskDOExample = new StroopTaskDOExample();
            StroopTaskDOExample.Criteria criteria3 = stroopTaskDOExample.createCriteria();
            criteria3.andUserIdEqualTo(userId);
            stroopTaskMapper.deleteByExample(stroopTaskDOExample);
            // 删除word
            WordTaskDOExample wordTaskDOExample = new WordTaskDOExample();
            WordTaskDOExample.Criteria criteria4 = wordTaskDOExample.createCriteria();
            criteria4.andUserIdEqualTo(userId);
            wordTaskMapper.deleteByExample(wordTaskDOExample);
            // 删除clinicalinfo
            ClinicalInfoDOExample clinicalInfoDOExample = new ClinicalInfoDOExample();
            ClinicalInfoDOExample.Criteria criteria5 = clinicalInfoDOExample.createCriteria();
            criteria5.andUserIdEqualTo(userId);
            clinicalInfoMapper.deleteByExample(clinicalInfoDOExample);
            BloodOxygenDOExample bloodOxygenDOExample = new BloodOxygenDOExample();
            BloodOxygenDOExample.Criteria criteria6 = bloodOxygenDOExample.createCriteria();
            criteria6.andUserIdEqualTo(userId);
            bloodOxygenMapper.deleteByExample(bloodOxygenDOExample);

            UserDOExample example = new UserDOExample();
            UserDOExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            userMapper.deleteByPrimaryKey(id);

            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        }catch (Exception e){
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }
}
