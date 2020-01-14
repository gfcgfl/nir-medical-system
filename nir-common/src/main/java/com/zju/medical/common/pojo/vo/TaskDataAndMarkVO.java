package com.zju.medical.common.pojo.vo;

import com.zju.medical.common.pojo.Mark;
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
public class TaskDataAndMarkVO {
    public List<Mark> marks;
    public int taskId;
    public ReyTaskVO task1;
    public WordTaskVO task2;
    public StroopTaskVO task3;
    public RestingTaskVO taskQuiet;
    public SnapTaskVO task5;

    public int userId;
}
