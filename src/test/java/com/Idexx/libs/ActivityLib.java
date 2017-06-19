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

public class ActivityLib extends IdexxLib {

	public int sleep = 3000;


	public void CreateNewEvent(Hashtable<String, String> data) throws Throwable
	{
		new ActivityPage().Activity_Page();
		Thread.sleep(sleep);
		click(ActivityPage.newEvent, "New Event button");
		Thread.sleep(sleep);
		type(ActivityPage.newEventSubject, data.get("openActivities_Subject"), "subject ");		
		clickUsingJavascriptExecutor(ActivityPage.eventName_lookUp, "lookup Button");
		Thread.sleep(5000);

		if(searchAndClickOnContactInContactLookup(data.get("existing_contact1"))){
			clickUsingJavascriptExecutor(ActivityPage.Useradd, "add Button");
			Thread.sleep(2000);
		}else
			assertTrue(false, "searched contact does not exist - " + data.get("existing_contact1"));


		if(searchAndClickOnContactInContactLookup(data.get("existing_contact2"))){
			clickUsingJavascriptExecutor(ActivityPage.Useradd, "add Button");
			Thread.sleep(2000);
		}else
			assertTrue(false, "searched contact does not exist - " + data.get("existing_contact2"));


		Thread.sleep(3000);
		clickUsingJavascriptExecutor(ActivityPage.userDone, "Done Button");
		Thread.sleep(3000);
		click(ActivityPage.continueButton, "save Button");
		Thread.sleep(4000);
	}

	public void CreateNewTask(Hashtable<String, String> data) throws Throwable
	{

		new ActivityPage().Activity_Page();
		Thread.sleep(sleep);
		click(ActivityPage.ActnewTask, "Successfully Clicked on New Task Button");
		Thread.sleep(sleep);
		isElementPresent(ActivityPage.newTaskRequestPage, "verify New Activity Request Page", true);
		selectByVisibleText(ActivityPage.NewRecord, data.get("RecordType"), "Selected Sales Activity from drop down");
		click(ActivityPage.Continue, "Successfully Clicked on Continue Button");
		Thread.sleep(sleep);
		waitForElementPresent(ActivityPage.Sub, "AccountNumber field", 10);
		type(ActivityPage.Sub, data.get("openActivities_Subject"), "AccountNumber field");
		Thread.sleep(sleep);
		click(ActivityPage.Save_Sales, "Successfully Clicked on Save Button");
		Thread.sleep(sleep);

	}

	public void createActivityHistory(Hashtable<String, String> data) throws Throwable
	{

		new ActivityPage().Activity_Page();
		Thread.sleep(sleep);
		//clickUsingJavascriptExecutor(ActivityPage.logAnInteractionbtn,"log an interaction button");
		clickUsingJavascriptExecutor(ActivityPage.logacallbtn,"log a call button");
		
		//
		Thread.sleep(sleep);
		selectByVisibleText(ActivityPage.NewRecord, data.get("RecordType"), "Selected Sales Activity from drop down");
		clickUsingJavascriptExecutor(ActivityPage.Continue, "Successfully Clicked on Continue Button");
		Thread.sleep(3000);	
		//
		type(ActivityPage.logAcall_Subject, data.get("subject_activity"), "Successfully entered into subject field");
		selectByVisibleText(ActivityPage.InteractionOrigin, data.get("InteractionOrigin"), "Selected Sales Activity from drop down");
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(ActivityPage.log_savebtn," loga call information is saved");
		Thread.sleep(3000);
		//call option is not available in the dropdown, choosing Fax option 
		if(data.get("InteractionOrigin").equalsIgnoreCase("Fax"))
		{
			Thread.sleep(3000);
			String status = Driver.findElement(By.xpath(".//td[contains(text(),'Status')]/following-sibling::td[1]//div")).getText();
			System.out.println("status"+status);
			Thread.sleep(3000);
			assertTextMatching((ActivityPage.logAcallStatus), status, "Verify Status");
		}
	}

	/*public void createActivityHistoryForContact(Hashtable<String, String> data) throws Throwable
	{

		new ActivityPage().Activity_Page();
		Thread.sleep(sleep);
		clickUsingJavascriptExecutor(ActivityPage.logacallbtn,"log a call button"); 
		Thread.sleep(sleep);
		selectByVisibleText(ActivityPage.NewRecord, data.get("RecordType"), "Selected Sales Activity from drop down");
		clickUsingJavascriptExecutor(ActivityPage.Continue, "Successfully Clicked on Continue Button");
		Thread.sleep(3000);	
		type(ActivityPage.logAcall_Subject, data.get("subject_activity"), "Successfully entered into subject field");
		selectByVisibleText(ActivityPage.InteractionOrigin, data.get("InteractionOrigin"), "Selected Sales Activity from drop down");
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(ActivityPage.log_savebtn," loga call information is saved");
		Thread.sleep(3000);
		//call option is not available in the dropdown, choosing Fax option 
		if(data.get("InteractionOrigin").equalsIgnoreCase("Fax"))
		{
			Thread.sleep(3000);
			String status = Driver.findElement(By.xpath(".//td[contains(text(),'Status')]/following-sibling::td[1]//div")).getText();
			System.out.println("status"+status);
			Thread.sleep(3000);
			assertTextMatching((ActivityPage.logAcallStatus), status, "Verify Status");
		}
	}
*/	
	public void viewActivityHistory(Hashtable<String, String> data,String contactName) throws Throwable
	{

		new ActivityPage().Activity_Page();
		Thread.sleep(7000);
		click(ActivityPage.relatedTo," clicked on relatedTo account");
		Thread.sleep(3000);
		
		if(isElementPresent(ActivityPage.ActivitiesHistoryHyperlink, "", true)){
			mouseHoverByJavaScript(ActivityPage.ActivitiesHistoryHyperlink, "mousehover");
			Thread.sleep(2000);
		}
	//	System.out.println("get sub from Activity History   "+Driver.findElement(ActivityPage.RelatedTo_mouseHover).getText());
		Thread.sleep(4000);
		String actualText = Driver.findElement(ActivityPage.RelatedTo_mouseHover).getText();
		System.out.println("actualText - " + actualText);
		//assertTextMatching(ActivityPage.RelatedTo_mouseHover, accountName, "Verify activity related to");
		assertTextStringMatching(actualText, contactName);
	}
	
