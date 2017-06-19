package com.Idexx.libs;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Idexx.page.AccountsPage;
import com.Idexx.page.ActivityPage;
import com.Idexx.page.CasePage;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.Idexx.page.OpportunityPage;

public class CaseLib extends IdexxLib{

	public int sleep = 2000;

	public void createNewCase(Hashtable<String, String> data, String name) throws Throwable
	{
		new CasePage().Case_Page();
		new AccountsPage().AccountsPage();
		Thread.sleep(4000);
		click(CasePage.NewCase,"new case button");
		new ActivityPage().Activity_Page();
		Thread.sleep(sleep);
		selectByVisibleText(ActivityPage.NewRecord, data.get("RecordType"), "Selected Sales Activity from drop down");
		click(ActivityPage.Continue, "Successfully Clicked on Continue Button");
		Thread.sleep(8000);
		type(CasePage.contactName,  name, "contactName is entered successfully");
		Thread.sleep(2000);
//		selectByVisibleText(CasePage.caseAction,  data.get("caseAction"), "Selected caseAction from drop down");
//		Thread.sleep(2000);
		System.out.println("case resolution value" + data.get("caseResolution"));
		selectByVisibleText(CasePage.caseResolution,  data.get("caseResolution"), "Selected caseResolution from drop down");
		Thread.sleep(2000);
		selectByVisibleText(CasePage.caseOrigin,  data.get("caseOrigin"), "caseOrigin caseResolution from drop down");
		type(CasePage.caseSubject,  data.get("caseSubject"), "caseSubject is entered successfully");
		type(CasePage.caseDesc,  data.get("caseDesc"), "caseDesc is entered successfully");
		type(CasePage.caseComments,  data.get("caseComments"), "caseResolution is entered successfully");
		click(AccountsPage.save, "Save button ");
		Thread.sleep(sleep+2000);
		System.out.println("checking contact Name---"+name.isEmpty());
		if(name.isEmpty())
		{
			Thread.sleep(sleep);
			assertTextMatching(CasePage.caseError, "Error: You must enter a value","Verify error");
			Thread.sleep(sleep);
		}		

		else
			assertTextMatching(CasePage.contactNameAfterSave, name ,"Verify contact Name");
	}

	public void CreateDealSupportRequest(Hashtable<String, String> data,String oppName) throws Throwable
	{

		new CasePage().Case_Page();
		Thread.sleep(sleep);
		click(CasePage.newDealSupportRequest, "Successfully Clicked on new Deal Support Request Button");
		isElementPresent(CasePage.caseEditPage, "verify caseEdit Request Page", true);
		WebElement Opp= Driver.findElement(By.xpath(".//label[contains(text(),'Opportunity')]/parent::td/following-sibling::td[1]//span/input[1]")); 
		String ActualOpportunity=Opp.getAttribute("value");
		System.out.println("Actual Opportunity is----"+ActualOpportunity);

		Thread.sleep(sleep);
		type(CasePage.caseContactName, data.get("caseContactName"), "Successfully entered into caseContactName field");

		type(CasePage.caseSubject,  data.get("caseSubject"), "caseSubject is entered successfully");
		type(CasePage.caseDesc,  data.get("caseDesc"), "caseDesc is entered successfully");
		type(CasePage.caseComments,  data.get("caseComments"), "caseResolution is entered successfully");


		System.out.println("1st loop---"+data.get("caseContactName").isEmpty());
		System.out.println("2nd loop---"+data.get("caseOrigin").equalsIgnoreCase("None"));
		System.out.println("3rd loop---"+oppName.equalsIgnoreCase("clear"));
		System.out.println("4th loop is"+(!(data.get("caseContactName").isEmpty())&&!(data.get("caseOrigin").equalsIgnoreCase("None"))&&!(data.get("caseOpportunityName").equalsIgnoreCase("clear"))));
		if(data.get("caseContactName").isEmpty())
		{
			System.out.println("enter into contact loop");
			selectByVisibleText(CasePage.caseOrigin,  data.get("caseOrigin"), "caseOrigin caseResolution from drop down");
			click(AccountsPage.save, "Save button ");
			Thread.sleep(sleep);
			assertTextMatching(CasePage.caseError, "Error: You must enter a value","Verify error");
		}
		if(data.get("caseOrigin").equalsIgnoreCase("None"))

		{
			System.out.println("enter into case loop");
			click(AccountsPage.save, "Save button ");
			Thread.sleep(sleep);
			assertTextMatching(CasePage.dealCaseOriginError, "Error: You must enter a value","Verify error");
		}
		if(data.get("caseOpportunityName").equalsIgnoreCase("clear"))
		{
			System.out.println("enter into 3rd loop");
			Driver.findElement(By.xpath(".//label[contains(text(),'Opportunity')]/parent::td/following-sibling::td[1]//span/input[1]")).clear();
			selectByVisibleText(CasePage.caseOrigin,  data.get("caseOrigin"), "caseOrigin caseResolution from drop down");
			click(AccountsPage.save, "Save button ");
			Thread.sleep(sleep);
			System.out.println("tttttt--->"+getText(CasePage.caseOpportunityErrorDesc, "Error Description"));
			assertTextMatching(CasePage.caseOpportunityErrorDesc, "Deal Support Request Cases should only be created for Opportunities.","Verify.");
			Thread.sleep(sleep);
		}

			if((!(data.get("caseContactName").isEmpty())&&!(data.get("caseOrigin").equalsIgnoreCase("None"))&&!(data.get("caseOpportunityName").equalsIgnoreCase("clear"))))
		{
			Thread.sleep(sleep);
			selectByVisibleText(CasePage.caseOrigin,  data.get("caseOrigin"), "caseOrigin caseResolution from drop down");
			click(AccountsPage.save, "Save button ");
		}
	}



