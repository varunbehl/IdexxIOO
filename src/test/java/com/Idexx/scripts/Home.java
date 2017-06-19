package com.Idexx.scripts;


import java.util.Hashtable;

//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.HomeLib;
import com.Idexx.page.HomePage;
//import com.automation.accelerators.TestEngine;
import com.automation.utilities.TestUtil;


public class Home extends HomeLib {

	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{	
		loginAsUserRole(userrole);
	}

	@DataProvider
	public Object[][] getTestDataFor_TestGlobalSearch() {
		return TestUtil.getData("TestGlobalSearch", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.2 <br> 
	 * This Test verify whether user can use global search bar.<br>
	 * Search an account, click on it and verify whether it can be clicked.
	 */
	@Test(dataProvider = "getTestDataFor_TestGlobalSearch",priority=2)
	public void TestGlobalSearch(Hashtable<String, String> data) throws Throwable {
		try {
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( "TC1.2");	
					goToHomePage();	
					doSearch(data.get("searchKey"));
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCustomize_AddTab() {
		return TestUtil.getData("TestCustomize_AddTab", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.3 <br>
	 * This Test verify whether user can Customize it's tabs displayed.<br>
	 * Add a tab and verify it is shown after saving the changes.
	 */
	@Test(dataProvider = "getTestDataFor_TestCustomize_AddTab",priority=3)
	public void TestCustomize_AddTab(Hashtable<String, String> data) throws Throwable {

		try {
		
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( "TC1.3");
					goToHomePage();
					customize_addTab(data.get("tabName"));
				} 
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider
	public Object[][] getTestDataFor_TestCustomize_RemoveTab() {
		return TestUtil.getData("TestCustomize_RemoveTab", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.3 <br>
	 * This Test verify whether user can Customize it's tabs displayed.<br>
	 * Add a tab and verify it is shown after saving the changes.
	 */
	@Test(dataProvider = "getTestDataFor_TestCustomize_RemoveTab",priority=4)
	public void TestCustomize_RemoveTab(Hashtable<String, String> data) throws Throwable {

		try {
			
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( "TC1.0");

					//provide the tab to be picked and add 
					// provide the tab to remove ...
					//goToHomePage();
					remove_Tab(data.get("tabName"));
				} 
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * TC-ID : TC1.4 <br>
	 * This Test verify whether user can view MyTasks and Calendar section.<br>
	 */
	@Test(priority=5)	
	public void TestVerifyMyTaskAndCalenderSection() throws Throwable
	{				
		try{
		
				this.reporter.initTestCaseDescription(  "TC1.1");  
				goToHomePage();
				new HomePage().Home_Page();
				assertTextMatching(HomePage.myTasksSectionHead, "My Tasks", "Verifying the mytaks section");
				assertElementPresent(HomePage.newTaskBtn, "verifying the new button");
				assertElementPresent(HomePage.myTaskTableHeader, "verifying the MyTasks table header");
				assertTextMatching(HomePage.myTasksSectionHead, "My Tasks", "Verifying the mytaks section");
				assertTextMatching(HomePage.calenderSectionHead, "Calendar", "Verifying the calender section");
			
		}

		catch(Exception e){			
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_ActivateUsers() {
		return TestUtil.getData("ActivateUsers", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.2 <br> 
	 * This Test verify whether user can use global search bar.<br>
	 * Search an account, click on it and verify whether it can be clicked.
	 */
	@Test(dataProvider = "getTestDataFor_ActivateUsers",priority=6)
	public void ActivateUsers(Hashtable<String, String> data) throws Throwable {
		try {
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( data.get("ActivationURL"));	
					ActivateUsers(data.get("ActivationURL"));
					
					
					
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DataProvider
	public Object[][] getTestDataFor_ValidateLink() {
		return TestUtil.getData("ValidateLink", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.2 <br> 
	 * This Test verify whether user can use global search bar.<br>
	 * Search an account, click on it and verify whether it can be clicked.
	 */
	@Test(dataProvider = "getTestDataFor_ValidateLink",priority=7)
	public void ValidateLink(Hashtable<String, String> data) throws Throwable {
		try {
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( data.get("ActivationURL"));	
					ValidateLink(data.get("ActivationURL"));
					
					
					
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//VerifyUserLogin
	@DataProvider
	public Object[][] getTestDataFor_VerifyUserLogin() {
		return TestUtil.getData("VerifyUserLogin", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.2 <br> 
	 * This Test verify whether user can use global search bar.<br>
	 * Search an account, click on it and verify whether it can be clicked.
	 */
	@Test(dataProvider = "getTestDataFor_VerifyUserLogin",priority=1)
	public void VerifyUserLogin(Hashtable<String, String> data) throws Throwable {
		try {
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( "Validate users");	
					VerifyUserLogin(data.get("UserName"));
					
					
					
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@DataProvider
	public Object[][] getTestDataFor_ValidateUsers() {
		return TestUtil.getData("ValidateUsers", TestData, "Home");
	}
	/**
	 * TC-ID : TC1.2 <br> 
	 * This Test verify whether user can use global search bar.<br>
	 * Search an account, click on it and verify whether it can be clicked.
	 */
	@Test(dataProvider = "getTestDataFor_ValidateUsers",priority=1)
	public void ValidateUsers(Hashtable<String, String> data) throws Throwable {
		try {
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription( "Validate users");	
					ValidateUsers(data.get("UserName"));
					
					
					
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void logOut() throws Throwable {
		doLogout();
	}

}
