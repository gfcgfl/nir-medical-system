package com.zju.medical.common.constant;

/**
 * @author xiaoguo
 */
public class BloodOxygenDataConstant {

    /**
     * excel文件扩展名 .xls
     */
    public static final String EXCEL_FILE_EXT_NAME_XLS = ".xls";

    /**
     * excel文件扩展名 .xlsx
     */
    public static final String EXCEL_FILE_EXT_NAME_XLSX = ".xlsx";

    /**
     * txt文件扩展名
     */
    public static final String TEXT_FILE_EXT_NAME = ".txt";
    /**
     * txt文件扩展名
     */
    public static final String BIN_FILE_EXT_NAME = ".BIN";

    /**
     * excel文件中的特殊分隔符组成的正则表达式  用于将文件名split
     */
    public static final String EXCEL_FILE_NAME_SPECIAL_SEPARATION_REGEX = "[#-\\.]";

    /**
     * excel文件名被特殊分隔符分开后共有几部分
     */
    public static final int EXCEL_FILE_NAME_PART_NUM = 4;

    /**
     * excel文件相对于servlet context的相对路径 文件夹名称
     */
    public static final String EXCEL_FILE_RELATIVE_DIR = "/excel";
    /**
     * text文件相对于servlet context的相对路径 文件夹名称
     */
    public static final String TEXT_FILE_RELATIVE_DIR = "/text";

    /**
     * 下面两个表明 解析excel中的通道数据的时间信息时  从一个sheet的哪个起始位置（行号，列号）开始矩形区域的数据获取
     */
    public static final int EXCEL_PARSE_TIME_START_ROW_NUMBER = 0;
    public static final int EXCEL_PARSE_TIME_START_COL_NUMBER = 0;

    /**
     * 下面两个表明在excel中获取通道数据的时间信息时，矩形数据区域的行数和列数：  -1 表示所有行或者列
     */
    public static final int EXCEL_PARSE_TIMET_ROW_LEHGTH = -1;
    public static final int EXCEL_PARSE_TIMET_COL_LEHGTH = 1;

    /**
     * 下面两个表明 解析excel中的通道数据的具体参数信息时  从一个sheet的哪个起始位置（行号，列号）开始矩形区域的数据获取
     */
    public static final int EXCEL_PARSE_CHANNEL_DATA_START_ROW_NUMBER = 0;
    public static final int EXCEL_PARSE_CHANNEL_DATA_START_COL_NUMBER = 7;

    /**
     * 下面两个表明在excel中获取通道数据的具体参数信息时，矩形数据区域的行数和列数：  -1 表示所有行或者列
     * EXCEL_PARSE_CHANNEL_DATA_COL_LEHGTH = 5 是因为 有五个参数信息  (不包括mark)
     */
    public static final int EXCEL_PARSE_CHANNEL_DATA_ROW_LEHGTH = -1;
    public static final int EXCEL_PARSE_CHANNEL_DATA_COL_LEHGTH = 5;


}
