package org.homework3.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    By alertWithTextBoxAnchorLocator = By.cssSelector("a[href='#Textbox']");

    By promptButtonLocator = By.cssSelector("button[onclick='promptbox()']");

    By greetingParagraphLocator = new By.ById("demo1");
    public AlertPage(WebDriver driver, String url) {
        super(driver, url);
    }


    public AlertPage clickAlertWithTextBoxAnchor(){
        click(alertWithTextBoxAnchorLocator);
        return this;
    }
    public AlertPage clickPromptButton(){
        click(promptButtonLocator);
        return this;
    }
    public AlertPage setAlertPrompt(String input){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(input);
        alert.accept();
        return this;
    }

    public String getGreetingParagraph(){
        return findElement(greetingParagraphLocator).getText();
    }


}
