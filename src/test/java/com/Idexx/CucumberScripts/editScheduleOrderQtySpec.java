package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 18-08-2017.
 */
public class editScheduleOrderQtySpec extends createOrderLib {

    @And("^Click on Schedule Orders edit link")
    public void Click_on_Schedule_Orders_edit_link() throws Throwable {
        click(ContactsPage.scheduleOrderEditLink(ordNameValue), "Click on Schedule Orders edit link");
        Thread.sleep(2000);
    }
    @When("^Enter qty value")
    public void Enter_qty_value() throws Throwable {
        String qty=driver.findElement(HomePage.qtyField).getAttribute("value");



        int qtyValue=Integer.parseInt(qty);

        int value=qtyValue+1;
        String QuantityValue = Integer.toString(value);
        type(HomePage.qtyField, QuantityValue, "Enter qty value");
    }

    @Then("^Verify second Submit order button")
    public void Verify_second_Submit_order_Button() throws Throwable {
        waitForElementPresent(HomePage.submitOrderBtn2, "Verify second Submit order Button ", 10);

    }
    @And("^Click on second Submit order button")
    public void Click_second_Submit_order_Button() throws Throwable {

        click(HomePage.submitOrderBtn2, "Click on second Submit order button");
    }
}
