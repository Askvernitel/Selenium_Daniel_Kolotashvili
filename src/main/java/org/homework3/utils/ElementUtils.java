package org.homework3.utils;

import org.homework3.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementUtils {


    public static List<WebElement> findElements(BasePage page, By... locators) {
        return Arrays.stream(locators).flatMap((locator) -> {
            List<WebElement> resultElementList = page.findElements(locator);
            return resultElementList.stream();
        }).toList();
    }

    public static WebElement findElementByText(List<WebElement> elements, String text){
        return elements.stream().filter(element-> element.getText().startsWith(text)).findFirst().orElse(null);
    }
    /*
    public static List<WebElement> findElement(BasePage page, By parent, By child){
        return Arrays.stream(locators).flatMap((locator)->{
            List<WebElement> resultElementList = page.findElements(locator);
            return resultElementList.stream();
        }).toList();
    }*/


}
