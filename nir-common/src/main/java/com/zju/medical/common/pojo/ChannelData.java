package com.zju.medical.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 某个通道 在某一时刻采集到的数据
 * @author xiaoguo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelData {

    private Date time;

    private Integer frameNum;

    private Float toi;

    private Float tHi;

    private Float dHb;

    private Float dHbO2;

    private Float dtHb;


}
