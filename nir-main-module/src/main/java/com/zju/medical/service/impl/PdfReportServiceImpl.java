package com.zju.medical.service.impl;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.zju.medical.common.constant.ReportConstant;
import com.zju.medical.common.pojo.ChannelDataAndMark;
import com.zju.medical.common.pojo.Mark;
import com.zju.medical.common.pojo.bo.ReportDataBO;
import com.zju.medical.common.utils.BloodOxygenDataFileUtils;
import com.zju.medical.common.utils.FileUtils;
import com.zju.medical.common.utils.PdfFontUtils;
import com.zju.medical.common.xenum.AdhdTaskTypeEnum;
import com.zju.medical.config.ReportImageConfig;
import com.zju.medical.service.BloodOxygenWaveformImgService;
import com.zju.medical.service.PdfReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.zju.medical.common.pojo.bo.ReportDataBO.BloodOxygenInfoForTask;

/**
 * @author xiaoguo
 */
@Service
public class PdfReportServiceImpl implements PdfReportService {

    private static final Logger logger = LoggerFactory.getLogger(PdfReportServiceImpl.class);

    @Autowired
    private BloodOxygenWaveformImgService waveformImgService;

    @Autowired
    private ReportImageConfig reportImageConfig;

    /**
     * pdf报告 相关的常量 {@link com.zju.medical.common.constant.ReportConstant}
     * pdf所需数据形式 暂定为 {@link com.zju.medical.common.pojo.bo.ReportDataBO}
     * <p>
     * todo 所需要实现的接口是   给定pdf数据ReportDataBO 生成pdf 存储在pdf存储目录中， 然后返回pdf文件路径
     */

    @Override
    public String createPdf(ReportDataBO reportDataBO) {

        Map<AdhdTaskTypeEnum, BloodOxygenInfoForTask> taskBloodOxygenInfo
                = reportDataBO.getTaskBloodOxygenInfo();

        // 获取每个任务的第一个有效通道的数据及其mark信息
        Map<AdhdTaskTypeEnum, ChannelDataAndMark> taskChannelDataAndMark = new HashMap<>(10);
        for (Map.Entry<AdhdTaskTypeEnum, BloodOxygenInfoForTask> entry : taskBloodOxygenInfo.entrySet()) {
            // 获取数据文件路径
            String dataFilePath = entry.getValue().getFilePath();
            if (StringUtils.isEmpty(dataFilePath)) {
                continue;
            }
            File bloodOxygenDataFile = new File(dataFilePath);
            // 获取到当前任务第一个有效通道的数据及mark信息
            ChannelDataAndMark dataAndMark
                    = BloodOxygenDataFileUtils.getFirstValidChannelData(bloodOxygenDataFile);
            taskChannelDataAndMark.put(entry.getKey(), dataAndMark);
        }

        // 画图并保存
        Map<AdhdTaskTypeEnum, List<String>> imgMap = waveformImgService.createImgFile(
                taskChannelDataAndMark,
                reportDataBO.getUserId().toString(),
                reportImageConfig);

        //创建pdf文件
        File pdfDir = new File(ReportConstant.CLASSPATH, ReportConstant.PDF_FILE_SAVE_PATH);
        FileUtils.createDirectory(pdfDir);
        FileOutputStream file = null;
        String filePath = new File(pdfDir, reportDataBO.getUserId() + ".pdf").getAbsolutePath();
        try {
            file = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            logger.error("文件路径有问题");
            return null;
        }

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, file);
            document.open();

            /*
            首页
             */
            document.add(PdfFontUtils.getFont(1, "血氧报告"));

            document.add(PdfFontUtils.getFont(3, "基本信息"));
            document.add(PdfFontUtils.getFont(6, "姓名：" + reportDataBO.getUserId().toString()));
            document.add(PdfFontUtils.getFont(6, "年龄：" + reportDataBO.getUserAge().toString()));

            document.add(PdfFontUtils.getFont(3, "得分信息"));

            for (Map.Entry<AdhdTaskTypeEnum, List<String>> entry : imgMap.entrySet()) {
                AdhdTaskTypeEnum taskType = entry.getKey();
                ReportDataBO.ScoreInfoForTask scoreInfoForTask = reportDataBO.getTaskScoreInfo().get(taskType);
                if (scoreInfoForTask != null) {
                    document.add(PdfFontUtils.getFont(6, taskType.getTaskChineseName() + "得分："));
                    document.add(PdfFontUtils.getFont(6, scoreInfoForTask.getScoreMap().toString()));
                }
            }

            /*
            任务波形
             */
            for (Map.Entry<AdhdTaskTypeEnum, List<String>> entry : imgMap.entrySet()) {
                AdhdTaskTypeEnum taskType = entry.getKey();
                List<String> imgList = entry.getValue();

                //if (null == imgList.get(0))  continue;
                //该通道无效

                document.newPage();
                document.add(PdfFontUtils.getFont(2, taskType.getTaskChineseName()));

                //添加图片
                final float PAGE_WIDTH = document.getPageSize().getWidth();
                final float PAGE_HEIGHT = document.getPageSize().getHeight();
                for (int i = 0; i < ReportConstant.IMG_NUM; i++) {
                    Image image = Image.getInstance(imgList.get(i));
                    image.setAlignment(Image.ALIGN_CENTER);
                    image.scaleToFit( PAGE_WIDTH, (PAGE_HEIGHT-200) / 5);
                    document.add(image);
                }

                //标注信息
                if(null != taskChannelDataAndMark.get(taskType).getMarks()) {
                    StringBuffer sb = new StringBuffer("标注信息:");
                    for (Mark mark : taskChannelDataAndMark.get(taskType).getMarks()) {
                        sb.append("["+mark.getMarkId() + "]" + mark.getMarkName()+"; ");
                    }
                    document.add(PdfFontUtils.getFont(6,sb.toString()));
                }
            }
            document.close();

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            logger.error("输出pdf文件失败");
            return null;
        }

        return filePath;

    }

}
