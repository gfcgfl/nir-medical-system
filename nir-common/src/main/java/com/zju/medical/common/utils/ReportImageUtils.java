package com.zju.medical.common.utils;


import com.zju.medical.common.constant.ReportConstant;
import com.zju.medical.common.pojo.ChannelData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 报告中图片生成相关的工具类
 *
 * @author xiaoguo
 */
public class ReportImageUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReportImageUtils.class);

    /**
     * 通过不同的数字区分画的是 toi图 、thi图 还是其他三个参数的图
     */
    private static final int DRAW_TOI = 1;
    private static final int DRAW_THI = 2;
    private static final int DRAW_DHb = 3;
    private static final int DRAW_DHbO2 = 4;
    private static final int DRAW_DtHb = 5;





    /**
     * 为一个通道数据绘制波形图，并保存图片，返回保存文件绝对路径
     * 生成的文件按顺序依次是  TOI波形 、 THI 、 其他三个△参数(三个参数的波形放在一个图里面)
     *
     * @param data
     * @param imgFileNamePrefix 待保存的文件名前缀
     * @return
     */
    public static List<String> drawChannelWaveformAndSave(
            List<ChannelData> data,
            String imgFileNamePrefix) throws Exception {

        List<String> result = new ArrayList<>(5);
        int[] label = {DRAW_TOI, DRAW_THI, DRAW_DHb, DRAW_DHbO2, DRAW_DtHb};
        String imgPath = null;
        for (int i = 0; i < 5; i++) {
            imgPath = drawAndSaveSingleWaveform(imgFileNamePrefix, label[i], data);
            result.add(imgPath);
        }
//        // 获取到toi图片的保存绝对路径
//        imgPath = drawAndSaveSingleWaveform(imgFileNamePrefix, DRAW_TOI, data);
//        result.add(imgPath);
//
//        // 获取到thi图片的保存绝对路径
//        imgPath = drawAndSaveSingleWaveform(imgFileNamePrefix, DRAW_THI, data);
//        result.add(imgPath);
//
//
//        // 获取到其他三个参数的图片的保存绝对路径
//        imgPath = drawAndSaveOtherThreeWaveform(imgFileNamePrefix, DRAW_OTHER_THREE, data);
//        result.add(imgPath);


        return result;
    }


    /**
     * 绘制并保存单条波形图，适用于thi toi这两个参数
     * 返回值为thi或者toi的图片文件的保存绝对路径
     *
     * @return
     */
    private static String drawAndSaveSingleWaveform(String imgNamePrefix,
                                                    int drawWhich,
                                                    List<ChannelData> data) {
        // len保存实际应该有多少帧数据 也就是它等于最后一帧的帧编号而不是等于data的size（正常情况两者是相等的）
        // 但是考虑到可能会出现 size=2，两个帧的编号却分别是1,3的情况，此时len=3
        int len;
        if (data instanceof ArrayList) {
            len = data.get(data.size() - 1).getFrameNum();
        } else {
            len = ((LinkedList<ChannelData>) data).getLast().getFrameNum();
        }

        // 下面的代码 判断出toi或者thi的波形数据的上下限、生成需要绘制波形的数据并且获取需要生成的图片的文件名
        float up;
        float low;
        String fileName;
        Float[] paramData = new Float[len];

        up = data.get(0).getToi();
        low = up;
        String item = "";
        for (ChannelData dat : data) {
            float p = 0.0f;
            switch (drawWhich) {
                case DRAW_TOI: {
                    p = dat.getToi();
                    item = "TOI";
                    break;
                }
                case DRAW_THI: {
                    p = dat.getTHi();
                    item = "THI";
                    break;
                }
                case DRAW_DHb: {
                    p = dat.getDHb();
                    item = "ΔHb";
                    break;
                }
                case DRAW_DHbO2: {
                    p = dat.getDHbO2();
                    item = "ΔHbO2";
                    break;
                }
                case DRAW_DtHb: {
                    p = dat.getDtHb();
                    item = "ΔtHb";
                    break;
                }
                default: {
                }
            }
            paramData[dat.getFrameNum() - 1] = p;
            if (p > up) {
                up = p;
            } else if (p < low) {
                low = p;
            }
        }
        fileName = imgNamePrefix + "--" + item
                + "." + ReportConstant.IMG_FILE_EXT_NAME;


        List<Float[]> datas = new ArrayList<>(1);
        datas.add(paramData);
        // 绘制toi或者thi波形图并保存
        Draw draw = new Draw(fileName, datas, up, low);
        String savePath = draw.drawAndSave();
        return savePath;

    }

