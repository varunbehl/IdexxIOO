package com.Idexx.libs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Idexx.page.AccountsPage;
import com.Idexx.page.HomePage;

public class OpportunityLib extends IdexxLib{

	
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

}
