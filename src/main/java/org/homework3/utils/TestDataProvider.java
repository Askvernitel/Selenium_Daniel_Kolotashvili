package org.homework3.utils;

import org.homework3.dto.FormPageData;
import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;
import org.homework3.pages.FormPage;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestDataProvider {


    @DataProvider(name = "alertPageData")
    public Object[][] alertPageData() {
        return FileUtils.getObjectArrayFrom(Config.ALERT_DATA_FILE_PATH);
    }

    @DataProvider(name = "formPageData")
    public Object[][] formPageData() {
        Map<String, String> fileDataMap = FileUtils.getJsonMapFrom(Config.FORM_DATA_FILE_PATH);
        Object[][] formData = {
                new FormPageData[]{new FormPageData(
                        fileDataMap.get("firstName"),
                        fileDataMap.get("lastName"),
                        fileDataMap.get("email"),
                        GenderType.valueOf(fileDataMap.get("gender")),
                        fileDataMap.get("phoneNumber"),
                        fileDataMap.get("subject"),
                        HobbyType.valueOf(fileDataMap.get("hobby")),
                        fileDataMap.get("currentAddress"),
                        fileDataMap.get("state"),
                        fileDataMap.get("city")
                )}
        };
        return formData;
    }
}
