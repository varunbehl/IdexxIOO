package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 14-08-2017.
 */
public class createSaveOrderSpec extends createOrderLib {
    String ordNameValue;
    public static String saveordName;

    @Then("Verify the Save for Later button")
    public void Verify_the_Save_for_Later_button() throws Throwable {
        waitForElementPresent(ContactsPage.saveForLaterBtn, "Verify the Save for Later button", 10);
    }
    @Then("Click on Save For Later button")
    public void Click_on_Save_For_Later_button() throws Throwable {
        click(ContactsPage.saveForLaterBtn, "Click on Save For Later button");
    }
    @When("Verify Order Name Dialogue Box")
    public void Verify_Order_Name_Dialogue_Box() throws Throwable {
        waitForElementPresent(ContactsPage.orderNameDialogeBox, "Verify Order Name Dialogue Box ", 10);
    }

    @When("Enter Order Name")
    public void Enter_Order_Name() throws Throwable {

        String arg1=getTestData.get("OrderName");
        int Num = (int) (Math.random() * 9000) + 1000;
        // use this String wherever you want

        String RandomNum = Integer.toString(Num);
        saveordName = arg1 + RandomNum;
        System.out.println(saveordName);

        type(ContactsPage.orderNameField, saveordName, "Enter Order Name");
    }
    @When("Click on OK button")
    public void Click_on_OK_button() throws Throwable {
        click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
        Thread.sleep(2000);
    }
    @Then("Verify My orders button")
    public void Verify_My_orders_button() throws Throwable {
        waitForElementPresent(ContactsPage.myOrdersBtn, "Verify My orders button ", 10);
    }
    @When("Hover on My Orders button")
    public void Hover_on_My_Orders_button() throws Throwable {
        mouseHoverByJavaScript(ContactsPage.myOrdersBtn, "Hover on My Orders button");
    }
    @When("Click on Saved Orders link")
     public void Click_on_Saved_Orders_link() throws Throwable {
        click(ContactsPage.savedOrdersLink, "Click on Saved Orders link");
    }
    @Then("Verify Saved Order number")
    public void Verify_Saved_Order_number() throws Throwable {
        waitForElementPresent(ContactsPage.orderNoVerify, "Verify Saved Order number", 10);
    }
}
