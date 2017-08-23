package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by e002222 on 21-08-2017.
 */
public class removeExistingMaterialSpec extends createOrderLib {

    @Then("^Verify Delete Icon")
      public void Verify_Delete_Icon() throws Throwable {
        waitForElementPresent(HomePage.deleteIcon, "Verify Delete Icon ", 10);


    }
    @And("^Click Delete Icon")
    public void Click_Delete_Icon() throws Throwable {

        click(HomePage.deleteIcon, "Click Delete Icon");

    }
}
