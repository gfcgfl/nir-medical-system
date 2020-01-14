package com.zju.medical.service;


import com.zju.medical.common.pojo.ReportMessage;

/**
 * @author xiaoguo
 */
public interface ReportService {


    /**
     * 根据用户id生成他的报告（pdf格式）
     * @param userId  用户的id
     * @return 报告的相关信息
     */
    ReportMessage createUserReportById(Integer userId);

//    /**
//     * 检查当前用户的报告是否已经存在
//     * @param userId
//     * @return
//     */
//    ReportMessage checkExist(Integer userId);
}
