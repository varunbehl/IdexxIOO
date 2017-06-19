package com.Idexx.libs;

import java.util.Hashtable;
import java.util.Random;

import org.openqa.selenium.By;

import com.Idexx.page.AccountsPage;
import com.Idexx.page.CasePage;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.ForecastPage;
import com.Idexx.page.HomePage;
import com.Idexx.page.LoginPage;
import com.Idexx.page.OpportunityPage;
import com.automation.accelerators.ActionEngine;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;

public class IdexxLib extends ActionEngine {
	
	
	HomePage h = new HomePage();
	
	public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
	//public Xls_Reader TestData2 = new Xls_Reader(System.getProperty("user.dir")+"/TestData/CreateUserTestData.xlsx");

	public final int LOWWAITTIME = 2000;
	public final int WAITTIME = 50000;
	public final int LONGWAITTIME = 200000;
	public String gErrMsg = "";

	/**
	 * Launches the ESPN Web Application
	 * 
	 * @return
	 * @throws Throwable
	 */
	public boolean launchUrl() throws Throwable {
		gErrMsg = "";
		boolean flag = false;
		try {
			/*if (configProps.getProperty("platformType").equalsIgnoreCase(
					"Mobile")) {
				remoteWebDriverForAppium.get("https://login.salesforce.com/");
				flag = true;
			}
			if (configProps.getProperty("platformType").equalsIgnoreCase(
					"Web_Fullscreen")) {
				driver.get("https://login.salesforce.com/?locale=in");
				flag = true;
			}*/
			Driver.get("v");
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			gErrMsg = "Launch Failed";
			return false;
		}

	}
	
	public void loginAsUserRole(String userrole) throws Throwable {

		System.out.println(userrole);
		System.out.println("***********");
		Hashtable<String, String> data = TestUtil.getDataSignUp(userrole,"login");
		System.out.println(data.get("username"));
		System.out.println(data.get("password"));
		new LoginPage().Login_Page();
		//clickUsingJavascriptExecutor(LoginPage.userName, "");
		Driver.findElement(LoginPage.userName).click();
		Driver.findElement(LoginPage.userName).clear();
		Driver.findElement(LoginPage.userName).sendKeys(data.get("username"));
		//clickUsingJavascriptExecutor(LoginPage.password, "");
		Driver.findElement(LoginPage.password).click();
		Driver.findElement(LoginPage.password).clear();
		Driver.findElement(LoginPage.password).sendKeys(data.get("password"));
		Thread.sleep(3000);
		Driver.findElement(LoginPage.loginBtn).click();
		Thread.sleep(60000);
		System.out.println("login completed ");
	/*	if(Driver.findElement(By.xpath(".//*[@id='save']")).isEnabled()){
			System.out.println("Verification popup arised.****** Waiting to enter the code manually");
			Thread.sleep(60000);
		}else
			System.out.println("No verification popup arised.******");
		*/
	}

	public void doLogin(String username, String password) throws Throwable {
		new LoginPage().Login_Page();
		Thread.sleep(3000);
		type(LoginPage.userName, username, "entering login username");
		type(LoginPage.password, password, "entering login password");
		click(LoginPage.loginBtn, "Click on Login button");
		System.out.println("login completed ");
		Thread.sleep(25000);
		System.out.println("login completed ");
		
//		if(isElementPresent(LoginPage.verificationCode_saveBtn, "verification screen", true)){
//			System.out.println("Verification popup arised.****** Waiting to enter the code manually");
//			Thread.sleep(60000);
//		}else
//			System.out.println("No verification popup arised.******");
	}

	public void goToHomePage() throws Throwable {
		//new HomePage().Home_Page();
		Thread.sleep(5000);
		System.out.println("before wait for visi");
		waitForVisibilityOfElement(h.homePageTab, "homepage tab");
		System.out.println("after wait for visi");
		clickUsingJavascriptExecutor(h.homePageTab, "click on homepage");
		System.out.println("after click for visi");
		Thread.sleep(8000);
	}
	
	public void goToReportTab() throws Throwable {
		new HomePage().Home_Page();
		clickUsingJavascriptExecutor(HomePage.reportsTab, "on report tab");
	}

		
	public void goToAccountsPage() throws Throwable {
		new AccountsPage().AccountsPage();
		clickUsingJavascriptExecutor(AccountsPage.AccountTab, "click on Account tab");

	}
	
