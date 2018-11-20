package org.adidas.common.utils.excelUtils;

import org.adidas.common.utils.excelUtils.testLiterals.TestStatus;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

import static org.adidas.common.utils.Files.TMP_DIRECTORY;

public class ExcelInit extends ExcelUtils {

    public ExcelInit(String filePath) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void excelWriteOut(String outputPath) {
        try {
            FileOutputStream out = new FileOutputStream(outputPath);
            workbook.write(out);
            out.close();
            workbook = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //TODO delete the below , Oly require for testing
    static String EXCEL_RESULT_PATH = TMP_DIRECTORY + "\\resultFile.xlsx";
    private static final String TEST_DATA_PATH = "src/test/resource/testData.xlsx";

    public static void main(String[] args) {
        ExcelInit ex = new ExcelInit(TEST_DATA_PATH);
        System.out.println(ex.getCellValue("formValidation", "Test1", "Name213", TestStatus.SKIP));
        System.out.println(ex.getColumnValues("formValidation", "Expectation"));

        ex.excelWriteOut(EXCEL_RESULT_PATH);
    }

}
