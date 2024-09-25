package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGUnitTestCases {

	@Test()
	public void test1() {
		System.out.println("This is Test NG Unit test case");
	}

	@Test()
	public void test2() {
		if (100 == 10) {
			System.out.println("This is Test NG Unit test case is Pass");
		} else {
			System.out.println("This is Test NG Unit test case is Fail");
		}

	}
	
	@Test()
	public void test3() {
		Assert.assertEquals(true, 100 == 10, "This is Test NG Unit test case is Fail");
	}
	
	@Test()
	public void test4() {
		Assert.assertTrue(100 == 100, "This is Test NG Unit test case is Fail");
	}

}
