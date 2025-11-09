package utils;

import interfaces.Macro;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ElementUtils {
    public static void run(WebElement element, Macro<WebElement> transform) {
        if(element == null){
            throw new NullPointerException("Provided Web Element is null");
        }
        try {
            transform.run(element);
        } catch (Exception e) {
            System.out.println("Error In Element Utils run(WebElement, Macro<WebElement>): " + e.getMessage());
            System.out.println("Stack Trace:");
            e.printStackTrace(System.out);
        }
    }

    public static void runScrollBefore(WebElement element, WebDriver driver, Macro<WebElement> transform){
        if(element == null){
            throw new NullPointerException("Provided Web Element is null");
        }
        try {
            Actions actions = new Actions(driver);
            int height = element.getSize().height;
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
            actions.scrollByAmount( 0,3*height).perform();

            transform.run(element);
        } catch (Exception e) {
            System.out.println("Error In Element Utils run(WebElement,WebDriver,Macro<WebElement>): " + e.getMessage());
            System.out.println("Stack Trace:");
            e.printStackTrace(System.out);
            Assert.fail("Exception in Element Run Scroll Before was thrown:" + e.getMessage());
        }
    }
}
