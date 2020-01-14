package com.zju.medical.service;

import java.io.File;

/**
 * @author xiaoguo
 */
public interface BloodOxygenDataService {


    /**
     * 负责将txt（串口接受数据后的转储文件）或者BIN文件（血氧仪中的存储文件，需要解析）统一转换为txt文件
     * 并保存，将路径添加到数据库。
     *
     * @param ext 传入文件的扩展名 （扩展名以这个为准）
     * @param file
     * @param userId
     * @param task
     * @return true 表示操作成功
     */
    boolean dataFileParseAndSave(String ext, File file, Integer userId, Integer task);



    /**
     * 将excelFile文件 1保存在服务端 2存储路径添加到数据库
     *                 3将有效数据解析出来存储为txt 4 将txt文件的路径保存至数据库
     *  dir: 两种文件的保存路径基址
     */
//    void saveAndParseExcelFile(String baseDir, MultipartFile uploadExcelFile) throws ParseExcelFileException;
}
