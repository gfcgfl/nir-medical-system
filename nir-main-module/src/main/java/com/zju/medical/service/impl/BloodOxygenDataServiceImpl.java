package com.zju.medical.service.impl;


import com.zju.medical.service.BloodOxygenDataService;
import com.zju.medical.service.DataPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author xiaoguo
 */
@Service
public class BloodOxygenDataServiceImpl implements BloodOxygenDataService {

    @Autowired
    private DataPathService dataPathService;

    @Override
    public boolean dataFileParseAndSave(String ext, File file, Integer userId, Integer task) {

        // 如果是txt文件，则直接存储

//        dataPathService.addOrUpdateDataPath();
        return true;
    }


//    /**
//     * 将excelFile文件 1保存在服务端 2存储路径添加到数据库
//     * 3将有效数据解析出来存储为txt 4 将txt文件的路径保存至数据库
//     * dir: 两种文件的保存路径基址
//     *
//     * @param baseDir
//     * @param uploadExcelFile
//     */
//    @Override
//    @SuppressWarnings("all")
//    public void saveAndParseExcelFile(String baseDir, MultipartFile uploadExcelFile) throws ParseExcelFileException {
//        String uploadExcelFileName = uploadExcelFile.getOriginalFilename();
//
//
//        BloodOxygenExcelFileNamePartsBO fileNameParts = parseExcelFileName(uploadExcelFileName);
//
//        //创建excel的保存目录文件夹
//        File excelDir = new File(baseDir + BloodOxygenDataConstant.EXCEL_FILE_RELATIVE_DIR);
//        if (!excelDir.exists()) {
//            excelDir.mkdir();
//        }
//        //单独为此用户创建excel文件存放的文件夹，文件夹名字为userId
//        File userExcelDir = new File(excelDir.getAbsolutePath() + File.separator + fileNameParts.getUserId());
//        if (!userExcelDir.exists()) {
//            userExcelDir.mkdir();
//        }
//        File excelFile = new File(userExcelDir.getAbsolutePath() + File.separator + uploadExcelFileName);
//        File textFile = null;
//        try {
//            //将excel中的数据解析成txt并保存
//            String textFileName = uploadExcelFileName.substring(0, uploadExcelFileName.lastIndexOf(".")) + BloodOxygenDataConstant.TEXT_FILE_EXT_NAME;
//            //先解析excel保存text，再将excel文件保存：这样的话当保存txt出错的时候就不会保存excel
//            uploadExcelFile.transferTo(excelFile);
//            textFile = parseExcelAndSaveText(excelFile, baseDir, textFileName, fileNameParts.getUserId());
//            //将文件路径更新到数据库
//            updateExcelSavePath(excelFile.getAbsolutePath(), textFile.getAbsolutePath(), fileNameParts);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseExcelFileException | DataAccessException e) {
//            //注意在使用mybaits时，执行mapper的增删改查产生的SQLException在这里是捕获不到的，需要用DataAccessException
//            //出现其他异常时，例如数据库异常，将两个文件删除，并抛出ParseExcelFileException
//            if (excelFile != null) {
//                excelFile.delete();
//            }
//            if (textFile != null) {
//                textFile.delete();
//            }
//            throw (e instanceof ParseExcelFileException) ? (ParseExcelFileException) e : new ParseExcelFileException("其他异常发生，也许是数据库插入/更新异常；文件已删除：" + ((DataAccessException) e).getMessage());
//        }
//
//    }
//
//    /**
//     * 解析excel文件名
//     *
//     * @param uploadExcelFileName
//     * @return
//     */
//    private BloodOxygenExcelFileNamePartsBO parseExcelFileName(String uploadExcelFileName) {
//        String[] split = uploadExcelFileName.split(BloodOxygenDataConstant.EXCEL_FILE_NAME_SPECIAL_SEPARATION_REGEX);
//        BloodOxygenExcelFileNamePartsBO fileNamePartsBo = new BloodOxygenExcelFileNamePartsBO();
//        fileNamePartsBo.setUserId(Integer.parseInt(split[0]));
//        fileNamePartsBo.setInstrumentTime(split[2]);
//        fileNamePartsBo.setExtName(split[3]);
//        //判断此excel是针对哪一种任务
//        switch (split[1]) {
//            case AdhdTaskConstant.REY_COMPLEX_FIGURE_MEMORY: {
//                fileNamePartsBo.setTaskType(REY_COMPLEX_FIGURE_MEMORY_TASK);
//                break;
//            }
//            case AdhdTaskConstant.DIGIT_ALPHABET_LINKING: {
//                fileNamePartsBo.setTaskType(AdhdTaskConstant.AdhdTaskTypeEnum.DIGIT_ALPHABET_LINKING_TASK);
//                break;
//            }
//            case AdhdTaskConstant.STROOP_COLOR_WORDS: {
//                fileNamePartsBo.setTaskType(AdhdTaskConstant.AdhdTaskTypeEnum.STROOP_COLOR_WORDS_TASK);
//                break;
//            }
//            default:
//        }
//        return fileNamePartsBo;
//    }
//
//    /**
//     * 将excel中的数据解析成txt并保存
//     *
//     * @param excelFile
//     * @param baseDir
//     * @param textFileName text文件名
//     */
//    @SuppressWarnings("all")
//    private File parseExcelAndSaveText(File excelFile, String baseDir, String textFileName, Integer userId) throws IOException, ParseExcelFileException {
//        //创建text文件存放的文件夹
//        File textDir = new File(baseDir + BloodOxygenDataConstant.TEXT_FILE_RELATIVE_DIR);
//        if (!textDir.exists()) {
//            textDir.mkdir();
//        }
//        //单独为此用户创建text文件存放的文件夹，文件夹名字为userId
//        File userTextlDir = new File(textDir.getAbsolutePath() + File.separator + userId);
//        if (!userTextlDir.exists()) {
//            userTextlDir.mkdir();
//        }
//        //TODO 这里暂时是先将通道1和通道2的sheet解析
//        //先解析通道1各个数据的采集时间（也就是所有通道的时间）
//        ArrayList<List<Object>> timeList = ExcelUtils.readExcelBySheetAndArea(excelFile,
//                1,
//                BloodOxygenDataConstant.EXCEL_PARSE_TIME_START_ROW_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_TIME_START_COL_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_TIMET_ROW_LEHGTH,
//                BloodOxygenDataConstant.EXCEL_PARSE_TIMET_COL_LEHGTH);
//        //获取通道1的参数的数据
//        ArrayList<List<Object>> channel1ParamList = ExcelUtils.readExcelBySheetAndArea(excelFile,
//                1,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_START_ROW_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_START_COL_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_ROW_LEHGTH,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_COL_LEHGTH);
//        //获取通道2的参数的数据
//        ArrayList<List<Object>> channel2ParamList = ExcelUtils.readExcelBySheetAndArea(excelFile,
//                2,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_START_ROW_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_START_COL_NUMBER,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_ROW_LEHGTH,
//                BloodOxygenDataConstant.EXCEL_PARSE_CHANNEL_DATA_COL_LEHGTH);
//        if ((timeList.size() != channel1ParamList.size()) || (timeList.size() != channel2ParamList.size())) {
//            throw new ParseExcelFileException("解析excel文件出错，请确保仪器采集数据时四个通道的操作正确");
//        }
//        File textFile = new File(userTextlDir.getAbsolutePath() + File.separator + textFileName);
//        saveTextFile(textFile, timeList, channel1ParamList, channel2ParamList);
//
//        return textFile;
//    }
//
//    /**
//     * excel、txt文件的存储路径更新到数据库
//     * @param excelFileAbsPath
//     * @param txtFileAbsPath
//     * @param fileNameParts
//     */
//    private void updateExcelSavePath(String excelFileAbsPath, String txtFileAbsPath, BloodOxygenExcelFileNamePartsBO fileNameParts) throws DataAccessException{
//        Integer userId = fileNameParts.getUserId();
//        //用于选择性更新或者插入的DO对象
//        BloodOxygenDO bloodOxygenDo = new BloodOxygenDO();
//        //确定这两个文件是针对哪个任务
//        switch (fileNameParts.getTaskType()) {
//            case REY_COMPLEX_FIGURE_MEMORY_TASK: {
//                bloodOxygenDo.setTask1ExcelPath(excelFileAbsPath);
//                bloodOxygenDo.setTask1TxtPath(txtFileAbsPath);
//                break;
//            }
//            case DIGIT_ALPHABET_LINKING_TASK: {
//                bloodOxygenDo.setTask2ExcelPath(excelFileAbsPath);
//                bloodOxygenDo.setTask2TxtPath(txtFileAbsPath);
//                break;
//            }
//            case STROOP_COLOR_WORDS_TASK: {
//                bloodOxygenDo.setTask3ExcelPath(excelFileAbsPath);
//                bloodOxygenDo.setTask3TxtPath(txtFileAbsPath);
//                break;
//            }
//            default:
//        }
//        bloodOxygenDo.setCreateTime(new Date());
//        //先查询一下是否该用户的数据已在数据库中存在
//        BloodOxygenDOExample example = new BloodOxygenDOExample();
//        example.createCriteria().andUserIdEqualTo(userId);
//        List<BloodOxygenDO> bloodOxygen = bloodOxygenMapper.selectByExample(example);
//        if (!bloodOxygen.isEmpty()) {
//            //不为空说明 数据表中 userId代表用户的数据行已经存在，则进行选择性更新
//            bloodOxygenMapper.updateByExampleSelective(bloodOxygenDo, example);
//        } else {
//            //为空说明 数据表中 userId代表用户的数据行不存在，则进行选择性插入， 注意插入的时候要指定userId
//            bloodOxygenDo.setUserId(fileNameParts.getUserId());
//            bloodOxygenMapper.insertSelective(bloodOxygenDo);
//        }
//
//    }
//
//
//    /**
//     * 将text文件保存
//     * @param textFile
//     * @param timeList
//     * @param channelParamLists
//     */
//    @SafeVarargs
//    private final void saveTextFile(File textFile, ArrayList<List<Object>> timeList, ArrayList<List<Object>>... channelParamLists) {
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(textFile);
//            //TODO 这里也没有判断三个list的长度是不是相同的  不出意外应该是相同的
//            for (int i = 0; i < timeList.size(); i++) {
//                //时间信息写入
//                List<Object> time = timeList.get(i);
//                if (CollectionUtils.isEmpty(time)) {
//                    continue;
//                }
//                fileWriter.write((String) time.get(0));
//                fileWriter.write("\t:\t");
//
//                //写入每一个channel
//                for (int channel = 0; channel < channelParamLists.length; channel++) {
//                    ArrayList<List<Object>> channelParamList = channelParamLists[channel];
//                    List<Object> channelParamAtTimei = channelParamList.get(i);
//                    for (int j = 0; j < channelParamAtTimei.size(); j++) {
//                        Object param = channelParamAtTimei.get(j);
//                        //写入channel获得的每个param
//                        String s;
//                        try {
//                            // param有可能是数据类型有可能是string类型
//                            s = String.valueOf(((BigDecimal) param).floatValue());
//                        } catch (ClassCastException e) {
//                            s = String.valueOf(param);
//                        }
//                        fileWriter.write(s);
//                        if (j < channelParamAtTimei.size() - 1) {
//                            fileWriter.write("\t");
//                        }
//                    }
//                    if (channel < channelParamLists.length - 1) {
//                        fileWriter.write("\t|\t");
//                    }
//                }
//                fileWriter.write("\n");
//                fileWriter.flush();
//            }
//        } catch (IOException e) {
//
//        } finally {
//            if (fileWriter != null) {
//                try {
//                    fileWriter.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
