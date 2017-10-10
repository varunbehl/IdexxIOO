package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import com.Idexx.scripts.Contacts;
import com.automation.utilities.TestUtil;
import com.automation.utilities.Xls_Reader;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.crypto.Data;
import java.util.Hashtable;
import java.util.List;


/**
 * Created by e002222 on 11-08-2017.
 */
public class createOrderSpec extends createOrderLib {
    public static By productSearchField;
    public static By searchIcon;
    public WebDriver driver = HooksTest.driver;
//WebDriver driver;
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
        doLogin(getTestData.get("Email"), getTestData.get("PWD"));
    }
    @And("Click on submit button")
    public void Click_on_submit_button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {
            click(ContactsPage.signIn, "Click Sign In button");
            Thread.sleep(2000);
        } else if (data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {
            click(ContactsPage.signIn, "Click Sign In button");
            Thread.sleep(2000);
        }
    }

    @When("Click on Order Now Button")
    public void Click_on_OrderNow_Button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {
            click(HomePage.orderNowBtn, "Click Order now button");
        }
    }

    @Then("Verify Product Search field")
    public void Verify_Product_Search_field() throws Throwable {

        waitForElementPresent(HomePage.productSearchField, "Verify Product Search field ", 10);
    }

    @And("Enter Product (\\d+) \"([^\"]*)\"")
    public void Enter_Product_Description(int num, String arg1) throws Throwable {


        productSearchField = By.id("artikel100" + num + "");
        searchIcon = By.id("searchIcon100" + num + "");

        driver.findElement(productSearchField).sendKeys(arg1);
        // type(productSearchField, data.get(i).get(i), "Enter Product Description");
        //waitForElementPresent(productSearchField, "Verify Product Search field ", 10);
        click(searchIcon, "Click on search Icon");
        WebDriverWait wait = new WebDriverWait(driver, 35);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/*//*[@id='loading']/img")));
        waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
        click(HomePage.addToCartBtn, "Click on Add to cart button");
        Thread.sleep(3000);


        //type(HomePage.productSearchField, "prod", "Enter Product Description");

/*
        for(int i=0;i<num; i++){
            List<List<String>> data = table.raw();
            for(int j=i+1; j<=num; j++){

                productSearchField= By.id("artikel100"+j+"");
                searchIcon= By.id("searchIcon100"+j+"");


            type(productSearchField, data.get(i).get(i), "Enter Product Description");
            //waitForElementPresent(productSearchField, "Verify Product Search field ", 10);
            click(searchIcon, "Click on search Icon");
                WebDriverWait wait = new WebDriverWait(driver, 35);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/*//*[@id='loading']/img")));
            waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
            click(HomePage.addToCartBtn, "Click on Add to cart button");
            Thread.sleep(3000);
            }
        }*/

       /* waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
        click(HomePage.nextBtn, "Click on Next button");
        Thread.sleep(3000);
        waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
        click(HomePage.submitOrderBtn2, "Click on Submit order button");*/


        //arg1=getTestData.get("ProductDescription");
        //type(HomePage.productSearchField, prodDesc, "Enter Product Description");
        //type(HomePage.productSearchField, getTestData.get("ProductDescription"), "Enter Product Description");
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
    public void Verify_next_Button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            waitForElementPresent(HomePage.nextBtn_Fr, "Verify next Button ", 10);
            Thread.sleep(2000);
        }



    }

    @When("^Click on Next button")
    public void Click_on_Next_button(DataTable url) throws Throwable {

        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            click(HomePage.nextBtn, "Click on Next button");
            Thread.sleep(3000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            click(HomePage.nextBtn_Fr, "Click on Next button");
            Thread.sleep(3000);
        }



    }

    @And("^Check the submit order checkbox")
    public void Check_the_submit_order_checkbox(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            click(HomePage.submitOrderCheckbox_FR, "Click on Submit order button");
            Thread.sleep(2000);
        }
    }

    @Then("^Verify Submit order Button")
    public void Verify_Submit_order_Button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            waitForElementPresent(HomePage.submitOrderBtn_FR, "Verify Submit order Button ", 10);
            Thread.sleep(2000);
        }

    }

    @When("^Click on Submit order button")
    public void Click_on_Submit_order_button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            click(HomePage.submitOrderBtn2, "Click on Submit order button");
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            click(HomePage.submitOrderBtn_FR, "Click on Submit order button");
            Thread.sleep(2000);
        }


    }


    @Then("^Verify schedule Order number")
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
    }

    @Then("^Verify the following button")
    public void Verify_the_following_button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();

        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            waitForElementPresent(ContactsPage.followingBtn, "Verify the following button ", 10);
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            waitForElementPresent(ContactsPage.followingBtn, "Verify the following button ", 10);
            Thread.sleep(2000);
        }
    }

    @When("^Click on the following button")
    public void Click_the_following_button(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            click(ContactsPage.followingBtn, "Click on following button");
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            click(ContactsPage.followingBtn, "Click on following button");
            Thread.sleep(2000);
        }




    }

    @And("Enter (\\d+) Product")
    public void Enter_Product(int num, DataTable url) throws Throwable {


        // for (int i = 0; i < num; i++) {
        List<List<String>> data = url.raw();
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")){

System.out.println("Number of rows for data table is "+ data.size());
       // for(List<String> row : data) {
            //for (int i = 1; i <= num; i++) {
                for (int k = 1; k <= data.size()-1; k++) {
                    productSearchField = By.id("artikel100" + k + "");
                    searchIcon = By.id("searchIcon100" + k + "");
                    type(productSearchField, data.get(k).get(0), "Enter Product Description");
                    click(searchIcon, "Click on search Icon");
                    WebDriverWait wait = new WebDriverWait(driver, 35);
                     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']/img")));
                    waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
                    click(HomePage.addToCartBtn, "Click on Add to cart button");
                    Thread.sleep(3000);
                }



        }
        else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")){


            System.out.println("Number of rows for data table is "+ data.size());
           // for(List<String> row : data) {
               // for (int i = 1; i <= data.size(); i++) {
                    for (int k = 1; k <= data.size()-1; k++) {
                        productSearchField = By.id("artikel100" + k + "");
                        searchIcon = By.id("searchIcon100" + k + "");
                        type(productSearchField, data.get(k).get(0), "Enter Product Description");
                        click(searchIcon, "Click on search Icon");
                        //WebDriverWait wait = new WebDriverWait(driver, 35);
                        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loading']/img")));
                        waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
                        click(HomePage.addToCartLink, "Click on Add to cart button");
                        Thread.sleep(3000);


            }
        }







       /* if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {
            for (int k = 1; k <= num; k++) {
                productSearchField = By.id("artikel100" + k + "");
                searchIcon = By.id("searchIcon100" + k + "");
                type(productSearchField, data.get(k).get(0), "Enter Product Description");
                click(searchIcon, "Click on search Icon");
                WebDriverWait wait = new WebDriverWait(driver, 35);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("*//*//**//*[@id='loading']/img")));
                waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
                click(HomePage.addToCartBtn, "Click on Add to cart button");
                Thread.sleep(3000);
            }
            //waitForElementPresent(productSearchField, "Verify Product Search field ", 10);

        } else if (data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            for (int k = 1; k <= num; k++) {
                productSearchField = By.id("artikel100" + k + "");
                //searchIcon = By.id("zzartsrch1001");

                searchIcon = By.id("zzartsrch100" + k + "");
                type(productSearchField, data.get(k).get(0), "Enter Product Description");
                click(searchIcon, "Click on search Icon");
               *//* WebDriverWait wait = new WebDriverWait(driver, 35);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("*//**//*//**//**//**//*[@id='loading']/img")));*//*
                waitForElementPresent(HomePage.searchResultPopup, "Verify Search result pop up ", 10);
                click(HomePage.addToCartLink, "Click on Add to order link");
                Thread.sleep(3000);


            }
        }*/


       /* waitForElementPresent(HomePage.nextBtn, "Verify next Button ", 10);
        click(HomePage.nextBtn, "Click on Next button");
        Thread.sleep(3000);
        waitForElementPresent(HomePage.submitOrderBtn2, "Verify Submit order Button ", 10);
        click(HomePage.submitOrderBtn2, "Click on Submit order button");*/


        //arg1=getTestData.get("ProductDescription");
        //type(HomePage.productSearchField, prodDesc, "Enter Product Description");
        //type(HomePage.productSearchField, getTestData.get("ProductDescription"), "Enter Product Description");
    }

    @When("^Verify the New Order Link")
    public void Verify_the_New_Order_Link(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {
            waitForElementPresent(ContactsPage.newOrderlink, "Verify New Order Link", 10);

        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            waitForElementPresent(ContactsPage.newOrderlink, "Verify New Order Link", 10);

        }




    }
    @When("^Click on the New Order Link")
    public void Click_on_the_New_Order_Link(DataTable url) throws Throwable {
        List<List<String>> data = url.raw();
        if (data.get(0).get(0).equalsIgnoreCase("https://qaorder.idexx.com")) {

            click(ContactsPage.newOrderlink, "Click on new order link");
            Thread.sleep(2000);
        }else if(data.get(0).get(0).equalsIgnoreCase("https://qacommande.idexx.fr")) {

            click(ContactsPage.newOrderlink, "Click on new order link");
            Thread.sleep(2000);
        }




    }


}
