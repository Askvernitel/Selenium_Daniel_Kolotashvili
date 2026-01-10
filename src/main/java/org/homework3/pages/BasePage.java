package org.homework3.pages;

import org.homework3.utils.GeneralUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    String url;

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.url = url;
        driver.navigate().to(url);
    }

    public void click(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void type(By locator, String input) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
    }

    public void type(By locator, Keys keys) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(keys);
    }

    public void screenshot(){
        GeneralUtils.screenshot(driver);
    }

    public List<WebElement> findElements(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    public WebElement findElement(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void scrollTo(By locator, Integer factor) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        int height = element.getSize().height;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
        actions.scrollByAmount(0, factor * height).perform();
    }

    public String getText(By locator) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }
}
