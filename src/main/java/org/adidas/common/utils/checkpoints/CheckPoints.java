package org.adidas.common.utils.checkpoints;

import org.adidas.common.globalLibrary.Ex;
import org.adidas.common.globalLibrary.Get;
import org.adidas.common.utils.excelUtils.testLiterals.TestDataSheetName;
import org.adidas.common.utils.excelUtils.testLiterals.TestStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.util.Objects.isNull;
import static org.adidas.common.utils.SeleniumUtils.captureScreenShots;

public class CheckPoints {

    public boolean validateText(WebDriver driver,WebElement element, TestDataSheetName sheetName, String row, String col) {
        TestStatus status = null;
        try{
        String excelValue = getValueFromExcel(sheetName, row, col);
        String uiValue=Get.steps().getText(element);
         status =
                (isNull(excelValue) ||
                        uiValue.equalsIgnoreCase(excelValue)) ? TestStatus.PASS : TestStatus.FAIL;

        setCommentToExcel( sheetName,  row,  col,  uiValue+"\n"+captureScreenShots(driver), status);
       }
       catch(Exception e)
       {
           captureScreenShots(driver);
       }return status==TestStatus.PASS?true:false;
    }

    private String getValueFromExcel(TestDataSheetName sheetName, String row, String col) {
        return Ex.getTestData().getCellValue(sheetName.name(), row, col).orElse(null);
    }
    private String getValueFromExcel(TestDataSheetName sheetName, String row, String col, TestStatus status) {
        return Ex.getTestData().getCellValue(sheetName.name(), row, col, status).orElse(null);
    }
    private void setCommentToExcel(TestDataSheetName sheetName, String row, String col, String comment,TestStatus status) {
         Ex.getTestData().setComment(sheetName.name(), row, col, comment,status);
    }
}
