package com.Idexx.libs;


import com.Idexx.CucumberScripts.ActionEngineCucumber;
import com.Idexx.CucumberScripts.DriverManager;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;
import org.openqa.selenium.WebDriver;

import java.util.Hashtable;


/**
 * Created by e002222 on 27-07-2017.
 */
public class LoginLib extends ActionEngineCucumber {
   //WebDriver driver = HooksTest.driver;
   WebDriver driver = DriverManager.getDriver();
    String url = "https://qaorder.idexx.com/";
    public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
    public Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");

    public void goToBaseUrl(String url){

        driver.get(url);
        driver.manage().window().maximize();
    }



    public void doLogin( String username, String password) throws Throwable {

        new HomePage().Home_Page();
        new ContactsPage().OrderPage();
        new ContactsPage().CreateContactPage();
System.out.println("this uis the +=+++++++++++++++++++++++");
        System.out.println("this uis the +=+++++++++++wfwefewf++++++++++++");


        click(HomePage.signInBtn, "Click on Sign in btn");
       // waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);

        Thread.sleep(3000);
        type(ContactsPage.username, username, "Enter Username");
       // driver.findElement(ContactsPage.password).sendKeys("olsjos");
        type(ContactsPage.password, password, "Enter Password");
        Thread.sleep(2000);

        //click(ContactsPage.signIn, "Click Sign In button");
        Thread.sleep(2000);
       /* try {
            System.out.println("this uis the +=+++++++++++wfwefewf++++++++++++");
          Driver.get("https://qaorder.idexx.com/");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        }


}
