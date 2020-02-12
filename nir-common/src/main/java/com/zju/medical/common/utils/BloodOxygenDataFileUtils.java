package com.zju.medical.common.utils;

import com.zju.medical.common.pojo.ChannelData;
import com.zju.medical.common.pojo.ChannelDataAndMark;
import com.zju.medical.common.pojo.Mark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 操作血氧数据文件（串口接收后血氧数据然后保存的文件）的工具类
 * @author xiaoguo
 */
public class BloodOxygenDataFileUtils {

    // 通道间分隔符通过若干个一下字符组成
    private static String CHANNEL_DATA_DELIMITER = "=";

    /**
     * 返回bloodOxygenDataFile血氧数据文件中的第一个有效通道的数据，没有有效通道的时候返回null
     * @param bloodOxygenDataFile
     * @return
     */
    public static ChannelDataAndMark getFirstValidChannelData(File bloodOxygenDataFile) {

        List<ChannelData> channelsData = new LinkedList<>();
        List<Mark> marks = new LinkedList<>();
        try(
                FileReader fileReader = new FileReader(bloodOxygenDataFile);
                BufferedReader reader = new BufferedReader(fileReader)){
            int delimiterNum = 0;

            //跳过第一行
            String line = reader.readLine();

            while(true) {

                line = reader.readLine();
                if (line == null || line.endsWith("通道无数据") || line.trim().isEmpty()) {
                    continue;
                }
                if (line.startsWith(CHANNEL_DATA_DELIMITER)) {
                    delimiterNum++;
                    continue;
                }

                if (delimiterNum == 5) {
                    break;
                }

                // 说明是第一个有效通道的第一个数据行，直接在一个内循环中读取有效数据

                // frame用于指示是第几帧数据
                int frame = 0;
                int markId = 0;
                //2是年份的开头
                while(line.startsWith("2")) {
                    frame++;
                    String[] split = line.split(":\\s+");
                    String[] values = split[1].trim().split("\\s+");

                    String markName = null;
                    if (values.length == 6) {
                        //说明当前行有标记
                        markId++;
                        String[] markAndName = values[5].split(":");
                        if (markAndName.length > 2) {
                            // 正常情况下markAndName长度为2，但是也有可能出现  “mark1:A:读汉字开始”这种情况
                            // 需要将后面的连接起来作为markName
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i = 1; i < markAndName.length; i++) {
                                stringBuilder.append(markAndName[i]);
                            }
                            markName = stringBuilder.toString();
                        } else if (markAndName.length == 2){
                            markName = markAndName[1];
                        }
                        marks.add(new Mark(markId, frame, null, markName));
                    }

                    ChannelData channelData = new ChannelData(null,
                            frame,
                            Float.parseFloat(values[0]),
                            Float.parseFloat(values[1]),
                            Float.parseFloat(values[2]),
                            Float.parseFloat(values[3]),
                            Float.parseFloat(values[4]));
                    channelsData.add(channelData);
                    line = reader.readLine();

                }

                break;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        ChannelDataAndMark ret = new ChannelDataAndMark();
        if (!channelsData.isEmpty()) {
            ret.setChannelsData(channelsData);
        }
        if (!marks.isEmpty()) {
            ret.setMarks(marks);
        }
        return ret;
    }
}
