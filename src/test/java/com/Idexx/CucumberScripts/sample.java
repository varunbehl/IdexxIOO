package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by e002222 on 04-10-2017.
 */
public class sample extends createOrderLib {

    public WebDriver driver = HooksTest.driver;
    /*@Before
    public void deleteAllCookies() {
        DriverManager.getDriver();
        //log.info("Deleting all cookies...");
        DriverManager.getDriver().manage().deleteAllCookies();
    }*/
    @Given("^go to url")
    public void Navigate_to_Idexx(DataTable url) {
        /*String browserName="chrome";
        WebDriver driver = LocalDriverFactory.createInstance(browserName);
        DriverManager.setWebDriver(driver);*/
        List<List<String>> data = url.raw();


        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {
            driver.get("https://qaorder.idexx.com");
            driver.manage().window().maximize();

        } else if (data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr"))
            driver.get("https://qacommande.idexx.fr");
        driver.manage().window().maximize();
    }

    @Given("^Enter credentials")
    public void Enter_udername_and_password( DataTable url) throws Throwable {
        new HomePage().Home_Page();
        new ContactsPage().OrderPage();
        new ContactsPage().CreateContactPage();
        List<List<String>> data = url.raw();
        // waitForElementPresent(HomePage.signInBtn, "Verify Sign In btn ", 10);
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {


            click(HomePage.signInBtn, "Click on Sign in btn");
            Thread.sleep(3000);
            type(ContactsPage.username, getTestData.get("Email"), "Enter Username");
            type(ContactsPage.password, getTestData.get("PWD"), "Enter Password");
            Thread.sleep(2000);
        }
        else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")){
            click(HomePage.signInBtn, "Click on Sign in btn");
            Thread.sleep(3000);
            type(ContactsPage.username, getTestData1.get("Email"), "Enter Username");
            type(ContactsPage.password, getTestData1.get("PWD"), "Enter Password");
            Thread.sleep(2000);


        }

    }
}
