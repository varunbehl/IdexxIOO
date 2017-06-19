
package com.automation.accelerators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.report.ReporterConstants;
//import com.shoebuy.page.Sbaddtocartpage;









public class ActionEngine extends TestEngineWeb {
	private final Logger LOG = Logger.getLogger(ActionEngine.class);

	private final String msgClickSuccess = "Successfully Clicked On ";
	private final String msgClickFailure = "Unable To Click On ";
	private final String msgTypeSuccess = "Successfully Typed On ";
	private final String msgTypeFailure = "Unable To Type On ";
	private final String msgIsElementFoundSuccess = "Successfully Found Element ";
	private final String msgIsElementFoundFailure = "Unable To Found Element ";
	public int sleep = 2000;

	/**
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByIndex(By locator, int index,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Select Value from the Dropdown"+locatorName, "Option at index " + index
						+ " is Not Select from the DropDown" + locatorName);


			} else if (flag) {
				reporter.SuccessReport("Select Value from the Dropdown"+locatorName, "Option at index " + index
						+ "is Selected from the DropDown" + locatorName);

			}
		}
	}
	public boolean assertTrue(boolean conditon, String message)
			throws Throwable {
		boolean flag = false;
		try {
		//	driver.findElement(by);

			if(conditon)
			return true;
			else
				return false;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		} finally {
			if (!conditon) {
				reporter.failureReport("Expected true "," but found false.");
			} else if (flag) {
				reporter.SuccessReport("Expected " + conditon, message);
			}

		}
	}
	public boolean assertElementPresent(By by, String locatorName)
			throws Throwable {

		boolean flag = false;
		try {
			Assert.assertTrue(isElementPresent(by, locatorName, true));
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				reporter.failureReport("AssertElementPresent", locatorName
						+ " present in the page");
				return false;
			} else if (flag) {
				reporter.SuccessReport("AssertElementPresent", locatorName
						+ " is not present in the page");
			}
		}
		return flag;

	}

	public boolean mouseHoverByJavaScript(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = Driver.findElement(locator);
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) Driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("MouseOver",
						"MouseOver action is not perform on" + locatorName);
			} else if (flag) {
				reporter.SuccessReport("MouseOver",
						"MouserOver Action is Done on" + locatorName);
			}
		}
	}
	public boolean waitForVisibilityOfElement(By by, String locator)
			throws Throwable {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(Driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("WaitForVisibilityOfElement", "Element "
						+ locator + " is not visible");
			} else if (flag) {
				reporter.SuccessReport("WaitForVisibilityOfElement", "Element "
						+ locator + "  is visible");
			}
		}
	}

	public boolean clickUsingJavascriptExecutor(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement element = Driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor)Driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);
			flag = true;
			System.out.println("clicked " + locatorName);
		} catch (Exception e) {
				
		} finally {
			if (!flag) {
				reporter.failureReport("Click", "Unable to clicked on"
						+ locatorName);
				return true;
			} else {
				reporter.SuccessReport("Click", "Successfully clicked on"
						+ locatorName);

			}
		}
		return flag;
	}

	public boolean selectByValue(By locator, String value,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Select",
						"Option with value attribute" + value
						+ " is Not Select from the DropDown"
						+ locatorName);

			} else if ( flag) {
				reporter.SuccessReport("Select",
						"Option with value attribute" + value
						+ " is  Selected from the DropDown"
						+ locatorName);
			}
		}
	}
	public boolean isVisible(By locator, String locatorName)
			throws Throwable {
		Boolean value = false;
		boolean flag = false;
		try {

			value = Driver.findElement(locator).isDisplayed();
			value = true;
			flag = true;
		} catch (Exception e) {
			flag = false;
			value = false;

		} finally {
			if (!flag) {
				reporter.failureReport("IsVisible", locatorName
						+ " Element is Not Visible");
			} else if (flag) {
				reporter.SuccessReport("IsVisible", locatorName
						+ " Element is Visible");

			}
		}
		return value;
	}

	public int getRowCount(By locator) throws Exception {

		WebElement table = Driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	public boolean assertTextMatching(By by, String text,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			String ActualText = getText(by, text).trim();
			if (ActualText.contains(text.trim())) {
				flag = true;
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Verify " + locatorName, text
						+ " is not present in the element");
				return false;

			} else if ( flag) {
				reporter.SuccessReport("Verify " + locatorName, text
						+ " is  present in the element ");
			}
		}

	}
	

	public boolean assertTextStringMatching(String acttext, String expText) throws Throwable {
		boolean flag = false;
		try {
			String ActualText = acttext.trim();
			if (ActualText.equalsIgnoreCase(expText)) {
				flag = true;
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Verify " + expText, acttext
						+ " is not present in the element");
				return false;

			} else if ( flag) {
				reporter.SuccessReport("Verify " + expText, acttext
						+ " is  present in the element ");
			}
		}

	}

	public boolean click(By locator, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
			/*((JavascriptExecutor) this.Driver).executeScript(
					"arguments[0].scrollIntoView();", locator);*/
			System.out.println(msgClickSuccess+locatorName);
			Waittime();
			Driver.findElement(locator).click();
			
