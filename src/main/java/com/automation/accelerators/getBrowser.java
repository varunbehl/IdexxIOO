package com.automation.accelerators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

/**
 * Created by e002222 on 08-08-2017.
 */
public class getBrowser {
    public WebDriver driver;
    public String browser = null;
    public String version = null;
    public String platform = null;
    public String environment = null;
    public String automationName = null;

    @BeforeSuite(alwaysRun = true)
    //@BeforeTest
    @Parameters({"automationName", "browser", "browserVersion", "environment", "platformName"})
    public void beforeTest(String automationName, String browser, String browserVersion, String environment, String platformName) throws IOException, InterruptedException {
		/*PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Log.properties");
		   System.out.println(System.getProperty("user.dir")+"\\Log.properties");*/

		/*get configuration */
        this.automationName = automationName;
        this.browser = browser;
        this.version = browserVersion;
        this.platform = platformName;
        this.environment = environment;


		/**/
        System.out.println(environment);

        if (environment.equalsIgnoreCase("local")) {
            this.setWebDriverForLocal(browser);
        }
    }

    public void setWebDriverForLocal(String browser) throws IOException, InterruptedException {
        switch (browser) {
            case "firefox":
                Thread.sleep(13000);
                this.driver = new FirefoxDriver();
                Thread.sleep(5000);
                break;
            case "ie":
                Thread.sleep(10000);
                System.out.println("iam in case IE");
                DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
                capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capab.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
                //capab.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, INIT_PAGE);

                File file = new File("Drivers\\IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
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
                Thread.sleep(10000);
                break;


            case "Safari":

                for (int i = 1; i <= 10; i++) {

                    try {
                        this.driver = new SafariDriver();

                        break;
                    } catch (Exception e1) {
                        Runtime.getRuntime().exec("taskkill /F /IM Safari.exe");
                        Thread.sleep(3000);
                        Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
                        Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");

                        continue;

                    }

                }

        }

    }
}