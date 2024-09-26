package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTestCasesExecutionOrder {

//	@Test(priority = 2)
	@Test(groups = "RegressionTest", priority = 3, dataProvider = "TestData3")
	public void deleteUser(Integer values) {
		System.out.println("This is Delete User Method");
		System.out.println(values);
	}

//	@Test(priority = 0)
//	@Test(invocationCount = 5, enabled = false)
	@Test(groups = { "SmokeTest", "SanityTest", "RegressionTest" }, priority = 0)
	@Parameters({ "UserName", "Job" })
	public void addUser(String userName, String job) {
		System.out.println("This is Add User Method");
		System.out.println(userName);
		System.out.println(job);
	}

//	@Test(priority = 1)
	@Test(groups = "RegressionTest", priority = 2, dataProvider = "TestData1", dependsOnMethods = "addUser")
	public void getUser(int empid) {
		System.out.println("This is Get User Method");
		System.out.println(empid);
	}

	@Test(groups = { "SanityTest", "RegressionTest" }, priority = 1, dataProvider = "TestData2") // default priority is 0
	public void updateUser(Object[] eachObj) {
		System.out.println("This is Update User Method");		
		for(Object eachNum:eachObj) {
			System.out.println(eachNum);
		}
	}

	@DataProvider(name = "TestData1")
	public Object[] testData1() {
		Object[] obj1 = { 1, 2, 3, 4, 5 };
		return obj1;
	}

	@DataProvider(name = "TestData2")
	public Object[][] testData2() {
		Object[][] obj2 = { { 1, 2, 3, 4, 5 }, { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 } };
		return obj2;
	}

	@DataProvider(name = "TestData3")
	public Iterator<Integer> testData3() {
		Iterator<Integer> itr = new ArrayList<Integer>(Arrays.asList(101, 102, 103, 104)).iterator();
		return itr;
	}
	
	@DataProvider(name = "TestData4")
	public ArrayList<Integer> testData4() {
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(101, 102, 103, 104));
		return arrList;
	}

}
