package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Hashtable;


/**
 * Created by e002222 on 11-08-2017.
 */
public class createOrderSpec extends createOrderLib {
    //WebDriver driver = DriverManager.getDriver();
   // public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
   // public Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");
    @Given("Navigate to Idexx Login page")
    public void Navigate_to_Idexx_Login_page(){
        /* Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");
         Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");*/
        goToBaseUrl(getTestData.get("URL"));
    }
    @When("Enter username and password")
    public void Enter_username_and_password() throws Throwable {
        doLogin(getTestData.get("Email"), getTestData.get("PWDaa"));
    }
    @And("Click on submit button")
    public void Click_on_submit_button() throws Throwable {

        click(ContactsPage.signIn, "Click Sign In button");
        Thread.sleep(2000);
    }

    @When("Click on Order Now Button")
    public void Click_on_OrderNow_Button() throws Throwable {
        click(HomePage.orderNowBtn, "Click Order now button");
            }
    @Then("Verify Product Search field")
    public void Verify_Product_Search_field() throws Throwable {
        waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
    }
    @And("Enter Product Description")
    public void Enter_Product_Description(){
        //arg1=getTestData.get("ProductDescription");
        type(HomePage.productSearchField, getTestData.get("ProductDescription"), "Enter Product Description");
    }
    @And("^Click on search icon")
    public void Click_on_search_icon() throws Throwable {
        click(HomePage.searchIcon, "Click on search Icon");
    }

    @Then("^Verify Search result pop up")
    public void Verify_Search_result_pop_up() throws Throwable {
        waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
    }
    @And("^Click on Add to cart button")
    public void Click_on_Add_to_cart_button() throws Throwable {
        click(HomePage.addToCartBtn, "Click on Add to cart button");
    }
    @Then("^Verify next Button")
    public void Verify_next_Button() throws Throwable {
        waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);

    }
    @When("^Click on Next button")
    public void Click_on_Next_button() throws Throwable {
        click(HomePage.nextBtn, "Click on Next button");
        Thread.sleep(3000);
    }

    @Then("^Verify Submit order Button")
    public void Verify_Submit_order_Button() throws Throwable {

        waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
    }
    @When("^Click on Submit order button")
    public void Click_on_Submit_order_button() throws Throwable {
        click(HomePage.submitOrderBtn2, "Click on Submit order button");
    }


   /* @Then("^Verify schedule Order number")
    public void Verify_Order_number() throws Throwable {
        waitForElementPresent(HomePage.ScheduleOrderNumberText, "Verify Schedule Order number ", 10);
    }
    @Then("^Verify schedule Thank you text")
    public void Verify_Thank_you_text() throws Throwable {
        waitForElementPresent(HomePage.ScheduleConfirmationText, "Verify schedule Confirmation text ", 10);
    }
    @Then("^Verify schedule Thank you confirmation")
    public void Verify_Thank_you_confirmation() throws Throwable {
        waitForElementPresent(HomePage.ScheduleOrderConfirmation, "Verify schedule order Thank you confirmation ", 10);
        Thread.sleep(2000);
    }*/







}
