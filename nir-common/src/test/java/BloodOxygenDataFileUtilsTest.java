import com.zju.medical.common.pojo.ChannelDataAndMark;
import com.zju.medical.common.utils.BloodOxygenDataFileUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author xiaoguo
 */
public class BloodOxygenDataFileUtilsTest {

    @Test
    public void testGetFirstValidChannelData() {

        File file = new File("D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\target\\classes\\static\\marked-task3-10-20200114043922805.txt");
        ChannelDataAndMark firstValidChannelData = BloodOxygenDataFileUtils.getFirstValidChannelData(file);
        System.out.println();
    }
}
