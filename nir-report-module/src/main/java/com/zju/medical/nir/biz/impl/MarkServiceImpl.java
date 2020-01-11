package com.zju.medical.nir.biz.impl;

import com.zju.medical.common.pojo.Mark;
import com.zju.medical.nir.biz.MarkService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
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
    final static String rePatten = "\\d+/\\d+/\\d+ \\d+:\\d+:\\d+.*?";

    @Override
    public String doMark(List<Mark> marks, File file) {

        File infile = file;
        File outfile = new File(infile.getParent(), "marked" + infile.getName());
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

                if (temp.matches(rePatten)) {
                    for (Mark mark : marksToMark) {
                        if (temp.indexOf(mark.getMarkTime()) != -1) {
                            outTemp.append("\t\tmark" + mark.getMarkId() + ":" + mark.getMarkName());
                        }
                    }
                }
                bw.write(outTemp.toString());
                bw.newLine();
                temp = br.readLine();
            }

            br.close();
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
