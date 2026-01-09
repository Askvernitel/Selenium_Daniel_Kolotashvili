package tests;

import org.homework3.base.TestBase;
import org.homework3.dto.AlertPageData;
import org.homework3.dto.FormPageData;
import org.homework3.pages.AlertPage;
import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.homework3.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends TestBase {


    @Test(dataProvider = "alertPageData", dataProviderClass = TestDataProvider.class)
    public void testAlertPage(AlertPageData inputData){
        AlertPage alertPage = new AlertPage(DriverFactory.getDriver(), Config.ALERT_URL);
        String alertPageOutput = alertPage.clickAlertWithTextBoxAnchor()
                .clickPromptButton()
                .setAlertPrompt(inputData.getAlertInput())
                .getGreetingParagraph();

        Assert.assertTrue(alertPageOutput.contains(inputData.getAlertInput()));
    }
}
