package com.zju.medical.web.controller;

import com.zju.medical.nir.biz.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report/{id}")
    public void getReportById(@PathVariable Integer userId) {

        String reportPath;
        reportPath = reportService.generateReport(userId);

        // todo 重定向到pdf的报告

    }

}
