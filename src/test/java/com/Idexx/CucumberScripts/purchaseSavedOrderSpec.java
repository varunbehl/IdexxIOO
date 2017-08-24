package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import cucumber.api.java.en.Then;

/**
 * Created by e002222 on 16-08-2017.
 */
public class purchaseSavedOrderSpec extends createOrderLib {

    @Then("Verify Order Now Link")
    public void Verify_Order_Now_Link() throws Throwable {
        waitForElementPresent(ContactsPage.orderNowLink, "Verify Order Now Link", 10);
    }
    @Then("Click on Order Now link")
    public void Click_on_Order_Now_link() throws Throwable {
        click(ContactsPage.orderNowLink, "Click on Order Now link");
    }
}
