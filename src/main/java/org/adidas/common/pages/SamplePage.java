package org.adidas.common.pages;

import org.adidas.common.globalLibrary.Ex;
import org.adidas.common.globalLibrary.Get;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.adidas.common.utils.excelUtils.testLiterals.TestDataSheetName.formValidation;

public class SamplePage {
    private WebDriver driver;

    @FindBy(xpath = "//textarea")
    WebElement txtComment;

    @FindBy(xpath = "//input[@id='author']")
    WebElement txtName;

    @FindBy(xpath = "//input[@id='email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='url']")
    WebElement txtWebSite;

    @FindBy(xpath = "//input[@id='submit']")
    WebElement btnSubmit;

    String testName;

    public SamplePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Scenario(String testName) {
        this.testName = testName;
        Get.steps().type(txtComment, getTestData("Comment"))
                .type(txtName, getTestData("Name"))
                .type(txtEmail, getTestData("Email"))
                .type(txtWebSite, getTestData("Website"));
    }

    public PostFormSubmissionPage navigateToPostFormSubmissionPage() {
        Get.steps().submit(btnSubmit, "btnSubmit");
        return PageFactory.initElements(driver, PostFormSubmissionPage.class);
    }

    private String getTestData(String testData) {
        return Ex.getTestData().getCellValue(formValidation.name(), testName, testData).orElse("");
    }

}
