package com.automation.accelerators;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.report.CReporter;
import com.automation.report.ReporterConstants;
import com.automation.support.ExcelReader;
/**
 * 
 * @author in01518
 *
 */
public class TestEngine {
	private static final Logger LOG = Logger.getLogger(TestEngine.class);
	//public static ExcelReader xlsrdr = new ExcelReader("C:\\Users\\IN01663\\workspace\\Shoebuy\\TestData\\TestData.xls","Test_Data");
	protected AppiumDriver appiumDriver = null;
	protected WebDriver Driver = null;
	protected CReporter reporter = null;
	private DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
		
	@BeforeTest

	@Parameters({"automationName","rotatable","safariAllowPopups","safariIgnoreFraudWarning","mbrowser","app","platformName","platformVersion", "deviceName","deviceID","appiumUrl","APP_PACKAGE","APP_ACTIVITY"})
	public void beforeTest(String automationName, String rotatable, String safariAllowPopups, String safariIgnoreFraudWarning, String mbrowser, String app,String platformName , String platformVersion, String deviceName, String deviceID, String appiumUrl, String APP_PACKAGE, String APP_ACTIVITY) throws MalformedURLException
	{
		
		capabilitiesForAppium.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
		capabilitiesForAppium.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300000");
		if(platformName.equals("iOS"))
		{
		capabilitiesForAppium.setCapability(MobileCapabilityType.ROTATABLE,rotatable.equalsIgnoreCase("true")== true ? true : false);
		capabilitiesForAppium.setCapability("safariAllowPopups",safariAllowPopups.equalsIgnoreCase("true")== true ? true : false);
		capabilitiesForAppium.setCapability("safariIgnoreFraudWarning",safariIgnoreFraudWarning.equalsIgnoreCase("true")== true ? true : false);
		capabilitiesForAppium.setCapability(MobileCapabilityType.BROWSER_NAME, mbrowser);
		capabilitiesForAppium.setCapability(MobileCapabilityType.APP,app);
		
				
		/**/
		capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
		capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
		capabilitiesForAppium.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);		
		capabilitiesForAppium.setCapability("udid",deviceID);	
		capabilitiesForAppium.setCapability(MobileCapabilityType.APP_PACKAGE,APP_PACKAGE);
		capabilitiesForAppium.setCapability(MobileCapabilityType.APP_ACTIVITY,APP_ACTIVITY);
		appiumDriver = new IOSDriver(new URL(appiumUrl), capabilitiesForAppium);
		reporter = CReporter.getCReporter(deviceName, platformName, platformVersion, true);	
		
		}
		if(platformName.equalsIgnoreCase("android"))
		{
			capabilitiesForAppium.setCapability(MobileCapabilityType.ROTATABLE,rotatable.equalsIgnoreCase("true")== true ? true : false);
			
			capabilitiesForAppium.setCapability(MobileCapabilityType.BROWSER_NAME, mbrowser);	
			
					
			/**/
			capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
			capabilitiesForAppium.setCapability(MobileCapabilityType.PLATFORM_VERSION,platformVersion);
			capabilitiesForAppium.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);		
			capabilitiesForAppium.setCapability("udid",deviceID);
			capabilitiesForAppium.setCapability(MobileCapabilityType.APP_PACKAGE,APP_PACKAGE);
			capabilitiesForAppium.setCapability(MobileCapabilityType.APP_ACTIVITY,APP_ACTIVITY);
			reporter = CReporter.getCReporter(deviceName, platformName, platformVersion, true);	
			appiumDriver = new AndroidDriver(new URL(appiumUrl), capabilitiesForAppium);
		}
		
		//appiumDriver.get(ReporterConstants.APP_BASE_URL);
		appiumDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		reporter.calculateSuiteStartTime();	
		
	}
		
	
	

	
	@AfterTest
	@Parameters({"deviceName","platformName","platformVersion"})
	public void afterTest(String deviceName, String platformName, String platformVersion) throws Exception
	{
	
		//get browser info
		
		//reporter = CReporter.getCReporter(deviceName, platformName, platformVersion, true);
		appiumDriver.close();
		appiumDriver.quit();
		reporter.calculateSuiteExecutionTime();
		reporter.createHtmlSummaryReport(ReporterConstants.APP_BASE_URL,true);
		reporter.closeSummaryReport();
	
		
	}
	
	@BeforeMethod
	@Parameters({"deviceName","platformName","platformVersion"})
	public void beforeMethod(Method method,String deviceName, String platformName, String platformVersion)
	{
		//get browser info		
		
		reporter = CReporter.getCReporter(deviceName, platformName, platformVersion, true);	
		reporter.initTestCase(this.getClass().getName().substring(0,this.getClass().getName().lastIndexOf(".")), method.getName(), null, true);
	}
	
	@AfterMethod
	@Parameters({"deviceName","platformName","platformVersion"})
	public void afterMethod(Method method, String deviceName, String platformName, String platformVersion) throws IOException
	{
		//get browser info
				
		//reporter = CReporter.getCReporter(deviceName, platformName, platformVersion, true);				
		reporter.calculateTestCaseExecutionTime();		
		reporter.closeDetailedReport();		
		reporter.updateTestCaseStatus();
	}
	
	
}
