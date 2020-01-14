package com.zju.medical.service;


import com.zju.medical.common.pojo.vo.TaskDataAndMarkVO;
import com.zju.medical.common.pojo.xdo.*;
import com.zju.medical.common.result.ReturnResult;

public interface TaskService {

    ReturnResult<Integer> addTask(String whichTask, TaskDataAndMarkVO taskDataAndMark);

    //rey任务相关接口
    ReturnResult<Integer> addReyTask(ReyTaskDO reyTaskDO);

    ReturnResult<Integer> updateReyTaskById(ReyTaskDO reyTaskDO, int userId);

    ReturnResult<Integer> deleteReyTaskById(int userId);

    ReturnResult<ReyTaskDO> selectReyTaskById(int userId);

    //snap任务相关接口
    ReturnResult<Integer> addSnapTask(SnapTaskDO snapTaskDO);

    ReturnResult<Integer> updateSnapTaskById(SnapTaskDO snapTaskDO, int userId);

    ReturnResult<Integer> deleteSnapTaskById(int userId);

    ReturnResult<SnapTaskDO> selectSnapTaskById(int userId);

    //stroop任务相关接口
    ReturnResult<Integer> addStroopTask(StroopTaskDO stroopTaskDO);

    ReturnResult<Integer> updateStroopTaskById(StroopTaskDO stroopTaskDO, int userId);

    ReturnResult<Integer> deleteStroopTaskById(int userId);

    ReturnResult<StroopTaskDO> selectStroopTaskById(int userId);

    //word任务相关接口
    ReturnResult<Integer> addWordTask(WordTaskDO wordTaskDO);

    ReturnResult<Integer> updateWordTaskById(WordTaskDO wordTaskDO, int userId);

    ReturnResult<Integer> deleteWordTaskById(int userId);

    ReturnResult<WordTaskDO> selectWordTaskById(int userId);

    // resting任务接口
    ReturnResult<Integer> addRestingTask(RestingTaskDO restingTaskDO);


    //根据数据情况自动判断添加还是更新
    ReturnResult<Integer> addOrUpdateReyTask(ReyTaskDO reyTaskDO, int userId);

    ReturnResult<Integer> addOrUpdateSnapTask(SnapTaskDO snapTaskDO, int userId);

    ReturnResult<Integer> addOrUpdateStroopTask(StroopTaskDO stroopTaskDO, int userId);

    ReturnResult<Integer> addOrUpdateWordTask(WordTaskDO wordTaskDO, int userId);

}
