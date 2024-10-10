package com.weconnect.Utilities;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
	

        
	@DataProvider(name = "excelDataProvider")
    public static Object[][] excelData() {
        String filePath = ".\\testData\\test_data.xlsx"; // Update this path
        String sheetName = "Sheet1";

        // Create an instance of ExcelUtil
        ExcelUtilityFile excelUtil = new ExcelUtilityFile(filePath, sheetName);

        // Read data from Excel
        String[][] excelData = excelUtil.readData();

        // Close the Excel workbook
        excelUtil.close();

        return excelData;
    }
	   
        
}
