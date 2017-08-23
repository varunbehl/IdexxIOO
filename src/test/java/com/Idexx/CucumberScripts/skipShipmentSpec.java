package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by e002222 on 18-08-2017.
 */
public class skipShipmentSpec extends createOrderLib {
    public static String DateValueBefore;
    @And("Click on Skip Shipment link")
    public void Click_on_Skip_Shipment_link() throws Throwable {
         DateValueBefore=driver.findElement(ContactsPage.skipShipmentDateText(ordNameValue)).getText();


        int val=DateValueBefore.length();
        System.out.println("val is +++++++++++++ " + val);
        String DateBefore=DateValueBefore.substring(0,10);
        System.out.println("DateBefore is " + DateBefore);
        click(ContactsPage.skipShipmentLink(ordNameValue), "Click on Skip Shipment link");
    }
    @Then("Verify skip shipment dialog box")
    public void Verify_skip_shipment_dialog_box() throws Throwable {
        waitForElementPresent(ContactsPage.skipShipmentDialog, "Verify skip shipment dialog box", 10);
    }
    @Then("Verify date before and date after")
    public void Verify_date_before_and_date_after() throws Throwable {
        String DateValueAfter=getText(ContactsPage.skipShipmentDateText(ordNameValue),"Get date after ");
        String DateAfter=DateValueAfter.substring(0,10);
        System.out.println("DateAfter is " + DateAfter);
        assert DateValueBefore!=DateValueAfter;
    }
}
