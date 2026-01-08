package org.homework3.utils;

import org.testng.ITestContext;

import java.util.Map;

public class Config {

    public static String ALERT_URL;
    public static String FORM_URL;
    public static String DEFAULT_BROWSER;
    public static String ALERT_DATA_FILE_PATH;
    public static String FORM_DATA_FILE_PATH;

    public static void initConfig(ITestContext context){
        Map<String,String> paramToValue = context.getSuite().getXmlSuite().getAllParameters();
        ALERT_URL = paramToValue.get("ALERT_URL");
        FORM_URL = paramToValue.get("FORM_URL");
        DEFAULT_BROWSER = paramToValue.get("DEFAULT_BROWSER");
        ALERT_DATA_FILE_PATH = paramToValue.get("ALERT_DATA_FILE_PATH");
        FORM_DATA_FILE_PATH =  paramToValue.get("FORM_DATA_FILE_PATH");
    }
}
