package service;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author xiaoguo
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={BloodOxygenWaveformImgServiceImplTest.class})
public class BloodOxygenWaveformImgServiceImplTest {


    @Test
    public void testDrawWithJava() throws Exception {

//        private List<String> drawWithJava(String dataFilePath, String imgStorageDir,
//                String userId, String taskIdentifier) {

        Class<?> aClass = Class.forName("com.zju.medical.service.impl.BloodOxygenWaveformImgServiceImpl");
        Object o = aClass.newInstance();


        Method method = aClass.getDeclaredMethod("drawWithJava", String.class, String.class, String.class, String.class);
        method.setAccessible(true);

        String dataFilePath = "D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\target\\classes\\static\\marked-task3-10-20200114043922805.txt";
        String imgStorageDir = "D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\src\\test\\resources\\img\\java";
        String userId = "10";
        String taskIdentifier = "3";

        List<String> invoke = (List<String>)method.invoke(o, dataFilePath, imgStorageDir, userId, taskIdentifier);

        System.out.println();
    }

    @Test
    public void testDrawWithPython() throws Exception {

//        private List<String> drawWithJava(String dataFilePath, String imgStorageDir,
//                String userId, String taskIdentifier) {

        Class<?> aClass = Class.forName("com.zju.medical.service.impl.BloodOxygenWaveformImgServiceImpl");
        Object o = aClass.newInstance();


        Method method = aClass.getDeclaredMethod("drawWithPython", String.class, String.class, String.class, String.class, String.class);
        method.setAccessible(true);

        String dataFilePath = "D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\target\\classes\\static\\task3-10-20200114043922804.txt";
        String imgStorageDir = "D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\src\\test\\resources\\img\\python";
        String userId = "10";
        String taskIdentifier = "3";
        String pyFilePath = "D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\src\\main\\resources\\python\\FigureGenerator.py";

        List<String> invoke = (List<String>)method.invoke(o, dataFilePath, imgStorageDir, userId, taskIdentifier, pyFilePath);

        System.out.println();
    }
}
