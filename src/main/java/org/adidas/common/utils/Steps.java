package org.adidas.common.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {
    final static Logger log = Logger.getLogger(DriverUtils.class.getName());

    public Steps navigate(WebDriver driver, String url) {
        try {

            driver.get(url);
            log.info("Navigate to : " + url);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return this;
    }

    public Steps type(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            log.info("added text : " + text);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return this;
    }

    public Steps click(WebElement element, String elementName) {
        try {
            element.click();
            log.info("click element :" + elementName);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return this;
    }

    public Steps submit(WebElement element, String elementName) {
        try {
            element.submit();
            log.info("submit      :" + elementName);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return this;
    }

    public String getText(WebElement element) {
        String text=null;
        try {
            text=element.getText();
            log.info("text is    :"+ text);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return text;
    }

    public String getActiveURL(WebDriver driver) {
        String text=null;
        try {
            text=driver.getCurrentUrl();
            log.info("the current URL is    :"+ text);
        } catch (Exception e) {
            log.fatal(e.getMessage());
        }
        return text;
    }

}
