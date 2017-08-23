package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * Created by e002222 on 18-08-2017.
 */
public class addNewMaterialSpec extends createOrderLib {



    @And("Enter second new product")
    public void Enter_second_new_product() throws Throwable {
        type(HomePage.productSearchField2, getTestData.get("ProductDescription"), "enter new product");
    }
    @Then("Verify second Product Search field")
      public void Verify_second_Product_Search_field() throws Throwable {
        waitForElementPresent(HomePage.searchIcon2, "Verify Product Search field ", 10);
    }
    @Then("Click on second search Icon")
    public void Click_on_second_search_Icon() throws Throwable {
        click(HomePage.searchIcon2, "Click on search Icon");
    }
}
