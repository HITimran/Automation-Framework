package org.adidas.common;

import org.adidas.common.globalLibrary.Ex;
import org.adidas.common.pages.HomePage;
import org.adidas.common.utils.DriverUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static org.adidas.common.utils.Files.TMP_DIRECTORY;

public interface CommonSetup {
    Logger log = Logger.getLogger(CommonSetup.class.getName());
    DriverUtils driver = new DriverUtils();
    String EXCEL_RESULT_PATH = TMP_DIRECTORY + "\\resultFile.xlsx";

    @BeforeTest
    default void beforeTest() {
        log.info("Before Test method");
        driver.OpenBrowser();
    }

    @AfterTest
    default void afterTest() {
        log.info("After Test method");
        driver.closeBrowser();
    }

    @AfterSuite(alwaysRun = true)
    default void AfterSuite() {
        log.info("After Suite method");
        Ex.getTestData().excelWriteOut(EXCEL_RESULT_PATH);
    }
}
