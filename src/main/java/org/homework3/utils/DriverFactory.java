package org.homework3.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
    private static WebDriver driver;



    //NOTE: Probably It Is Better Enum Instead of type String
    public static void initDriverOf(String typeStr){
        typeStr=typeStr.toLowerCase();

        switch(typeStr){
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new InvalidArgumentException("Provide Correct Driver Type");
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        System.out.println("Quiting Driver");
        if(driver == null) return;
        System.out.println("Quiting Driver");
        driver.quit();
    }
}
