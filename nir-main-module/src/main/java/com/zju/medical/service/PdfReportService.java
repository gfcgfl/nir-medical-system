package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.ReportDataBO;

/**
 * @author xiaoguo
 */
public interface PdfReportService {

    /**
     * 生成报告
     * @param reportDataBO
     * @return
     */
    public String createPdf(ReportDataBO reportDataBO);

}
