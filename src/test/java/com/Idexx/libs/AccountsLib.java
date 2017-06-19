package com.Idexx.libs;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.Idexx.page.AccountsPage;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.Idexx.page.ReportsPage;

public class AccountsLib extends IdexxLib{
	
	public int sleepTime_chrome = 3000;

	//Accounts
	public void viewAndEditMyAccount(Hashtable<String, String> data) throws Throwable
	{
		/**
		 * By hovering on 'Account Detail', we do not see any data available.
		 * Assuming it is a defect.
		 * 
		 * Instead we can proceed by mouse hover on the 'Account owner' field in 'accounts detail' section ...do we need to proceed ? 
		 */
		
		new AccountsPage().AccountsPage();
		click(AccountsPage.editBtn, "clicked on Edit btn");
		Thread.sleep(2000);
		//System.out.println(data.get("LPDBusinessPlanText"));
		Thread.sleep(2000);
		clickUsingJavascriptExecutor(AccountsPage.lpdBusinessPlanTextArea, "lpdBusinessPlanTextArea field");
		type(AccountsPage.lpdBusinessPlanTextArea, data.get("LPDBusinessPlanText"), "Entering LPD business plan text");
		Thread.sleep(2000);
		click(AccountsPage.save, "clicked on Save button");
		Thread.sleep(2000);
		//assertTextStartsByPrefix(text, prefix)
		assertText(AccountsPage.lpdBussinessAreaTextAfterSave, data.get("LPDBusinessPlanText"));
	}
	
	public void viewAccountTeamMembers(Hashtable<String, String> data) throws Throwable{
		new AccountsPage().AccountsPage();
	//	mouseover(AccountsPage.accountTeamHyperlink, "accounts team hyperlink");
		Actions action = new Actions(Driver);
		action.moveToElement(Driver.findElement(AccountsPage.accountTeamHyperlink)).build().perform();
		System.out.println(Driver.findElement(AccountsPage.teamMember).getText());
		System.out.println(Driver.findElement(AccountsPage.teamRole).getText());
		assertTextMatching(AccountsPage.teamMember, data.get("teamMember"), "Verify team member");
		assertTextMatching(AccountsPage.teamRole, data.get("teamRole"), "verify team role");
		click(AccountsPage.topNameDisplayedOnContactHeader, "click on header row");
		Thread.sleep(3000);

	}


	public void viewActivities(Hashtable<String, String> data) throws Throwable{
		new AccountsPage().AccountsPage();
		Thread.sleep(3000);
		if(isElementPresent(AccountsPage.openActivitiesHyperlink, "", true)){
			mouseHoverByJavaScript(AccountsPage.openActivitiesHyperlink, "mousehover");
			Thread.sleep(2000);
		}
		System.out.println(Driver.findElement(AccountsPage.openActivities_subjectOnMouseHover).getText());
		assertTextMatching(AccountsPage.openActivities_subjectOnMouseHover, data.get("openActivities_Subject"), "Verify Open activities subject");

	}


	public void viewContactMembers(Hashtable<String, String> data) throws Throwable{
		new AccountsPage().AccountsPage();
		Actions action = new Actions(Driver);
		action.moveToElement(Driver.findElement(AccountsPage.contactsHyperlink)).build().perform();
		System.out.println(Driver.findElement(AccountsPage.contacts_contactNameOnMouseHover).getText());
		assertTextMatching(AccountsPage.contacts_contactNameOnMouseHover, data.get("contactName"), "Verify contact");	
	}

	public void viewOpportunityDetails(Hashtable<String, String> data) throws Throwable{
		new AccountsPage().AccountsPage();
	
		Actions action = new Actions(Driver);
		action.moveToElement(Driver.findElement(AccountsPage.opportunitiesHyperlink)).build().perform();
		System.out.println(Driver.findElement(AccountsPage.opportunity_nameOnMouseHover).getText());
		System.out.println(Driver.findElement(AccountsPage.opportunity_stageOnMouseHover).getText());
		System.out.println("stage -" +data.get("opportunity_Stage") );
		assertTextMatching(AccountsPage.opportunity_nameOnMouseHover, data.get("opportunity_Name"), "Verify Oppurtunity name");
		assertTextMatching(AccountsPage.opportunity_stageOnMouseHover, data.get("opportunity_Stage"), "verify Oppurtunity Stage");
		
	}
	
