package org.adidas.common.utils;

import org.adidas.common.globalLibrary.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Validator {

    public boolean ifElementExist(WebElement element)
    {
        try{
        if(element.isDisplayed())
        {return true;}
        return false;}
        catch(Exception e)
        {

        }return false;
    }

    public boolean IfValueExist(WebDriver driver,By by)
    {
       List<WebElement> elements= driver.findElements(by);
        for (WebElement e: elements) {
            Get.steps().getText(e);
           // if(Get.steps().getText(e))
        }
        return true;
    }
}
