package com.Idexx.libs;

import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;

public class ContactsLib extends IdexxLib {
	String ordNameValue;
	String saveordName;
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

	public boolean createDuplicateContact(Hashtable<String, String> data, String accountName, String contactName) throws Throwable {

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

			Select s = new Select(Driver.findElement(ContactsPage.viewDropdown));

			String selectedValue = s.getFirstSelectedOption().getText();
			System.out.println("selectedValue = " + selectedValue);
			if (!(selectedValue.equalsIgnoreCase("All Contacts"))) {
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


	public void EnterContactInfo(Hashtable<String, String> data, String accountName, String contactName) throws Throwable {
		
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

	public void linkContactWithMultipleAccounts(Hashtable<String, String> data) throws Throwable {
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

	public boolean searchAndClickContactUsingGlobalSearch(String contactName) throws Throwable {

		boolean found = false;
		goToHomePage();
		new HomePage().Home_Page();
		type(HomePage.search, contactName, "search");
		Thread.sleep(3000);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.TAB);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		if (!(isElementPresent(HomePage.contactsHyperlink, "Contacts hyperlink on the left side tab after search", true))) {
			Assert.fail("No Contact found.");
		} else {
			click(HomePage.contactsHyperlink, "Contacts hyperlink on the left side tab");
			Thread.sleep(4000);
			// if(isElementPresent(HomePage.showMoreLink_contactsBody, "show more link in Contact section", true))
			//{	click(HomePage.showMoreLink_contactsBody, "click on show more link .");
			//	 clickUsingJavascriptExecutor(HomePage.showMoreLink_contactsBody, "click on show more link .");
			Thread.sleep(4000);
		}
		int count = Driver.findElements(By.xpath(".//*[@id='Contact_body']/table/tbody/tr")).size();

		for (int i = 2; i <= count; i++) {
			String text = Driver.findElement(By.xpath(".//*[@id='Contact_body']/table/tbody/tr[" + i + "]/th/a")).getText();
			System.out.println(text);
			if (text.equalsIgnoreCase(contactName)) {
				WebElement element = Driver.findElement(By.xpath(".//*[@id='Contact_body']/table/tbody/tr[" + i + "]/th/a"));
				JavascriptExecutor executor = (JavascriptExecutor) Driver;
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

	public void TestCreateAccount(String url, String lob, String fname, String lname, String email, String country, String password, String AccNumber, String postCode, String jobTitle) throws Throwable {
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
		String act = Driver.findElement(By.id("success-heading")).getText();
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

		for (String handle : Driver.getWindowHandles()) {
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
				if (url.equalsIgnoreCase("https://qaorder.idexx.com")) {
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qabestellung.idexx.at")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);

				} else if (url.equalsIgnoreCase("https://qaorder.idexx.com.au")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.be")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.ca")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qabestellung.idexx.ch")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaobjednavky.idexx.cz")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qabestellung.idexx.de")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.dk")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qapedido.idexx.es")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.fi")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qacommande.idexx.fr")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.co.uk")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaordini.idexx.it")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.nl")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.no")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.co.nz")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.se")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaobjednavky.idexx.sk")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.com")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
					Driver.findElement(By.xpath("//input[@id='submit']")).submit();
					Thread.sleep(4000);
					JSClick(ContactsPage.finishBtn, "Clcik on finish Button");
					Thread.sleep(6000);
				} else if (url.equalsIgnoreCase("https://qaorder.idexx.co.za")) {
					click(By.xpath("//input[@name='" + lob + "']"), "select bus focus radio button");
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


	public void TestCreateOrder(String url, String email, String password, String customer, String ProdDesc, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().CreateContactPage();
		new ContactsPage().OrderPage();


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




			if (url.equalsIgnoreCase("https://qaorder.idexx.com")) {
				waitForElementPresent(ContactsPage.followingBtn, "Verify the next button ", 10);
				click(ContactsPage.followingBtn, "Click on next button");
				Thread.sleep(2000);
				click(ContactsPage.newOrderlink, "Click on Order Now link");

			} else if (url.equalsIgnoreCase("http://devordercore.idexx.com")) {
				click(HomePage.orderNowBtn, "Click on Order Now button");
				Thread.sleep(6000);

			}



		waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify Product Search field ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartLink, "Click on Add to order link");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		Thread.sleep(2000);
		waitForElementPresent(HomePage.submitOrderCheckbox_FR, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderCheckbox_FR, "Click on Submit order button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);

		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		/*waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);*/
		Thread.sleep(2000);
		/*JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		Thread.sleep(4000);*/
		//Driver.manage().deleteAllCookies();
		//Driver.navigate().refresh();
		//Driver.close();

	}

	public void TestPurchaseSavedOrder(String url, String email, String password, String customer, String ProdDesc, String ordName, String Quantity) throws Throwable {
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

	public void TestSaveOrder(String url, String email, String password, String customer, String ProdDesc, String ordName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		int Num = (int) (Math.random() * 9000) + 1000;
		// use this String wherever you want

		String RandomNum = Integer.toString(Num);
		saveordName = ordName + RandomNum;
		System.out.println(saveordName);

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
		waitForElementPresent(ContactsPage.saveForLaterBtn, "Verify the Save for Later button", 10);
		click(ContactsPage.saveForLaterBtn, "Click on Save For Later button");
		waitForElementPresent(ContactsPage.orderNameDialogeBox, "Verify Order Name Dialogue Box ", 10);

		type(ContactsPage.orderNameField, saveordName, "Enter Order Name");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(2000);
		waitForElementPresent(ContactsPage.myOrdersBtn, "Verify My orders button ", 10);
		//click(ContactsPage.myOrdersBtn, "Click on my orders button");
		mouseHoverByJavaScript(ContactsPage.myOrdersBtn, "Hover on My Orders button");
		click(ContactsPage.savedOrdersLink, "Click on Saved Orders link");
		waitForElementPresent(ContactsPage.orderNoVerify, "Verify Saved Order number", 10);
		/*JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		Thread.sleep(4000);*/
	}

	public void TestDeleteOrder(String url, String email, String password, String customer, String ProdDesc, String ordName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestSaveOrder(url, email, password, customer, ProdDesc, ordName, Quantity);
		click(ContactsPage.deleteLink, "Click on Delete link");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(4000);

	}

	public void TestCreateFavoriteOrder(String url, String email, String password, String customer, String ProdDesc, String favOdrName, String Quantity) throws Throwable {
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
		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.favoriteOrdersLink, "Click on favorite Orders link");
		waitForElementPresent(ContactsPage.newFavoriteOrdersBtn, "Verify new favorite Orders link", 10);
		click(ContactsPage.newFavoriteOrdersBtn, "Click on new favorite Orders link");
		waitForElementPresent(HomePage.favOrdernameField, "Verify Fav order name field ", 10);

		//  give your own name or read it from HTML doc


		int Num = (int) (Math.random() * 9000) + 1000;
		// use this String wherever you want

		String RandomNum = Integer.toString(Num);

		String favOdrNameValue = favOdrName + RandomNum;
		System.out.println(favOdrNameValue);

		type(HomePage.favOrdernameField, favOdrNameValue, "Enter Favorite order");

		waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify search Icon ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(HomePage.favSaveBtn, "Verify save favorite button ", 10);
		click(HomePage.favSaveBtn, "Click on save favorite button");
		waitForElementPresent(HomePage.favOrderConfirmationMsg, "Verify Favorite order confirmation ", 10);
		//String val=getText(By.xpath("//span[contains(text(),'"+favOdrName+"')]"),"Fav order name text");

		String val = getText(HomePage.favOrderNameText(favOdrNameValue), "Fav order name text");
		verify(val, favOdrNameValue, "verify favorite order text");
		Thread.sleep(3000);

	}

	public void TestCreateFavoriteOrderFromOrder(String url, String email, String password, String customer, String ProdDesc, String purchaseOdrNo, String ordName, String Quantity) throws Throwable {
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
		waitForElementPresent(HomePage.homeBtn, "Verify Home Button ", 10);
		click(HomePage.homeBtn, "Click on Home button");
		waitForElementPresent(HomePage.orderNowBtn, "Verify Order Now Button ", 10);
		click(HomePage.orderNowBtn, "Click on Order Now button");
		click(HomePage.viewOrderBtn, "Click on View Order button");
		waitForElementPresent(HomePage.favOrdernameField, "Verify Purchase Order Number field ", 10);
		type(HomePage.favOrdernameField, purchaseOdrNo, "Enter Purchase Order No order");
		click(HomePage.addToFavOrderBtn, "Click on Add to Favorite Order button");
		type(ContactsPage.orderNameField, ordName, "Enter Order Name");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
	}

	public void TestCreateOrderFromFavOrder(String url, String email, String password, String customer, String ProdDesc, String purchaseOdrNo, String ordName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestCreateFavoriteOrder(url, email, password, customer, ProdDesc, ordName, Quantity);
		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.favoriteOrdersLink, "Click on favorite Orders link");
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
	}

