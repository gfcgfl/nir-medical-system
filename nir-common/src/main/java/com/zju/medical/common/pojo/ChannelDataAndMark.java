package com.zju.medical.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiaoguo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDataAndMark {

    private List<ChannelData> channelsData;

    /**
     * 为null或者为空说明不存在标记
     */
    private List<Mark> marks;
}
