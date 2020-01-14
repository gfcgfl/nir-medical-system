package com.zju.medical.common.pojo.bo;

import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import lombok.Data;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xiaoguo
 */
@Data
public class ReportDataBO {

    private Integer userId;

    private Integer userAge;


    /**
     * 每个任务的得分信息
     */
    private Map<AdhdTaskTypeEnum, ScoreInfoForTask> taskScoreInfo;

    /**
     * 存储每个任务的血氧数据
     */
    private Map<AdhdTaskTypeEnum, BloodOxygenInfoForTask> taskBloodOxygenInfo;


    /**
     * 单个任务的血样数据
     */
    @Data
    public static class BloodOxygenInfoForTask {

        /**
         * 这里存储的是任务的血氧数据文件的绝对路径
         */
        private String filePath;
    }

    /**
     * 单个任务的得分信息
     */
    @Data
    public static class ScoreInfoForTask {
        /**
         * 任务数据生成时间
         */
        private Date taskDate;

        /**
         * key： 得分项
         * value：分值
         */
        private LinkedHashMap<String, Integer> scoreMap;



        public void addScore(String item, Integer score) {
            if (this.scoreMap == null) {
                this.scoreMap = new LinkedHashMap<>();
            }
            this.scoreMap.put(item, score);
        }
    }
}
