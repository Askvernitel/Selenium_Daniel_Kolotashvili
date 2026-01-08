package org.homework3.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void type(By locator, String input){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
    }

    public void type(By locator, Keys keys){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(keys);
    }

    public List<WebElement> findElements(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }


    public void scrollTo(By locator, Integer factor) {
        WebElement element=driver.findElement(locator);
        Actions actions = new Actions(driver);
        int height = element.getSize().height;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
        actions.scrollByAmount( 0,factor*height).perform();
    }

    public String getText(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
