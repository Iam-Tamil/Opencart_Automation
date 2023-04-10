package com.Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

public static String[][] getExcelData(String Filename) {
		
		XSSFWorkbook Wbook = null;
		try {
			Wbook = new XSSFWorkbook(System.getProperty("user.dir") 
					+ "/src/main/Excel File/"+Filename+".xlsx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = Wbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastRow][lastCell];
		
		for (int i = 1; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCell; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String Value = dft.formatCellValue(cell);
				data[i-1][j] = Value;      
			}
		}
		try {
			Wbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
		