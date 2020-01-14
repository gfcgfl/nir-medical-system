package com.zju.medical.common.utils;

import java.io.File;

/**
 * @author xiaoguo
 */
public class FileUtils {

    /**
     * 递归创建目录
     * @param dir
     */
    public static void createDirectory(File dir) {

//        if (!dir.isDirectory()) {
//            dir = dir.getParentFile();
//        }
        if (dir.exists()) {

            return;
        }

        createDirectory(dir.getParentFile());
        dir.mkdir();
        return;
    }
}
