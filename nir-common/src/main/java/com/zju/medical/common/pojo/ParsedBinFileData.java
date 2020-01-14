package com.zju.medical.common.pojo;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author xiaoguo
 */

@Data
public class ParsedBinFileData {

    /**
     * 门诊部门的名称
     */
//    private String departmentName;

    /**
     * 患者名字
     */
//    private String userName;


    /**
     * 仪器开始工作的时间
     */
    private Date machineStartTime;

    /**
     * 仪器结束工作的时间
     */
    private Date machineEndTime;

    /**
     * 有效数据的起始时间
     */
    private Date validDateStartTime;
    /**
     * 有效数据的结束时间
     */
    private Date validDateEndTime;


    private LinkedList<ChannelData> channel1Data;

    private LinkedList<ChannelData> channel2Data;

    private LinkedList<ChannelData> channel3Data;

    private LinkedList<ChannelData> channel4Data;


    {
        channel1Data = new LinkedList<>();
        channel2Data = new LinkedList<>();
        channel3Data = new LinkedList<>();
        channel4Data = new LinkedList<>();
    }

}
