package org.adidas.common.utils;

import org.adidas.common.globalLibrary.Get;
import org.adidas.common.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.adidas.common.utils.Files.TMP_DIRECTORY;
import static org.adidas.common.utils.Files.cleanDirectory;
import static org.adidas.common.utils.SeleniumUtils.captureScreenShots;

public class DriverUtils {
    private static WebDriver driver;
    final static Logger log = Logger.getLogger(DriverUtils.class.getName());

    static HomePage homePage;

    public HomePage homepage() {
        return homePage = PageFactory.initElements(driver, HomePage.class);
    }

    static void kilDriver() {
        try {
            Runtime.getRuntime().exec(new String[]{"cmd", "taskkill/F /IM chromedriver.exe", "Start"});
            log.info("kill driver instance before launching the browser");
        } catch (IOException e) {
            log.fatal(e.getMessage());
        }
    }

    public void OpenBrowser() {
        kilDriver();
        cleanDirectory(TMP_DIRECTORY);
        chromeSetUp();
        Get.steps().navigate(driver, "http://store.demoqa.com/");
        captureScreenShots(driver);
    }

    private void chromeSetUp() {
        System.setProperty("webdriver.chrome.driver", ".\\target\\classes\\lib\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.close();
        driver.quit();
        log.info("Successfully close the browser");
    }
}
