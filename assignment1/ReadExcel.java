package week5.day2.assignment1;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	// 3.change the main method to normal method
	public static String[][] readData(String fileName) throws IOException {

		// 1.setup the path for workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");

		// 2.Get into Respective sheet
		XSSFSheet ws = wb.getSheetAt(0);
		//wb.getSheetAt(0);

		// 3.Get into the respective row
		// XSSFRow row = ws.getRow(2);

		// 4.Get into the Respective Cell
		// XSSFCell cell = row.getCell(2);

		// 5.to read data from the cell
		// String cellval = cell.getStringCellValue();
		// System.out.println(cellval);

		// to get the column 1 data
		/*
		 * for (int i = 1; i <= 2; i++) {
		 * 
		 * String cellval = ws.getRow(i).getCell(0).getStringCellValue();
		 * System.out.println(cellval);
		 * 
		 * }
		 */

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
		// i-row
		// j-column
		// 2.save the excel data into data[i-1][j]
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				String cellval = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellval);
				data[i - 1][j] = cellval;
			}
		}
		// 6.close the workbook
		wb.close();

		// 4.apply return data at last by making method return type to string[][]
		return data;

	}

}
