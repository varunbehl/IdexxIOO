package com.Idexx.libs;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;

public class ContactsLib extends IdexxLib {

	public boolean viewAllContacts() throws Throwable {

		boolean flag = true;
		try {
			new ContactsPage().Contacts_Page();
			Thread.sleep(2000);
			selectByVisibleText(ContactsPage.viewDropdown, "All Contacts",
					"select All Contacts from the list");
			click(ContactsPage.goButton, "click on the go button");
			String firstContact = getText(ContactsPage.firstContactDisplayed,
					"get the contact displayed in the first row");
			System.out.println("first contact - " + firstContact);
			String split[] = StringUtils.split(firstContact);
			String partialtext = split[0];
			System.out.println(" partial text - " + partialtext);
			click(ContactsPage.firstContactDisplayedLink,
					"click on the first displayed contact");
			String contactHeader = getText(
					ContactsPage.topNameDisplayedOnContactHeader,
					"contact header");
			Assert.assertTrue(
					StringUtils.containsIgnoreCase(contactHeader, partialtext),
					"Contact header dioes not contain contact's name.");

		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}

	public boolean createDuplicateContact(Hashtable<String,String> data, String accountName, String contactName) throws Throwable {

		boolean flag = true;
		try {
			new ContactsPage().Contacts_Page();
			Thread.sleep(3000);

			selectByVisibleText(ContactsPage.viewDropdown, "All Contacts",
					"select All Contacts from the list");
			click(ContactsPage.goButton, "click on the go button");
			Thread.sleep(3000);
			click(ContactsPage.newContactBtn, "click on the contact btn");
			Thread.sleep(3000);
			new ContactsPage().Contacts_Page();
			EnterContactInfo(data, accountName, contactName);
			
			click(ContactsPage.saveNewBtn,
					"clicking on the save and new button");
			Thread.sleep(3000);
			EnterContactInfo(data, accountName, contactName);
			click(ContactsPage.saveBtn, "click on save btn");
			Thread.sleep(3000);
			String lastname = data.get("newContactLastName");
			Thread.sleep(3000);
			String contactHeader = getText(
					ContactsPage.topNameDisplayedOnContactHeader,
					"contact header");
			System.out.println("contact header - " + contactHeader);
			System.out.println("last name - " + lastname);
			Assert.assertTrue(
					!(StringUtils.containsIgnoreCase(contactHeader, lastname)),
					"Contact header does not contain contact's name.");
		} catch (Exception ex) {
			flag = false;
		}
		return flag;
	}

	public boolean createContact(Hashtable<String, String> data, String accountName, String contactName) throws Throwable {

		boolean flag = true;
		try {
			//goToHomePage();
			goToContactsPage();
			new ContactsPage().Contacts_Page();
			Thread.sleep(2000);

			Select s =  new Select(Driver.findElement(ContactsPage.viewDropdown));

			String selectedValue  =		s.getFirstSelectedOption().getText();
			System.out.println("selectedValue = " + selectedValue );
			if(!(selectedValue.equalsIgnoreCase("All Contacts"))){
			selectByVisibleText(ContactsPage.viewDropdown, "All Contacts",
					"select All Contacts from the list");
			Thread.sleep(2000);
			}
			click(ContactsPage.goButton, "click on the go button");
			Thread.sleep(3000);
			click(ContactsPage.newContactBtn, "click on the contact btn");
			Thread.sleep(3000);
			new ContactsPage().Contacts_Page();
			EnterContactInfo(data, accountName, contactName);
			click(ContactsPage.saveBtn, "click on save btn");
			waitForElementPresent(ContactsPage.topNameDisplayedOnContactHeader, "contact header", 10);
			String lastname = contactName;
			String contactHeader = getText(
					ContactsPage.topNameDisplayedOnContactHeader, "contact header");
			Assert.assertTrue(
					(StringUtils.containsIgnoreCase(contactHeader, lastname)),
					"Contact header does not contain contact's name.");
		} catch (Exception ex) {
			flag = false;
		}

		return flag;
	}

	
	
public void EnterContactInfo(Hashtable<String, String> data, String accountName, String contactName) throws Throwable{
		
	/*selectByVisibleText(ContactsPage.salutionDropDown, data.get("salutation"), "selecting Mr. from dropdown");
	type(ContactsPage.firstName, data.get("firstName"), "entring the first name");*/
	Thread.sleep(2000);
	new ContactsPage().Contacts_Page();
	System.out.println(contactName);
	//type(ContactsPage.lastname, contactName, "entering the last name");
	/*type(ContactsPage.middleName, data.get("middleName"), "entering the middle name");
	type(ContactsPage.mobile, data.get("mobile"), "entering the mobile");
	type(ContactsPage.email, data.get("email"), "entering the email");*/
	type(ContactsPage.accountName, accountName, "entering the account name");
	}

     public void linkContactWithMultipleAccounts(Hashtable<String, String> data) throws Throwable{
	//	 Hashtable<String, String> data = TestUtil.getDataSignUp("TestLinkContactWithMultipleAccounts", "Contacts");
		 new ContactsPage().Contacts_Page();
					
			click(ContactsPage.newAccountInAccountSection, "new account button in accounts section");
			Thread.sleep(1000);
			type(ContactsPage.newAccountName, data.get("newAccountName"), "subject ");
			Driver.findElement(ContactsPage.primaryContact).clear();
			selectByVisibleText(ContactsPage.businessUnitDropdown, data.get("bussinessUnitDropdown"), "select business unit dropdown");
			selectByVisibleText(ContactsPage.industryDropdown, data.get("industryDropdown"), "select industry dropdown");
			click(ContactsPage.saveBtn, "");
	
	 }
	 
     public boolean searchAndClickContactUsingGlobalSearch(String contactName) throws Throwable{

    	 boolean found = false;
    	 goToHomePage();
    	 new HomePage().Home_Page();
    	 type(HomePage.search, contactName, "search");
    	 Thread.sleep(3000);
    	 Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.TAB);
    	 Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.ENTER);
    	 Thread.sleep(5000);
    	 if(!(isElementPresent(HomePage.contactsHyperlink, "Contacts hyperlink on the left side tab after search", true))){
    		 Assert.fail("No Contact found.");
    	 }else{
    		 click(HomePage.contactsHyperlink, "Contacts hyperlink on the left side tab");
    		 Thread.sleep(4000);
    		// if(isElementPresent(HomePage.showMoreLink_contactsBody, "show more link in Contact section", true))
    			 //{	click(HomePage.showMoreLink_contactsBody, "click on show more link .");
    		//	 clickUsingJavascriptExecutor(HomePage.showMoreLink_contactsBody, "click on show more link .");
    		 Thread.sleep(4000);
    	 }
    	 int count = Driver.findElements(By.xpath(".//*[@id='Contact_body']/table/tbody/tr")).size();

