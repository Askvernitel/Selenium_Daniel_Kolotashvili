package org.homework3.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {


    @DataProvider(name="alertPageData")
    public Object[][] alertPageData(){
        return FileUtils.getObjectArrayFrom(Config.ALERT_DATA_FILE_PATH);
    }

    @DataProvider(name="formPageData")
    public Object[][] formPageData(){
        return FileUtils.getObjectArrayFrom(Config.FORM_DATA_FILE_PATH);
    }
}
