package com.test.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) {
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("* Total of resources in excel sheet:: "+ (rowCount-1));
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} catch (Exception e) {
			e.getMessage();
			e.getCause();
			e.printStackTrace();
		}
		return colCount;
	}
	
	public String getCraName(int row, int col) {
		String cellData= null;
		try {
			cellData = sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	
	public double getTicketCount(int row, int col) {
		double cellData = 0;
		try {
			cellData = sheet.getRow(row).getCell(col).getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	

}
