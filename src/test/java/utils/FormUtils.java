package utils;

import dto.FieldsDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class FormUtils {
    public static FieldsDTO getFields(List<WebElement> elements){
        FieldsDTO result = new FieldsDTO();
        elements.forEach((elem)->{
            String labelFor = elem.getAttribute("for");
            if(labelFor != null && labelFor.contains("radio")) {
                result.getRadios().add(elem);
                return;
            }
            if(labelFor != null && labelFor.contains("checkbox")){
                result.getCheckboxes().add(elem);
                return;
            }

            String id = elem.getAttribute("id");
            if (id == null) {
                Assert.fail("Element Id Not Found");
            }

            switch (id) {
                case "userEmail":
                    result.getEmailInput().add(elem);
                    return;
                case "userNumber":
                    result.getPhoneInput().add(elem);
                    return;
                case "dateOfBirthInput":
                    result.getDatePickers().add(elem);
                    return;
                case "subjectsInput":
                    result.getSelectInputs().add(elem);
                    return;
                case "react-select-4-input":
                    result.getSelectInputs().add(elem);
                    return;
                case "react-select-3-input":
                    result.getSelectInputs().add(elem);
                    return;
            }
            result.getInputFields().add(elem);
        });
        return result;
    }
    public static void fillDatePickers(List<WebElement> elem, Date date){
        elem.forEach((welem) -> fillDatePicker(welem, date));
    }
    public static void fillDatePicker(WebElement elem, Date date){
        String strDate = new SimpleDateFormat("d MMM yyyy").format(date.getTime());
        elem.sendKeys(Keys.CONTROL + "a");
        elem.sendKeys(strDate);
        elem.sendKeys(Keys.ENTER);
    }
    public static void fillSelectInputFields(List<WebElement> elem, String input){
        elem.forEach((welem) -> fillInputField(welem, input, true));
    }
    public static void fillInputFields(List<WebElement> elem, String input) {
        elem.forEach((welem) -> fillInputField(welem, input, false));
    }
    public static void fillInputField(WebElement elem, String value, Boolean pressTab){
        try{
            elem.sendKeys(value);
            if(pressTab){
                elem.sendKeys(Keys.TAB);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void setInputCheckboxes(List<WebElement> elem, Boolean value){
        elem.forEach((welem)->{ setInputCheckbox(welem, value);});
    }
    public static void setInputCheckbox(WebElement elem, Boolean value){
        try{
            if(value && !elem.isSelected()){
                elem.click();
            }else if(!value && elem.isSelected()){
                elem.click();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void markInputRadiosByOption(List<WebElement> elem, String option){
        elem.forEach((welem)->{
            if(welem.getText().equals(option)){
                markInputRadio(welem);
            }
        });
    }
    public static void markInputRadio(WebElement elem){
        try{
            elem.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static WebElement getElementFromListById(List<WebElement> elems , String id){
        if (id == null){
            return null;
        }
        return elems.stream().filter((elem)->{
            return Objects.equals(elem.getAttribute("id"), id);
        }).findFirst().get();
    }

    public static String findTableMatchByLabel(List<WebElement> elems, String label){
        for(WebElement elem:elems){
            List<WebElement> tds = elem.findElements(By.tagName("td"));
            if(tds.isEmpty()){
                continue;
            }
            WebElement td1 = tds.get(0);
            WebElement td2 = tds.get(1);
            if(td1.getText().equals(label)){
                return td2.getText();
            }
        }
        return "";
    }


}