	public void viewOpenActivities(Hashtable<String, String> data) throws Throwable{
		new AccountsPage().AccountsPage();
	
		Actions action = new Actions(Driver);
		action.moveToElement(Driver.findElement(AccountsPage.openActivitiesHyperlink)).build().perform();
		System.out.println(Driver.findElement(AccountsPage.openActivities_subjectOnMouseHover).getText());
	    System.out.println(Driver.findElement(AccountsPage.openActivities_relatedTo).getText());
		System.out.println("related to -" +data.get("openActivities_RelatedTo") );
		Thread.sleep(2000);
		assertTextMatching(AccountsPage.openActivities_subjectOnMouseHover, data.get("openActivities_Subject"), "Verify Open activities subject");
		assertTextMatching(AccountsPage.openActivities_relatedTo, data.get("openActivities_RelatedTo"), "verify open activities related to ");
		
	}

	
	public void selectAccount() throws Throwable {

		new AccountsPage().AccountsPage();
		click(AccountsPage.accountsTab,"Accounts tab is clicked successfully");
		selectByIndex(AccountsPage.listview,0,"All Accounts is selected succcessfully");
		waitForElementPresent(AccountsPage.goButton, "", 10);
		click(AccountsPage.goButton,"Go button is clicked successfully");

		waitForElementPresent(AccountsPage.accountData, "",10);
		WebElement table = Driver.findElement(AccountsPage.accountData);
		List<WebElement> rows = table.findElements(By.tagName("div"));
		int rowCount = rows.size();
		System.out.println("row count"+rowCount);
		if(rowCount > 0)
			System.out.println("A list of existing accounts is appearing on the page");

		waitForElementPresent(AccountsPage.accountName, "",10);
		click(AccountsPage.accountName,"Account name is clicked successfully");
		isElementPresent(AccountsPage.accountDetail,"Account detail page is displayed successfully",true);
		isVisible(AccountsPage.accountDetail, "The details of the selected Account should be visible");

	}

	

	public void assignTerritories() throws Throwable {

		new AccountsPage().AccountsPage();
		click(AccountsPage.accountsTab,"Accounts tab is clicked successfully");
		selectByIndex(AccountsPage.listview,0,"All Accounts is selected succcessfully");
		waitForElementPresent(AccountsPage.goButton, "",10);
		click(AccountsPage.goButton,"Go button is clicked successfully");
		waitForElementPresent(AccountsPage.accountName, "",10);
		click(AccountsPage.accountName,"Account name is clicked successfully");

		click(AccountsPage.edit,"Edit button is clicked successfully");
		waitForElementPresent(AccountsPage.postalZip, "",10);
		type(AccountsPage.postalZip, "123", "Postal Zip is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");

		waitForElementPresent(AccountsPage.edit, "",10);
		click(AccountsPage.edit,"Edit button is clicked successfully");
		type(AccountsPage.shippingCountry, "United states", "Shipping Country is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");

		waitForElementPresent(AccountsPage.edit, "",10);
		click(AccountsPage.edit,"Edit button is clicked successfully");
		type(AccountsPage.billingCountry, "France", "Billing Country is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");

		waitForElementPresent(AccountsPage.edit, "",10);
		click(AccountsPage.edit,"Edit button is clicked successfully");
		type(AccountsPage.billingCountry, "Italy", "Billing Country is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");

		waitForElementPresent(AccountsPage.edit, "",10);
		click(AccountsPage.edit,"Edit button is clicked successfully");
		type(AccountsPage.billingCountry, "UK", "Billing Country is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");

		waitForElementPresent(AccountsPage.edit, "",10);
		click(AccountsPage.edit,"Edit button is clicked successfully");
		type(AccountsPage.shippingCountry, "United states", "Shipping Country is entered successfully");
		click(AccountsPage.territoriesSave,"save Button");
	}
	