	public void TestCreateScheduleOrder(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
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
		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");

		//waitForElementPresent(ContactsPage.newScheduleOrdersBtn, "Verify new Schedule Order Button", 10);
		try {
			boolean isBtn = false;
			isBtn = Driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
			if (isBtn) {
				click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");


				try {
					boolean isPopup1 =false;

					isPopup1 = Driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
					if (isPopup1) {
						click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
						Thread.sleep(2000);
						click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
						Thread.sleep(2000);
						waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
						waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
						click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
						click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
						Thread.sleep(3000);
						mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
						click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
						Thread.sleep(3000);
						click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");
					}
				}catch (Exception e) {

					waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
					waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
					click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
					click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
					Thread.sleep(3000);
					mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
					click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
					Thread.sleep(3000);
					click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");
				}





				try {
					boolean isPopup =false;

					isPopup = Driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
					if (isPopup)
					{
						click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
						Thread.sleep(2000);
						click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
						Thread.sleep(2000);
						testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
					}


				}catch (Exception e) {

					testMethod(url, email,password, customer,ProdDesc,ScheduleOrdName,Quantity);
				}


			}
		} catch (Exception e) {

			click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

	try{

			if (!tesVerifyPopup(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity)) {
				testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
			}
	}catch(Exception e1){
	        testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);}
		}


}

	public  Boolean tesVerifyPopup(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity)throws Throwable{

		boolean isPopup=false;
		isPopup = Driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
		if (isPopup)
		{
			click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
			Thread.sleep(2000);
			click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
			Thread.sleep(2000);
			testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
		}
		return isPopup;
	}


	public void testMethod(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable{
		waitForElementPresent(ContactsPage.newScheduleOrderNameField, "Verify Fav order name field ", 10);




		int Num = (int) (Math.random() * 9000) + 1000;
		// use this String wherever you want

		String RandomNum = Integer.toString(Num);

		ordNameValue = ScheduleOrdName + RandomNum;
		System.out.println(ordNameValue);


		//waitForElementPresent(ContactsPage.scheduleOrderNameField, "Verify Schedule order name field ", 10);
		type(ContactsPage.newScheduleOrderNameField, ordNameValue, "Enter Schedule order name");
		type(HomePage.productSearchField, ProdDesc, "Enter Product Description");
		waitForElementPresent(HomePage.searchIcon, "Verify Product Search field ", 10);
		click(HomePage.searchIcon, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		waitForElementPresent(HomePage.scheduleOrderConfirmationText, "Verify Schedule order Confirmation ", 10);
		waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
		String val = getText(ContactsPage.scheduleOrderNameField(ordNameValue), "Schedule order name text");
		verify(val, ordNameValue, "verify Schedule order text");
		Thread.sleep(3000);



	}
	public void TestEditScheduleOrderQty(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");

		waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
		//String qty=getText(HomePage.qtyField,"Qty field value");


		String qty=Driver.findElement(HomePage.qtyField).getAttribute("value");



		int qtyValue=Integer.parseInt(qty);

		int value=qtyValue+1;
		String QuantityValue = Integer.toString(value);
		type(HomePage.qtyField, QuantityValue, "Enter qty value");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify second Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on second Submit order button");

	}

	public void TestDeleteScheduleOrderQty(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
		waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
		waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
		click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(3000);
	}
	public void TestCreateSecondScheduleOrder(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
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
		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");


		try {
			boolean isBtn = false;
			isBtn = Driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
			//if (isBtn)
			if(isBtn){
				click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");
				waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
				waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
				click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
				click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
				Thread.sleep(3000);
				mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
				click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
				Thread.sleep(3000);
				click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");
				waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
				waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
				click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
				click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
				Thread.sleep(3000);
				mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
				click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
				Thread.sleep(3000);

				Select se = new Select(Driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

				List<WebElement> l = se.getOptions();
				int value=l.size();
				System.out.println("value of dropdown is " +value);
				waitForElementPresent(ContactsPage.newScheduleOrdersBtn, "Verify new Schedule Order Button", 10);
				click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

				try {
					boolean isPopup =false;

					isPopup = Driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
					if (isPopup)
					{
						click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
						Thread.sleep(2000);
						click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
						Thread.sleep(2000);
						testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
						Select se1 = new Select(Driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

						List<WebElement> l1 = se1.getOptions();
						int value1=l1.size();
						System.out.println("value of dropdown is " +value1);
						assert value>value1;
					}


				}catch (Exception e) {

					testMethod(url, email,password, customer,ProdDesc,ScheduleOrdName,Quantity);
					Select se1 = new Select(Driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

					List<WebElement> l1 = se1.getOptions();
					int value1=l1.size();
					System.out.println("value of dropdown is " +value1);
					assert value>value1;
				}


			}
		} catch (Exception e) {





			Select se = new Select(Driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

			List<WebElement> l = se.getOptions();
			int value=l.size();
			System.out.println("value of dropdown is " +value);
			waitForElementPresent(ContactsPage.newScheduleOrdersBtn, "Verify new Schedule Order Button", 10);
			click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

			try{

				if (!tesVerifyPopup(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity)) {
					testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
				}
			}catch(Exception e1){
				testMethod(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);


				try {
					boolean isBtn = false;
					isBtn = Driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
					//if (isBtn)
					if (isBtn) {
						System.out.println("There is no frequency dropdown to be selected");

					}
				}catch(Exception e2) {

					Select se1 = new Select(Driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

					List<WebElement> l1 = se1.getOptions();
					int value1 = l1.size();
					System.out.println("value of dropdown is " + value1);
					assert value > value1;

				}





			}
		}



	}
	public void TestSkipShipment(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
		String DateValueBefore=Driver.findElement(ContactsPage.skipShipmentDateText(ordNameValue)).getText();


		int val=DateValueBefore.length();
		System.out.println("val is +++++++++++++ " + val);
		String DateBefore=DateValueBefore.substring(0,10);
		System.out.println("DateBefore is " + DateBefore);
		click(ContactsPage.skipShipmentLink(ordNameValue), "Click on Skip Shipment link");
		waitForElementPresent(ContactsPage.skipShipmentDialog, "Verify skip shipment dialog box", 10);
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(3000);
		String DateValueAfter=getText(ContactsPage.skipShipmentDateText(ordNameValue),"Get date after ");
		String DateAfter=DateValueAfter.substring(0,10);
		System.out.println("DateAfter is " + DateAfter);
		assert DateValueBefore!=DateValueAfter;
	}
	public void TestAddNewMaterial(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);

		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
		type(HomePage.productSearchField2,ProdDesc, "enter new product");
		waitForElementPresent(HomePage.searchIcon2, "Verify Product Search field ", 10);
		click(HomePage.searchIcon2, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);
		Thread.sleep(2000);




	}
	public void TestRemoveExistingMaterial(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);

		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
		waitForElementPresent(HomePage.productSearchField2, "Verify Product Search field2 ", 10);
		type(HomePage.productSearchField2,ProdDesc, "enter new product");
		waitForElementPresent(HomePage.searchIcon2, "Verify  Search icon ", 10);
		click(HomePage.searchIcon2, "Click on search Icon");
		waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
		click(HomePage.addToCartBtn, "Click on Add to cart button");
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		/*waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);*/
		Thread.sleep(2000);
		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
		waitForElementPresent(HomePage.deleteIcon, "Verify Delete Icon ", 10);
		click(HomePage.deleteIcon, "Click Delete Icon");

		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		/*waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
		waitForElementPresent(HomePage.thankyouText, "Verify Thank you text ", 10);
		waitForElementPresent(HomePage.thankyouConfirmation, "Verify Thank you confirmation ", 10);*/
		Thread.sleep(2000);




	}
	public void TestChangeArrivalDate(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);
		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
		waitForElementPresent(HomePage.arrivalDayDropdown, "Verify Arrival day dropdown",10);
		Select select = new Select(Driver.findElement(HomePage.arrivalDayDropdown));
		WebElement option = select.getFirstSelectedOption();
		String arrivalDay=option.getText().replaceAll("\\s","");
		System.out.println("arival day is +++++++" +arrivalDay);
		if (arrivalDay.equalsIgnoreCase("Tuesday")){
			select.selectByVisibleText("Wednesday");
		}else if (arrivalDay.equalsIgnoreCase("Wednesday")){
			select.selectByVisibleText("Thursday");
		}
		else if (arrivalDay.equalsIgnoreCase("Thursday")){
			select.selectByVisibleText("Friday");
		}
		else if (arrivalDay.equalsIgnoreCase("Friday")){
			select.selectByVisibleText("Monday");
		}
		else if (arrivalDay.equalsIgnoreCase("Monday")){
			select.selectByVisibleText("Tuesday");
		}
		waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
		click(HomePage.nextBtn, "Click on Next button");
		waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
		click(HomePage.submitOrderBtn2, "Click on Submit order button");
		Thread.sleep(3000);
	}

	public void TestDeleteScheduleOrder(String url, String email, String password, String customer, String ProdDesc, String ScheduleOrdName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();
		TestCreateScheduleOrder(url, email, password, customer, ProdDesc, ScheduleOrdName, Quantity);

		click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Schedule Orders edit link");
		waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete Schedule Order button",10);
		click(HomePage.deleteScheduleOrderBtn, "Delete Schedule Order button");
		waitForElementPresent(ContactsPage.skipShipmentDialog, "Verify Delete Schedule Order dialog box", 10);
		click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
		Thread.sleep(3000);

		waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);
		mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
		click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
		try {
			if (Driver.findElement(ContactsPage.scheduleOrderNameField(ordNameValue)).isDisplayed()){
				this.reporter.failureReport("Verify the presence of Deleted Schedule Order","Schedule Order " + ordNameValue + " is not deleted");
			}
		}
		catch (Exception e){
			this.reporter.SuccessReport("Verify the presence of Deleted Schedule Order","Schedule Order " + ordNameValue + " has been deleted");
		}
		Thread.sleep(3000);
	}

	public void TestEditSaveOrder(String url, String email, String password, String customer, String ProdDesc, String ordName, String Quantity) throws Throwable {
		new HomePage().Home_Page();
		new ContactsPage().OrderPage();
		new ContactsPage().CreateContactPage();

		TestSaveOrder(url, email, password, customer, ProdDesc, ordName, Quantity);

		click(ContactsPage.saveOrderEditLink(saveordName), "Click on Schedule Orders edit link");
		waitForElementPresent(HomePage.viewSavedOrderTxt, "Verify View Saved Order text", 10);
		click(HomePage.editBtn, "Click on Edit button");
		waitForElementPresent(HomePage.editSavedOrderTxt, "Verify Edit Saved Order text", 10);

		waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
		//String qty=getText(HomePage.qtyField,"Qty field value");

		String qty=Driver.findElement(HomePage.qtyField).getAttribute("value");
		int qtyValue=Integer.parseInt(qty);
		int value=qtyValue+1;
		String QuantityValue = Integer.toString(value);
		type(HomePage.qtyField, QuantityValue, "Save Order Quantity");

		waitForElementPresent(HomePage.saveBtn, "Verify Save Button ", 10);
		click(HomePage.saveBtn, "Click on Save button");
		waitForElementPresent(HomePage.savedOrderConfirmationTxt, "Verify Saved Order - Confirmation text", 10);

		String qty1=Driver.findElement(HomePage.qtyField).getAttribute("value");
		//int qtyValue1=Integer.parseInt(qty1);
		//String QuantityValue1 = Integer.toString(qtyValue1);

		verify(QuantityValue,qty1,"Verify Qunatity field edited");

		click(HomePage.closeBtn, "Click on Close button");

	}


}
