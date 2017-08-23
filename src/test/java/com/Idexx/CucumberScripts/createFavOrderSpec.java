package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by e002222 on 17-08-2017.
 */
public class createFavOrderSpec extends createOrderLib {
public static String favodrname;
    public static String favOdrNameValue;
    @Then("Verify ReOrder Option button")
    public void Verify_ReOrder_Option_button(){
        waitForElementPresent(ContactsPage.reOrderOptionBtn, "Verify ReOrder Option button ", 10);
    }
    @When("Hover on ReOrder Option button")
    public void Hover_on_ReOrder_Option_button(){
        mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
    }
    @When("Click on favorite Orders link")
    public void Click_on_favorite_Orders_link() throws Throwable {
        click(ContactsPage.favoriteOrdersLink, "Click on favorite Orders link");
    }
    @When("Click on new favorite Orders link")
    public void Click_on_new_favorite_Orders_link() throws Throwable {
        click(ContactsPage.newFavoriteOrdersBtn, "Click on new favorite Orders Button");
    }
    @Then("Verify Fav order name field")
     public void Verify_Fav_order_name_field() throws Throwable {
        waitForElementPresent(HomePage.favOrdernameField, "Verify Fav order name field ", 10);
    }
    @When("Enter Favorite order")
    public void Enter_Favorite_order() throws Throwable {

        favodrname=getTestData.get("FavoriteOrderName");

        int Num = (int) (Math.random() * 9000) + 1000;
        // use this String wherever you want

        String RandomNum = Integer.toString(Num);

        favOdrNameValue = favodrname + RandomNum;
        System.out.println(favOdrNameValue);
        type(HomePage.favOrdernameField, favOdrNameValue, "Enter Favorite order");
    }

    @Then("Verify search Icon")
    public void Verify_search_Icon() throws Throwable {
        waitForElementPresent(HomePage.searchIcon, "Verify search Icon ", 10);
    }
    @Then("Verify save favorite button")
    public void Verify_save_favorite_button() throws Throwable {
        waitForElementPresent(HomePage.favSaveBtn, "Verify save favorite button ", 10);
    }
    @Then("Click on save favorite button")
    public void Click_on_save_favorite_button() throws Throwable {
        click(HomePage.favSaveBtn, "Click on save favorite button");
    }
    @Then("Verify Favorite order confirmation")
    public void Verify_Favorite_order_confirmation() throws Throwable {
        waitForElementPresent(HomePage.favOrderConfirmationMsg, "Verify Favorite order confirmation ", 10);
    }
    @Then("Verify Favorite order text")
    public void Verify_Favorite_order_text() throws Throwable {
        String val = getText(HomePage.favOrderNameText(favOdrNameValue), "Fav order name text");
        verify(val, favodrname, "verify favorite order text");
        Thread.sleep(3000);
    }
}
