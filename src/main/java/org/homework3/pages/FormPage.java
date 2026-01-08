package org.homework3.pages;

import org.homework3.enums.GenderType;
import org.homework3.enums.HobbyType;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage extends BasePage {
    private String url;
    private By inputTagLocator = By.tagName("input");
    private By textAreaTagLocator = By.tagName("textarea");

    private By customInputClassNameLocator = By.className("custom-control-label");


    private By firstNameLocator = new By.ById("firstName");
    private By lastNameLocator = new By.ById("lastName");
    private By emailLocator  = new By.ById("userEmail");
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
    public FormPage(WebDriver driver, String url) {
        super(driver);
        this.url = url;
        driver.navigate().to(url);
    }
    public void clickSubmitButton(){
        click(submitButtonLocator);
    }


    public FormPage setFirstNameField(String input){
        type(firstNameLocator, input);
        return this;
    }
    public FormPage setLastNameField(String input){
        type(lastNameLocator, input);
        return this;
    }

    public FormPage setEmailField(String input){
        type(emailLocator, input);
        return this;
    }
    public FormPage setGenderField(GenderType input){
        switch(input){
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
    public FormPage setPhoneNumberField(String input){
        type(phoneNumberLocator, input);
        return this;
    }
    public FormPage setDateOfBirthField(String input){
        return this;
    }
    public FormPage setSubjectField(String input){
        type(subjectLocator, input);
        type(subjectLocator, Keys.TAB);
        return this;
    }
    public FormPage setHobbiesField(HobbyType input){
        switch(input){
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
    public FormPage setCurrentAddressField(String input){
        type(currentAddressLocator, input);
        return this;
    }
    public FormPage setStateField(String input){
        type(stateLocator, input);
        type(stateLocator, Keys.ENTER);
        return this;
    }
    public FormPage setCityField(String input){
        type(cityLocator, input);
        type(cityLocator, Keys.ENTER);
        return this;
    }

    public FormPage scrollToSubmitButton(){
        scrollTo(submitButtonLocator, 4);
        return this;
    }

}
