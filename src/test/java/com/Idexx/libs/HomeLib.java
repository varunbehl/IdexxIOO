package com.Idexx.libs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Idexx.page.AccountsPage;
import com.Idexx.page.HomePage;
import com.Idexx.page.LoginPage;

public class HomeLib extends IdexxLib {
	
	public void VerifyUserLogin(String UserName) throws Throwable{
	By UserNav = By.xpath("//*[@id='userNav']");
	By logout = By.xpath("//*[@title='Logout']");
	By HomeTab = By.xpath("//*[@id='home_Tab']");
	By ContactTab = By.xpath("//*[@id='Contact_Tab']");
	new LoginPage().Login_Page();
	Thread.sleep(3000);
	type(LoginPage.userName, UserName, "entering login username");
	type(LoginPage.password, "Idexx123$", "entering login password");
	click(LoginPage.loginBtn, "Click on Login button");
	System.out.println("login completed ");
	Thread.sleep(5000);
	System.out.println("login completed ");
	click(ContactTab,"click on Contact tab");
	// Logout
	click(UserNav,"Click on user Navigation");
	Thread.sleep(2000);
	click(logout,"click on logout");
	/*WebElement d = Driver.findElement();
				d.click();			
				WebElement e = Driver.findElement(By.xpath(""));
				e.click();
				Thread.sleep(2000);*/
				System.out.println("Clicked on User Navigation and Log out");
	}
	//validating users
	public void ValidateUsers(String UserName) throws Throwable{
		
		By Usernameid = By.xpath("//*[@id='i_lg_gv_userid']");
		By Passwordid = By.xpath("//*[@id='i_lg_gv_pwd']");
		By SigninButton = By.xpath("//*[@id='loginForm']/div/input[3]");
		//By logoffButton = By.xpath("//*[@id='zza_logoff']");
		//click(logoffButton, "Clicked on log off Button");
		Thread.sleep(3000);
		click(Usernameid, "Clicked on User Name");
		type(Usernameid, UserName, "User Name : "  + UserName);
		Thread.sleep(2000);
		click(Passwordid, "Clicked on Password");
		type(Passwordid, "test1234", "password"+ UserName);
		Thread.sleep(2000);
		click(SigninButton, "Clicked on Sign in Button");
		Thread.sleep(5000);
		//click(logoffButton, "Clicked on log off Button");
		//WebElement image = Driver.findElement(By.id("zza_logoff"));
		Driver.findElement(By.linkText("Log Off")).click();
		//Driver.findElement(By.cssSelector("a[href*='qaorder.idexx.com']")).click();
		//Driver.findElement(By.xpath("//*[@id='zza_logoff']")).click();
		//Driver.quit();
		Thread.sleep(2000);
		Driver.get("https://qaorder.idexx.com/new");
		//Driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	public void ValidateLink(String URL) throws Throwable{
		Driver.get(URL);
		Thread.sleep(2000);
		//isElementPresent(AccountsPage.accountDetail,"Account detail page is displayed successfully", true);
		isElementPresent(By.xpath("//*[@id='main']/div[4]/table/tbody/tr/td[1]/img"),"Error Link Displayed", true);
	}
	
