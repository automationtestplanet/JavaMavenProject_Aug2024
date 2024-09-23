package demo.file.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public void writeDataToExcel(String filePath, String sheetName, int rowNum, int coulmnNum, String data) {
		try {
			File excelFile = new File(filePath);
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook excelWorkBook = new XSSFWorkbook(fis);
			XSSFSheet augustSheet = excelWorkBook.getSheet(sheetName);
			Row row1 = augustSheet.createRow(rowNum);
			Cell cell1 = row1.createCell(coulmnNum);
			cell1.setCellValue(data);

			FileOutputStream fos = new FileOutputStream(excelFile);
			excelWorkBook.write(fos);
			fos.close();
		} catch (Exception e) {
			System.out.println("Exception Occured while Wirting the data to Excel: " + e.getMessage());
		}
	}

	public void readDataFromExcel(String filePath) {
		try {
			File excelFile = new File(filePath);
			FileInputStream fis = new FileInputStream(excelFile);
			XSSFWorkbook excelWorkBook = new XSSFWorkbook(fis);
			XSSFSheet languagesSheet = excelWorkBook.getSheet("Languages");
			Iterator<Row> allRows = languagesSheet.rowIterator();
			while (allRows.hasNext()) {
				Row eachRow = allRows.next();
				Iterator<Cell> allCell = eachRow.cellIterator();

				while (allCell.hasNext()) {
					Cell eachChell = allCell.next();
					String str = "";
					if (eachChell.getCellType() == CellType.STRING) {
						str = eachChell.getStringCellValue();
						System.out.print(str + " -> ");
					} else if (eachChell.getCellType() == CellType.NUMERIC) {
						double double1 = eachChell.getNumericCellValue();
						System.out.print(double1 + " -> ");
					} else if (eachChell.getCellType() == CellType.BLANK) {
						str = "EMPTY_COLUMN";
						System.out.print(str + " -> ");
					}
				}
				System.out.println("");
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while read data from excel: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Test.xlsx";

		ExcelOperations excel = new ExcelOperations();
		excel.readDataFromExcel(excelFilePath);		
		excel.writeDataToExcel(excelFilePath,"August2024", 0, 0, "This is New Data from Maven ");

	}
}
