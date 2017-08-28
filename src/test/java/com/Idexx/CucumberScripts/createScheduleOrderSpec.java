package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

/**
 * Created by e002222 on 17-08-2017.
 */
public class createScheduleOrderSpec extends createOrderLib {
    public String ordNameValue;
    @And("Click on Schedule Orders link")
    public void Click_on_Schedule_Orders_link() throws Throwable {
        click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
        Thread.sleep(2000);

    }
    @When("Click on new Schedule Orders Button")
    public void Click_on_new_Schedule_Orders_Button() throws Throwable {
        try {
            boolean isBtn = false;
            isBtn = driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
            if (isBtn) {
                click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");


                try {
                    boolean isPopup1 =false;

                    isPopup1 = driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
                    if (isPopup1) {
                        click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
                        Thread.sleep(2000);
                        click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                        Thread.sleep(2000);
                        waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
                        waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
                        click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
                        click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                        Thread.sleep(3000);
                        mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
                        click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
                        Thread.sleep(3000);
                        click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

                    }
                }catch (Exception e) {

                    waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
                    waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
                    click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
                    click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                    Thread.sleep(3000);
                    mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
                    click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
                    Thread.sleep(3000);
                    click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");
                }





                try {
                    boolean isPopup =false;

                    isPopup = driver.findElement(ContactsPage.deleteOrderBtn).isDisplayed();
                    if (isPopup)
                    {
                        click(ContactsPage.deleteOrderBtn, "Click on Delete Order Button");
                        Thread.sleep(2000);
                        click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                        Thread.sleep(2000);
                        testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
                    }


                }catch (Exception e) {

                    testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
                }


            }
        } catch (Exception e) {

            click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

            try{

                if (!tesVerifyPopup(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"))) {
                    testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
                }
            }catch(Exception e1){
                testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));}
        }
    }
    /*@And("Enter Schedule order name")
    public void Enter_Schedule_order_name() throws Throwable {
        click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");

    }*/


}
