package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by e002222 on 21-08-2017.
 */
public class changeArrivalDateSpec extends createOrderLib {

    @Then("Verify Arrival day dropdown")
    public void Verify_Arrival_day_dropdown() throws Throwable {

        waitForElementPresent(HomePage.arrivalDayDropdown, "Verify Arrival day dropdown",10);
        Select select = new Select(driver.findElement(HomePage.arrivalDayDropdown));
        WebElement option = select.getFirstSelectedOption();
        String arrivalDay=option.getText().replaceAll("\\s","");
        System.out.println("arival day is +++++++" + arrivalDay);

        if (arrivalDay.equalsIgnoreCase("Tuesday")){
            select.selectByVisibleText("Wednesday");
        }else if (arrivalDay.equalsIgnoreCase("Wednesday")){
            select.selectByVisibleText("Thursday");
        }
        else if (arrivalDay.equalsIgnoreCase("Thursday")){
            select.selectByVisibleText("Friday");
        }
        else if (arrivalDay.equalsIgnoreCase("Friday")){
            select.selectByVisibleText("Monday");
        }
        else if (arrivalDay.equalsIgnoreCase("Monday")){
            select.selectByVisibleText("Tuesday");
        }
    }
}
