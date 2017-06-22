package com.Idexx.page;

import org.openqa.selenium.By;

import com.automation.accelerators.ActionEngine;


public class ContactsPage extends ActionEngine {

	//idexx locators elements
	public static By firstName;
	public static By lastName;
	public static By email;
	public static By confirmEmail;
	public static By countryDropdown;
	public static By privacyPolicyCheckbox;
	public static By pwd;
	public static By createAccountBtn;
	public static By idexxAccountNumber;
	public static By postCode;
	public static By submitBtn;
	
	
	public static By jobTitleDropdown;
	public static By finishBtn;
	public static By successMsg;
	public static By username;
	public static By password;
	public static By signIn;

	public static By saveForLaterBtn;
	public static By orderNameDialogeBox;

	public static By  orderNameField;
	public static By orderNameDialogeOKBtn;
	public static By myOrdersBtn;
	public static By savedOrdersLink;
	public static By orderNowLink;
	public static By orderNoVerify;
	public static By deleteLink;

	public static By reOrderOptionBtn;
	public static By favoriteOrdersLink;
	public static By newFavoriteOrdersBtn;


	
	
	
	public static By contactTab ;
	public static By viewDropdown;
	public static By goButton;
	public static By firstContactDisplayed;
	public static By firstContactDisplayedLink;
	public static By topNameDisplayedOnContactHeader;
	public static By newContactBtn;
	public static By salutionDropDown;
	//public static By firstName;
	public static By middleName;
	public static By lastname;
	public static By accountName;
	//public static By email;
	public static By mobile;
	public static By saveBtn;
	public static By saveNewBtn;
	public static By newAccountInAccountSection;
	public static By newAccountName;
	public static By businessUnitDropdown;
	public static By industryDropdown;
	public static By primaryContact;
	
	public static By accountNameDisplayed;
	
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void CreateContactPage(){
		
		firstName = By.id("givenName");
		lastName = By.id("familyName");
		email = By.id("email");
		confirmEmail = By.id("email_confirm");
		countryDropdown = By.id("country");
		 privacyPolicyCheckbox = By.id("privacy");
		 pwd= By.id("password");
		 createAccountBtn = By.id("submit");
		 username=By.id("username");
		 password=By.id("password");
		signIn=By.xpath("//input[@id='submit']");
	}
   public void BusinessAffiliationPage(){
		
	  idexxAccountNumber = By.xpath("//input[@id='accountNumber']");
		postCode = By.xpath("//input[@id='postalCode']");
		submitBtn = By.id("submit");
		jobTitleDropdown = By.xpath("//select[@id='jobTitleId']");
		finishBtn = By.xpath("//input[@id='submit']");
		successMsg=By.id("congrats");
		
	}

	public void OrderPage(){

		saveForLaterBtn=By.id("zzbas1salesorder_onetimetempl");
        orderNameDialogeBox=By.className("vex-dialog-form");
		orderNameField=By.className("vex-dialog-prompt-input");

		orderNameDialogeOKBtn=By.xpath("//*[@class='vex-dialog-button-primary vex-dialog-button vex-first']");
		myOrdersBtn=By.xpath("(//li[@class='zzjetborder']/a)[3]");
		savedOrdersLink=By.xpath("((//li[@class='zzjetborder'])[3]/ul/li/a)[1]");


		favoriteOrdersLink= By.xpath("(//li[@class='zzjetborder'])[2]/ul/li[2]/a");
		orderNowLink=By.xpath("(//a[@class='zzlink_red'])[1]");
		orderNoVerify=By.xpath("//*[@class='contentrow1 zzhide479_tr']/td");
		deleteLink=By.xpath("(//a[contains(text(),'Delete')])[1]");
		reOrderOptionBtn= By.xpath("(//li[@class='zzjetborder']/a)[2]");
		newFavoriteOrdersBtn= By.xpath("//button[@type='button' and contains(text(),'New Favorite Order')]");




	}
   
	
	
	
	
public void  Contacts_Page()
	
	{
		//	 if(configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen"))
			{
				 contactTab = By.xpath(".//*[@id='Contact_Tab']/a");
				 viewDropdown = By.xpath(".//*[@id='fcf']");
				 goButton = By.xpath(".//input[@title='Go!']");
				 firstContactDisplayed = By.xpath(".//div[contains(@class,'x-grid3-row-first')]/table/tbody/tr[1]/td[4]/div/a/span");
				 firstContactDisplayedLink = By.xpath(".//div[contains(@class,'x-grid3-row-first')]/table/tbody/tr[1]/td[4]/div/a");
				 topNameDisplayedOnContactHeader = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
				 newContactBtn = By.xpath(".//input[@title='New Contact']");
				 
				 salutionDropDown = By.xpath(".//*[@title='Salutation']");
				 firstName = By.xpath(".//*[@id='name_firstcon2']") ;
				 middleName = By.xpath(".//*[@id='name_middlecon2']");
				 lastname = By.xpath(".//*[@id='name_lastcon2']");
				 accountName= By.xpath(".//*[@id='con4']");
				 email = By.xpath("//label[text()='Email']/..//following-sibling::td/input") ;
				 mobile = By.xpath("//label[text()='Mobile']/..//following-sibling::td/input");
				 saveBtn = By.xpath(".//*[@title='Save']");
				 saveNewBtn = By.xpath(".//*[@name='save_new']");
				 
				 newAccountInAccountSection = By.xpath(".//h3[text()='Accounts']//parent::td//following-sibling::td[1]/input[@title='New Account']");
				 newAccountName = By.xpath(".//label[contains(text(),'Account Name')]//parent::td/following-sibling::td[1]//input");
				 businessUnitDropdown = By.xpath(".//label[contains(text(),'Business Unit')]/parent::td/following-sibling::td[1]//select");
				 industryDropdown = By.xpath(".//label[contains(text(),'Industry')]/parent::td/following-sibling::td[1]//select");
				 primaryContact = By.xpath(".//label[contains(text(),'Primary Contact')]/parent::td/following-sibling::td[1]//span[@class='lookupInput']/input");
				 
				 accountNameDisplayed = By.xpath(".//td[text()='Account Name']/following-sibling::td/div/a");
				 
			}
		
	}
	
}