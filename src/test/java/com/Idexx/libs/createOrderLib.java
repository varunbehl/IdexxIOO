package com.Idexx.libs;

import com.Idexx.CucumberScripts.ActionEngineCucumber;
import com.Idexx.CucumberScripts.DriverManager;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Hashtable;

/**
 * Created by e002222 on 11-08-2017.
 */
public class createOrderLib extends ActionEngineCucumber{
    public static String ordNameValue;
    public WebDriver driver = DriverManager.getDriver();
    public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
    public Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");


    public void goToBaseUrl(String url){
        /* Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
         Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");*/
        //driver.navigate().to("https://google.com");
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void doLogin(String email, String password) throws Throwable {
        new HomePage().Home_Page();
        new ContactsPage().OrderPage();
        new ContactsPage().CreateContactPage();
       // waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
        click(HomePage.signInBtn, "Click on Sign in btn");
        Thread.sleep(3000);
        type(ContactsPage.username, email, "Enter Username");
        type(ContactsPage.password, password, "Enter Password");
        Thread.sleep(2000);


    }

    public void TestCreateOrder( String customer, String ProdDesc, String Quantity) throws Throwable {
        new HomePage().Home_Page();
        new ContactsPage().CreateContactPage();

/*
        driver.navigate().to("https://google.com");
        Thread.sleep(3000);
        driver.navigate().to(url);
        waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
        click(HomePage.signInBtn, "Click on Sign in btn");
        Thread.sleep(3000);
        type(ContactsPage.username, email, "Enter Username");
        type(ContactsPage.password, password, "Enter Password");
        Thread.sleep(2000);

        click(ContactsPage.signIn, "Click Sign In button");
        Thread.sleep(2000);*/
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

    public void testMethod(String ProdDesc, String ScheduleOrdName) throws Throwable{
        Thread.sleep(2000);
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
//        waitForElementPresent(HomePage.OrderNumberText, "Verify Order number ", 10);
        waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);

        mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
        click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
        String val = getText(ContactsPage.scheduleOrderNameField(ordNameValue), "Schedule order name text");
        verify(val, ordNameValue, "verify Schedule order text");
        Thread.sleep(3000);



    }
    public  Boolean tesVerifyPopup(String ProdDesc, String ScheduleOrdName)throws Throwable{

        boolean isPopup=false;
        isPopup = driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
        if (isPopup)
        {
            click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
            Thread.sleep(2000);
            click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
            Thread.sleep(2000);
            testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
        }
        return isPopup;
    }
    public void logout() {
        try {

            click(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
            Thread.sleep(4000);
            driver.quit();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
