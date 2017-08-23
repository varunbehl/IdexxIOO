package com.Idexx.scripts;

import com.Idexx.libs.ContactsLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

/**
 * Created by e002222 on 21-07-2017.
 */
public class Docker {
@Test
    public static void testDocker()throws Throwable, IOException, InterruptedException{
    WebDriver driver;
    System.out.println("iam in case Chrome");
   /* System.setProperty("webdriver.chrome.driver",
            "Drivers\\chromedriver.exe");*/

    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    //ChromeOptions options = new ChromeOptions();

    capabilities.setCapability("platform", "LINUX");
    driver = new RemoteWebDriver(new URL("http://192.168.99.100:4545/wd/hub"), capabilities);
    driver.get("http://www.google.com");
    Thread.sleep(10000);
    }

}