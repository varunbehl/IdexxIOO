package com.Idexx.CucumberScripts;


import com.Idexx.libs.createOrderLib;
import com.automation.report.ReporterConstants;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by e002222 on 28-07-2017.
 */
public class HooksTest extends createOrderLib {
    public static WebDriver driver;
    static Logger log;
    static {
        log = Logger.getLogger(HooksTest.class);
    }


   @Before

    public void beforeScenario() throws IOException, InterruptedException {

        setWebDriverForLocal("chrome");


        System.out.println("+++++++++++++++++this is before statement++++++++++++++++++++");

    }
    @After
    public void embedScreenshot(Scenario scenario) throws Throwable {
        if ( scenario.isFailed() ) {
           // log.error("Scenario failed! Browser: " + DriverManager.getBrowserInfo() + " Taking screenshot...");
           // scenario.write("Current Page URL is: " + DriverManager.getDriver().getCurrentUrl());
            //scenario.write("Scenario Failed in: " + DriverManager.getBrowserInfo());
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("target\\screenshot\\" + timestamp() + ".png");
                FileUtils.copyFile(scr, dest);
                Thread.sleep(3000);
                //click(By.xpath("//div[@class='sso-sign-out']/a"), "Click on sign out");
                //logout();
                driver.quit();
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                log.error(somePlatformsDontSupportScreenshots.getMessage());
            }

        }else{
            logout("clicked on sign out link");

            driver.quit();
        }
    }

    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    public void logout(String msg) {
        try {

            driver.findElement(By.xpath("//div[@class='sso-sign-out']/a")).click();
            System.out.println(msg);
            Thread.sleep(4000);
            //driver.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

   public void setWebDriverForLocal(String browser) throws IOException, InterruptedException
    {
        switch(browser)
        {
            case "firefox":
                Thread.sleep(13000);
                this.driver = new FirefoxDriver();
                Thread.sleep(5000);
                break;
            case "ie":
                Thread.sleep(10000);
                System.out.println("iam in case IE");
                DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
                capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                capab.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
                //capab.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, INIT_PAGE);

                File file = new File("Drivers\\IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
                capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                capab.setJavascriptEnabled(true);
                capab.setCapability("requireWindowFocus", true);
                capab.setCapability("enablePersistentHover", false);

                this.driver = new InternetExplorerDriver(capab);
			/* Process p = Runtime
						.getRuntime()
						.exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
				p.waitFor();*/
                Thread.sleep(8000);
                break;
            case "chrome":
                Thread.sleep(2000);
                System.out.println("iam in case Chrome");
                System.setProperty("webdriver.chrome.driver",
                        "Drivers\\chromedriver.exe");

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                this.driver = new ChromeDriver(capabilities);
                Thread.sleep(3000);
                break;




            case "Safari":

                for(int i=1;i<=10;i++){

                    try{
                        this.driver=new SafariDriver();

                        break;
                    }catch(Exception e1){
                        Runtime.getRuntime().exec("taskkill /F /IM Safari.exe");
                        Thread.sleep(3000);
                        Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
                        Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

                        continue;

                    }

                }

        }

    }

       /*public WebDriver GetBrowser()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
         return  this.driver = new ChromeDriver(capabilities);
    }*/

    /*@BeforeClass(alwaysRun=true)
    //@BeforeTest
    @Parameters({"automationName","browser","browserVersion","environment","platformName"})
    public void beforeTest(String automationName, String browser, String browserVersion,String environment,String platformName) throws IOException, InterruptedException
    {
		*//*PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Log.properties");
		   System.out.println(System.getProperty("user.dir")+"\\Log.properties");*//*

		*//*get configuration *//*
        this.automationName = automationName;
        this.browser = browser;
        this.version = browserVersion;
        this.platform = platformName;
        this.environment = environment;


		*//**//*
        System.out.println(environment);

        if(environment.equalsIgnoreCase("local"))
        {
            this.setWebDriverForLocal(browser);
        }}*/
}