    	 for(int i = 2; i<=count;i++){
    		 String text = Driver.findElement(By.xpath(".//*[@id='Contact_body']/table/tbody/tr["+i+"]/th/a")).getText();
    		 System.out.println(text);
    		 if(text.equalsIgnoreCase(contactName)){
    			 WebElement element = Driver.findElement(By.xpath(".//*[@id='Contact_body']/table/tbody/tr["+i+"]/th/a"));
    				JavascriptExecutor executor = (JavascriptExecutor)Driver;
    				executor.executeScript("arguments[0].click();", element);
    			 
    			 
    			 found = true;
    			// driver.findElement(By.xpath(".//*[@id='Contact_body']/table/tbody/tr["+i+"]/th/a")).click();
    			 Thread.sleep(3000);
    			 System.out.println("clicked on Contact ...");
    			 break;
    		 }
    	 }
    	 new ContactsPage().Contacts_Page();
    	 assertTextMatching(ContactsPage.topNameDisplayedOnContactHeader, contactName, "verifying the search result");
  
     return found;
}
	 
	public void TestCreateAccount(String url, String lob, String fname, String lname, String email, String country, String password, String AccNumber, String postCode, String jobTitle) throws Throwable{
		new HomePage().Home_Page();
		new ContactsPage().CreateContactPage();
		new ContactsPage().BusinessAffiliationPage();
		//Driver.get(ReporterConstants.APP_BASE_URL);
		//Driver= new ChromeDriver();
		Driver.navigate().to("https://google.com");
		Thread.sleep(3000);
		Driver.navigate().to(url);
		/*if (row=="Yes") {
			JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on the logout link");
		}*/
		
		
		
		waitForElementPresent(HomePage.createAccountBtn, "Verify Create Acc btn ", 10);
		click(HomePage.createAccountBtn, "Click on Create acc btn");
		Thread.sleep(3000);
		waitForElementPresent(ContactsPage.firstName, "Verify first name field ", 10);
		type(ContactsPage.firstName, fname, "Enter first name");
		
		waitForElementPresent(ContactsPage.lastName, "Verify last name field ", 10);
		type(ContactsPage.lastName, lname, "Enter last name");
		
		waitForElementPresent(ContactsPage.email, "Verify email field ", 10);
		type(ContactsPage.email, email, "Enter email");
		waitForElementPresent(ContactsPage.confirmEmail, "Verify confEmail field ", 10);
		type(ContactsPage.confirmEmail, email, "Enter confEmail");
		selectByValue(ContactsPage.countryDropdown, country, "Select country");
		click(ContactsPage.privacyPolicyCheckbox, "Check Privacy policy checkbox");
		type(ContactsPage.pwd, password, "Set password");
		click(ContactsPage.createAccountBtn, "Click on create account Button");
		Thread.sleep(6000);
		String act= Driver.findElement(By.id("success-heading")).getText();
		//assertTextStringMatching(act, "Almost done. Please check your email.");
		
		Driver.navigate().to("https://www.mailinator.com/");
		type(By.id("inboxfield"), email, "Enter email");
		Thread.sleep(5000);
		click(By.xpath("//button[@class='btn btn-dark']"), "Click on Go button");
		Thread.sleep(10000);
		click(By.xpath("(//div[@class='innermail ng-binding' and text()])[3]"), "Click on the recieved email");
		Thread.sleep(2000);
		Driver.switchTo().frame("publicshowmaildivcontent");
		click(By.xpath("//a[contains(@href,'https://np-profile.idexx.com/confirm/index.html')]"), "Click on the link");
		Thread.sleep(2000);
		 String originalHandle = Driver.getWindowHandle();

		    //Do something to open new tabs

		    for(String handle : Driver.getWindowHandles()) {
		        if (!handle.equals(originalHandle)) {
		            Driver.switchTo().window(handle);
		            type(ContactsPage.username, email, "Enter Username");
		    	    type(ContactsPage.password, password, "Enter Password");
		    	    Thread.sleep(2000);

		    	    click(ContactsPage.signIn, "Click Sign In button");
		    	    Thread.sleep(4000);
		    	    //Integer.parseInt(AccNumber);
		    	    type(ContactsPage.idexxAccountNumber, AccNumber, "Enter Customer Account number");
		    	    
		    	   
		    	  
		    	    
		    	    type(ContactsPage.postCode, postCode, "Enter PostCode");
		    	    
//		    	    type(By.xpath("//input[@id='postalCode']"), "76576", "enter acc number");
		    	    click(ContactsPage.submitBtn, "Click on continue button");
		    		
		    		
		    		    Thread.sleep(4000);
		    	    selectByValue(ContactsPage.jobTitleDropdown, jobTitle, "Select Job Title");
		    	    Thread.sleep(4000);
		    	  Driver.findElement(By.xpath("//h1[@id='affiliate-result-heading']")).click();
		    	  Thread.sleep(4000);
		    	    //click(ContactsPage.finishBtn, "Clcik on finish Button");
		    	   
		    	   
		    	    
		    	    //String URLString;
		          if (url.equalsIgnoreCase("https://qaorder.idexx.com")){
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
		          }else if (url.equalsIgnoreCase("https://qabestellung.idexx.at")) {
		        	  click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
					
				}else if(url.equalsIgnoreCase("https://qaorder.idexx.com.au")){
					 click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qaorder.idexx.be")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qaorder.idexx.ca")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qabestellung.idexx.ch")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qaobjednavky.idexx.cz")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
		    	    Thread.sleep(4000);
		    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
		    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qabestellung.idexx.de")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}else if(url.equalsIgnoreCase("https://qaorder.idexx.dk")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qapedido.idexx.es")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.fi")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qacommande.idexx.fr")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.co.uk")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaordini.idexx.it")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.nl")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.no")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.co.nz")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.se")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaobjednavky.idexx.sk")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.com")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}
				else if(url.equalsIgnoreCase("https://qaorder.idexx.co.za")){
					click(By.xpath("//input[@name='"+lob+"']"), "select bus focus radio button");
		        	  Driver.findElement(By.xpath("//input[@id='submit']")).submit();
			    	    Thread.sleep(4000);
			    	   JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
			    	    Thread.sleep(6000);
				}   
		    	    
		    	    
		    	    
		    	    
		    	    JSClick(By.xpath("//a[@id='sso-sign-out-link']"), "Click on sign out");
		    	    Driver.manage().deleteAllCookies();
		    	    Driver.navigate().refresh();
		            Driver.close();
		        }
		    }

		    Driver.switchTo().window(originalHandle);
		    Driver.manage().deleteAllCookies();
    	    Driver.navigate().refresh();
    	    Thread.sleep(4000);
    	   // Driver.manage().deleteAllCookies();
    	    
    	   // Driver.navigate().refresh();
    	   // Thread.sleep(4000);
		
		
	
	  /*  String act1= Driver.findElement(By.id("congrats")).getText();
	    Thread.sleep(6000);
		assertTextStringMatching(act1, "Your profile has been updated");*/
	    //Driver.close();
	}


	public void TestCreateOrder(String url, String email, String password,String customer, String ProdDesc, String Quantity )throws Throwable{
		new HomePage().Home_Page();
		new ContactsPage().CreateContactPage();


		Driver.navigate().to("https://google.com");
		Thread.sleep(3000);
		Driver.navigate().to(url);
		waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
		click(HomePage.signInBtn, "Click on Sign in btn");
		Thread.sleep(3000);
		type(ContactsPage.username, email, "Enter Username");
		type(ContactsPage.password, password, "Enter Password");
		Thread.sleep(2000);

		click(ContactsPage.signIn, "Click Sign In button");
		Thread.sleep(2000);
		click(HomePage.orderNowBtn, "Click Order now button");
		waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify Product Search field ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn, "Click on Submit order button");
		waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);
		Thread.sleep(2000);
		/*JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		Thread.sleep(4000);*/
		//Driver.manage().deleteAllCookies();
		//Driver.navigate().refresh();
		//Driver.close();

	}

	public void TestPurchaseSavedOrder(String url, String email, String password,String customer, String ProdDesc, String ordName, String Quantity)throws Throwable{
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestSaveOrder(url, email, password, customer, ProdDesc, ordName, Quantity);
		/*Driver.navigate().to("https://google.com");
		Thread.sleep(3000);
		Driver.navigate().to(url);
		waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
		click(HomePage.signInBtn, "Click on Sign in btn");
		Thread.sleep(3000);
		type(ContactsPage.username, email, "Enter Username");
		type(ContactsPage.password, password, "Enter Password");
		Thread.sleep(2000);

		click(ContactsPage.signIn, "Click Sign In button");
		Thread.sleep(2000);
		click(HomePage.orderNowBtn, "Click Order now button");
		waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify Product Search field ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(ContactsPage.saveForLaterBtn,"Verify the Save for Later button", 10);
		click(ContactsPage.saveForLaterBtn, "Click on Save For Later button");
		waitForElementPresent(ContactsPage.orderNameDialogeBox, "Verify Order Name Dialogue Box ", 10);

		type(ContactsPage.orderNameField, ordName, "Enter Order Name");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		waitForElementPresent(ContactsPage.myOrdersBtn, "Verify My orders button ", 10);
		//click(ContactsPage.myOrdersBtn, "Click on my orders button");
		mouseHoverByJavaScript(ContactsPage.myOrdersBtn, "Hover on My Orders button");
		click(ContactsPage.savedOrdersLink, "Click on Saved Orders link");*/
		waitForElementPresent(ContactsPage.orderNowLink, "Verify Order Now Link", 10);
		click(ContactsPage.orderNowLink, "Click on Order Now link");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn, "Click on Submit order button");
		waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);
		Thread.sleep(2000);
		/*JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		Thread.sleep(4000);*/
	}

	public void TestSaveOrder(String url, String email, String password,String customer, String ProdDesc, String ordName, String Quantity)throws Throwable{
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();


		Driver.navigate().to("https://google.com");
		Thread.sleep(3000);
		Driver.navigate().to(url);
		waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
		click(HomePage.signInBtn, "Click on Sign in btn");
		Thread.sleep(3000);
		type(ContactsPage.username, email, "Enter Username");
		type(ContactsPage.password, password, "Enter Password");
		Thread.sleep(2000);

		click(ContactsPage.signIn, "Click Sign In button");
		Thread.sleep(2000);
		click(HomePage.orderNowBtn, "Click Order now button");
		waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify Product Search field ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(ContactsPage.saveForLaterBtn,"Verify the Save for Later button", 10);
		click(ContactsPage.saveForLaterBtn, "Click on Save For Later button");
		waitForElementPresent(ContactsPage.orderNameDialogeBox, "Verify Order Name Dialogue Box ", 10);

		type(ContactsPage.orderNameField, ordName, "Enter Order Name");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		waitForElementPresent(ContactsPage.myOrdersBtn, "Verify My orders button ", 10);
		//click(ContactsPage.myOrdersBtn, "Click on my orders button");
		mouseHoverByJavaScript(ContactsPage.myOrdersBtn, "Hover on My Orders button");
		click(ContactsPage.savedOrdersLink, "Click on Saved Orders link");
		waitForElementPresent(ContactsPage.orderNoVerify, "Verify Saved Order number", 10);
		/*JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		Thread.sleep(4000);*/
	}
	public void TestDeleteOrder(String url, String email, String password,String customer, String ProdDesc, String ordName, String Quantity)throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestSaveOrder(url, email, password, customer, ProdDesc, ordName, Quantity);
		click(ContactsPage.deleteLink, "Click on Delete link");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(4000);

	}
	
}
