package week5.day2.assignment2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	// change the main method to normal method
	public static String[][] readData(String fileName) throws IOException {

		// setup the path for workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");

		// Get into Respective sheet
		XSSFSheet ws = wb.getSheetAt(0);

		// to get row count
		int rowCount = ws.getLastRowNum();
		// System.out.println("Row Count : "+rowCount);

		// to get the cellcount
		int cellCount = ws.getRow(0).getLastCellNum();
		// System.out.println("Cell Count : "+cellCount);

		// how to integrate readexcel with data provider
		// 1.declare 2d string array

		String[][] data = new String[rowCount][cellCount];

		// to read all the data - nested for loop

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellval = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellval);
				data[i - 1][j] = cellval;
			}
		}
		// close the workbook
		wb.close();

		// apply return data at last by making method return type to string[][]
		return data;

	}

}
