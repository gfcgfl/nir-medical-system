package com.zju.medical.common.pojo;

import com.zju.medical.common.pojo.xdo.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Data
@NoArgsConstructor
public class TaskDataAndMark {
    public List<Mark> marks;
    public int taskId;
    public ReyTaskDO task1;
    public WordTaskDO task2;
    public StroopTaskDO task3;
    public SnapTaskDO task4;
    public RestingTaskDO taskQuiet;
    public int userId;
}
