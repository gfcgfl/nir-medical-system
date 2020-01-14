package com.zju.medical.common.constant;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author xiaoguo
 */
public class ReportConstant {

    /**
     * 无数据返回的值
     */
    public static final String NO_IMG = "no data";

    /**
     * 通道数量
     */
    public static final int CHANNEL_NUM = 4;

    /**
     * 每个通道图片数量
     */
    public static final int IMG_NUM = 5;

    /**
     * 图片标题
     */
    public static final String[] WAVEFORM_TITLE= {"toi", "thi", "Hb", "HbO2", "tHb"};

    /**
     * python脚本路径
     */
    public static final String PY_SCRIPT_PATH = "/python/FigureGenerator.py";


    public static final String CLASSPATH;

    /**
     * 静态资源存放目录
     */
    public static final String STATIC_RESOURCE_DIR;

    /**
     * 生成的pdf文档的存储位置（相对于classpath）
     */
    public static final String PDF_FILE_SAVE_PATH = "/static/pdf";

    /**
     * 临时生成的波形图片的存储位置（相对于classpath）
     */
    public static final String IMG_FILE_SAVE_PATH = "/static/img";

    /**
     * 生成的图片文件扩展名
     */
    public static final String IMG_FILE_EXT_NAME = "png";


    /**
     * 图片的初始化画板大小 (但是实际显示出的图片大小可能不是这里设定的值)
     */
    public static final int REPORT_IMAGE_WIDTH = 1500;
    public static final int REPORT_IMAGE_HEIGHT = 300;


    /**
     * 图片的实际显示波形的区域
     *  |------------------------------------|
     *  |                 Y                  |
     *  |   -------------------------(x2,y2) |
     *  |   |                            |   |
     *  | X |                            | X |
     *  |   |                            |   |
     *  | (x1,y1)------------------------|   |
     *  |                 Y                  |
     * (0,0)----------------------------------|
     */
    public static final int X = 30;
    public static final int Y = 20;

    public static final int WAVEFORM_DISPLAY_AREA_WIDTH = REPORT_IMAGE_WIDTH - X - X;
    public static final int WAVEFORM_DISPLAY_AREA_HEIGHT = REPORT_IMAGE_HEIGHT -Y -Y;


    static {
        String s;
        try {
            Enumeration<URL> resources =
                    ReportConstant.class.getClassLoader().getResources("/");
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                System.out.println(url.toString());
            }
            s = Thread.currentThread().getContextClassLoader().getResource("/").getPath();
        } catch (Exception e) {
            s = ReportConstant.class.getClassLoader().getResource("").getPath();
        }
        CLASSPATH = s;
        STATIC_RESOURCE_DIR = new File(CLASSPATH, "static").getAbsolutePath();

    }

}