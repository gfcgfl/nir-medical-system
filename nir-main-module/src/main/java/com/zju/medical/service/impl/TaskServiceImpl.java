package com.zju.medical.service.impl;

import com.zju.medical.common.pojo.vo.*;
import com.zju.medical.common.pojo.xdo.*;
import com.zju.medical.common.result.ResultCodeEnum;
import com.zju.medical.common.result.ReturnResult;
import com.zju.medical.dao.mapper.ReyTaskMapper;
import com.zju.medical.dao.mapper.SnapTaskMapper;
import com.zju.medical.dao.mapper.StroopTaskMapper;
import com.zju.medical.dao.mapper.WordTaskMapper;
import com.zju.medical.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

import static com.zju.medical.common.constant.AdhdTaskConstant.*;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    ReyTaskMapper reyTaskMapper;

    @Autowired
    SnapTaskMapper snapTaskMapper;

    @Autowired
    StroopTaskMapper stroopTaskMapper;

    @Autowired
    WordTaskMapper wordTaskMapper;



    @Override
    public ReturnResult<Integer> addTask(String whichTask, TaskDataAndMarkVO taskDataAndMark) {
        ReturnResult<Integer> result = null;
        switch (whichTask) {
            case REY_COMPLEX_FIGURE_MEMORY: {
                ReyTaskVO task1 = taskDataAndMark.getTask1();
                ReyTaskDO target = new ReyTaskDO();
                BeanUtils.copyProperties(task1, target);
                result = this.addReyTask(target);
                break;
            }
            case DIGIT_ALPHABET_LINKING: {
                // 数字字母连线任务也就是 word task
                WordTaskVO task2 = taskDataAndMark.getTask2();
                WordTaskDO target = new WordTaskDO();
                BeanUtils.copyProperties(task2, target);
                result = this.addWordTask(target);
                break;
            }
            case STROOP_COLOR_WORDS: {
                StroopTaskVO task3 = taskDataAndMark.getTask3();
                StroopTaskDO target = new StroopTaskDO();
                BeanUtils.copyProperties(task3, target);
                result = this.addStroopTask(target);
                break;
            }
            case RESTING_STATE: {
                // task quiet也就是resting task
                RestingTaskVO taskQuiet = taskDataAndMark.getTaskQuiet();
                RestingTaskDO target = new RestingTaskDO();
                BeanUtils.copyProperties(taskQuiet, target);
                result = this.addRestingTask(target);
                break;
            }
            case SNAP_SCORE: {
                result = ReturnResult.FAILED;
                break;
            }
            default: {
                result = ReturnResult.FAILED;
                break;
            }
        }
        return result;
    }


    @Override
    public ReturnResult<Integer> addReyTask(ReyTaskDO reyTaskDO) {
        try {
            Date date = new Date();
            reyTaskDO.setCreateTime(date);
            int result = reyTaskMapper.insertSelective(reyTaskDO);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> updateReyTaskById(ReyTaskDO reyTaskDO, int userId) {
        try {
            ReyTaskDOExample example = new ReyTaskDOExample();
            ReyTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = reyTaskMapper.updateByExampleSelective(reyTaskDO, example);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> deleteReyTaskById(int userId) {
        try {
            ReyTaskDOExample example = new ReyTaskDOExample();
            ReyTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            reyTaskMapper.deleteByExample(example);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<ReyTaskDO> selectReyTaskById(int userId) {
        try {
            ReyTaskDOExample example = new ReyTaskDOExample();
            ReyTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<ReyTaskDO> reyTaskDOList = reyTaskMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(reyTaskDOList)) {
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            } else {
                return new ReturnResult<>(ResultCodeEnum.SUCCESS, reyTaskDOList.get(0));
            }
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addSnapTask(SnapTaskDO snapTaskDO) {
        try {
            Date date = new Date();
            snapTaskDO.setCreateTime(date);
            int result = snapTaskMapper.insertSelective(snapTaskDO);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> updateSnapTaskById(SnapTaskDO snapTaskDO, int userId) {
        try {
            SnapTaskDOExample example = new SnapTaskDOExample();
            SnapTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = snapTaskMapper.updateByExampleSelective(snapTaskDO, example);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> deleteSnapTaskById(int userId) {
        try {
            SnapTaskDOExample example = new SnapTaskDOExample();
            SnapTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            snapTaskMapper.deleteByExample(example);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<SnapTaskDO> selectSnapTaskById(int userId) {
        try {
            SnapTaskDOExample example = new SnapTaskDOExample();
            SnapTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<SnapTaskDO> snapTaskDOList = snapTaskMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(snapTaskDOList)) {
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, snapTaskDOList.get(0));
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addStroopTask(StroopTaskDO stroopTaskDO) {
        try {
            Date date = new Date();
            stroopTaskDO.setCreateTime(date);
            int result = stroopTaskMapper.insertSelective(stroopTaskDO);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> updateStroopTaskById(StroopTaskDO stroopTaskDO, int userId) {
        try {
            StroopTaskDOExample example = new StroopTaskDOExample();
            StroopTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = stroopTaskMapper.updateByExampleSelective(stroopTaskDO, example);
            if (result < 0) return new ReturnResult<>(ResultCodeEnum.FAIL);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> deleteStroopTaskById(int userId) {
        try {
            StroopTaskDOExample example = new StroopTaskDOExample();
            StroopTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = stroopTaskMapper.deleteByExample(example);
            if (result < 0) return new ReturnResult<>(ResultCodeEnum.FAIL);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<StroopTaskDO> selectStroopTaskById(int userId) {
        try {
            StroopTaskDOExample example = new StroopTaskDOExample();
            StroopTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<StroopTaskDO> stroopTaskDOList = stroopTaskMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(stroopTaskDOList)) {
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, stroopTaskDOList.get(0));
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addWordTask(WordTaskDO wordTaskDO) {
        try {
            Date date = new Date();
            wordTaskDO.setCreateTime(date);
            int result = wordTaskMapper.insertSelective(wordTaskDO);
            if (result < 0) {
                return new ReturnResult<>(ResultCodeEnum.FAIL);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> updateWordTaskById(WordTaskDO wordTaskDO, int userId) {
        try {
            WordTaskDOExample example = new WordTaskDOExample();
            WordTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = wordTaskMapper.updateByExampleSelective(wordTaskDO, example);
            if (result < 0) return new ReturnResult<>(ResultCodeEnum.FAIL);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> deleteWordTaskById(int userId) {
        try {
            WordTaskDOExample example = new WordTaskDOExample();
            WordTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            int result = wordTaskMapper.deleteByExample(example);
            if (result < 0) return new ReturnResult<>(ResultCodeEnum.FAIL);
            return new ReturnResult<>(ResultCodeEnum.SUCCESS);
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<WordTaskDO> selectWordTaskById(int userId) {
        try {
            WordTaskDOExample example = new WordTaskDOExample();
            WordTaskDOExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<WordTaskDO> wordTaskDOList = wordTaskMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(wordTaskDOList)) {
                return new ReturnResult<>(ResultCodeEnum.EMPTY_RESULT);
            }
            return new ReturnResult<>(ResultCodeEnum.SUCCESS, wordTaskDOList.get(0));
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addRestingTask(RestingTaskDO restingTaskDO) {

        //不进行实质性的插入，象征性的返回 success
        return new ReturnResult<>(ResultCodeEnum.SUCCESS);

    }



    @Override
    public ReturnResult<Integer> addOrUpdateReyTask(ReyTaskDO reyTaskDO, int userId) {
        try {
            if (selectReyTaskById(userId).getData() != null) {
                return updateReyTaskById(reyTaskDO, userId);
            } else {
                reyTaskDO.setUserId(userId);
                return addReyTask(reyTaskDO);
            }
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addOrUpdateSnapTask(SnapTaskDO snapTaskDO, int userId) {
        try {
            if (selectSnapTaskById(userId).getData() != null) {
                return updateSnapTaskById(snapTaskDO, userId);
            } else {
                snapTaskDO.setUserId(userId);
                return addSnapTask(snapTaskDO);
            }
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addOrUpdateStroopTask(StroopTaskDO stroopTaskDO, int userId) {
        try {
            if (selectStroopTaskById(userId).getData() != null) {
                return updateStroopTaskById(stroopTaskDO, userId);
            } else {
                stroopTaskDO.setUserId(userId);
                return addStroopTask(stroopTaskDO);
            }
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }

    @Override
    public ReturnResult<Integer> addOrUpdateWordTask(WordTaskDO wordTaskDO, int userId) {
        try {
            if (selectWordTaskById(userId).getData() != null) {
                return updateWordTaskById(wordTaskDO, userId);
            } else {
                wordTaskDO.setUserId(userId);
                return addWordTask(wordTaskDO);
            }
        } catch (Exception e) {
            return new ReturnResult<>(ResultCodeEnum.FAIL);
        }
    }
}
