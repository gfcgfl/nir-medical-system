package com.zju.medical.common.utils;


import com.zju.medical.common.constant.ReportConstant;
import com.zju.medical.common.pojo.ChannelData;
import com.zju.medical.common.pojo.ChannelDataAndMark;
import com.zju.medical.common.pojo.Mark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.zju.medical.common.constant.ReportConstant.*;
import static java.awt.BasicStroke.CAP_SQUARE;
import static java.awt.BasicStroke.JOIN_MITER;

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
    private static final int DRAW_TOI = 0;
    private static final int DRAW_THI = 1;
    private static final int DRAW_DHb = 2;
    private static final int DRAW_DHbO2 = 3;
    private static final int DRAW_DtHb = 4;

    private static int[] LABEL = {DRAW_TOI, DRAW_THI, DRAW_DHb, DRAW_DHbO2, DRAW_DtHb};
    private static String[] ITEM_ENG = {"TOI", "THI", "ΔHb", "ΔHbO2", "ΔtHb"};
    private static String[] ITEM_CHN = {"局部组织氧饱和度" , "局部组织血红蛋白浓度指数",
            "局部组织脱氧血红蛋白变化量", "局部组织含氧血红蛋白变化量", "局部组织总血红蛋白变化量"};
    private static String[] ITEM_UNIT = {"%", " ", "μmol/L", "μmol/L", "μmol/L"};

    /**
     * 为一个通道数据绘制波形图，并保存图片，返回保存文件绝对路径
     * 生成的文件按顺序依次是  TOI波形 、 THI 、 其他三个△参数
     * @param dataAndMark
     * @param imgFileNamePrefix 待保存的文件名前缀
     * @return 五个波形的路径， 返回null表明波形文件均创建失败
     */
    public static List<String> drawChannelWaveformAndSave(
            ChannelDataAndMark dataAndMark,
            String imgSaveDir,
            String imgFileNamePrefix) {

        List<String> result = new ArrayList<>(5);

        String imgPath = null;
        for (int i = 0; i < 5; i++) {
            imgPath = drawAndSaveSingleWaveform(imgFileNamePrefix, imgSaveDir, LABEL[i], dataAndMark);
            if(imgPath != null) {
                result.add(imgPath);
            }

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


        return result.isEmpty() ? null : result;
    }


    /**
     * 绘制并保存单条波形图
     * @return 为null说明创建图失败，否则为图片的绝对路径
     */
    private static String drawAndSaveSingleWaveform(String imgNamePrefix,
                                                    String imgSaveDir,
                                                    int drawWhich,
                                                    ChannelDataAndMark dataAndMark) {
        // len保存实际应该有多少帧数据 也就是它等于最后一帧的帧编号而不是等于data的size（正常情况两者是相等的）
        // 但是考虑到可能会出现 size=2，两个帧的编号却分别是1,3的情况，此时len=3
        int len;
        List<ChannelData> data = dataAndMark.getChannelsData();
        if (data == null || data.isEmpty()) {
            return null;
        }
        if (data instanceof ArrayList) {
            len = data.get(data.size() - 1).getFrameNum();
        } else {
            len = ((LinkedList<ChannelData>) data).getLast().getFrameNum();
        }

        // 下面的代码 判断出toi等参数的波形数据的上下限、生成需要绘制波形的数据并且获取需要生成的图片的文件名
        float up = 0.0f;
        float low;
        String fileName;
        Float[] paramData = new Float[len];

        //确定参数值的最大最小界限
        switch (drawWhich) {
            case DRAW_TOI: {
                up = data.get(0).getToi();
                break;
            }
            case DRAW_THI: {
                up = data.get(0).getTHi();
                break;
            }
            case DRAW_DHb: {
                up = data.get(0).getDHb();
                break;
            }
            case DRAW_DHbO2: {
                up = data.get(0).getDHbO2();
                break;
            }
            case DRAW_DtHb: {
                up = data.get(0).getDtHb();
                break;
            }
            default: {
            }
        }
        low = up;
        for (ChannelData dat : data) {
            float p = 0.0f;
            switch (drawWhich) {
                case DRAW_TOI: {
                    p = dat.getToi();
                    break;
                }
                case DRAW_THI: {
                    p = dat.getTHi();
                    break;
                }
                case DRAW_DHb: {
                    p = dat.getDHb();
                    break;
                }
                case DRAW_DHbO2: {
                    p = dat.getDHbO2();
                    break;
                }
                case DRAW_DtHb: {
                    p = dat.getDtHb();
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
        fileName = imgNamePrefix + "--" + ITEM_ENG[drawWhich]
                + "." + ReportConstant.IMG_FILE_EXT_NAME;


        List<Float[]> datas = new ArrayList<>(1);
        datas.add(paramData);
        // 绘制toi或者thi波形图并保存
        Draw draw = new Draw(ITEM_CHN[drawWhich] + "(" + ITEM_ENG[drawWhich] + ")",
                fileName,
                imgSaveDir,
                ITEM_UNIT[drawWhich],
                datas,
                dataAndMark.getMarks(),
                up, low);
        String savePath = draw.drawAndSave();
        return savePath;

    }


    private static final float floatMin(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }

    private static final float floatMax(float a, float b, float c) {
        return Math.max(Math.max(a, b), c);
    }


    private static class Draw {

//        private static AtomicInteger curColor = new AtomicInteger(0);
        private static int curColor = 0;
        private static Color[] colors = new Color[]{Color.BLACK, Color.RED, Color.BLUE, Color.GREEN,
                Color.ORANGE, Color.MAGENTA};

        private String imgTitle;
        private String imgName;
        // 纵轴数值的单位
        private String unit;
        private String imgSaveDir;
        /**
         * toi 、thi 、三个以△开头的参数的数据
         * 如果想将多个数据画在一张图里面则在list中添加多个参数的float[]数组
         * float[]中记录了每一帧的数据
         */
        private List<Float[]> waveformData;
        /**
         * 标记信息（在哪一帧上有标记、标记的内容是啥），
         */
        private List<Mark> marks;
        private float waveformWidth;
        private float waveformHeight;

        private float waveformValueMax;
        private float waveformValueMin;

        //关于画图有关的
        private static Stroke INTERNAL_AXIS_STROKE = new BasicStroke(1.0f,
                CAP_SQUARE, JOIN_MITER, 10.0f, new float[]{10.0f, 5.0f}, 0.0f);

        private static Stroke WAVEFORM_STROKE = new BasicStroke(1.2f,
                CAP_SQUARE, JOIN_MITER, 10.0f, null, 0.0f);

        private static Stroke MARK_STROKE = new BasicStroke(1.5f,
                CAP_SQUARE, JOIN_MITER, 10.0f, null, 0.0f);

        private static Font FONT_TITLE = new Font("黑体", Font.BOLD,25);
        private static Font FONT_PLAIN = new Font("宋体", Font.PLAIN, 18);
        private static Font FONT_MARK = new Font("宋体", Font.BOLD, 20);

        private static DecimalFormat FORMAT = new DecimalFormat("0.00");

        public Draw(String imgTitle, String imgName,
                    String imgSaveDir, String unit,
                    List<Float[]> waveformData,
                    List<Mark> marks,
                    float valueMax, float valueMin) {
            // 图片中的标题
            this.imgTitle = imgTitle;
            // 保存的图片的名称
            this.imgName = imgName;
            this.imgSaveDir = imgSaveDir;
            this.unit = unit;
            this.waveformData = waveformData;
            this.marks = marks;
            //在最大值最小值之外留出一点空间
            float temp = (valueMax - valueMin >= 6) ? 1.0f : 0.2f;
            this.waveformValueMax = valueMax + temp;
            this.waveformValueMin = valueMin - temp;
            this.waveformWidth = CollectionUtils.isEmpty(waveformData)
                    ? 0 : waveformData.get(0).length - 1;
            this.waveformHeight = this.waveformValueMax - this.waveformValueMin;
        }

        public String drawAndSave() {

            if (this.waveformWidth == 0) {
                return null;
            }
            BufferedImage targetImage = new BufferedImage(ReportConstant.REPORT_IMAGE_WIDTH,
                    REPORT_IMAGE_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
            Graphics2D g = targetImage.createGraphics();

            String savePath = null;
            try {
                setBackGround(g, ReportConstant.REPORT_IMAGE_WIDTH, REPORT_IMAGE_HEIGHT);
                drawCoordinates(g);
                drawWaveform(g);
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
            g.setStroke(WAVEFORM_STROKE);
            // 每次画图（新的图）的时候重置颜色，只有当一张图里面画多个曲线才区分颜色
            curColor = 0;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
            g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            // =============做出数据波形图==============
            for (Float[] dats : waveformData) {
                Color color = colors[curColor++];
                if (curColor == colors.length) {
                    curColor = 0;
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
            // =============做出标记: 在对应的横轴（帧）上画一个点==============
            int circleRadius = 5;
            int circleDiameter = circleRadius << 1;
            if (this.marks != null && !this.marks.isEmpty()) {
                g.setStroke(MARK_STROKE);
                g.setColor(Color.RED);

                for (Mark mark : marks) {
                    int xPos = getMappingPointPositionX((float) (mark.getFrameNum() - 1));
//                    g.drawLine(xPos, Y, xPos, REPORT_IMAGE_HEIGHT - Y);

//                    g.fillOval(xPos - circleRadius, Y - circleRadius, circleDiameter, circleDiameter);
                    g.fillOval(xPos - circleRadius, REPORT_IMAGE_HEIGHT - Y - circleRadius,
                            circleDiameter, circleDiameter);
                    drawStringCenterAligned(mark.getMarkId().toString(),
                            FONT_MARK, g, xPos, REPORT_IMAGE_HEIGHT - Y - 20);
                }
            }
        }

        private void drawCoordinates(Graphics2D g) {

            // ===== 1 画出图的边框========
            int x1 = ReportConstant.X;
            int y1 = REPORT_IMAGE_HEIGHT - Y;
            int x2 = ReportConstant.REPORT_IMAGE_WIDTH - ReportConstant.X;
            int y2 = Y;
            // 边界的stroke暂且与波形的相同
            g.setStroke(Draw.WAVEFORM_STROKE);
            g.setColor(Color.BLACK);
            // 四个边
            g.drawLine(x1, y1, x1, y2);
            g.drawLine(x1, y2, x2, y2);
            g.drawLine(x2, y1, x2, y2);
            g.drawLine(x2, y1, x1, y1);
            g.setStroke(Draw.INTERNAL_AXIS_STROKE);
            // ======2 根据横轴宽度，决定竖直的轴线的相邻间的宽度并绘制他们（用细虚线）
            int interval = (int)Math.ceil(this.waveformWidth / 20);  //大概就画20条
            if (interval % 2 == 1) {
                interval++;    //使得间隔是2的整数倍
            }
            // 需要注意将interval反映到Graphics2D上，得到在Graphics2D上的实际interval，
            // 这里为了方便直接使用getMappingPointPositionX方法
            int mappingPointPositionX = getMappingPointPositionX(0);
            int intervalGraphics2D = getMappingPointPositionX(interval) - mappingPointPositionX;

            for (int i = mappingPointPositionX + intervalGraphics2D;
                 i < getMappingPointPositionX(this.waveformWidth);
                 i = i + intervalGraphics2D) {

                g.drawLine(i, y1, i, y2);
            }

            // ======3 标注x轴的数值===============================
            // 先标注0
            drawStringCenterAligned("0", Draw.FONT_PLAIN, g,
                    mappingPointPositionX, Y_VALUE_OF_X_ANNOTATION);
            // 再标注其他的
            for (int i = mappingPointPositionX + intervalGraphics2D, xValue = interval;
                 i < getMappingPointPositionX(this.waveformWidth);
                 i += intervalGraphics2D, xValue += interval) {
                //因为实际上数据是每两秒一个，即当横洲上有20个数据的时候，横轴的数值应该到40s
                int realXValue = xValue << 1;
                drawStringCenterAligned(String.valueOf(realXValue), Draw.FONT_PLAIN, g,
                        i, Y_VALUE_OF_X_ANNOTATION);
            }

            // ======4 根据纵轴宽度，决定水平的轴线的相邻间的宽度并绘制他们（用细虚线）
            double intervalY = this.waveformHeight / 7;  //大概就画6 7条
            // intervalY向上取偶 例如 0.852 -> 0.86   4.52 -> 4.6
            if (this.waveformHeight <= 6.0f) {
                intervalY = Math.ceil(intervalY / 0.01) * 0.01;
            } else {
                intervalY = Math.ceil(intervalY / 0.1) * 0.10;
            }

            int mappingPointPositionY = getMappingPointPositionY(0);

            // 需要注意将interval反映到Graphics2D上，得到在Graphics2D上的实际interval
            intervalGraphics2D = mappingPointPositionY - getMappingPointPositionY((float)intervalY);
            // 从纵坐标的0处开始分别向上向下话水平轴线 （保证轴线代表0.5或者5的倍数处）， 注意在g2d中的纵坐标是反着的
            for (int y = mappingPointPositionY; y > Y; y = y - intervalGraphics2D) {
                if (y >= REPORT_IMAGE_HEIGHT - Y) {
                    // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                    continue;
                }
                g.drawLine(x1, y, x2, y);
            }
            for (int y = mappingPointPositionY + intervalGraphics2D;
                 y < REPORT_IMAGE_HEIGHT - Y;
                 y = y + intervalGraphics2D) {
                if (y <= Y) {
                    // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                    continue;
                }
                g.drawLine(x1, y, x2, y);
            }
            // ======5 标注y轴的数值===============================
            // 先找到0处，并标注0 (如果0不在绘图范围内则不标注)
            if(mappingPointPositionY <= REPORT_IMAGE_HEIGHT - Y
                    && mappingPointPositionY >= Y) {
                drawStringCenterAligned("0", FONT_PLAIN, g,
                        X_VALUE_OF_Y_ANNOTATION, mappingPointPositionY);
            }
            double yValue = intervalY;
            for (int y = mappingPointPositionY - intervalGraphics2D;
                 y > Y;
                 y = y - intervalGraphics2D, yValue += intervalY) {
                if (y >= REPORT_IMAGE_HEIGHT - Y) {
                    // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                    continue;
                }
                drawStringCenterAligned(FORMAT.format(yValue), FONT_PLAIN, g,
                        X_VALUE_OF_Y_ANNOTATION, y);
            }
            yValue = -intervalY;
            for (int y = mappingPointPositionY + intervalGraphics2D;
                 y < REPORT_IMAGE_HEIGHT - Y;
                 y = y + intervalGraphics2D, yValue -= intervalY) {
                if (y <= Y) {
                    // 当y的值在规定的画图纵向范围之外时候是不画横向的轴线的
                    continue;
                }
                drawStringCenterAligned(FORMAT.format(yValue), FONT_PLAIN, g,
                        X_VALUE_OF_Y_ANNOTATION, y);
            }
            // ======6 标题title ===========
            drawStringCenterAligned(this.imgTitle,
                    Draw.FONT_TITLE,
                    g,
                    ReportConstant.REPORT_IMAGE_WIDTH / 2,
                    ReportConstant.IMG_TITLE_Y);

            // =====7 横纵轴的单位
            // y轴
            drawStringCenterAligned(this.unit, Draw.FONT_PLAIN, g, X_VALUE_OF_Y_UNIT, Y_VALUE_OF_Y_UNIT);
            drawStringCenterAligned("时间/s", Draw.FONT_PLAIN, g, X_VALUE_OF_X_UNIT, Y_VALUE_OF_X_UNIT);
        }

        private String saveImg(BufferedImage targetImage) throws IOException {
            File saveDir = new File(this.imgSaveDir);
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
            // Graphics2D的坐标原点是在左上角，而我们认为的原点是在左下角，对于y轴坐标要修正

            float v = Y
                    + (y - this.waveformValueMin) / this.waveformHeight * ReportConstant.WAVEFORM_DISPLAY_AREA_HEIGHT;
            return REPORT_IMAGE_HEIGHT - Math.round(v);
        }


        /**
         * 在x,y处居中显示字符串
         * @param string
         * @param font
         * @param g
         * @param x Graphics2D中的x坐标值
         * @param y Graphics2D中的y坐标值
         */
        private void drawStringCenterAligned(String string, Font font, Graphics2D g, int x, int y) {
            g.setFont(font);
            FontMetrics fontMetrics = g.getFontMetrics(font);
//            // 计算出中心点 x 位置
//            int centerX = ReportConstant.REPORT_IMAGE_WIDTH / 2;
            // 文字宽度
            int textWidth = fontMetrics.stringWidth(string);
            int textHeight = fontMetrics.getHeight();
            g.drawString(string, x - textWidth / 2, y + textHeight / 2);
        }
    }


}
