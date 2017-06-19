package com.Idexx.scripts;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.AccountsLib;
import com.Idexx.libs.CaseLib;
import com.Idexx.libs.ContactsLib;
import com.Idexx.libs.OpportunityLib;
import com.Idexx.page.CasePage;
import com.automation.utilities.TestUtil;
//@Test(groups = "Case",dependsOnGroups = "Activity")

public class Case extends CaseLib {
	
	AccountsLib accLib = new AccountsLib();
	OpportunityLib oppLib = new OpportunityLib();
	ContactsLib contactLib = new ContactsLib();


	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{
		loginAsUserRole(userrole);
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateCaseFromAccounts() {
		return TestUtil.getData("CreateCaseFromAccounts", TestData, "Case");
	}

	@Test(dataProvider = "getTestDataFor_CreateCaseFromAccounts")
	public void CreateCaseFromAccounts(Hashtable<String, String> data) throws Throwable {

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
				String contactname = data.get("newContactLastName");
				createNewCase(data, contactname);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@DataProvider
	public Object[][] getTestDataFor_CreateCaseFromContact() {
		return TestUtil.getData("CreateCaseFromContact", TestData, "Case");
	}

	@Test(dataProvider = "getTestDataFor_CreateCaseFromContact")
	public void CreateCaseFromContact(Hashtable<String, String> data) throws Throwable {

		try {

			if (data.get("RunMode").equals("Y")){

				this.reporter.initTestCaseDescription( "TC1.2");	
			//	goToHomePage();	
				//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
				/*new ContactsPage().Contacts_Page();
				click(ContactsPage.newContactBtn, "click on the contact btn");*/
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
				/*click(ContactsPage.saveBtn, "click on save btn");*/
				createNewCase(data, newContact);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CreateCaseFromOpportunity() {
		return TestUtil.getData("CreateCaseFromOpportunity", TestData, "Case");
	}

	@Test(dataProvider = "getTestDataFor_CreateCaseFromOpportunity")
	public void CreateCaseFromOpportunity(Hashtable<String, String> data) throws Throwable {

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
				String oppName = Integer.toString(randNum) + "_" + getBrowser() + "_"+data.get("OpportunityName");
				createNewAccount(data,accName);
				CreateOpportunity(data,accName,oppName);
				CreateDealSupportRequest(data,oppName);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TransferCase() {
		return TestUtil.getData("TransferCase", TestData, "Case");
	}

	@Test(dataProvider = "getTestDataFor_TransferCase")
	public void TransferCase(Hashtable<String, String> data) throws Throwable {

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
				String contactname = data.get("newContactLastName");
				createNewCase(data, contactname);
				//caseOwnerChange(data); //Do not have enough previlages 
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_CaseEscalationRules() {
		return TestUtil.getData("CaseEscalationRules", TestData, "Case");
	}

	@Test(dataProvider = "getTestDataFor_CaseEscalationRules")
	public void CaseEscalationRules(Hashtable<String, String> data) throws Throwable {

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
				String contactname = data.get("newContactLastName");
				createNewCase(data, contactname);
				String caseText = getText(CasePage.caseText, "Get the case");
				System.out.println("case text is----"+caseText);
				caseVerify(caseText);
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
