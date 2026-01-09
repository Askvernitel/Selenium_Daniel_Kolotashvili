package org.homework3.pages;

import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;
import org.openqa.selenium.*;

import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormPage extends BasePage {
    private By firstNameLocator = new By.ById("firstName");
    private By lastNameLocator = new By.ById("lastName");
    private By emailLocator = new By.ById("userEmail");
    private By phoneNumberLocator = new By.ById("userNumber");
    private By subjectLocator = new By.ById("subjectsInput");
    private By currentAddressLocator = new By.ById("currentAddress");
    private By stateLocator = new By.ById("react-select-3-input");
    private By cityLocator = new By.ById("react-select-4-input");


    private By maleCheckboxLocator = new By.ByCssSelector("label[for='gender-radio-1']");
    private By femaleCheckboxLocator = new By.ByCssSelector("label[for='gender-radio-2']");
    private By otherCheckboxLocator = new By.ByCssSelector("label[for='gender-radio-3']");

    private By sportsCheckboxLocator = new By.ByCssSelector("label[for='hobbies-checkbox-1']");
    private By readingCheckboxLocator = new By.ByCssSelector("label[for='hobbies-checkbox-2']");
    private By musicCheckboxLocator = new By.ByCssSelector("label[for='hobbies-checkbox-3']");

    private By submitButtonLocator = new By.ById("submit");

    private By tableLocator = By.className("modal-body");
    private By tableRowLocator = By.tagName("tr");
    private By tableColumnLocator = By.tagName("td");

    public FormPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public void clickSubmitButton() {
        click(submitButtonLocator);
    }


    public FormPage setFirstNameField(String input) {
        type(firstNameLocator, input);
        return this;
    }

    public FormPage setLastNameField(String input) {
        type(lastNameLocator, input);
        return this;
    }

    public FormPage setEmailField(String input) {
        type(emailLocator, input);
        return this;
    }

    public FormPage setGenderField(GenderType input) {
        switch (input) {
            case MALE:
                click(maleCheckboxLocator);
                break;
            case FEMALE:
                click(femaleCheckboxLocator);
                break;
            case OTHER:
                click(otherCheckboxLocator);
                break;
            case null:
                throw new NullPointerException();
            default:
                throw new InvalidArgumentException("Invalid Argument For Gender Field");
        }
        return this;
    }

    public FormPage setPhoneNumberField(String input) {
        type(phoneNumberLocator, input);
        return this;
    }

    public FormPage setDateOfBirthField(String input) {
        return this;
    }

    public FormPage setSubjectField(String input) {
        type(subjectLocator, input);
        type(subjectLocator, Keys.TAB);
        return this;
    }

    public FormPage setHobbiesField(HobbyType input) {
        switch (input) {
            case SPORTS:
                click(sportsCheckboxLocator);
                break;
            case READING:
                click(readingCheckboxLocator);
                break;
            case MUSIC:
                click(musicCheckboxLocator);
                break;
            case null:
                throw new NullPointerException();
            default:
                throw new InvalidArgumentException("Invalid Argument For Gender Field");
        }
        return this;
    }

    public FormPage setCurrentAddressField(String input) {
        type(currentAddressLocator, input);
        return this;
    }

    public FormPage setStateField(String input) {
        type(stateLocator, input);
        type(stateLocator, Keys.ENTER);
        return this;
    }

    public FormPage setCityField(String input) {
        type(cityLocator, input);
        type(cityLocator, Keys.ENTER);
        return this;
    }


    public FormPage scrollToSubmitButton() {
        scrollTo(submitButtonLocator, 4);
        return this;
    }


    public Map<String, String> getTableLabelMap() {
        Map<String, String> resultLabelMap = new HashMap<>();
        WebElement table = driver.findElement(tableLocator);

        List<WebElement> tableRows = table.findElements(tableRowLocator);

        for (WebElement tableRow : tableRows) {
            List<WebElement> tableColumn = tableRow.findElements(tableColumnLocator);
            boolean enoughColumns = tableColumn.size() >= 2;

            if (!enoughColumns) {
                continue;
            }
            String label = tableColumn.getFirst().getText();
            String value = tableColumn.getLast().getText();

            resultLabelMap.put(label, value);
        }
        return resultLabelMap;
    }

    public static String findTableMatchByLabel(List<WebElement> elems, String label) {
        for (WebElement elem : elems) {
            List<WebElement> tds = elem.findElements(By.tagName("td"));
            if (tds.isEmpty()) {
                continue;
            }
            WebElement td1 = tds.get(0);
            WebElement td2 = tds.get(1);
            if (td1.getText().equals(label)) {
                return td2.getText();
            }
        }
        return "";
    }


}
