package org.adidas.common.pages;

import org.adidas.common.globalLibrary.Get;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "menu-item-54")
    WebElement lblSamplePage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SamplePage navigateToSamplePage() {
        Get.steps().click(lblSamplePage, " sample page link ");
        return PageFactory.initElements(driver, SamplePage.class);
    }

}