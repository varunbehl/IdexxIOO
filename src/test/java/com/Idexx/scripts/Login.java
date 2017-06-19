package com.Idexx.scripts;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Idexx.libs.IdexxLib;
import com.automation.utilities.TestUtil;


public class Login extends IdexxLib {

	String loginUser;

	@Parameters({"userrole"})
	@BeforeMethod
	public void login(String userrole) throws Throwable{
		loginUser = userrole;
	}

	@Test(priority=1)
	public void TestLogin() throws Throwable {
		try {
		
				this.reporter.initTestCaseDescription( "TC1.1");
				Hashtable<String, String> data = TestUtil.getDataSignUp(loginUser,"login");
				
				System.out.println("user role -> " + loginUser);
				System.out.println("username -> " + data.get("username"));
				
				doLogin(data.get("username"), data.get("password"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void dologout() throws Throwable{
		doLogout();	
	}
}
