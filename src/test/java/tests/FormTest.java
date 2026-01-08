package tests;

import org.homework3.base.TestBase;
import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;
import org.homework3.pages.FormPage;
import org.homework3.utils.Config;
import org.homework3.utils.DriverFactory;
import org.homework3.utils.TestDataProvider;
import org.testng.annotations.Test;

public class FormTest extends TestBase {


    @Test(dataProvider = "formPageData", dataProviderClass= TestDataProvider.class)
    public void testFormPage(String firstName, String lastName) throws InterruptedException{
        FormPage formPage = new FormPage(DriverFactory.getDriver(), Config.FORM_URL);

        formPage.scrollToSubmitButton()
                .setFirstNameField(firstName)
                .setLastNameField(lastName)
                .setPhoneNumberField("1234567891")
                .setEmailField("Daniel@gmail.com")
                .setGenderField(GenderType.OTHER)
                .setHobbiesField(HobbyType.SPORTS)
                .setSubjectField("English")
                .setCurrentAddressField("Address")
                .setStateField("NCR")
                .setCityField("Delhi")
                .clickSubmitButton();


        Thread.sleep(10000);
    }
}
