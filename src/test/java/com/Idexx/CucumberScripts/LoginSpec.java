package com.Idexx.CucumberScripts;


import com.Idexx.libs.LoginLib;
import com.Idexx.page.HomePage;
import com.automation.utilities.TestUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import java.util.Hashtable;



/**
 * Created by e002222 on 27-07-2017.
 */

public class LoginSpec extends LoginLib {
   // WebDriver driver = DriverManager.getDriver();
    //public WebDriver driver = HooksTest.driver;
   // String url = "https://qaorder.idexx.com/";
   // public List<HashMap<String,String>> datamap=TestUtil.getData("TestCucumber", "Contacts");
   // public List<HashMap<String,String>> datamap=TestUtil.getData(System.getProperty("user.dir") + "//TestData//TestData.xlsx", "Contacts");
   /* public LoginSpec()
    {

        datamap = ExcelDataHelper.data(System.getProperty("user.dir")+"//TestData//TestData.xlsx","Contacts");
    }*/





  // public Xls_Reader TestData = new Xls_Reader(System.getProperty("user.dir")+"/TestData/TestData.xlsx");

    @Given("^Navigate to Idexx Login page \\\"([^\\\"]*)\\\"$")

    public void Navigate_to_Idexx_Login_page(String arg1) throws Throwable {
        new HomePage().Home_Page();
        //Hash()
        //String value = TestData.getCellData("Sheet1", "URL",1);
        //TestUtil.getData("TestCucumber", TestData, "Contacts");

        goToBaseUrl(arg1);
       // doLogin(arg1,"www", "wwwww");

        System.out.println("hodhd  eeeeeeeeeeeeeeeeeeeee");
    }


    /*@When("^Enter username and password$")
    public void Enter_username_and_password() throws Throwable {
        System.out.println("hodhd");

       //int index = Integer.parseInt(arg3)-1;
        System.out.println("Printing current data set...");
       *//* for(HashMap h:datamap)
        {
            System.out.println(h.keySet());
            System.out.println(h.values());
        }*//*

        //Hashtable<String, String> getTestData=

      //  Hashtable<String,String> getTestData=  TestUtil.getDataCucumber("TestCucumber", TestData, "Contacts");

        System.out.println("value from  excel _______" + getTestData.get("URL"));
        System.out.println("value from  excel _______" + getTestData.get("Email"));
//String val=getTestData.get("URL");
       doLogin(getTestData.get("Email"),getTestData.get("PWD"));


      *//*Object[][]data=TestUtil.getData("TestCucumber", TestData, "Contacts");

        for(int i=0;i<data.length;i++){

            System.out.println("Row: "+i+" ===============================================");
            for(int j=0;j<data[i].length;j++){
                System.out.print("Column "+j+" :"+data[i][j]+" ");
            }


            System.out.println("---------------------------------------");
        }*//*
       // doLogin(data[0].toString(),"www", "wwwww");
    }*/

   /* @When ("^Click on Order Now Button$")
    public void Click_on_Order_Now_Button(){


    }*/



}
