package com.zju.medical.common.pojo;

import com.zju.medical.common.pojo.vo.*;
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
    public SnapTaskVO task4;
    public RestingTaskVO taskQuiet;
    public int userId;
}
