package tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.DriverUtils;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class AlertTests {
    WebDriver driver;

    private class Constants {
        private static final String ALERT_INPUT = "Daniel Kolotashvili";
    }

    @Parameters(value = "ALERT_URL")
    @BeforeClass
    public void setup(String alertUrl) {
        driver = new FirefoxDriver();
        DriverUtils.run(driver, (driver) -> {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.navigate().to(alertUrl);
        });
    }

    @Test
    public void testAlerts() {
        DriverUtils.run(driver, (driver) -> {
            List<WebElement> elems = driver.findElements(By.className("analystic"));
            WebElement linkBtn = elems.stream().filter(e -> e.getText().startsWith("Alert with Textbox")).findFirst().get();
            linkBtn.click();
            List<WebElement> btns = driver.findElements(By.className("btn"));

            WebElement alertBtn = btns.stream().filter(e -> e.getText().startsWith("click the button to demonstrate the prompt box")).findFirst().get();
            alertBtn.click();
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(Constants.ALERT_INPUT);
            alert.accept();

            WebElement outputText = driver.findElement(By.id("demo1"));
            Assert.assertTrue(outputText.getText().contains(Constants.ALERT_INPUT));
        });


    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
