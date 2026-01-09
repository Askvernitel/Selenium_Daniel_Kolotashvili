package tests;

import org.homework3.base.TestBase;
import org.testng.annotations.Test;
import org.homework3.utils.Config;
import org.homework3.utils.TestDataProvider;

public class LoadTest extends TestBase {


    @Test(dataProvider = "alertPageData", dataProviderClass = TestDataProvider.class)
    public void testData(String first, String second) {
        System.out.println(Config.ALERT_DATA_FILE_PATH);
        System.out.println(Config.FORM_DATA_FILE_PATH);
        System.out.println("First" + first);
    }
}
