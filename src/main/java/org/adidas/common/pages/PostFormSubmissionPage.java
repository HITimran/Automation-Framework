package org.adidas.common.pages;

import org.adidas.common.globalLibrary.Get;
import org.adidas.common.utils.excelUtils.testLiterals.TestDataSheetName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.adidas.common.utils.SeleniumUtils.captureScreenShots;

public class PostFormSubmissionPage {
    private WebDriver driver;

    @FindBy(partialLinkText = "Back")
    WebElement btnBack;

    @FindBy(xpath = "//*[@id=\"error-page\"]/p[2]")
    WebElement lblErrorMessage;

    @FindBy(xpath = "//h1")
    WebElement lblErrorMethodNotAllowed;

    String currentUrl;

    public PostFormSubmissionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void validate(String test) {
        this.currentUrl = Get.steps().getActiveURL(driver);

        if (isOnSamePage()) {
            checkForCommentInModerateReview(test);
        } else if (noErrorOnPage(test)) {
            validateErrorMessage(test, lblErrorMessage);
            backToSamplePage();
        }
    }

    private void validateErrorMessage(String test, WebElement element) {
        Get.chkPoints().validateText(driver, element, TestDataSheetName.formValidation, test, "Expected Value");
    }

    private void backToSamplePage() {
        Get.steps().click(btnBack, "coming back");
    }

    private void checkForCommentInModerateReview(String test) {

        captureScreenShots(driver);
        By comment = By.xpath("//*[@id=\"" + currentUrl.split("#")[1] + "\"]/div[2]/div[2]/p");
        validateErrorMessage(test, driver.findElement(comment));
    }

    private boolean isOnSamePage() {
        return
                currentUrl.contains("sample-page/#comment-") &&
                        (!currentUrl.contains("wp-comments-post"));
    }

    boolean noErrorOnPage(String test) {
        if ((!Get.validator().ifElementExist(lblErrorMessage)) && Get.steps().getText(lblErrorMethodNotAllowed).equalsIgnoreCase("405 Not Allowed")) {
            validateErrorMessage(test, lblErrorMethodNotAllowed);
            Get.steps().navigate(driver, "http://store.demoqa.com/sample-page/");
            return false;
        }
        return true;
    }
}
