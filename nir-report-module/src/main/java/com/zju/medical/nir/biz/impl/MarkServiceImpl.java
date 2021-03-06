package com.zju.medical.nir.biz.impl;

import com.zju.medical.common.pojo.Mark;
import com.zju.medical.nir.biz.MarkService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@Slf4j
@Service
public class MarkServiceImpl implements MarkService {

    private static final Logger logger = LoggerFactory.getLogger(MarkServiceImpl.class);
    private static final String rePattern = "\\d+/\\d+/\\d+ \\d+:\\d+:\\d+.*?";
    //时间格式
    public static final String formatterString = "yyyy/MM/dd HH:mm:ss";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatterString);

    @Override
    public String doMark(List<Mark> marks, File file) {

        //没有标记
        if (null == marks || marks.size() < 1) {
            return file.getAbsolutePath();
        }

        File infile = file;
        File outfile = new File(infile.getParent(), "marked-" + infile.getName());
        if (!infile.exists()) {
            logger.warn("数据文件不存在");
            return null;
        }
        if (!outfile.exists()) {
            try {
                outfile.createNewFile();
            } catch (IOException e) {
                logger.warn("创建文件失败");
                e.printStackTrace();
                return null;
            }
        }


        try {
            BufferedReader br = new BufferedReader(new FileReader(infile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
            String temp = br.readLine();
            List<Mark> marksToMark = new ArrayList<>(marks);
            while (temp != null) {
                StringBuffer outTemp = new StringBuffer(temp);

                //行后标记
//                if (temp.matches(rePattern)) {
//                    for (Mark mark : marksToMark) {
//                        if (temp.indexOf(mark.getMarkTime()) != -1) {
//                            outTemp.append("\t\tmark" + mark.getMarkId() + ":" + mark.getMarkName());
//                        }
//                    }
//                }

                if (temp.matches(rePattern)) {
                    LocalDateTime recordTime = LocalDateTime.parse(temp.substring(0,formatterString.length()), formatter);
                    for (Mark mark : marksToMark) {
                        LocalDateTime markTime = LocalDateTime.parse(mark.getMarkTime(), formatter);
                        Duration duration = Duration.between(recordTime,markTime);
                        if (!duration.isNegative() && duration.getSeconds()<=1) {
                            outTemp.append("\t\tmark" + mark.getMarkId() + ":" + mark.getMarkName());
                        }
                    }
                }



                bw.write(outTemp.toString());
                bw.newLine();
                temp = br.readLine();
            }

            br.close();

            //数据后标记
//            bw.write("标记列表:");
//            bw.newLine();
//            bw.write("id\t\tname\t\ttime");
//            bw.newLine();
//            for (Mark mark : marksToMark) {
//                bw.write(mark.getMarkId() + "\t\t" + mark.getMarkName() + "\t\t" + mark.getMarkTime());
//                bw.newLine();
//            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            logger.warn("mark失败");
            e.printStackTrace();
            return null;
        }

        infile.delete();
        return outfile.getAbsolutePath();
    }
}
