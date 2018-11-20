package org.adidas.common.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static org.adidas.common.utils.Files.TMP_DIRECTORY;
import static org.adidas.common.utils.Helpers.Common.getRandomDigit;

public class SeleniumUtils {
    final static Logger log = Logger.getLogger(SeleniumUtils.class.getName());

    public static String captureScreenShots(WebDriver driver) {
        String screenshotName = "screenshot_" + getRandomDigit() + ".jpeg";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copyFiles(TMP_DIRECTORY + "\\" + screenshotName, scrFile);
        } catch (IOException e) {
            log.fatal(e.getMessage());
        }
        return screenshotName;
    }


}
