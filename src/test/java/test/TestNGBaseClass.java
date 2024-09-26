package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class TestNGBaseClass {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is Before Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("This is Before Test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is After Test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is After Suite");
	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

}
