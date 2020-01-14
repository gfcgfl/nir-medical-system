package com.zju.medical.common.pojo;

import lombok.Data;

/**
 * @author xiaoguo
 */
@Data
public class ReportMessage {

    /**
     * 报告是否生成成功
     */
    private Boolean created;

    /**
     * 报告的存放的绝对路径
     */
    private String absPath;

    /**
     * 报告的相对classpath的路径
     */
    private String relativePath;
    /**
     * 报告的文件名
     */
    private String reportName;
}
