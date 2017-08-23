package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 16-08-2017.
 */
public class createFavOrderFromOrderSpec extends createOrderLib {

    @Then("Verify Home Button")
    public void Verify_Home_Button() throws Throwable {

        waitForElementPresent(HomePage.homeBtn, "Verify Home Button ", 10);
    }
    @Then("Verify Order Now Button")
    public void Verify_Order_Now_Button() throws Throwable {

        waitForElementPresent(HomePage.orderNowBtn, "Verify Order Now Button ", 10);
    }
    @When("Click on Home button")
    public void Click_on_Home_button() throws Throwable {

        click(HomePage.homeBtn, "Click on Home button");
    }
    @When("Click on View Order Button")
    public void Click_on_View_Order_Button() throws Throwable {

        click(HomePage.viewOrderBtn, "Click on View Order button");
    }
    @Then("Verify Purchase Order Number field")
    public void Verify_Purchase_Order_Number_field() throws Throwable {

        waitForElementPresent(HomePage.favOrdernameField, "Verify Purchase Order Number field ", 10);
    }
    @When("Enter Purchase Order No order")
    public void Enter_Purchase_Order_No_order() throws Throwable {

        type(HomePage.favOrdernameField, getTestData.get("PurchaseOrderNumber"), "Enter Purchase Order No order");
    }
    @And("^Click on Add to Favorite Order button")
    public void Click_on_Add_to_Favorite_Order_button() throws Throwable {
        click(HomePage.addToFavOrderBtn, "Click on Add to Favorite Order button");
    }
  /*  @When("^Enter Order Name")
    public void Enter_Order_Name() throws Throwable {
        type(ContactsPage.orderNameField, getTestData.get("OrderName"), "Enter Order Name");
    }*/
}
