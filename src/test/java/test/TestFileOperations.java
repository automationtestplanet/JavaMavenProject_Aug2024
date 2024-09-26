package test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.file.operations.Credentials;
import demo.file.operations.ExcelOperations;
import demo.file.operations.ObjectMapperToReadDataFromFiles;
import demo.file.operations.UserDetails;

public class TestFileOperations extends TestNGBaseClass {

	@Test
	public void testReadDataFromExcel() {
		String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Test.xlsx";
		String sheetName = "Languages";
		ExcelOperations excel = new ExcelOperations();
		List<String> list1 = excel.readDataFromExcel(excelFilePath, sheetName);
		System.out.println(list1);
		Assert.assertNotNull(list1, "ReadDataFromExcel not working");
	}

	@Test
	public void readDataFromJson() {
		String josnFilePah = System.getProperty("user.dir") + "\\src\\main\\resources\\UserDetails.json";
		ObjectMapperToReadDataFromFiles objMapper = new ObjectMapperToReadDataFromFiles();
		UserDetails userDetails = objMapper.readDataFromJson(josnFilePah);
		Assert.assertNotNull(userDetails.getUserName());
		Assert.assertNotNull(userDetails.getPassword());
	}

	@Test
	public void readDataFromXML() {
		String xmlFilePah = System.getProperty("user.dir") + "\\src\\main\\resources\\Credentials.xml";
		ObjectMapperToReadDataFromFiles objMapper = new ObjectMapperToReadDataFromFiles();
		Credentials credentials = objMapper.readDataFromXml(xmlFilePah);
		Assert.assertNotNull(credentials.getUserName());
		Assert.assertNotNull(credentials.getPassword());
	}

}
