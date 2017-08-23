package com.Idexx.CucumberScripts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * Created by e002222 on 11-08-2017.
 */
public class SamplegoogleScript extends ActionEngineCucumber{

    WebDriver driver = DriverManager.getDriver();

    @Given("^Navigate to google Login page \\\"([^\\\"]*)\\\"$")
    public void Navigate_to_google_Login_page(String arg1){
        driver.get(arg1);
    }

    @When("Navigate to google Login")
    public void NavigatetogoogleLogin(){

    }


}
