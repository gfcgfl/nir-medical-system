package com.zju.medical.common.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author xiaoguo
 */
@Data
public class BloodOxygenData {
    /**
     * 门诊部门的名称
     */
    private String departmentName;

    private Integer userId;
    /**
     * 患者名字
     */
    private String userName;


//    /**
//     * 仪器开始工作的时间
//     */
//    private Date machineStartTime;
//
//    /**
//     * 仪器结束工作的时间
//     */
//    private Date machineEndTime;

    /**
     * 有效数据的起始时间
     */
    private Date validDataStartTime;
    /**
     * 有效数据的结束时间
     */
    private Date validDataEndTime;

    private boolean[] channelUsed;

    private ArrayList<LinkedList<ChannelData>> fourChannelsData;


    {
        fourChannelsData = new ArrayList<>(4);
        fourChannelsData.add(null);
        fourChannelsData.add(null);
        fourChannelsData.add(null);
        fourChannelsData.add(null);
    }

    /**
     *向某个通道添加一个数据
     */
    public void addChannelData(int channel, ChannelData channelData) {
        LinkedList<ChannelData> data = fourChannelsData.get(channel);
        if (data == null) {
            data = new LinkedList<>();
            fourChannelsData.set(channel, data);
        }
        data.add(channelData);
    }

}
