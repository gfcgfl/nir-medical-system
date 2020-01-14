package com.zju.medical.common.constant;

/**
 * @author xiaoguo
 */
public class BinFileConstant {

    public static final char HEADER_RECORD_TYPE_START0 = 0x11;
    public static final char HEADER_RECORD_TYPE_START1 = 0x12;
    public static final char HEADER_RECORD_TYPE_DATA = 0x21;
    public static final char HEADER_RECORD_TYPE_STOP = 0x52;
    /**
     * mark 头信息的record_type的上下限
     */
    public static final char HEADER_RECORD_TYPE_MARK_LOW_LIMIT = 0x30;
    public static final char HEADER_RECORD_TYPE_MARK_UP_LIMIT = 0x43;

    public static final int ONE_RECORD_HEADER_BYTE_LENGTH = 64;
    public static final int ONE_RECORD_DATA_BYTE_LENGTH = 80;
    public static final int ONE_RECORD_TOTAL_BYTE_LENGTH = ONE_RECORD_HEADER_BYTE_LENGTH + ONE_RECORD_DATA_BYTE_LENGTH;


    /**
     * department名称、患者信息在 数据体中 占据的字节数
     */
    public static final int DEPARTMENT_NAME_BYTE_LENGTH = 30;
    public static final int PATIENT_INFO_BYTE_LENGTH = 50;
}