	public void goToContactsPage() throws Throwable {
		new ContactsPage().Contacts_Page();
//		clickUsingJavascriptExecutor(ContactsPage.contactTab, "click on contact tab");
//		Thread.sleep(5000);
		Thread.sleep(5000);
		System.out.println("before wait for visi");
		waitForVisibilityOfElement(ContactsPage.contactTab, "contact tab");
		System.out.println("after wait for visi");
		clickUsingJavascriptExecutor(ContactsPage.contactTab, "click on homepage");
		System.out.println("after click for visi");
		Thread.sleep(8000);
	}

	// logout
	public void doLogout() throws Throwable {
		By logoffButton = By.xpath("//*[@id='zza_logoff']");
		click(logoffButton, "Clicked on log off Button");
		
	/*	Thread.sleep(3000);
		new HomePage().Home_Page();
		System.out.println("in logout ..");
	//	driver.findElement(HomePage.LogOut_Menu).click();
		clickUsingJavascriptExecutor(HomePage.LogOut_Menu, "Logout menu");
		clickUsingJavascriptExecutor(HomePage.LogOut_btn, "logout button");
		Driver.manage().deleteAllCookies();
		Thread.sleep(6000);
		//driver.findElement().click();
*/	}
	
	public void goToForecastsTab() throws Throwable {
		Thread.sleep(2000);
		new ForecastPage().Forecast();
		click(ForecastPage.forecastsTab, "click on forecasts tab");

	}
	
	public int generateRandonNumber() throws Throwable {

//		  int maximum = 5000;
//		  int minimum = 0;
//		  int randomNum;
//		  Random rn = new Random();
//		  int n = maximum - minimum + 1;
//		  int i = rn.nextInt() % n;
//		  randomNum =  minimum + i;
		Random generator = new Random();
		int random_number = generator.nextInt(9999) + 1000;
		  
		  return random_number;
		}
	
	public void createNewAccount(Hashtable<String, String> data, String accountName) throws Throwable {

		new AccountsPage().AccountsPage();
		click(AccountsPage.accountsTab,"Accounts tab is clicked successfully");
		Thread.sleep(5000);
		click(AccountsPage.newAccount, "New Account buttton is clicked succcessfully");
		Thread.sleep(6000);
		waitForElementPresent(AccountsPage.name, "Account Name ", 10);
		type(AccountsPage.name, accountName, "Account Name ");
		selectByValue(AccountsPage.businessUnit, data.get("businessUnit"), "Business unit");	
		Thread.sleep(3000);
		selectByValue(AccountsPage.industry, data.get("industry"), "Industry");	 
		Thread.sleep(3000);
		click(AccountsPage.save, "Save button is clicked succcessfully");
		Thread.sleep(12000);
		waitForElementPresent(AccountsPage.accountDetail, "Account detail page", 5);
		isElementPresent(AccountsPage.accountDetail,"Account detail page is displayed successfully", true);
		assertTextMatching(AccountsPage.descText,  accountName, "Account name");
	}

