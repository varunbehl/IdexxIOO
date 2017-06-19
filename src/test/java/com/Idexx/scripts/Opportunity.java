package com.Idexx.scripts;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.AccountsLib;
import com.Idexx.libs.ContactsLib;
import com.Idexx.libs.OpportunityLib;
import com.automation.utilities.TestUtil;

public class Opportunity extends OpportunityLib {
	
	AccountsLib accLib = new AccountsLib();
	OpportunityLib oppLib = new OpportunityLib();
	ContactsLib contactLib = new ContactsLib();

	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{	
		loginAsUserRole(userrole);
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateLPDOpportunity() {
		return TestUtil.getData("TestCreateLPDOpportunity", TestData, "Opportunity");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateLPDOpportunity",priority=18)
	public void TestCreateLPDOpportunity(Hashtable<String, String> data) throws Throwable {

		try {
		
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription("TC3.1");		
					int randNum = generateRandonNumber();
					/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
					String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
					System.out.println("=================");
					System.out.println("AccountName -> " + accName);
					System.out.println("=================");
					createNewAccount(data,accName);
					//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
					String oppName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("OpportunityName");
					CreateOpportunity(data,accName,oppName);
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateTenderOpportunity() {
		return TestUtil.getData("TestCreateTenderOpportunity", TestData, "Opportunity");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateTenderOpportunity")
	public void TestCreateTenderOpportunity(Hashtable<String, String> data) throws Throwable {
		try {
		
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription("TC3.2");	
					//goToHomePage();	
					//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
					int randNum = generateRandonNumber();
					/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
					String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
					System.out.println("=================");
					System.out.println("AccountName -> " + accName);
					System.out.println("=================");
					createNewAccount(data,accName);
					String oppName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("OpportunityName");
					CreateOpportunity(data,accName,oppName);
				}
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateNegativeWinBackOpportunity() {
		return TestUtil.getData("TestCreateNegativeWinBackOpportunity", TestData, "Opportunity");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateNegativeWinBackOpportunity",priority=19)
	public void TestCreateNegativeWinBackOpportunity(Hashtable<String, String> data) throws Throwable {
		try {
		
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription("TC3.3");	
					//goToHomePage();	
					//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
					int randNum = generateRandonNumber();
					/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
					String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
					System.out.println("=================");
					System.out.println("AccountName -> " + accName);
					System.out.println("=================");
					createNewAccount(data,accName);
					String oppName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("OpportunityName");
					CreateOpportunity(data,accName,oppName);
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateNegativeWinBackOpportunityWorkflow() {
		return TestUtil.getData("TestCreateNegativeWinBackOpportunityWorkflow", TestData, "Opportunity");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateNegativeWinBackOpportunityWorkflow",priority=20)
	public void TestCreateNegativeWinBackOpportunityWorkflow(Hashtable<String, String> data) throws Throwable {
		try {
		
				if (data.get("RunMode").equals("Y")){

					this.reporter.initTestCaseDescription("TC3.4");	
					//goToHomePage();	
					//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
					int randNum = generateRandonNumber();
					/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
					String accName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("accountName");
					System.out.println("=================");
					System.out.println("AccountName -> " + accName);
					System.out.println("=================");
					createNewAccount(data,accName);
					String oppName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("OpportunityName");
					CreateOpportunity(data,accName,oppName);
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
