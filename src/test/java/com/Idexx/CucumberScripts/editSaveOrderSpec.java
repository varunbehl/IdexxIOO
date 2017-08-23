package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 14-08-2017.
 */
public class editSaveOrderSpec extends createOrderLib {

    String QuantityValue;

    @When("Click on Saved Orders edit link")
    public void Click_on_Save_Orders_edit_link() throws Throwable {


        click(ContactsPage.saveOrderEditLink(createSaveOrderSpec.saveordName), "Click on Save Orders edit link");
    }
    @Then("Verify View Saved Order text")
    public void Verify_View_Saved_Order_text() throws Throwable {

        waitForElementPresent(HomePage.viewSavedOrderTxt, "Verify View Saved Order text", 10);
    }
    @And("Click on Edit button")
    public void Click_on_Edit_button() throws Throwable {

        click(HomePage.editBtn, "Click on Edit button");
    }
    @Then("Verify Edit Saved Order text")
    public void Verify_Edit_Saved_Order_text() throws Throwable {

        waitForElementPresent(HomePage.editSavedOrderTxt, "Verify Edit Saved Order text", 10);
    }
    @Then("Verify qty field")
    public void Verify_qty_field() throws Throwable {

        waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
    }
    @When("Save Order Quantity")
    public void Save_Order_Quantity() throws Throwable {

        String qty=driver.findElement(HomePage.qtyField).getAttribute("value");
        int qtyValue=Integer.parseInt(qty);
        int value=qtyValue+1;
          QuantityValue = Integer.toString(value);
        type(HomePage.qtyField, QuantityValue, "Save Order Quantity");
    }
    @Then("Verify Save Button")
    public void Verify_Save_Button() throws Throwable {

        waitForElementPresent(HomePage.saveBtn, "Verify Save Button ", 10);
    }
    @When("Click on Save button")
    public void Click_on_Save_button() throws Throwable {

        click(HomePage.saveBtn, "Click on Save button");
    }
    @Then("Verify Saved Order - Confirmation text")
    public void Verify_Saved_Order_Confirmation_text() throws Throwable {

        waitForElementPresent(HomePage.savedOrderConfirmationTxt, "Verify Saved Order - Confirmation text", 10);
    }
    @Then("Verify Quantity field edited")
    public void Verify_Quantity_field_edited() throws Throwable {

        String qty1=driver.findElement(HomePage.qtyField).getAttribute("value");


        verify(QuantityValue, qty1, "Verify Quantity field edited");
    }
    @Then("Click on Close button")
    public void Click_on_Close_button() throws Throwable {

        click(HomePage.closeBtn, "Click on Close button");
    }
}
