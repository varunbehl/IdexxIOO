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
public class deleteScheduleOrderQtySpec extends createOrderLib {

    @Then("^Verify Delete schedule order Button")
    public void Verify_Delete_schedule_order_Button() throws Throwable {
        waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);

    }
    @When("^Click on Delete schedule order Button")
    public void Click_on_Delete_schedule_order_Button() throws Throwable {
        click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
    }
}
