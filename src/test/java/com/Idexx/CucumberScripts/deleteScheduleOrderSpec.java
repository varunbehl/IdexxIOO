package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.Then;

/**
 * Created by e002222 on 21-08-2017.
 */
public class deleteScheduleOrderSpec extends createOrderLib {


    @Then("^Verify Delete schedule order dialog box")
    public void Verify_Delete_schedule_order_dialog_box() throws Throwable {
        waitForElementPresent(ContactsPage.skipShipmentDialog, "Verify Delete Schedule Order dialog box", 10);

    }
}
