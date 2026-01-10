package tests;

import io.qameta.allure.*;
import org.homework3.base.TestBase;
import org.homework3.dto.FormPageData;
import org.homework3.pages.FormPage;
import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.homework3.utils.GeneralUtils;
import org.homework3.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Map;
@Epic("Student Registration Form")
@Feature("Form Input")
public class FormTest extends TestBase {


    @Test(dataProvider = "formPageData", dataProviderClass = TestDataProvider.class)
    @Story("Entering Of Fields and Showing of table")
    @Description("Test Form Page")
    @Severity(SeverityLevel.NORMAL)
    @Step("Form Page input and output")
    public void testFormPage(FormPageData inputData) {
        FormPage formPage = new FormPage(DriverFactory.getDriver(), Config.FORM_URL);
        formPage.screenshot();
        formPage.scrollToSubmitButton()
                .setFirstNameField(inputData.getFirstName())
                .setLastNameField(inputData.getLastName())
                .setPhoneNumberField(inputData.getPhoneNumber())
                .setDateOfBirthField(inputData.getDateOfBirth())
                .setEmailField(inputData.getEmail())
                .setGenderField(inputData.getGenderType())
                .setHobbiesField(inputData.getHobby())
                .setSubjectField(inputData.getSubject())
                .setCurrentAddressField(inputData.getCurrentAddress())
                .setStateField(inputData.getState())
                .setCityField(inputData.getCity())
                .clickSubmitButton();
        Map<String, String> tableLabelMap = formPage.getTableLabelMap();

        Assert.assertEquals(tableLabelMap.get("Student Name"), String.format("%s %s", inputData.getFirstName(), inputData.getLastName()));
        Assert.assertEquals(tableLabelMap.get("Student Email"), inputData.getEmail());
        Assert.assertEquals(tableLabelMap.get("Gender"), inputData.getGenderType().getValue());
        Assert.assertEquals(tableLabelMap.get("Mobile"), inputData.getPhoneNumber());
        Assert.assertEquals(tableLabelMap.get("Date of Birth"), GeneralUtils.getLongDateFormatFrom(inputData.getDateOfBirth()));
        Assert.assertEquals(tableLabelMap.get("Subjects"), inputData.getSubject());
        Assert.assertEquals(tableLabelMap.get("Hobbies"), inputData.getHobby().getValue());
        Assert.assertEquals(tableLabelMap.get("Address"), inputData.getCurrentAddress());
        Assert.assertEquals(tableLabelMap.get("State and City"), String.format("%s %s", inputData.getState(), inputData.getCity()));
        formPage.screenshot();
    }
}
