package com.test.utils;

public class ExcelDataProvider {
	
	public static Object[][] testData(String excelPath, String sheetName){
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount; j++) {
				String cellData = excel.getCraName(i, j);
				data[i-1][j] = cellData;
			}
		}
		return data;
	}

}