	public boolean searchAndClickOnContactInContactLookup(String existingContactName) throws Throwable{
		
		boolean found= false;
		try{
			Thread.sleep(3000);
		type(ActivityPage.lookUpSearch, existingContactName, "Successfully entered into search field");
		Thread.sleep(3000);
		//click(ActivityPage.lookUpfind, "find Button");
		clickUsingJavascriptExecutor(ActivityPage.lookUpfind, "find Button");
		
		int size = Driver.findElements(By.xpath(".//*[@id='mw_picker_found_list_id']//li ")).size();
		for(int i=1; i<=size; i++){
			
			String text = Driver.findElement(By.xpath(".//*[@id='mw_picker_found_list_id']//li["+ i +"]/span//span[1]")).getText();
			System.out.println(text + " => " + existingContactName );
			if(text.trim().equalsIgnoreCase(existingContactName.trim())){
				found = true;
				Thread.sleep(1000);
			//	driver.findElement(By.xpath(".//*[@id='mw_picker_found_list_id']//li["+ i +"]/span//span[1]")).click();
				WebElement element = Driver.findElement(By.xpath(".//*[@id='mw_picker_found_list_id']//li["+ i +"]/span//span[1]"));
				JavascriptExecutor executor = (JavascriptExecutor)Driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(2000);
				break;
			}
			
		}
		
	//	assertTrue(found, "searched contact does not exist - " + existingContactName);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return found;	
	}
	
	public void createNewAccount(Hashtable<String, String> data) throws Throwable {

		new AccountsPage().AccountsPage();
		clickUsingJavascriptExecutor(AccountsPage.accountsTab,"Accounts tab is clicked successfully");
		Thread.sleep(2000);
		clickUsingJavascriptExecutor(AccountsPage.newAccount, "New Account buttton is clicked succcessfully");
		Thread.sleep(3000);
		type(AccountsPage.name, data.get("accountName"), "Account Name ");
		Thread.sleep(3000);
		selectByValue(AccountsPage.businessUnit, data.get("businessUnit"), "Business unit");	
		Thread.sleep(3000);
		selectByValue(AccountsPage.industry, data.get("industry"), "Industry");	 
		clickUsingJavascriptExecutor(AccountsPage.save, "Save button is clicked succcessfully");
		Thread.sleep(3000);
		isElementPresent(AccountsPage.accountDetail,"Account detail page is displayed successfully", true);
		assertTextMatching(AccountsPage.descText,  data.get("accountName"), "Account name");
	}
	
	public void viewActivities(Hashtable<String, String> data) throws Throwable{
		Thread.sleep(3000);
		new AccountsPage().AccountsPage();
		Thread.sleep(3000);
		if(isElementPresent(AccountsPage.openActivitiesHyperlink, "", true)){
			mouseHoverByJavaScript(AccountsPage.openActivitiesHyperlink, "mousehover");
			Thread.sleep(2000);
		}
		//System.out.println(Driver.findElement(AccountsPage.openActivities_subjectOnMouseHover).getText());
		assertTextMatching(AccountsPage.openActivities_subjectOnMouseHover, data.get("openActivities_Subject"), "Verify Open activities subject");

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
			Thread.sleep(2000);
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
	
	public void EnterContactInfo(Hashtable<String, String> data) throws Throwable{

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
	}
	
/*public void EnterContactInfoNewAndSave(Hashtable<String, String> data) throws Throwable{
		
		selectByVisibleText(ContactsPage.salutionDropDown, data.get("salutation"), "selecting Mr. from dropdown");
		type(ContactsPage.firstName, data.get("firstName"), "entring the first name");
	Thread.sleep(2000);
	new ContactsPage().Contacts_Page();
	click(ContactsPage.newContactBtn, "click on the contact btn");
		Thread.sleep(2000);
		new ContactsPage().Contacts_Page();
		System.out.println(data.get("newContactLastName"));
		type(ContactsPage.lastname, data.get("newContactLastName"), "entering the last name");
		type(ContactsPage.middleName, data.get("middleName"), "entering the middle name");
		type(ContactsPage.mobile, data.get("mobile"), "entering the mobile");
		type(ContactsPage.email, data.get("email"), "entering the email");
		type(ContactsPage.accountName, data.get("accountName"), "entering the account name");
		Thread.sleep(3000);
		click(ContactsPage.saveBtn, "click on save btn");
	}*/

	}
