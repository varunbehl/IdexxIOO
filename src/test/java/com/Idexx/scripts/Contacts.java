/**
 * Contacts Script
 */

package com.Idexx.scripts;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Idexx.libs.ContactsLib;
import com.automation.utilities.TestUtil;

/**
 * This class holds all the test scenarios related to contacts page.
 * @author in01999
 *
 */
public class Contacts extends ContactsLib {

	//@Parameters({"userrole"})
	/*@BeforeMethod
	public void login() throws Throwable{
		//loginAsUserRole(userrole);System.out.println("iam in case Chrome");
		System.setProperty("webdriver.chrome.driver",
				"Drivers\\chromedriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		this.WebDriver = new ChromeDriver(capabilities);
		Thread.sleep(10000);
	}
*/
	@DataProvider
	public Object[][] getTestDataFor_TestViewAllContacts() {
		return TestUtil.getData("TestViewAllContacts", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.1 This Test verify whether user can view all contacts. Click
	 * on any existing account to find its details.
	 *
	 * @throws Throwable
	 */
	@Test(dataProvider = "getTestDataFor_TestViewAllContacts")
	public void TestViewAllContacts(Hashtable<String, String> data) throws Throwable {

		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.1");
				assertTrue(searchAndClickContactUsingGlobalSearch(data.get("contactName")), " view a contact.");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * TC-ID : TC2.3 This Test verify whether user can create a new contact.
	 * Verify whether the contact details are saved and displayed properly.
	 */
	@DataProvider
	public Object[][] getTestDataFor_TestCreateContact() {
		return TestUtil.getData("TestCreateContact", TestData, "Contacts");
	}

	@Test(dataProvider = "getTestDataFor_TestCreateContact")
	public void TestCreateContact(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.3");
				//goToHomePage();
				int randNum = generateRandonNumber();
				/*  System.out.println("random generated - " + randNum);
					     System.out.println(" browser - " + getBrowser());*/
				String accName = Integer.toString(randNum) + "_" + getBrowser() + "_" + data.get("accountName");
				System.out.println("=================");
				System.out.println("AccountName -> " + accName);
				System.out.println("=================");
				String newContact = Integer.toString(randNum) + "_" + getBrowser() + "_" + data.get("newContactLastName");
				System.out.println("=================");
				System.out.println("contact name -> " + newContact);
				System.out.println("=================");
				createNewAccount(data, accName);
				assertTrue(createContact(data, accName, newContact), " Create a new contact");

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	/**
	 * Duplicate contacts is not allowed ...script is finished but functionality is broken.
	 *
	 * @return
	 */
	@DataProvider
	public Object[][] getTestDataFor_TestCreateDuplicateContact() {
		return TestUtil.getData("TestCreateDuplicateContact", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateDuplicateContact")
	public void TestCreateDuplicateContact(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.4");

				goToContactsPage();
				/**
				 * Duplicate contacts is not allowed ...script is finished but functionality is broken.
				 */
				assertTrue(createDuplicateContact(data, data.get("accountName"), data.get("newContactLastName")), " create duplicate contacts");

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestLinkContactWithMultipleAccounts() {
		return TestUtil.getData("TestLinkContactWithMultipleAccounts", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.2 This Test verify whether user can link a contact to
	 * multiple accounts. Verify the accounts linked are displayed in the
	 * accounts section of contact page for particular contact.
	 */
	@Test(dataProvider = "getTestDataFor_TestLinkContactWithMultipleAccounts")
	public void TestLinkContactWithMultipleAccounts(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {
				this.reporter.initTestCaseDescription("TC2.3");
				goToContactsPage();
				searchAndClickContactUsingGlobalSearch(data.get("contactName"));
				linkContactWithMultipleAccounts(data);
				searchAndClickContactUsingGlobalSearch(data.get("contactName"));
				//New account is added for contact as per mentioned in the test steps
				// Verifying multiple accounts is not scripted - because this feature is not present in the application
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tear down method for a method logout after every method.
	 */


	//@AfterMethod
	public void logout() {
		try {
			//Driver.quit();
			//doLogout();
			JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
			Thread.sleep(4000);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}


	@DataProvider
	public Object[][] getTestDataFor_TestCreateUser() {
		return TestUtil.getData("TestCreateUser", TestData, "CreateContact");
	}

	/**
	 * TC-ID : TC2.2 This Test verify whether user can link a contact to
	 * multiple accounts. Verify the accounts linked are displayed in the
	 * accounts section of contact page for particular contact.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateUser")
	public void TestCreateUser(Hashtable<String, String> data) {
		try {
			//if (data.get("RunMode").equals("Y")){
			this.reporter.initTestCaseDescription("TC2.4");
			System.out.println("DATA" + data.get("URL"));
			TestCreateAccount(data.get("URL"), data.get("LOB"), data.get("First name"), data.get("last name"), data.get("Email"), data.get("Country"), data.get("PWD"), data.get("Customer"), data.get("ZIP"), data.get("Job"));

		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateOrder() {
		return TestUtil.getData("TestCreateOrder", TestData, "CreateOrder");
	}

	/**
	 * TC-ID : TC2.2 This Test verify whether user can link a contact to
	 * multiple accounts. Verify the accounts linked are displayed in the
	 * accounts section of contact page for particular contact.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateOrder")
	public void TestCreateOrder(Hashtable<String, String> data) throws Throwable {
		try {
			if (data.get("RunMode").equals("Y")){
			this.reporter.initTestCaseDescription("TC2.5");
			System.out.println("DATA" + data.get("URL"));
			TestCreateOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("Product"), data.get("Qty"));
				//JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		} }catch (Throwable e) {

			e.printStackTrace();
		}/*finally {
			JSClick(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
		}*/

	}


	@DataProvider
	public Object[][] getTestDataFor_TestPurchaseSavedOrder() {
		return TestUtil.getData("TestPurchaseSavedOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestPurchaseSavedOrder")
	public void TestPurchaseSavedOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.6");

				System.out.println("DATA" + data.get("URL"));
				TestPurchaseSavedOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("OrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestSaveOrder() {
		return TestUtil.getData("TestSaveOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestSaveOrder")
	public void TestSaveOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.7");

				System.out.println("DATA" + data.get("URL"));
				TestSaveOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("OrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestDeleteOrder() {
		return TestUtil.getData("TestDeleteOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestDeleteOrder")
	public void TestDeleteOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.8");

				System.out.println("DATA" + data.get("URL"));
				TestDeleteOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("OrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestCreateFavoriteOrder() {
		return TestUtil.getData("TestCreateFavoriteOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateFavoriteOrder")
	public void TestCreateFavoriteOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.9");

				System.out.println("DATA" + data.get("URL"));
				TestCreateFavoriteOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"),data.get("FavoriteOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestCreateFavoriteOrderFromOrder() {
		return TestUtil.getData("TestCreateFavoriteOrderFromOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateFavoriteOrderFromOrder")
	public void TestCreateFavoriteOrderFromOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.10");

				System.out.println("DATA" + data.get("URL"));
				TestCreateFavoriteOrderFromOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("PurchaseOrderNumber"), data.get("OrderName"),data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestCreateOrderFromFavOrder() {
		return TestUtil.getData("TestCreateOrderFromFavOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateOrderFromFavOrder")
	public void TestCreateOrderFromFavOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.11");

				System.out.println("DATA" + data.get("URL"));
				TestCreateOrderFromFavOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("PurchaseOrderNumber"), data.get("OrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateScheduleOrder() {
		return TestUtil.getData("TestCreateScheduleOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateScheduleOrder")
	public void TestCreateScheduleOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.12");

				System.out.println("DATA" + data.get("URL"));
				TestCreateScheduleOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestEditScheduleOrderQty() {
		return TestUtil.getData("TestEditScheduleOrderQty", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestEditScheduleOrderQty")
	public void TestEditScheduleOrderQty(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.13");

				System.out.println("DATA" + data.get("URL"));
				TestEditScheduleOrderQty(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestDeleteScheduleOrderQty() {
		return TestUtil.getData("TestDeleteScheduleOrderQty", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestDeleteScheduleOrderQty")
	public void TestDeleteScheduleOrderQty(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.14");

				System.out.println("DATA" + data.get("URL"));
				TestDeleteScheduleOrderQty(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestCreateSecondScheduleOrder() {
		return TestUtil.getData("TestCreateSecondScheduleOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestCreateSecondScheduleOrder")
	public void TestCreateSecondScheduleOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.15");

				System.out.println("DATA" + data.get("URL"));
				TestCreateSecondScheduleOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestSkipShipment() {
		return TestUtil.getData("TestSkipShipment", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestSkipShipment")
	public void TestSkipShipment(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.16");

				System.out.println("DATA" + data.get("URL"));
				TestSkipShipment(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestAddNewMaterial() {
		return TestUtil.getData("TestAddNewMaterial", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestAddNewMaterial")
	public void TestAddNewMaterial(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.17");

				System.out.println("DATA" + data.get("URL"));
				TestAddNewMaterial(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestRemoveExistingMaterial() {
		return TestUtil.getData("TestRemoveExistingMaterial", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestRemoveExistingMaterial")
	public void TestRemoveExistingMaterial(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.18");

				System.out.println("DATA" + data.get("URL"));
				TestRemoveExistingMaterial(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestChangeArrivalDate() {
		return TestUtil.getData("TestChangeArrivalDate", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestChangeArrivalDate")
	public void TestChangeArrivalDate(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.19");

				System.out.println("DATA" + data.get("URL"));
				TestChangeArrivalDate(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getTestDataFor_TestDeleteScheduleOrder() {
		return TestUtil.getData("TestDeleteScheduleOrder", TestData, "Contacts");
	}

	/**
	 * TC-ID : TC2.4 This Test verify whether user can create a duplicate
	 * contact. Verify whether a validation error will be displayed saying that
	 * the contact already exists.
	 */
	@Test(dataProvider = "getTestDataFor_TestDeleteScheduleOrder")
	public void TestDeleteScheduleOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {

				this.reporter.initTestCaseDescription("TC2.20");

				System.out.println("DATA" + data.get("URL"));
				TestDeleteScheduleOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("ScheduleOrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	@DataProvider
	public Object[][] getTestDataFor_TestEditSaveOrder() {
		return TestUtil.getData("TestEditSaveOrder", TestData, "Contacts");
	}

	@Test(dataProvider = "getTestDataFor_TestEditSaveOrder")
	public void TestEditSaveOrder(Hashtable<String, String> data) {
		try {
			if (data.get("RunMode").equals("Y")) {
				this.reporter.initTestCaseDescription("TC2.21");
				System.out.println("DATA" + data.get("URL"));

				TestEditSaveOrder(data.get("URL"), data.get("Email"), data.get("PWD"), data.get("ShipToCustomer"), data.get("ProductDescription"), data.get("OrderName"), data.get("Qty"));

			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}