	public void caseOwnerChange(Hashtable<String, String> data) throws Throwable
	{
		Thread.sleep(3000);
		click(CasePage.caseOwnerChange, "change button ");
	}

	public void caseVerify(String caseText) throws Throwable
	{

		goToHomePage();
		new HomePage().Home_Page();
		type(HomePage.search, caseText, "search");
		Thread.sleep(3000);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.TAB);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		int count = Driver.findElements(By.xpath(".//*[@id='Case_body']/table/tbody/tr")).size();

		for(int i = 2; i<=count;i++){
			Thread.sleep(2000);
			String text = Driver.findElement(By.xpath(".//*[@id='Case_body']/table/tbody/tr["+i+"]/th/a")).getText();
			System.out.println(text);
			if(text.equalsIgnoreCase(caseText)){
				break;
			}
		}
		new CasePage().Case_Page();
		Thread.sleep(2000);
		assertTextMatching(CasePage.topNameDisplayedCase, caseText, "verifying the search result");	
	}
	
	public boolean searchAndClickAccountUsingGlobalSearch(String accountName) throws Throwable{

		System.out.println("in search");
		boolean found = false;
		goToHomePage();
		System.out.println("after in search");
		new HomePage().Home_Page();
		type(HomePage.search, accountName, "search");
		Thread.sleep(5000);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.TAB);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		if(!(isElementPresent(HomePage.accountsHyperlink, "Accounts hyperlink on the left side tab after search",true))){
			Assert.fail("No Account found.");
		}else{
			click(HomePage.accountsHyperlink, "accounts hyperlink on the left side tab");
			Thread.sleep(2000);
			/*if(isElementPresent(HomePage.showMoreLink_AccountsBody, "show more link in account section",true))
				click(HomePage.showMoreLink_AccountsBody, "click on show more link .");*/

			int count = Driver.findElements(By.xpath(".//*[@id='Account_body']/table/tbody/tr")).size();

			for(int i = 2; i<=count;i++){
				String text = Driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr["+i+"]/th/a")).getText();
				System.out.println(text);
				if(text.equalsIgnoreCase(accountName)){
					found = true;
					WebElement element = Driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr["+i+"]/th/a"));
					JavascriptExecutor executor = (JavascriptExecutor)Driver;
					executor.executeScript("arguments[0].click();", element);
					
				//	driver.findElement(By.xpath(".//*[@id='Account_body']/table/tbody/tr["+i+"]/th/a")).click();
					System.out.println("clicked on account ...");
					break;
				}
			}
			Thread.sleep(5000);
			new AccountsPage().AccountsPage();
			assertTextMatching(AccountsPage.topNameDisplayedOnContactHeader, accountName, "verifying the search result");
		}

		return found;
	}
	
public void EnterContactInfoNewAndSave(Hashtable<String, String> data) throws Throwable{
		
	new ContactsPage().Contacts_Page();
	click(ContactsPage.newContactBtn, "click on the contact btn");

	/*selectByVisibleText(ContactsPage.salutionDropDown, data.get("salutation"), "selecting Mr. from dropdown");
	type(ContactsPage.firstName, data.get("firstName"), "entring the first name");*/
	Thread.sleep(2000);
	new ContactsPage().Contacts_Page();
	System.out.println(data.get("newContactLastName"));
	type(ContactsPage.lastname, data.get("newContactLastName"), "entering the last name");
	/*type(ContactsPage.middleName, data.get("middleName"), "entering the middle name");
	type(ContactsPage.mobile, data.get("mobile"), "entering the mobile");
	type(ContactsPage.email, data.get("email"), "entering the email");*/
	type(ContactsPage.accountName, data.get("accountName"), "entering the account name");
	click(ContactsPage.saveBtn, "click on save btn");
	}

public void CreateOpportunity(Hashtable<String, String> data) throws Throwable
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

	type(OpportunityPage.Opportunity_Name, data.get("OpportunityName"), "Successfully entered into name field");
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
	assertTextStringMatching(defaultAccountDisplayed,data.get("accountName"));
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
			assertTextMatching(OpportunityPage.OpportunityHeader, data.get("OpportunityName"), "Verify account Name");
		}
		else
		{
			Thread.sleep(4000);
			getText(OpportunityPage.OpportunityCreateError, "Error Description");
			assertTextMatching(OpportunityPage.OpportunityCreateError, "The Amount on a Negative Win Back Opportunity cannot be a positive value.","Verify.");
		}
	}
}

public void createNewAccount(Hashtable<String, String> data) throws Throwable {

	new AccountsPage().AccountsPage();
	click(AccountsPage.accountsTab,"Accounts tab is clicked successfully");
	Thread.sleep(2000);
	click(AccountsPage.newAccount, "New Account buttton is clicked succcessfully");
	Thread.sleep(3000);
	type(AccountsPage.name, data.get("accountName"), "Account Name ");
	selectByValue(AccountsPage.businessUnit, data.get("businessUnit"), "Business unit");	
	selectByValue(AccountsPage.industry, data.get("industry"), "Industry");	 
	click(AccountsPage.save, "Save button is clicked succcessfully");
	Thread.sleep(3000);
	isElementPresent(AccountsPage.accountDetail,"Account detail page is displayed successfully", true);
	assertTextMatching(AccountsPage.descText,  data.get("accountName"), "Account name");
}

}
