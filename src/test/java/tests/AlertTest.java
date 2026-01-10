package tests;

import io.qameta.allure.*;
import org.homework3.base.TestBase;
import org.homework3.dto.AlertPageData;
import org.homework3.dto.FormPageData;
import org.homework3.pages.AlertPage;
import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.homework3.utils.GeneralUtils;
import org.homework3.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Alert Input")
@Feature("Form Input")
public class AlertTest extends TestBase {

    @Test(dataProvider = "alertPageData", dataProviderClass = TestDataProvider.class)
    @Story("Clicking on navigation and entering alert input")
    @Description("Test Alert Page")
    @Severity(SeverityLevel.NORMAL)
    @Step("Alert Page Click And Output")
    public void testAlertPage(AlertPageData inputData){
        AlertPage alertPage = new AlertPage(DriverFactory.getDriver(), Config.ALERT_URL);
        alertPage.screenshot();
        String alertPageOutput = alertPage.clickAlertWithTextBoxAnchor()
                .clickPromptButton()
                .setAlertPrompt(inputData.getAlertInput())
                .getGreetingParagraph();
        alertPage.screenshot();
        Assert.assertTrue(alertPageOutput.contains(inputData.getAlertInput()));
    }
}