//    /**
//     * 一张图中绘制其他三个参数的波形 主要针对dHb dHbO2 dtHb
//     *
//     * @param imgNamePrefix
//     * @param drawWhich
//     * @param data
//     * @return
//     */
//    private static String drawAndSaveOtherThreeWaveform(String imgNamePrefix,
//                                                        int drawWhich,
//                                                        List<ChannelData> data) {
//        if (drawWhich != DRAW_OTHER_THREE) {
//            return null;
//        }
//        // len保存实际应该有多少帧数据 也就是它等于最后一帧的帧编号而不是等于data的size（正常情况两者是相等的）
//        // 但是考虑到可能会出现 size=2，两个帧的编号却分别是1,3的情况，此时len=3
//        int len;
//        if (data instanceof ArrayList) {
//            len = data.get(data.size() - 1).getFrameNum();
//        } else {
//            len = ((LinkedList<ChannelData>) data).getLast().getFrameNum();
//        }
//
//        // 下面的代码 判断出toi或者thi的波形数据的上下限、生成需要绘制波形的数据并且获取需要生成的图片的文件名
//        float up;
//        float low;
//        String fileName;
//
//        Float[] dHbData = new Float[len];
//        Float[] dHbO2Data = new Float[len];
//        Float[] dtHbData = new Float[len];
//        ChannelData temp = data.get(0);
//        up = floatMax(temp.getDHb(), temp.getDtHb(), temp.getDHbO2());
//        low = floatMin(temp.getDHb(), temp.getDtHb(), temp.getDHbO2());
//        for (ChannelData dat : data) {
//            Float dHb = dat.getDHb();
//            Float dtHb = dat.getDtHb();
//            Float dHbO2 = dat.getDHbO2();
//            dHbData[dat.getFrameNum() - 1] = dHb;
//            dHbO2Data[dat.getFrameNum() - 1] = dtHb;
//            dtHbData[dat.getFrameNum() - 1] = dHbO2;
//            float max = floatMax(dHb, dtHb, dHbO2);
//            float min = floatMin(dHb, dtHb, dHbO2);
//            if (max > up) {
//                up = max;
//            }
//            if (min < low) {
//                low = min;
//            }
//        }
//        fileName = imgNamePrefix + "--THREE." + ReportConstant.IMG_FILE_EXT_NAME;
//        List<Float[]> datas = new ArrayList<>(1);
//        datas.add(dHbData);
//        datas.add(dtHbData);
//        datas.add(dHbO2Data);
//        // 绘制toi或者thi波形图并保存
//        Draw draw = new Draw(fileName, datas, up, low);
//        String savePath = draw.drawAndSave();
//        return savePath;
//    }


    private static final float floatMin(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }

    private static final float floatMax(float a, float b, float c) {
        return Math.max(Math.max(a, b), c);
    }


    private static class Draw {

        private static AtomicInteger curColor = new AtomicInteger(0);
        private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN};

        private String imgName;

        /**
         * toi   或者 thi  或者  三个以△开头的参数的数据  前两个的list的size==1， 最后一个 size==3
         */
        private List<Float[]> waveformData;

        private float waveformWidth;
        private float waveformHeight;

        private float waveformValueMax;
        private float waveformValueMin;


        public Draw(String imgName, List<Float[]> waveformData, float valueMax, float valueMin) {

            this.imgName = imgName;
            this.waveformData = waveformData;
            this.waveformValueMax = (float) Math.ceil(valueMax + 0.5);
            this.waveformValueMin = (float) Math.floor(valueMin - 0.5);
            this.waveformWidth = CollectionUtils.isEmpty(waveformData) ? 0 : waveformData.get(0).length - 1;
            this.waveformHeight = this.waveformValueMax - this.waveformValueMin;
        }

        public String drawAndSave() {

            if (this.waveformWidth == 0) {
                return null;
            }
            BufferedImage targetImage = new BufferedImage(ReportConstant.REPORT_IMAGE_WIDTH,
                    ReportConstant.REPORT_IMAGE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D g = targetImage.createGraphics();

            String savePath = null;
            try {
                setBackGround(g, ReportConstant.REPORT_IMAGE_WIDTH, ReportConstant.REPORT_IMAGE_HEIGHT);
                drawWaveform(g);
                drawCoordinates(g);
                savePath = saveImg(targetImage);
            } catch (IOException e) {
                logger.error("名称为\"{}\"的图片创建失败。", this.imgName);
                return null;
            } finally {
                g.dispose();
            }

            return savePath;
        }

        private void setBackGround(Graphics2D g, int width, int height) {
            g.setBackground(Color.WHITE);
            g.clearRect(0, 0, width, height);
        }


        private void drawWaveform(Graphics2D g) {

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            for (Float[] dats : waveformData) {
                Color color = colors[curColor.get()];
                if (curColor.incrementAndGet() == colors.length) {
                    curColor.set(0);
                }
                g.setColor(color);
                if (dats == null || dats.length == 0) {
                    continue;
                }
                Float pre = dats[0];
                for (int i = 1; i < dats.length; i++) {
                    Float cur = dats[i];
                    if (pre != null && cur != null) {
                        int x1Pos = getMappingPointPositionX((float) (i - 1));
                        int y1Pos = getMappingPointPositionY(pre);
                        int x2Pos = getMappingPointPositionX((float) i);
                        int y2Pos = getMappingPointPositionY(cur);
                        g.drawLine(x1Pos, y1Pos, x2Pos, y2Pos);
                        pre = cur;
                    }
                }
            }
        }

        private void drawCoordinates(Graphics2D g) {
            int x1 = ReportConstant.X;
            int y1 = ReportConstant.REPORT_IMAGE_HEIGHT - ReportConstant.Y;
            int x2 = ReportConstant.REPORT_IMAGE_WIDTH - ReportConstant.X;
            int y2 = ReportConstant.Y;

            // 画出波形范围的边框
            g.drawLine(x1, y1, x1, y2);
            g.drawLine(x1, y2, x2, y2);
            g.drawLine(x2, y1, x2, y2);
            g.drawLine(x2, y1, x1, y1);

        }

        private String saveImg(BufferedImage targetImage) throws IOException {
            File saveDir = new File(ReportConstant.CLASSPATH, ReportConstant.IMG_FILE_SAVE_PATH);
            if (!saveDir.exists()) {
                FileUtils.createDirectory(saveDir);
            }
            File f = new File(saveDir, this.imgName);
            ImageIO.write(targetImage, ReportConstant.IMG_FILE_EXT_NAME, f);
            return f.getAbsolutePath();
        }

        /**
         * 获取映射到的Graphics2D上的点的 x坐标
         */
        private int getMappingPointPositionX(float x) {
            return Math.round(ReportConstant.X
                    + x / this.waveformWidth * ReportConstant.WAVEFORM_DISPLAY_AREA_WIDTH);
        }

        /**
         * 获取映射到的Graphics2D上的点的 y坐标
         */
        private int getMappingPointPositionY(float y) {

            float v = ReportConstant.Y
                    + (y - this.waveformValueMin) / this.waveformHeight * ReportConstant.WAVEFORM_DISPLAY_AREA_HEIGHT;
            return ReportConstant.REPORT_IMAGE_HEIGHT - Math.round(v);
        }
    }


}
