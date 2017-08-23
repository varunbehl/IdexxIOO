package com.Idexx.CucumberScripts;

import com.Idexx.libs.createOrderLib;
import com.Idexx.page.ContactsPage;
import com.Idexx.page.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by e002222 on 23-08-2017.
 */
public class createSecondScheduleOrderSpec extends createOrderLib {

    @And("Click on Schedule Orders Button for second Schedule order")
    public void Click_on_Schedule_Orders_Button_for_second_Schedule_order() throws Throwable {

        try {
            boolean isBtn = false;
            isBtn = driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
            //if (isBtn)
            if(isBtn){
                click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");
                waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
                waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
                click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
                click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                Thread.sleep(3000);
                mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
                click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
                Thread.sleep(3000);
                click(By.xpath("//td[@class='rt_primary']/following-sibling::td[2]/div/a"), "Click on Schedule Orders edit link");
                waitForElementPresent(HomePage.qtyField, "Verify qty field ", 10);
                waitForElementPresent(HomePage.deleteScheduleOrderBtn, "Verify Delete schedule order Button ", 10);
                click(HomePage.deleteScheduleOrderBtn, "Click on Delete schedule order Button");
                click(ContactsPage.orderNameDialogeOKBtn, "Click on OK button");
                Thread.sleep(3000);
                mouseHoverByJavaScript(ContactsPage.reOrderOptionBtn, "Hover on ReOrder Option button");
                click(ContactsPage.scheduledOrdersLink, "Click on Schedule Orders link");
                Thread.sleep(3000);

                Select se = new Select(driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

                List<WebElement> l = se.getOptions();
                int value=l.size();
                System.out.println("value of dropdown is " +value);
                waitForElementPresent(ContactsPage.newScheduleOrdersBtn, "Verify new Schedule Order Button", 10);
                click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

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
                        Select se1 = new Select(driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

                        List<WebElement> l1 = se1.getOptions();
                        int value1=l1.size();
                        System.out.println("value of dropdown is " +value1);
                        assert value>value1;
                    }


                }catch (Exception e) {

                    testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
                    Select se1 = new Select(driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

                    List<WebElement> l1 = se1.getOptions();
                    int value1=l1.size();
                    System.out.println("value of dropdown is " +value1);
                    assert value>value1;
                }


            }
        } catch (Exception e) {





            Select se = new Select(driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

            List<WebElement> l = se.getOptions();
            int value=l.size();
            System.out.println("value of dropdown is " +value);
            waitForElementPresent(ContactsPage.newScheduleOrdersBtn, "Verify new Schedule Order Button", 10);
            click(ContactsPage.newScheduleOrdersBtn, "Click on new Schedule Orders Button");

            try{

                if (!tesVerifyPopup(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"))) {
                    testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));
                }
            }catch(Exception e1){
                testMethod(getTestData.get("ProductDescription"), getTestData.get("ScheduleOrderName"));


                try {
                    boolean isBtn = false;
                    isBtn = driver.findElement(By.xpath("//div[@class='row']/h4")).isDisplayed();
                    //if (isBtn)
                    if (isBtn) {
                        System.out.println("There is no frequency dropdown to be selected");

                    }
                }catch(Exception e2) {

                    Select se1 = new Select(driver.findElement(By.xpath("//select[@id='gv_zzfreq']")));

                    List<WebElement> l1 = se1.getOptions();
                    int value1 = l1.size();
                    System.out.println("value of dropdown is " + value1);
                    assert value > value1;

                }


            }
        }

    }
}
