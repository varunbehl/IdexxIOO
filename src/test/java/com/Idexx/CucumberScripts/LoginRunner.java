package com.Idexx.CucumberScripts;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by e002222 on 27-07-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        monochrome = true,
        features = {"src/test/resources/features"},
        tags = {"~@ignore"},
        plugin = {"pretty", "html:target/cucumber-html-report" ,"json:target/cucumber.json"})


public class LoginRunner  extends AbstractTestNGCucumberTests{

}