	public void CreateOpportunity(Hashtable<String, String> data,String accountName,String oppName) throws Throwable
	{
		new OpportunityPage().Opportunity();
		Thread.sleep(1000);
		clickUsingJavascriptExecutor(OpportunityPage.newOpportunity, "Clicked on New Opportunity Btn");
		Thread.sleep(3000);
		new CasePage().Case_Page();
		Thread.sleep(3000);
		selectByVisibleText(CasePage.OpportunityRecordType, data.get("OpportunityRecordType"), "Selectd Opportunity from drop down");
		Thread.sleep(3000);
		//		WebElement element1 = driver.findElement(CasePage.OpportunityRecordType_Con);
		//		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//		executor.executeScript("arguments[0].click();", element1);
		clickUsingJavascriptExecutor(CasePage.OpportunityRecordType_Con, "continue button");

		type(OpportunityPage.Opportunity_Name, oppName, "Successfully entered into name field");
		selectByVisibleText(OpportunityPage.Opportunity_Type,data.get("Opportunity_Type") , "New Business from drop down");

		if(data.get("OpportunityRecordType").equalsIgnoreCase("Tender"))
		{
			click(OpportunityPage.TenderStartDate, "Successfully Clicked on startDate Btn");
			//type(OpportunityPage.TenderPrimaryCampaignSource, data.get("PrimaryCampaignSource"), "Successfully entered into PrimaryCampaignSource field");
			click(OpportunityPage.TenderOpportunity_EndDate, "Successfully Clicked on end date Btn");
			Thread.sleep(2000);
			selectByVisibleText(OpportunityPage.Opportunity_Stage_menu, data.get("Stage"), "Selectd 1 Prospect from drop down");
			Thread.sleep(2000);
			selectByVisibleText(OpportunityPage.TenderOpportunityLostReason, "Lost to Competition", "Selectd 1 Prospect from drop down");
			Thread.sleep(2000);
			click(OpportunityPage.TenderOpportunityPeroid, "Successfully Clicked on period Btn");

		}
		type(OpportunityPage.Opportunity_Desc, data.get("Desc"), "Successfully entered into desc field");

		if(data.get("OpportunityRecordType").equalsIgnoreCase("Negative Win Back"))
		{
			selectByVisibleText(OpportunityPage.LeadSource, data.get("LeadSource"), "Advertisement from drop down");
			//selectByVisibleText(OpportunityPage.Opportunity_Stage_menu, data.get("Stage"), "Selectd 1 Prospect from drop down");
			selectByVisibleText(OpportunityPage.TenderOpportunityLostReason, "Lost to Competition", "Selectd 1 Prospect from drop down");
			type(OpportunityPage.nextStep, data.get("nextStep"), "Successfully entered into nextStep field");
		}

		click(OpportunityPage.Opportunity_closeDate, "Successfully Clicked on closedate Btn");	
		type(OpportunityPage.Opportunity_Amount, data.get("Amount"), "Successfully entered into Amount field");
		type(OpportunityPage.Opportunity_Probability, "20", "Successfully entered into Probability field");
		String defaultAccountDisplayed = Driver.findElement(By.xpath(".//label[contains(text(),'Account Name')]/parent::th/following-sibling::td[1]//span[@class='lookupInput']/input")).getAttribute("value");
		System.out.println("---"+defaultAccountDisplayed);
		assertTextStringMatching(defaultAccountDisplayed,accountName);
		if(data.get("OpportunityRecordType").equalsIgnoreCase("Tender"))
		{
			click(OpportunityPage.TenderOpportunity_syncCommitments, "Successfully Clicked Sync Commitments Btn");
			click(OpportunityPage.Submit, "Successfully Clicked on submit Btn");
			Thread.sleep(6000);
		}else{
			Thread.sleep(4000);
			selectByVisibleText(OpportunityPage.Opportunity_Stage_menu, data.get("Stage"), "Selectd 1 Prospect from drop down");
			click(OpportunityPage.Opportunity_save, "Successfully Clicked on save Btn");
			Thread.sleep(6000);
		}
		if(data.get("OpportunityRecordType").equalsIgnoreCase("Negative Win Back")){

			if((data.get("Amount").startsWith("-")))
			{
				Thread.sleep(4000);
				assertText(OpportunityPage.Opportunity_Detail,"Opportunity Detail");
				assertTextMatching(OpportunityPage.OpportunityHeader, oppName, "Verify account Name");
			}
			else
			{
				Thread.sleep(4000);
				getText(OpportunityPage.OpportunityCreateError, "Error Description");
				assertTextMatching(OpportunityPage.OpportunityCreateError, "The Amount on a Negative Win Back Opportunity cannot be a positive value.","Verify.");
			}
		}
	}
	
public void EnterContactInfoNewAndSave(Hashtable<String, String> data,String accountName,String ContactlastName) throws Throwable{
		
		new ContactsPage().Contacts_Page();
		click(ContactsPage.newContactBtn, "click on the contact btn");

		/*selectByVisibleText(ContactsPage.salutionDropDown, data.get("salutation"), "selecting Mr. from dropdown");
		type(ContactsPage.firstName, data.get("firstName"), "entring the first name");*/
		Thread.sleep(2000);
		new ContactsPage().Contacts_Page();
		System.out.println(ContactlastName);
		type(ContactsPage.lastname, ContactlastName, "entering the last name");
		/*type(ContactsPage.middleName, data.get("middleName"), "entering the middle name");
		type(ContactsPage.mobile, data.get("mobile"), "entering the mobile");
		type(ContactsPage.email, data.get("email"), "entering the email");*/
		type(ContactsPage.accountName, accountName, "entering the account name");
		click(ContactsPage.saveBtn, "click on save btn");
		
		
	}
}
