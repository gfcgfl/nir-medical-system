import com.zju.medical.common.pojo.ChannelData;
import com.zju.medical.common.utils.BloodOxygenDataFileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author xiaoguo
 */
public class BloodOxygenDataFileUtilsTest {

    @Test
    public void testGetFirstValidChannelData() {

        File file = new File("D:\\pro\\JAVA\\Prjs\\nir-medical-system\\" +
                "nir-main-module\\target\\classes\\static\\task3-10-20200114043922804.txt");
        List<ChannelData> firstValidChannelData = BloodOxygenDataFileUtils.getFirstValidChannelData(file);
        System.out.println();
    }
}
