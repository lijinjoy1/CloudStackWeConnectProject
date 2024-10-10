package com.weconnect.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityFile {

	private Workbook workbook;
    private Sheet sheet;

    // Constructor to initialize the Excel file and sheet
    public ExcelUtilityFile(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            this.workbook = WorkbookFactory.create(fileInputStream);
            this.sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read all data from the sheet
    public String[][] readData() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] data = new String[rowCount - 1][colCount]; // Exclude header

        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    data[i - 1][j] = cell.toString(); // Convert cell to String
                } else {
                    data[i - 1][j] = ""; // Handle empty cells
                }
            }
        }

        return data;
    }

    // Close the workbook
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

	
	
}
