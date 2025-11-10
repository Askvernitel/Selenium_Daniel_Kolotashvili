package tests;

import dto.FieldsDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverUtils;
import utils.ElementUtils;
import utils.FormUtils;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FormTests {
    public WebDriver driver;

    private class Constants {
        private static String INPUT_FIELD_VALUE = "Daniel";
        private static String PHONE_FIELD_VALUE = "0123456789";
        private static String EMAIL_FIELD_VALUE = "daniel@gmail.com";
        private static String GENDER_FIELD_VALUE = "Male";
        private static String SUBJECT_FIELD_VALUE = "Maths";
        private static String STATE_FIELD_VALUE = "NCR";
        private static String CITY_FIELD_VALUE = "Delhi";
        private static Boolean CHECKBOX_FIELD_VALUE = true;

    }

    @Parameters(value = "FORM_URL")
    @BeforeClass
    public void setup(String formUrl) {
        this.driver = new FirefoxDriver();
        DriverUtils.run(driver, (driver) -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.navigate().to(formUrl);
        });
    }

    @Test
    public void testForm() {
        DriverUtils.run(driver, (driver) -> {
            WebElement button = driver.findElement(By.id("submit"));
            ElementUtils.runScrollBefore(button, driver, (btnElem) -> {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                List<WebElement> allInputs = driver.findElements(By.tagName("input"));
                allInputs.addAll(driver.findElements(By.className("custom-control-label")));
                allInputs.add(driver.findElement(By.tagName("textarea")));

                List<WebElement> requiredFields = allInputs.stream().filter((elem) -> {
                    boolean isFileInput = Objects.equals(elem.getAttribute("id"), "uploadPicture");
                    boolean isRadioInput = Objects.equals(elem.getAttribute("type"), "radio");
                    boolean isCheckboxInput = Objects.equals(elem.getAttribute("type"), "checkbox");
                    return !isFileInput && !isRadioInput && !isCheckboxInput;
                }).toList();

                FieldsDTO fieldsDTO = FormUtils.getFields(requiredFields);
                FormUtils.fillInputFields(fieldsDTO.getInputFields(), Constants.INPUT_FIELD_VALUE);
                FormUtils.fillInputFields(fieldsDTO.getPhoneInput(), Constants.PHONE_FIELD_VALUE);
                FormUtils.fillInputFields(fieldsDTO.getEmailInput(), Constants.EMAIL_FIELD_VALUE);
                FormUtils.setInputCheckboxes(fieldsDTO.getCheckboxes(), Constants.CHECKBOX_FIELD_VALUE);
                FormUtils.markInputRadiosByOption(fieldsDTO.getRadios(), Constants.GENDER_FIELD_VALUE);

                WebElement subjectInputField = FormUtils.getElementFromListById(fieldsDTO.getSelectInputs(), "subjectsInput");
                WebElement stateInputField = FormUtils.getElementFromListById(fieldsDTO.getSelectInputs(), "react-select-3-input");
                WebElement cityInputField = FormUtils.getElementFromListById(fieldsDTO.getSelectInputs(), "react-select-4-input");


                subjectInputField.click();
                FormUtils.fillInputField(subjectInputField, Constants.SUBJECT_FIELD_VALUE, true);
                FormUtils.fillInputField(stateInputField, Constants.STATE_FIELD_VALUE, true);
                FormUtils.fillDatePickers(fieldsDTO.getDatePickers(), new Date(110, 10, 10));

                wait.until(d -> d.findElements(By.tagName("div"))
                            .stream()
                            .anyMatch(e -> e.getText().equals(Constants.STATE_FIELD_VALUE))
                );

                FormUtils.fillInputField(cityInputField, Constants.CITY_FIELD_VALUE, true);
                btnElem.click();

                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
                WebElement elem =driver.findElement(By.tagName("table"));

                List<WebElement> rows = elem.findElements(By.tagName("tr"));
                String studentName = FormUtils.findTableMatchByLabel(rows, "Student Name");
                String studentEmail = FormUtils.findTableMatchByLabel(rows, "Student Email");
                String gender = FormUtils.findTableMatchByLabel(rows, "Gender");
                String mobile = FormUtils.findTableMatchByLabel(rows, "Mobile");
                String dateOfBirth = FormUtils.findTableMatchByLabel(rows, "Date of Birth");
                String subjects = FormUtils.findTableMatchByLabel(rows, "Subjects");
                String hobbies = FormUtils.findTableMatchByLabel(rows, "Hobbies");
                String address = FormUtils.findTableMatchByLabel(rows, "Address");
                String stateAndCity = FormUtils.findTableMatchByLabel(rows, "State and City");

                Assert.assertEquals(studentName, Constants.INPUT_FIELD_VALUE + " "+ Constants.INPUT_FIELD_VALUE);
                Assert.assertEquals(studentEmail,Constants.EMAIL_FIELD_VALUE) ;
                Assert.assertEquals(gender, Constants.GENDER_FIELD_VALUE);
                Assert.assertEquals(mobile, Constants.PHONE_FIELD_VALUE);
                Assert.assertEquals(subjects, Constants.SUBJECT_FIELD_VALUE);
                Assert.assertEquals(hobbies.replaceAll(" ","").split("\\,").length, 3);
                Assert.assertEquals(address, Constants.INPUT_FIELD_VALUE);
                Assert.assertEquals(dateOfBirth, "10 November,2010");
                Assert.assertEquals(stateAndCity, Constants.STATE_FIELD_VALUE + " " + Constants.CITY_FIELD_VALUE);
            });
        });
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}