	public boolean searchAndClickAccountUsingGlobalSearch(String accountName) throws Throwable{

		System.out.println("in search");
		boolean found = false;
	//	goToHomePage();
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
	
	
	
public void createNewReport(Hashtable<String, String> data, String accountname) throws Throwable{
		
		goToReportTab();
		new ReportsPage().Reports_Page();
		click(ReportsPage.newReportButton, " new report button ");
		sleep(3000);
		clickUsingJavascriptExecutor(ReportsPage.accountsAndContactsNode, "accountsAndContactsNode object");
		sleep(2000);
		clickUsingJavascriptExecutor(ReportsPage.accountsChildNode, "Accounts object");
		sleep(2000);
		clickUsingJavascriptExecutor(ReportsPage.createButton, "create button");
		sleep(3000);
		
		//select show all accounts
		clickUsingJavascriptExecutor(ReportsPage.showDropdownXpath, "show dropdown");
		sleep(2000);
		clickUsingJavascriptExecutor(ReportsPage.allAccountsXpath, "select all accounts");
		
		//type(ReportsPage.fromDate, data.get("fromdate"), "enter from date");
//	Driver.findElement(ReportsPage.fromDate).clear();
//	Driver.findElement(ReportsPage.fromDate).sendKeys("11/10/2015");
	
		//((JavascriptExecutor) Driver).executeScript("arguments[0].value = ' "+data.get("fromdate")+"';",Driver.findElement(ReportsPage.fromDate));
	//	((JavascriptExecutor) Driver).executeScript("arguments[0].value = '11/10/2015';",Driver.findElement(ReportsPage.fromDate));
		clickUsingJavascriptExecutor(ReportsPage.addButton, "add button to add more filters");
		sleep(4000);
		clickUsingJavascriptExecutor(ReportsPage.add_FilterByDropDown, "filter drodpown after clicking add");
		clickUsingJavascriptExecutor(ReportsPage.byAccountNameOption, "Accounts Name option in the filter by drodown.");

		clickUsingJavascriptExecutor(ReportsPage.add_FilterComparator, "add filter comparation");

		clickUsingJavascriptExecutor(ReportsPage.byEqualsOption, "equals option");
		clickUsingJavascriptExecutor(ReportsPage.add_FilterInputBox, "add filter input box.");
		//
		System.out.println(" account name --> " + accountname);
		((JavascriptExecutor) Driver).executeScript("arguments[0].value = ' "+accountname+"';",Driver.findElement(ReportsPage.add_FilterInputBox));
	//	type(ReportsPage.add_FilterInputBox, data.get("accountName"), "input data for the filters");
		sleep(4000);
		clickUsingJavascriptExecutor(ReportsPage.add_FilterOk, "Ok button");

		clickUsingJavascriptExecutor(ReportsPage.runReport, "run report");
		
		// .//*[@id='fchArea']/table/tbody/tr[2]/td[2]/a
		int size = Driver.findElements(By.xpath(".//*[@id='fchArea']/table/tbody/tr")).size();
		for(int i = 2; i<=size -2; i ++){
			String text = Driver.findElement(By.xpath(".//*[@id='fchArea']/table/tbody/tr["+i+"]/td[2]/a")).getText();
			System.out.println(text);
			if(!(text.equalsIgnoreCase(accountname)))
				Assert.fail("expected : " + accountname + " || actual : " + text);
		}
		sleep(4000);
	}
	
	public boolean createContactForAccount(Hashtable<String, String> data, String newContact) throws Throwable{

		boolean created = false;
		try{
			//searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
			
			new AccountsPage().AccountsPage();
			click(AccountsPage.newContactButton, "new contact button on accounts page");
			Thread.sleep(4000);
			new ContactsPage().Contacts_Page();
		//	System.out.println(data.get("newContactLastName"));
			type(ContactsPage.lastname, newContact, "entering the last name");
			click(ContactsPage.saveBtn, "save button");
			waitForVisibilityOfElement(ContactsPage.accountNameDisplayed, "account name page");
			if(isElementPresent(ContactsPage.accountNameDisplayed, "account link display",true)){
				System.out.println("Account name hyperlink is visible ...");
				clickUsingJavascriptExecutor(ContactsPage.accountNameDisplayed, "accountName");
				Thread.sleep(4000);
			}
			// .//*[contains(@id,'RelatedContactList_body')]/table/tbody/tr[2]/th/a
		//	int count = getRowCount(AccountsPage.contactsTableData);
			new AccountsPage().AccountsPage();
			waitForVisibilityOfElement(AccountsPage.topNameDisplayedOnContactHeader, "Account page opened");
			
			Driver.findElement(AccountsPage.topNameDisplayedOnContactHeader).sendKeys(Keys.PAGE_DOWN);
			Driver.findElement(AccountsPage.topNameDisplayedOnContactHeader).sendKeys(Keys.PAGE_DOWN);
			Driver.findElement(AccountsPage.topNameDisplayedOnContactHeader).sendKeys(Keys.PAGE_DOWN);
			
			int count = Driver.findElements(By.xpath(".//*[contains(@id,'RelatedContactList_body')]/table/tbody/tr")).size();
			System.out.println("count --> " + count);
			for(int i = 2; i<=count; i++){
				System.out.println("in for loop");
				String text = Driver.findElement(By.xpath(".//*[contains(@id,'RelatedContactList_body')]/table/tbody/tr["+i +"]/th/a")).getText();
				System.out.println("text -> " + text);
				if(text.equalsIgnoreCase(newContact)){
					created = true;
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return created;
	}
	
	
	
	
	
	//Praveen
	
	//account hierarchy(1.8)
		public void viewAccounthierarchy(Hashtable<String, String> data) throws Throwable
		{
			searchAndClickAccountUsingGlobalSearch(data.get("accountName"));
			Thread.sleep(4000);
			//assertText(AccountsPage.view_Hierarchy,data.get("accountName"));
		//	String str = getText(AccountsPage.accountDetail_AccountName, "");
		//	System.out.println(str);
			assertTextMatching(AccountsPage.accountDetail_AccountName, data.get("accountName"),"base account hierarchy");
			assertText(AccountsPage.view_Hierarchy,"[View Hierarchy]");
			clickUsingJavascriptExecutor(AccountsPage.view_Hierarchy, "Clicked on View Hierarchy link");
			Thread.sleep(5000);
			waitForVisibilityOfElement(AccountsPage.baseAccount, "base account link");
			assertTextMatching(AccountsPage.baseAccount, data.get("accountName"),"base account hierarchy");
			assertTextMatching(AccountsPage.viewHierarchy_ParentAccount, data.get("ParentNodeAccount"),"parent account hierarchy");
			assertTextMatching(AccountsPage.viewHierarchy_GrandParentAccount, data.get("GrandParentAccount"),"Grand Parent account hierarchy");
		}
		
		public void CompetitorProducts(Hashtable<String, String> data) throws Throwable{
			
			new AccountsPage().AccountsPage();
			assertTextMatching(AccountsPage.competitorProductsName, data.get("competitor_productName"), "verify competitor product");
		//	String competitorProductName = getText(AccountsPage.competitorProductsName, "Get the text of the Competitor product");
			click(AccountsPage.competitorProductsName, "Competitor product name link");
			Thread.sleep(2000);
			assertTextMatching(AccountsPage.competitorProductDetailPageTitle,"Competitor Product Detail" , "verify competitor product page title");
		
			assertTextMatching(AccountsPage.competitorProductsNameOnCompetitorsPage, data.get("competitor_productName"), "verify competitor product name after click");
			}
		
	
	
	
	
}
