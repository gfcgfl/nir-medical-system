package com.zju.medical.service;


import com.zju.medical.common.pojo.bo.ReportDataBO;

/**
 * @author xiaoguo
 */
public interface PdfReportService {

    /**
     * 生成报告
     * 所需要实现的是   给定pdf数据ReportDataBO 生成pdf 存储在pdf存储目录中， 然后返回pdf文件路径
     * @param reportDataBO
     * @return
     */
    public String createPdf(ReportDataBO reportDataBO);

}
