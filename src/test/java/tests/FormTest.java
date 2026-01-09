package tests;

import org.homework3.base.TestBase;
import org.homework3.dto.FormPageData;
import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;
import org.homework3.pages.FormPage;
import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.homework3.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FormTest extends TestBase {


    @Test(dataProvider = "formPageData", dataProviderClass = TestDataProvider.class)
    public void testFormPage(FormPageData inputData) throws InterruptedException {
        FormPage formPage = new FormPage(DriverFactory.getDriver(), Config.FORM_URL);

        formPage.scrollToSubmitButton()
                .setFirstNameField(inputData.getFirstName())
                .setLastNameField(inputData.getLastName())
                .setPhoneNumberField(inputData.getPhoneNumber())
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

    }
}
