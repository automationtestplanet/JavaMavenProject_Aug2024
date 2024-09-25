package test;

import demo.file.operations.ExcelOperations;

public class FileOperations {

	public static void main(String[] args) {
		String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Test.xlsx";
		String sheetName = "Languages";
		ExcelOperations excel = new ExcelOperations();
		excel.readDataFromExcel(excelFilePath,sheetName);

	}
}
