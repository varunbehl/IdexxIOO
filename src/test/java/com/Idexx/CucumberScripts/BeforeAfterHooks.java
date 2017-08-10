package com.Idexx.CucumberScripts;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Based on SharedDriver.java taken from cucumber-jvm/examples/java-webbit-websockets-selenium
 *
 * @src: https://github.com/cucumber/cucumber-jvm/blob/master/examples/java-webbit-websockets-selenium/src/test/java/cucumber/examples/java/websockets/SharedDriver.java
 * @author: https://github.com/aslakhellesoy
 */
public class BeforeAfterHooks {
  WebDriver driver = DriverManager.getDriver();
    static Logger log;

    static {
        log = Logger.getLogger(BeforeAfterHooks.class);
    }

    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    @Before
    public void deleteAllCookies() {
        log.info("Deleting all cookies...");
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    @After
    public void embedScreenshot(Scenario scenario) throws IOException {
        if ( scenario.isFailed() ) {
            log.error("Scenario failed! Browser: " + DriverManager.getBrowserInfo() + " Taking screenshot...");
            scenario.write("Current Page URL is: " + DriverManager.getDriver().getCurrentUrl());
            scenario.write("Scenario Failed in: " + DriverManager.getBrowserInfo());
            try {
                byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
                File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File("target\\screenshot\\" + timestamp() + ".png");
                FileUtils.copyFile(scr, dest);
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                log.error(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
    }
    public String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}