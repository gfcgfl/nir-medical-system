package com.zju.medical.common.pojo;

import lombok.Data;

/**
 * @author xiaoguo
 */
@Data
public class Header {

    private Byte recordType;

    private Byte channel;

    private Short year;

    private Byte month;

    private Byte day;

    private Byte hour;

    private Byte minute;

    private Byte second;

    private Byte[] channelWarning;

    private Short[][][] intensity;
}