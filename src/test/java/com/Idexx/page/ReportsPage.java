package com.Idexx.page;

import org.openqa.selenium.By;
import com.automation.accelerators.ActionEngine;

public class ReportsPage extends ActionEngine {

	public static By newReportButton;
	public static By accountsAndContactsNode;
	public static By accountsChildNode;
	public static By createButton;
	public static By fromDate;
	public static By addButton;
	public static By add_FilterByDropDown;
	public static By byAccountNameOption;
	public static By add_FilterComparator;
	public static By byEqualsOption;
	public static By add_FilterInputBox;
	public static By add_FilterOk;
	public static By runReport;
	public static By showDropdownXpath;
	public static By allAccountsXpath;

	public void Reports_Page()

	{
		 {

			newReportButton = By.xpath(".//*[@value='New Report...']");
			accountsAndContactsNode = By.xpath(".//span[text()='Accounts & Contacts']");
			accountsChildNode = By.xpath(".//span[text()='Accounts']");
			createButton = By.xpath(".//input[@value='Create']");
		/*	showDropDown = By.xpath(".//*[@name='scope']");
			dateFieldDropDown = By.xpath(".//*[@name='dateColumn']");*/
			fromDate = By.xpath(".//*[@name='startDate']");
			addButton = By.xpath(".//button[text()='Add']");
			add_FilterByDropDown = By.xpath(".//div[contains(@id,'filter-prefix-id')]/following-sibling::div[1]/img");
			byAccountNameOption = By.xpath(".//*[@class='x-combo-list-item'][text()='Account Name']");
			add_FilterComparator = By.xpath(".//div[contains(@id,'filter-prefix-id')]/following-sibling::div[2]/img");
			byEqualsOption = By.xpath(".//*[contains(@class,'x-combo-list-item')][text()='equals']");
			add_FilterInputBox = By.xpath(".//div[contains(@id,'filter-prefix-id')]/following-sibling::div[3]/input");
			showDropdownXpath = By.xpath(".//*[@name='scope']");
			allAccountsXpath = By.xpath(".//*[text()='All accounts']");
			add_FilterOk = By.xpath(".//button[text()='OK']");
			runReport = By.xpath(".//button[text()='Run Report']");
		}
	}
}