package utils;

import interfaces.Macro;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DriverUtils {
    public static void run(WebDriver driver, Macro<WebDriver> transform) {
        if (driver == null) {
            throw new NullPointerException("Provided Driver is null");
        }
        try {
            transform.run(driver);
        } catch (Exception e) {
            System.out.println("Error In Driver Utils run(WebDriver, Macro<WebDriver>): " + e.getMessage());
            System.out.println("Stack Trace:");
            e.printStackTrace(System.out);
            Assert.fail("Exception In Driver Run Was Thrown");
        }
    }
}
