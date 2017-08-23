package com.Idexx.CucumberScripts;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by e002222 on 27-07-2017.
 */

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "src/test/resources/features/google.feature",

        plugin = {"pretty", "html:target/cucumber-html-report" ,"json:target/cucumber1.json"})


public class LoginRunner2 extends AbstractTestNGCucumberTests{

}



