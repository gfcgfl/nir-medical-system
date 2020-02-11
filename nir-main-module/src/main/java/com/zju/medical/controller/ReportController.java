package com.zju.medical.controller;

import com.zju.medical.common.pojo.ReportMessage;
import com.zju.medical.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */

@Controller
public class ReportController {
    @Autowired
    private ReportService reportService;


    @GetMapping("/report")
    public void getReportById(Integer userId, HttpServletResponse response) {


        ReportMessage reportMessage = reportService.createUserReportById(userId);

        // todo 重定向到pdf的报告
        if (reportMessage.getCreated()) {
            try {
                response.sendRedirect(reportMessage.getRelativePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
