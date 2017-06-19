package com.Idexx.scripts;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.AccountsLib;
import com.Idexx.page.AccountsPage;
import com.automation.utilities.TestUtil;

public class Accounts extends AccountsLib {


	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{	
		loginAsUserRole(userrole);
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateNewAccount() {
		return TestUtil.getData("TestCreateNewAccount", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateNewAccount")
	public void TestCreateNewAccount(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription("TC1.2");	
				//goToHomePage();	
				int randNum = generateRandonNumber();
				/*  System.out.println("random generated - " + randNum);
				     System.out.println(" browser - " + getBrowser());*/
				String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
				System.out.println("=================");
				System.out.println("AccountName -> " + accName);
				System.out.println("=================");
				createNewAccount(data, accName);
				searchAndClickAccountUsingGlobalSearch(accName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@DataProvider
	public Object[][] getTestDataFor_TestViewExistingAccount() {
		return TestUtil.getData("TestViewExistingAccount", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_TestViewExistingAccount")
	public void TestViewExistingAccount(Hashtable<String, String> data) throws Throwable {
		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				isElementPresent(AccountsPage.accountsDetailSection, "verify accounts details section available .", true);
				assertTrue(isElementPresent(AccountsPage.accountsDetailSection, "verify accounts details section available .",true),
						"Accounts Section not available.");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@DataProvider
	public Object[][] getTestDataFor_TestViewAndEditMyAccounts() {
		return TestUtil.getData("TestViewAndEditMyAccounts", TestData, "Accounts");
	}

	//Test step mentioned : select "MyAccounts" from the View dropdown in accounts tab
	// Test step scripted : Search the existing account name from global search bar and perform the remaining steps.
	//Reason : No search bar provided to find out the particular account after selecting the "MyAccounts" from the View dropdown.
	@Test(dataProvider = "getTestDataFor_TestViewAndEditMyAccounts")
	public void TestViewAndEditMyAccounts(Hashtable<String, String> data) throws Throwable {
		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				viewAccountTeamMembers(data);
				viewAndEditMyAccount(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_testViewHierarchy() {
		return TestUtil.getData("testViewHierarchy", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_testViewHierarchy")
	public void TestViewHierarchy(Hashtable<String, String> data) throws Throwable {
		try {

			if (data.get("RunMode").equals("Y")){
				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();
				viewAccounthierarchy(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@DataProvider
	public Object[][] getTestDataFor_TestCreateContactForAnAccount() {
		return TestUtil.getData("TestCreateContactForAnAccount", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateContactForAnAccount")
	public void TestCreateContactForAnAccount(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){
				this.reporter.initTestCaseDescription( "TC1.2");
				//goToHomePage();	
				int randNum = generateRandonNumber();
				/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
				String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
				System.out.println("=================");
				System.out.println("AccountName -> " + accName);
				System.out.println("=================");
				String newContact = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("newContactLastName");
				System.out.println("=================");
				System.out.println("contactName -> " + newContact);
				System.out.println("=================");
				createNewAccount(data, accName);

				createContactForAccount(data, newContact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	@DataProvider
	public Object[][] getTestDataFor_TestViewCompetitorProducts() {
		return TestUtil.getData("TestViewCompetitorProducts", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_TestViewCompetitorProducts")
	public void TestViewCompetitorProducts(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				CompetitorProducts(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_Test360viewofaccount() {
		return TestUtil.getData("Test360viewofaccount", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_Test360viewofaccount",priority=12)
	public void Test360viewofaccount(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				viewAccountTeamMembers(data);
				viewContactMembers(data);
				viewOpenActivities(data);
				viewOpportunityDetails(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateNewReport() {
		return TestUtil.getData("TestCreateNewReport", TestData, "Accounts");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateNewReport")
	public void TestCreateNewReport(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){
				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				int randNum = generateRandonNumber();
				/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
				String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
				System.out.println("=================");
				System.out.println("AccountName -> " + accName);
				System.out.println("=================");
				createNewAccount(data, accName);
				createNewReport(data,accName);
				Thread.sleep(2000);
				//goToHomePage();
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
