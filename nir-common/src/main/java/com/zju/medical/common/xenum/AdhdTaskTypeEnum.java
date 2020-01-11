package com.zju.medical.common.xenum;

import lombok.Getter;

import static com.zju.medical.common.constant.AdhdTaskConstant.*;


@Getter
public enum AdhdTaskTypeEnum {

    //Rey复杂图形记忆任务
    REY_COMPLEX_FIGURE_MEMORY_TASK("Rey复杂图形记忆任务", REY_COMPLEX_FIGURE_MEMORY),

    //数字字母连线测验
    DIGIT_ALPHABET_LINKING_TASK("数字字母连线测验", DIGIT_ALPHABET_LINKING),

    //Stroop色词命名任务
    STROOP_COLOR_WORDS_TASK("Stroop色词命名任务", STROOP_COLOR_WORDS),

    SNAP("斯诺佩评估量表", SNAP_SCORE);

    /**
     * 任务的中文名称
     */
    private String taskChineseName;

    /**
     * 任务标识符
     */
    private String taskIdentifier;

    AdhdTaskTypeEnum(String taskChineseName, String taskIdentifier) {
        this.taskChineseName = taskChineseName;
        this.taskIdentifier = taskIdentifier;
    }
}