			reporter.SuccessReport("Click : "+locatorName , msgClickSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			reporter.failureReport("Click : "+locatorName, msgClickFailure + locatorName, Driver);

		}
		return status;

	}

	public boolean isElementPresent(By by, String locatorName,boolean expected) throws Throwable
	{
		boolean status = false;
		try
		{
			Waittime();
			Driver.findElement(by);
			//this.reporter.SuccessReport("isElementPresent" , this.msgIsElementFoundSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			if(expected == status)
			{
				reporter.SuccessReport("isElementPresent", "isElementPresent");
			}
			else
			{
				reporter.failureReport("isElementPresent", msgIsElementFoundFailure + locatorName, Driver);
			}
		}
		return status;
	}
	
	public boolean scroll(By by, String locatorName) throws Throwable
	{
		boolean status = false;
		try
		{
			WebElement element = this.Driver.findElement(by);
			Actions actions = new Actions(this.Driver);
			actions.moveToElement(element);
			actions.build().perform();
			status = true;
		}
		catch(Exception e)
		{
			
		}
		return status;
	}
	
	
	public boolean VerifyElementPresent(By by, String locatorName,boolean expected) throws Throwable
	{
		boolean status = false;
		try
		{
			if(this.Driver.findElement(by).isDisplayed()){
				this.reporter.SuccessReport("VerifyElementPresent "+locatorName , this.msgIsElementFoundSuccess + locatorName);
				status = true;
			}
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			/*if(expected == status)
			{
				this.reporter.SuccessReport("isElementPresent", "isElementPresent");
			}
			else
			{
				this.reporter.failureReport("isElementPresent", this.msgIsElementFoundFailure + locatorName, this.Driver);
			}*/
		}
		return status;
	}


	public boolean Waittime() throws Throwable
	{
		boolean status = true;
		String time= ReporterConstants.Timeout;
		long timevalue=Long.parseLong(time);
		System.out.println("Time out value is"+timevalue);
		//Driver.manage().timeouts().implicitlyWait(timevalue, TimeUnit.SECONDS);
		Thread.sleep(timevalue*1000);
		return status;
		
	}
	


	public boolean type(By locator, String testdata, String locatorName) throws Throwable
	{
		
		boolean status = false;
		try
		{
			Waittime();
			Driver.findElement(locator).clear();
			Thread.sleep(sleep);
			Driver.findElement(locator).sendKeys(testdata);
			reporter.SuccessReport("Enter text in "+locatorName , msgTypeSuccess + locatorName);
			status = true;
		}
		catch(Exception e)
		{
			status = false;
			LOG.info(e.getMessage());
			reporter.failureReport("Enter text in "+locatorName, msgTypeFailure + locatorName, Driver);
		}

		return status;
	}
	
	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link,menus etc..)
	 * 
	 */
	public boolean waitForTitlePresent(By locator) throws Throwable {

		boolean flag = false;
		boolean bValue = false;

		try {
			for (int i = 0; i < 200; i++) {
				if (Driver.findElements(locator).size() > 0) {
					flag = true;
					bValue = true;
					break;
				} else {
					Driver.wait(50);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				reporter.failureReport("WaitForTitlePresent", "Title is wrong");

			} else if ( flag) {
				reporter.SuccessReport("WaitForTitlePresent",
						"Launched successfully expected Title");
			}
		}
		return bValue;
	}
	
	public String getTitle() throws Throwable {

		String text = Driver.getTitle();
		 {
			reporter.SuccessReport("Title", "Title of the page is" + text);
		}
		return text;
	}
	public boolean assertText(By by, String text) throws Throwable {
		boolean flag = false;
		try {
			Assert.assertEquals(getText(by, text).trim(), text.trim());
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("AssertText", text
						+ " is not present in the element ");
				return false;

			} else if ( flag) {
				reporter.SuccessReport("AssertText", text
						+ " is  present in the element ");
			}
		}

	}


	public boolean asserTitle(String title) throws Throwable {
		boolean flag = false;

		try {
			By windowTitle = By.xpath("//title[contains(text(),'" + title
					+ "')]");
			if (waitForTitlePresent(windowTitle)) {
				Assert.assertEquals(getTitle(), title);
				flag = true;
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {

			if (!flag) {
				reporter.failureReport("AsserTitle",
						"Page title is not matched with" + title);
				return false;
			} else if ( flag) {
				reporter.SuccessReport("AsserTitle",
						" Page title is verified with" + title);
			}
		}

	}

	
	public String getText(By locator, String locatorName)
			throws Throwable {
		String text = "";
		boolean flag = false;
		try {
			Waittime();
			if (isElementPresent(locator, locatorName,true)) {
				text = Driver.findElement(locator).getText();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag ==false) {
				reporter.warningReport("GetText", "Unable to get Text from"
						+ locatorName);
			} else if (flag == true) {
				reporter.SuccessReport("GetText", ""
						+ locatorName+ " is" +text);
			}
		}
		return text;
	}
	
	

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link,menus etc..)
	 * 
	 */
	public boolean mouseover(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = this.Driver.findElement(locator);
			new Actions(this.Driver).moveToElement(mo).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag == false) {
				this.reporter.failureReport("MouseOver",
						"MouseOver action is not perform on" + locatorName,this.Driver);

			} else if (flag == true) {

				this.reporter.SuccessReport("MouseOver",
						"MouserOver Action is Done on  " + locatorName);
			}
		}
	}
	public boolean JSClick(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement element = this.Driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) this.Driver;
			executor.executeScript("arguments[0].click();", element);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {


		} finally {
			if (flag == false) {
				this.reporter.failureReport("Click",
						"MouseOver action is not perform on" + locatorName);
				return flag;
			} else if (flag == true) {
				this.reporter.SuccessReport("Click",
						"Clicked " + locatorName);
				return flag;
			}
		}
		return flag;
	}
	
	public boolean selectByVisibleText(By locator, String visibletext,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				reporter.failureReport("Select", visibletext
						+ " is Not Select from the DropDown" + locatorName);

			} else if (flag) {
				reporter.SuccessReport("Select", visibletext
						+ "  is Selected from the DropDown" + locatorName);
			}
		}
	}


	
	
	
	public boolean JSmousehover(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement HoverElement=this.Driver.findElement(locator);
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
									((JavascriptExecutor) this.Driver).executeScript(mouseOverScript,HoverElement);
			flag = true;

		}
		
		catch (Exception e) {


		}finally {
			if (flag == false) {
				this.reporter.failureReport("MouseOver",
						"MouseOver action is not perform on" + locatorName);
				return flag;
			} else if (flag == true) {
				this.reporter.SuccessReport("MouseOver",
						"MouserOver Action is Done on" + locatorName);
				return flag;
			}
		}
		return flag;
	}
	
	public void sleep(int time) throws InterruptedException{
		Thread.sleep(time);
	}
	
	
	
	
	public boolean verify(String act, String exp, String value)
			throws Throwable {
		boolean flag = false;
		 if(act.contains(exp)){
			 flag = true;
		 }else{
			 flag = true;
			 
		 }
	
			if (flag == false) {
				this.reporter.failureReport("Varification",
						value+"are not verified");
				return flag;
			} else if (flag == true) {
				this.reporter.SuccessReport("Varification",
						value+" Verified Sucessfully");
				return flag;
			}
		
		return flag;
	}
	
	
	public boolean waitForElementPresent(By by, String locator, int secs)
			throws Throwable {
		boolean status = false;

		try {

			WebDriverWait wait = new WebDriverWait(this.Driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			/*((JavascriptExecutor) Driver).executeScript(
					"arguments[0].scrollIntoView();", by);*/
			
			for (int i = 0; i < secs/2; i++)
			{
				List<WebElement> elements = this.Driver.findElements(by);
				if (elements.size()>0)
				{
					status = true;
					return status;

				} 
				else
				{
					this.Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				}
			}


		} 
		catch (Exception e) {

			return status;
		} 

		return status;

	}
}
