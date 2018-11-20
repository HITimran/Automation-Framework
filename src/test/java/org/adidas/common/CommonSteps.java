package org.adidas.common;

import org.adidas.common.globalLibrary.Ex;
import org.adidas.common.pages.HomePage;
import org.adidas.common.pages.PostFormSubmissionPage;
import org.adidas.common.pages.SamplePage;

import java.util.List;
import java.util.Optional;

import static org.adidas.common.CommonSetup.driver;
import static org.adidas.common.utils.excelUtils.testLiterals.TestDataSheetName.formValidation;
import static org.adidas.common.utils.excelUtils.testLiterals.common.Scenario;

public class CommonSteps  {

    SamplePage samplePage;
    HomePage homePage;
    PostFormSubmissionPage postFormSubmissionPage;

    protected HomePage navigateToHomePage() {
        homePage = driver.homepage();
        return homePage;
    }

    protected SamplePage navigateToSamplePage() {
        samplePage = homePage.navigateToSamplePage();
        return samplePage;
    }

    protected void executeScenario() {
        Optional<List<String>> scenarios =
                Ex.getTestData().getColumnValues(formValidation.name(), Scenario.name());

        scenarios.ifPresent(l -> l.stream()
                .forEach(elem -> {
                    samplePage.Scenario(elem);
                    postFormSubmissionPage = samplePage.navigateToPostFormSubmissionPage();
                    postFormSubmissionPage.validate(elem);

                }));
    }


}
