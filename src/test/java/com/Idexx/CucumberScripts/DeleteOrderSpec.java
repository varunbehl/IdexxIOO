package com.Idexx.CucumberScripts;

import com.Idexx.libs.ContactsLib;
import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 14-08-2017.
 */
public class DeleteOrderSpec extends createOrderLib {

    @When("Click on Delete link")
    public void Click_on_Delete_link() throws Throwable {
        click(ContactsPage.deleteLink, "Click on Delete link");

    }
}
