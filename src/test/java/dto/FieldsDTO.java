package dto;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FieldsDTO {
    private List<WebElement> checkboxes;
    private List<WebElement> radios;
    private List<WebElement> inputFields;
    private List<WebElement> phoneInputs;
    private List<WebElement> emailInputs;
    private List<WebElement> selectInputs;
    private List<WebElement> datePickers;

    public FieldsDTO(){
        this.radios = new ArrayList<>();
        this.checkboxes = new ArrayList<>();
        this.inputFields = new ArrayList<>();
        this.phoneInputs = new ArrayList<>();
        this.emailInputs = new ArrayList<>();
        this.selectInputs = new ArrayList<>();
        this.datePickers = new ArrayList<>();
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(List<WebElement> checkboxes) {
        this.checkboxes = checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public void setRadios(List<WebElement> radios) {
        this.radios = radios;
    }

    public List<WebElement> getInputFields() {
        return inputFields;
    }

    public void setInputFields(List<WebElement> inputFields) {
        this.inputFields = inputFields;
    }

    public List<WebElement> getPhoneInput() {
        return phoneInputs;
    }

    public void setPhoneInput(List<WebElement> phoneInput) {
        this.phoneInputs = phoneInput;
    }

    public List<WebElement> getEmailInput() {
        return emailInputs;
    }

    public void setEmailInput(List<WebElement> emailInput) {
        this.emailInputs = emailInput;
    }

    public List<WebElement> getSelectInputs() {
        return selectInputs;
    }

    public void setSelectInputs(List<WebElement> selectInputs) {
        this.selectInputs = selectInputs;
    }

    public List<WebElement> getDatePickers() {
        return datePickers;
    }

    public void setDatePickers(List<WebElement> datePickers) {
        this.datePickers = datePickers;
    }


}
