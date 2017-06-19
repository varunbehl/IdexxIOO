package com.Idexx.scripts;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.AccountsLib;
import com.Idexx.libs.ActivityLib;
import com.Idexx.libs.ContactsLib;
import com.Idexx.libs.OpportunityLib;
import com.automation.utilities.TestUtil;
//@Test(groups = "Activity")
public class Activity extends ActivityLib{
	
	AccountsLib accLib = new AccountsLib();
	OpportunityLib oppLib = new OpportunityLib();
	ContactsLib contactLib = new ContactsLib();

	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{
		System.out.println("userrole - Activity -- " + userrole);
		loginAsUserRole(userrole);
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateSalesandSupportTask() {
		return TestUtil.getData("CreateSalesandSupportTask", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateSalesandSupportTask")
	public void CreateSalesandSupportTask(Hashtable<String, String> data) throws Throwable {

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
				createNewAccount(data,accName);
				CreateNewTask(data);
				viewActivities(data);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateSalesandSupportTaskOpportunity() {
		return TestUtil.getData("CreateSalesandSupportTaskOpportunity", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateSalesandSupportTaskOpportunity")
	public void CreateSalesandSupportTaskOpportunity(Hashtable<String, String> data) throws Throwable {

		try {
			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
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
				CreateNewTask(data);
				viewActivities(data);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateSalesandSupportTaskContact() {
		return TestUtil.getData("CreateSalesandSupportTaskContact", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateSalesandSupportTaskContact")
	public void CreateSalesandSupportTaskContact(Hashtable<String, String> data) throws Throwable {

		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
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
				String newContact = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("newContactLastName");
				System.out.println("=================");
				System.out.println("contactName -> " + newContact);
				System.out.println("=================");
				EnterContactInfoNewAndSave(data,accName,newContact);
				Thread.sleep(3000);
				/*click(ContactsPage.saveBtn, "click on save btn");*/
				CreateNewTask(data);
				viewActivities(data);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@DataProvider
	public Object[][] getTestDataFor_CreateSalesandSupportTaskMultipleContact() {
		return TestUtil.getData("CreateSalesandSupportTaskMultipleContact", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateSalesandSupportTaskMultipleContact")
	public void CreateSalesandSupportTaskMultipleContact(Hashtable<String, String> data) throws Throwable {

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
				createNewAccount(data,accName);
				CreateNewEvent(data);
				viewActivities(data);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateActivityFromAccounts() {
		return TestUtil.getData("CreateActivityFromAccounts", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateActivityFromAccounts")
	public void CreateActivityFromAccounts(Hashtable<String, String> data) throws Throwable {

		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
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
				createActivityHistory(data);
				viewActivityHistory(data,accName);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateActivityFromOpportunity() {
		return TestUtil.getData("CreateActivityFromOpportunity", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateActivityFromOpportunity")
	public void CreateActivityFromOpportunity(Hashtable<String, String> data) throws Throwable {

		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
				//goToHomePage();	
				//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				createNewAccount(data);
				CreateOpportunity(data);
				//unable to create an activity from opportunity... Could see "An unexpected error has occurred. Your development organization has been notified." 
				//createActivityHistory(data);
				//viewActivityHistory(data);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateActivityFromContact() {
		return TestUtil.getData("CreateActivityFromContact", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_CreateActivityFromContact")
	public void CreateActivityFromContact(Hashtable<String, String> data) throws Throwable {

		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
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
				String newContact = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("newContactLastName");
				System.out.println("=================");
				System.out.println("contactName -> " + newContact);
				System.out.println("=================");
				EnterContactInfoNewAndSave(data,accName,newContact);
				createActivityHistory(data);
				viewActivityHistory(data,newContact);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_DifferentiationBetweenActivityAndTask() {
		return TestUtil.getData("DifferentiationBetweenActivityAndTask", TestData, "Activity");
	}

	@Test(dataProvider = "getTestDataFor_DifferentiationBetweenActivityAndTask")
	public void DifferentiationBetweenActivityAndTask(Hashtable<String, String> data) throws Throwable {

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
				createNewAccount(data,accName);
				createActivityHistory(data);
				viewActivityHistory(data,accName);
				CreateNewTask(data);
				viewActivities(data);
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