	//Activate Users
	public void ActivateUsers(String URL) throws Throwable{
		
	
		// Invoking WebDriver
					WebDriver driver;
					System.out.println("iam in  Chrome");
					System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
					driver = new ChromeDriver();

					//Launch URL
					driver.get(URL);
					driver.manage().window().maximize();
					Thread.sleep(5000);
					//click on check box
					driver.findElement(By.xpath(".//*[@id='zzacctrm_checkbox']")).click();
					//LOG.info("Launched URL");
					System.out.println("URL :" + URL);
					Thread.sleep(5000);
					reporter.SuccessReport("Account Activation", "Account Activation has started for this URL" + URL);
					//click on submit
					driver.findElement(By.xpath(".//*[@id='zzacctrm_submit']")).click();
					Thread.sleep(10000);
					//switch to form
					//String formidp = driver.findElement(By.xpath("//div[@name='uap']//iform")).getAttribute("id");
					//driver.switchTo().frame(formidp);
					
					//Enter Password  By.xpath(".//*[@name='new']"); 
					//By Password = By.xpath(".//*[contains(@id,'zzpwdfgt_box')]/form/div[1]/table/tbody/tr[1]/td[2]/a");
					
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[1]/td[2]/input")).clear();
					//driver.findElement(By.xpath("//form/*[@name='i_pc_zzuapsecq_LS_H-PWD']]")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[1]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[1]/td[2]/input")).sendKeys("test1234");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_H-PWD']"),"test1234","password");
					Thread.sleep(2000);
					//Re enter password //*[@id="zzpwdfgt_box"]/form/div[1]/table/tbody/tr[1]/td[2]/input
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[2]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[2]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[1]/table/tbody/tr[2]/td[2]/input")).sendKeys("test1234");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_H-PWDV']"),"test1234","re enter password");
					Thread.sleep(2000);
					//Security question1
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[1]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[1]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[1]/td[2]/input")).sendKeys("q1");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[1 ].qest']"),"q1","question 1");
					Thread.sleep(2000);
					//Security answer1
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[2]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[2]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("a1");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[1 ].answ']"),"a1","answer 1");
					Thread.sleep(2000);
					//Security question2
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[3]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[3]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[3]/td[2]/input")).sendKeys("q2");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[2 ].qest']"),"q2","question 2");
					Thread.sleep(2000);
					//Security Answer 2
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[4]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[4]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[4]/td[2]/input")).sendKeys("a2");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[2 ].answ']"),"a2","answer 2");
					Thread.sleep(2000);
					//Security Question 3
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[5]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[5]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[5]/td[2]/input")).sendKeys("q3");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[3 ].qest']"),"q3","question 3");
					Thread.sleep(2000);
					//Security Answer 3
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[6]/td[2]/input")).clear();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[6]/td[2]/input")).click();
					driver.findElement(By.xpath("//*[@id='zzpwdfgt_box']/form/div[2]/table/tbody/tr[6]/td[2]/input")).sendKeys("a3");
					//type(By.xpath(".//*[@name='i_pc_zzuapsecq_LS_Q[2 ].answ']"),"a3","answer 3");
					Thread.sleep(2000);
					//Click on submit
					driver.findElement(By.xpath("//*[@id='zzv1aup_pwdchg']")).click();
					Thread.sleep(10000);
					driver.switchTo().defaultContent();
					//click on log off
					driver.findElement(By.xpath(".//*[@id='zza_logoff']")).click();
					Thread.sleep(2000);
					reporter.SuccessReport("Account Activated", "Account has been activated with URL" + URL);
					driver.quit();
					
	}

	// Home page
	public void doSearch(String searchKeyWord) throws Throwable {
		new HomePage().Home_Page();
		type(HomePage.search, searchKeyWord, "search");
		Thread.sleep(3000);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.TAB);
		Driver.findElement(By.xpath(".//*[@id='phSearchInput']")).sendKeys(Keys.ENTER);
		assertText(HomePage.SearchResultPage, "Search Results");
		Thread.sleep(3000);
	//	driver.switchTo().frame("history-iframe");
		
		if(isElementPresent(HomePage.searchCountReturned, "returned results count", true)){
	//	String actvalue = getText((HomePage.searchCountReturned), "SearchCount returned");
	//	System.out.println("actual value = " + actvalue);
		}
	
		WebElement table = Driver.findElement(HomePage.tableData);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();

		if (rowCount > 0)
			reporter.SuccessReport("Results",
					"A list of existing accounts is appearing on the page");
		else
			reporter.failureReport("Results",
					"A list of existing accounts are not appearing on the page");

	//	click(HomePage.SearchAll, "clicked on search all btn");

		String searchValue = getText(HomePage.Accounts_Results_Account,
				"link text for account after search.");
		System.out.println("searchg - " + searchValue);

		click(HomePage.Accounts_Results_Account,
				"clicked on one record details page");

		// ContactsPage.Contacts_Page();
		new AccountsPage().AccountsPage();
		System.out.println("contact header row - "
				+ getText(AccountsPage.topNameDisplayedOnContactHeader, ""));
		assertText(AccountsPage.topNameDisplayedOnContactHeader, searchValue);
		System.out.println("search completed ");

	}

	// Accounts
	public void Click_AccountTab_List() throws Throwable {
		new AccountsPage().AccountsPage();
		click(AccountsPage.AccountTab, "Clicked on account tab");
		assertText(AccountsPage.AccountTitle, "Accounts");
		selectByVisibleText(AccountsPage.Acconts_DropDown, "All Accounts",
				"Selectd All Accounts from drop down");
		click(AccountsPage.GoBtn, "Clicked on Go Btn");
		assertText(AccountsPage.Account_Go_cigniti1, "cigniti1");
		click(AccountsPage.Account_Go_cigniti1, "cigniti1");
		assertText(AccountsPage.Account_Go_cigniti1_title, "cigniti1");
		JavascriptExecutor jse = (JavascriptExecutor) Driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		click(AccountsPage.newAccount, "Clicked on new account btn");
		assertText(AccountsPage.newAccount_title, "New Contact");

	}

	public void customize_addTab(String tabName) throws Throwable {

		new HomePage().Home_Page();
		System.out.println("tab name to add -> " + tabName);
		clickUsingJavascriptExecutor(HomePage.allTabs, "Click on Alltabs button");
		Thread.sleep(2000);
		clickUsingJavascriptExecutor(HomePage.customizetabbtn, "Click on CustomozeMytabs button");
		Thread.sleep(2000);
		
		int count = Driver.findElements(By.xpath("//*[@id='duel_select_0']/option")).size();
		boolean tabFound = false;
		boolean tabDisplayed = false;
		for(int i=1; i<=count; i++){
		
			String newTab = (Driver.findElement(By
					.xpath("//*[@id='duel_select_0']/option["+i+"]")).getText());
			System.out.println(newTab + " == " + tabName);
            if(newTab.equalsIgnoreCase(tabName)){
			   Driver.findElement(By.xpath("//*[@id='duel_select_0']/option["+i+"]")).click();
			   tabFound = true;
            }
		}
		
		if(!tabFound)
			Assert.fail("The tab - " + tabName + " is not found in the list.");
	
		clickUsingJavascriptExecutor(HomePage.rightArrow, "click on the right arrow");
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(HomePage.saveBtn, "click on the save btn");
		goToHomePage();

		int tabCount = Driver.findElements(By.xpath(".//*[@id='tabBar']/li")).size();
	
		for (int i = 1; i <= tabCount; i++) {
			String displayedTab = Driver.findElement(
					By.xpath(".//*[@id='tabBar']/li[" + i + "]/a")).getText();
			if (displayedTab.equalsIgnoreCase(tabName))
				tabDisplayed = true;
		}
		
		if(!tabDisplayed)
			Assert.fail("The tab - " + tabName + " is not displayed in the home page.");
	}
	
	public void remove_Tab(String tabName) throws Throwable {

		new HomePage().Home_Page();
		System.out.println("tab name to be removed  -> " + tabName);
		click(HomePage.allTabs, "Click on Alltabs button");
		click(HomePage.customizetabbtn, "Click on CustomozeMytabs button");
		Thread.sleep(2000);
		int count = Driver.findElements(By.xpath("//*[@id='duel_select_1']/option")).size();
		boolean tabFound = false;
		boolean tabDisplayed = false;
		for(int i=1; i<=count; i++){
		
			String newTab = (Driver.findElement(By
					.xpath("//*[@id='duel_select_1']/option["+i+"]")).getText());
			System.out.println(newTab + " == " + tabName);
            if(newTab.equalsIgnoreCase(tabName)){
			   Driver.findElement(By.xpath("//*[@id='duel_select_1']/option["+i+"]")).click();
			   tabFound = true;
            }
		}
		
		if(!tabFound)
			Assert.fail("The tab - " + tabName + " is not found in the list.");
	
		click(HomePage.leftArrow, "click on the right arrow");
		Thread.sleep(3000);
		click(HomePage.saveBtn, "click on the save btn");
		goToHomePage();

		int tabCount = Driver.findElements(By.xpath(".//*[@id='tabBar']/li")).size();
	
		for (int i = 1; i <= tabCount; i++) {
			String displayedTab = Driver.findElement(
					By.xpath(".//*[@id='tabBar']/li[" + i + "]/a")).getText();
			if (displayedTab.equalsIgnoreCase(tabName))
				tabDisplayed = true;
		}
		
		if(tabDisplayed)
			Assert.fail("The tab - " + tabName + " is displayed in the home page after removal.");
	}
}
