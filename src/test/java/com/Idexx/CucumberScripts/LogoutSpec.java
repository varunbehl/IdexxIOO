package com.Idexx.CucumberScripts;


import com.Idexx.libs.LoginLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by e002222 on 01-08-2017.
 */
public class LogoutSpec extends LoginLib {
/*
@Test
    @When("^Enter \"([^\\\"]*)\" and \"([^\"]*)\"$")

    public void Navigate_to_Idexx_Login_page(String arg1, String arg2) throws Throwable {
        new HomePage().Home_Page();
        //Hash()
        //String value = TestData.getCellData("Sheet1", "URL",1);
        //TestUtil.getData("TestCucumber", TestData, "Contacts");

        doLogin(arg1,arg2);

        System.out.println("hodhd  eeeeeeeeeeeeeeeeeeeee");
    }
@Test
    @And("^Click on submit button$")
    public void Click_on_submit_button() throws Throwable {
        new HomePage().Home_Page();
        new ContactsPage().OrderPage();
        new ContactsPage().CreateContactPage();
        click(ContactsPage.signIn, "Click Sign In button");
        //doLoginLogout();
        //launchUrl();
    }
    @Test
    @Then("^Click on logout button$")
    public void Click_on_logout_button() throws Throwable {
        new HomePage().Home_Page();
        new ContactsPage().OrderPage();
        new ContactsPage().CreateContactPage();
        click(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
        //doLoginLogout();
        //launchUrl();
    }*/
}
