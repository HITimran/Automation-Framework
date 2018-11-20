package org.adidas.common;

import org.testng.annotations.Test;

public class AppTest extends CommonSteps implements CommonSetup {

    @Test
    public void testCase() {
        navigateToHomePage();
        navigateToSamplePage();
        executeScenario();
    }


}
