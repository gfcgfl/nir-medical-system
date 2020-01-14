package com.zju.medical.common.utils;


//import com.itextpdf.text.log.Logger;
//import com.itextpdf.text.log.LoggerFactory;

import com.zju.medical.common.constant.BinFileConstant;
import com.zju.medical.common.pojo.BloodOxygenData;
import com.zju.medical.common.pojo.ChannelData;
import com.zju.medical.common.pojo.Header;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author xiaoguo
 */
public class BinFileUtils {

//    private static final Logger logger = LoggerFactory.getLogger(BinFileUtils.class);

    /**
     * 将bin文件解析
     *
     * @param binFile
     */
    public static BloodOxygenData parseBinFile(File binFile) {

        byte[] totalBytes = readToByteArray(binFile);

        BinFileParser parser = new BinFileParser(totalBytes);

        return parser.parse();
    }


    private static byte[] readToByteArray(File binFile) {
        FileInputStream fileInputStream = null;
        byte[] totalBytes = null;
        try {
            fileInputStream = new FileInputStream(binFile);
            totalBytes = new byte[fileInputStream.available()];
            fileInputStream.read(totalBytes);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return totalBytes;
    }


    private static int getInt(byte[] b, int index) {
        int l;
        l = b[index];
        l &= 0xff;
        l |= ((long) b[index + 1] << 8);
        l &= 0xffff;
        l |= ((long) b[index + 2] << 16);
        l &= 0xffffff;
        l |= ((long) b[index + 3] << 24);
        return l;
    }




    private static final class BinFileParser {

        private byte[] binFileBytes;

        /**
         * 表示处理了多少帧的通道数据
         */
        private int frameNum = 0;

        public BinFileParser(byte[] binFileBytes) {
            this.binFileBytes = binFileBytes;
        }

        /**
         * 执行解析的入口
         * @return
         */
        private BloodOxygenData parse() {
            int totalLength = this.binFileBytes.length;
            int curPos = 0;
            BloodOxygenData parsedBinFileData = new BloodOxygenData();
            while (totalLength - curPos >= BinFileConstant.ONE_RECORD_TOTAL_BYTE_LENGTH) {
                readOneRecord(this.binFileBytes, curPos, parsedBinFileData);
                curPos += BinFileConstant.ONE_RECORD_TOTAL_BYTE_LENGTH;
            }

            // 解析出有效通道设置在parsedBinFileData中（单从上面无法发现哪些通道是有效的哪些是无效的）
            parseValidChannel(parsedBinFileData);
            // 获取有效数据的起始和结束时间
            parseValidDataTime(parsedBinFileData);
            return parsedBinFileData;
        }


        /**
         * 读取一条记录 （不一定每次都是真实有效的数据）
         *
         * @param totalBytes
         * @param pos
         * @param bloodOxygenData
         * @return
         */
        private void readOneRecord(byte[] totalBytes, int pos, BloodOxygenData bloodOxygenData) {
            Header header = readHeader(totalBytes, pos);
            if (header == null) {
                return;
            }

            // 跳过header
            pos += BinFileConstant.ONE_RECORD_HEADER_BYTE_LENGTH;

            switch (header.getRecordType()) {

                case BinFileConstant.HEADER_RECORD_TYPE_START0: {
                    break;
                }
                case BinFileConstant.HEADER_RECORD_TYPE_START1: {
                    // 病人信息
                    pos += BinFileConstant.DEPARTMENT_NAME_BYTE_LENGTH;
                    int j = pos;
                    for (; j < pos + BinFileConstant.PATIENT_INFO_BYTE_LENGTH; j++) {
                        if (totalBytes[j] == 0x00) {
                            break;
                        }
                    }
                    if (j < pos + BinFileConstant.PATIENT_INFO_BYTE_LENGTH) {
                        String patientName = new String(totalBytes, pos, j-pos);
                        bloodOxygenData.setUserName(patientName);
                    }
                    break;
                }
                case BinFileConstant.HEADER_RECORD_TYPE_DATA: {
                    this.frameNum++;
                    // 真实数据
                    //从header取出时间信息 组装为Date类型时间
                    Date time = getTimeFromHeader(header);
//                  @formatter:off
                    // 分别获取四个通道数据
                    ChannelData channel1Data = new ChannelData();
                    channel1Data.setTime(time);
                    channel1Data.setFrameNum(this.frameNum);
                    channel1Data.setToi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel1Data.setTHi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel1Data.setDHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel1Data.setDHbO2(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel1Data.setDtHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;

                    ChannelData channel2Data = new ChannelData();
                    channel2Data.setTime(time);
                    channel2Data.setFrameNum(this.frameNum);
                    channel2Data.setToi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel2Data.setTHi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel2Data.setDHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel2Data.setDHbO2(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel2Data.setDtHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;

                    ChannelData channel3Data = new ChannelData();
                    channel3Data.setTime(time);
                    channel3Data.setFrameNum(this.frameNum);
                    channel3Data.setToi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel3Data.setTHi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel3Data.setDHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel3Data.setDHbO2(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel3Data.setDtHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;

                    ChannelData channel4Data = new ChannelData();
                    channel4Data.setTime(time);
                    channel4Data.setFrameNum(this.frameNum);
                    channel4Data.setToi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel4Data.setTHi(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel4Data.setDHb(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel4Data.setDHbO2(Float.intBitsToFloat(getInt(totalBytes, pos)));pos += 4;
                    channel4Data.setDtHb(Float.intBitsToFloat(getInt(totalBytes, pos)));

                    bloodOxygenData.addChannelData(0, channel1Data);
                    bloodOxygenData.addChannelData(1, channel2Data);
                    bloodOxygenData.addChannelData(2, channel3Data);
                    bloodOxygenData.addChannelData(3, channel4Data);
//                  @formatter:on
                    break;
                }
                case BinFileConstant.HEADER_RECORD_TYPE_STOP: {
                    break;
                }
                default: {
                    // 表明是mark
                    break;
                }
            }
        }


        /**
         * 从header中取出时间信息
         *
         * @param header
         * @return
         */
        private Date getTimeFromHeader(Header header) {
            Calendar calendar = new GregorianCalendar();
            calendar.set(header.getYear(), header.getMonth() - 1, header.getDay(),
                    header.getHour(), header.getMinute(), header.getSecond());
            return calendar.getTime();
        }




        private Header readHeader(byte[] totalBytes, int pos) {
            byte recordType = totalBytes[pos];
            boolean recordTypeMatch = recordType == BinFileConstant.HEADER_RECORD_TYPE_START0
                    || recordType == BinFileConstant.HEADER_RECORD_TYPE_START1
                    || recordType == BinFileConstant.HEADER_RECORD_TYPE_DATA
                    || recordType == BinFileConstant.HEADER_RECORD_TYPE_STOP
                    || (recordType >= BinFileConstant.HEADER_RECORD_TYPE_MARK_LOW_LIMIT
                    && recordType <= BinFileConstant.HEADER_RECORD_TYPE_MARK_UP_LIMIT);
            if (!recordTypeMatch) {
//                logger.error("头信息的recordType出错");
                return null;
            }

            Header header = new Header();
            header.setRecordType(recordType);
            header.setChannel(totalBytes[++pos]);
            // 年份 改为高八位在前
            int low = totalBytes[++pos] & 0xFF;
            int high = totalBytes[++pos] & 0xFF;
            header.setYear((short)(low + (high << 8)));
            header.setMonth(totalBytes[++pos]);
            header.setDay(totalBytes[++pos]);
            header.setHour(totalBytes[++pos]);
            header.setMinute(totalBytes[++pos]);
            header.setSecond(totalBytes[++pos]);
            // 跳过 unused
            ++pos;
            Byte[] temp =
                    {totalBytes[++pos], totalBytes[++pos], totalBytes[++pos], totalBytes[++pos]};
            header.setChannelWarning(temp);

            // 后面的暂时不解析了需要的时候再说
            return header;
        }


        private void parseValidChannel(BloodOxygenData parsedBinFileData) {
            boolean[] channelUsed = parsedBinFileData.getChannelUsed();
            if(channelUsed == null) {
                channelUsed = new boolean[4];

            }

            ArrayList<LinkedList<ChannelData>> fourChannelsData = parsedBinFileData.getFourChannelsData();
            for(int i = 0; i< fourChannelsData.size(); i++) {
                LinkedList<ChannelData> oneChannel = fourChannelsData.get(i);
                int size = oneChannel.size();
                if (size < 10) {
                    // 通道数据小于10个，则直接认为通道无效
                    channelUsed[i] = false;
                    fourChannelsData.set(i,null);
                    continue;
                }
                int checkNum = (int) Math.ceil(size * 0.15);
                int start = size / 2 - checkNum / 2;
                // 从列表第start个元素开始检查checkNum个，判断是不是参数值都是0
                Iterator<ChannelData> iterator = oneChannel.iterator();
                ChannelData cur = null;
                while (start > 0) {
                    cur = iterator.next();
                    start--;
                }
                // cur实际上是不会为null的
                while (cur != null && checkNum > 0) {
                    boolean empty = cur.getDtHb() == 0.0f && cur.getDHb() == 0.0f && cur.getDHbO2() == 0.0f
                            && cur.getTHi() == 0.0f && cur.getToi() == 0.0f;
                    if (!empty) {
                        // 只要checkNum范围内检测到非全为0的数据说明此通道为有效
                        channelUsed[i] = true;
                        break;
                    }
                    cur = iterator.next();
                    checkNum--;
                }
                if (cur == null || checkNum == 0) {
                    channelUsed[i] = false;
                    fourChannelsData.set(i, null);
                }
            }
            parsedBinFileData.setChannelUsed(channelUsed);

        }

        /**
         * 解析出有效数据的起始和结束时间
         * @param parsedBinFileData
         */
        private void parseValidDataTime(BloodOxygenData parsedBinFileData) {
            // 获取第一个含有有效数据的通道
            boolean[] channelUsed = parsedBinFileData.getChannelUsed();
            if (channelUsed == null) {
                return;
            }
            int index = 0;
            while (index < channelUsed.length && !channelUsed[index]) {
                index++;
            }
            if (index == channelUsed.length) {
                return;
            }

            LinkedList<ChannelData> channel1Data = parsedBinFileData.getFourChannelsData().get(index);
            if (channel1Data != null && channel1Data.size() > 0) {
                parsedBinFileData.setValidDataStartTime(channel1Data.getFirst().getTime());
                parsedBinFileData.setValidDataEndTime(channel1Data.getLast().getTime());
            }
        }

    }

}
