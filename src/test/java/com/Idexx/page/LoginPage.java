package com.Idexx.page;

import org.openqa.selenium.By;
import com.automation.accelerators.ActionEngine;

public class LoginPage extends ActionEngine {

	public static By userName;
	public static By password;
	public static By loginBtn;
	public static By verificationCode_saveBtn;

	public void Login_Page()

	{
		 {

			userName = By.xpath(".//*[@id='username']");
			password = By.xpath("//*[@id='password']");
			loginBtn = By.xpath("//*[@id='Login']");
			verificationCode_saveBtn = By.xpath(".//*[@id='save']");
		}
	}
}