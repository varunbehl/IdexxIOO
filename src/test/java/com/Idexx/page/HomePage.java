package com.Idexx.page;

import org.openqa.selenium.By;

import com.automation.accelerators.ActionEngine;

public class HomePage extends ActionEngine {


	// idexx ecommerce application elements
	
	public static By createAccountBtn;

	public static By signInBtn;
	public static By orderNowBtn;
	public static By viewOrderBtn;

	public static By productSearchField;
	public static By productSearchField2;
	public static By favOrdernameField;
	public static By addToFavOrderBtn;
	public static By qtyField;
	public static By arrivalDayDropdown;

	public static By viewSavedOrderTxt;
	public static By editBtn;
	public static By editSavedOrderTxt;
	public static By savedOrderConfirmationTxt;
	public static By orderNameTxt;
	public static By closeBtn;





	public  static By favSaveBtn;
	public static By searchIcon;
	public static By searchIcon2;
	public static By addToCartBtn;
	public static By homeBtn;
	public static By deleteIcon;
	public static By addToCartLink;



	public static By searchResultPopup;
	public static By nextBtn;
	public static By nextBtn_Fr;
	public static By deleteScheduleOrderBtn;
	public static By submitOrderBtn;
	public static By submitOrderBtn2;
	public static By submitOrderBtn3;
	public static By submitOrderCheckbox1;
	public static By submitOrderCheckbox_FR;
	public static By submitOrderBtn_FR;
	public static By submitOdrBtn;
	public static By OrderNumberText;
	public static By ScheduleOrderNumberText;
	public static By ScheduleOrderConfirmation;
	public static By ScheduleConfirmationText;
	public static By thankyouText;
	public static By thankyouConfirmation;
	public static By favOrderConfirmationMsg;
	public static By favOrderNameText;
	public static By scheduleOrderConfirmationText;











	

	// public static By filter ;

	public static By myTasksSectionHead;
	public static By newTaskBtn;
	public static By homePageTab;
	public static By myTaskTableHeader;
	public static By calenderSectionHead;
	public static By scheduledMeetings;
	public static By requestedMeetings;
	public static By rolePick;
	public static By crossMark;
	public static By nextBtn1;
	public static By toggle;

	public static By search;
	public static By SearchButton;
	public static By SearchResultPage;
	public static By ActValue;
	public static By tableData;
	public static By Accounts_Results;
	public static By Accounts_Results_Account;
	public static By SearchAll;
	public static By Accounts_Title;
	public static By LogOut_Menu;
	public static By LogOut_btn;
	public static By SetUp;

	public static By Hometab;
	public static By allTabs;
	public static By customizetabbtn;
	public static By rightArrow;
	public static By leftArrow;
	public static By saveBtn;
	public static By firstDisplayedTab;
	public static By searchCountReturned;
	
	//After Search
	public static By accountsHyperlink;
	public static By showMoreLink_AccountsBody;
	public static By reportsTab;
	public static By contactsHyperlink;
	public static By showMoreLink_contactsBody;
	public String abc;
	
	
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void Home_Page()

	{
		//idexx locator
		createAccountBtn = By.className("btnregister");
		signInBtn= By.className("btnlogin");
		orderNowBtn= By.className("respxs_hide");
		viewOrderBtn=By.xpath("//input[@class='b_gotobas']");
		favOrdernameField=By.xpath("//input[@name='m_ba_bd_LS_H-REFNO']");
		addToFavOrderBtn=By.id("zzbas1salesorder_savetempl");
		favSaveBtn=By.xpath("//input[@value='Save']");
		qtyField= By.xpath("(//input[@id='QUANT'])[1]");
		productSearchField= By.id("artikel1001");
		productSearchField2= By.id("artikel1002");
		searchIcon= By.id("searchIcon1001");
		searchIcon2= By.id("searchIcon1002");
		addToCartBtn=By.xpath("(//div[@class='vbutton'])[3]");
		addToCartLink=By.xpath("//a[contains(@id,'zzbascatres_addtoorder')]");
		homeBtn=By.xpath("//a[@class='home']");
		searchResultPopup=By.xpath("//div[@id='searchResult']");
		//nextBtn=By.xpath("//input[@value='Next']");
		nextBtn=By.xpath("(//input[@type='button'])[1]");
		nextBtn_Fr=By.xpath("//input[@value='Suivant']");
		deleteScheduleOrderBtn=By.xpath("//input[@value='Delete Scheduled Order']");
		submitOrderBtn=By.xpath("(//input[@id='zzpay_send'])[1]");
		submitOrderBtn2=By.xpath("(//input[@type='button'])[1]");
		submitOrderBtn3=By.xpath("(//input[@type='button'])[1]");
		submitOdrBtn=By.xpath("(//input[@type='button'])[1]");
		submitOrderCheckbox_FR=By.id("zzacctrm");
		submitOrderCheckbox1=By.id("acctrm");
		submitOrderBtn_FR=By.xpath("(//input[@value='soumettre la commande'])[1]");

		viewSavedOrderTxt=By.xpath("//div[@id='docdetail']/h1");
		editBtn=By.xpath("//input[@value='Edit']");
		editSavedOrderTxt=By.xpath("//div/h1[@class='zznomargin']");
		saveBtn=By.xpath("//input[@value='Save']");
		savedOrderConfirmationTxt=By.xpath("//h1[contains(text(),'Saved Order - confirmation')]");
		orderNameTxt=By.xpath("((//div[@class='highlightbox row zzno_border zzpadding_top']/div)[1]/p)[1]/span");
		closeBtn=By.xpath("//input[@value='Close']");

		OrderNumberText=By.xpath("//div[@class='form form-stacked orderheader-form']/div/h4/span");
		ScheduleOrderNumberText=By.xpath("(//div[@class='form-group col-resp-100']/strong)[1]");
		ScheduleOrderConfirmation=By.xpath("//div[@id='basbody2']/h1");
		ScheduleConfirmationText=By.xpath("//div[@id='basbody2']/p");
		thankyouText=By.xpath("//div[@class='form-group col-resp-75']/h1");
		thankyouConfirmation=By.xpath("//div[@class='form-group col-resp-75']/p");
		favOrderConfirmationMsg=By.xpath("//h1[@class='zznomargin']");
		scheduleOrderConfirmationText=By.xpath("//h1[@class='zznomargin']");
		deleteIcon=By.xpath("(//td[@class='center rt_primary']/a/i)[1]");
		arrivalDayDropdown=By.xpath("//select[@name='m_ba_bd_LS_H-ZZARDAY']");

			myTasksSectionHead = By.xpath("//h3[text()='My Tasks']");
			newTaskBtn = By.xpath("//input[@title='New Task']");
			homePageTab = By.xpath(".//*[@id='home_Tab']/a");
			myTaskTableHeader = By
					.xpath(".//*[@id='actionForm']/div[2]/table/tbody/tr[1]/th");
			calenderSectionHead = By.xpath("//h3[text()='Calendar']");

			scheduledMeetings = By.xpath("//*[@id='homeCalRegEventTab']");
			requestedMeetings = By.xpath("//*[@id='homeCalProposedEventTab']");

			rolePick = By.xpath(".//*[@id='sales-rep-choice']/div");
			nextBtn1 = By.xpath(".//*[@title='Go to the next step']");
			crossMark = By
					.xpath(".//*[@id='walkthrough-callout-close']/img[1]");
			toggle = By.xpath(".//*[@id='walkthrough-sidebar-toggle']/img");
			search = By.xpath(".//*[@id='phSearchInput']");

			SearchButton = By.xpath(".//*[@id='phSearchButton']");
			SearchResultPage = By.xpath(".//*[@id='bodyTable']/tbody/tr/td/div[1]/div[1]/div[1]/h1");
			ActValue = By.xpath(".//*[@id='ext-gen1']/span[2]");
			tableData = By.xpath(".//*[@id='Account_body']/table");
			Accounts_Results = By
					.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a");
			Accounts_Results_Account= By
					.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a");
			SearchAll = By
					.xpath(".//*[@id='searchAllSummaryView']");
			Accounts_Title = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
			LogOut_Menu = By.xpath(".//*[@id='userNav-arrow']");
			LogOut_btn = By.xpath(".//*[@id='userNav-menuItems']/a[3]");
			SetUp = By.xpath(".//*[@id='setupLink']");

			Hometab = By.linkText("Home");
			allTabs = By.xpath(".//*[@id='AllTab_Tab']/a/img");
			customizetabbtn = By.name("customize");
			rightArrow = By.xpath(".//*[@id='duel_select_0_right']/img");
			leftArrow = By.xpath(".//*[@id='duel_select_0_left']/img");
			//saveBtn = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
			firstDisplayedTab = By.xpath("//*[@id='duel_select_0']/option[1]");
			searchCountReturned = By.xpath(".//*[@id='sidetabLink-001']/a[1]/span[2]");

			//After search
			accountsHyperlink = By.xpath(".//*[@class='truncate'][text()='Accounts']");
			showMoreLink_AccountsBody = By.xpath(".//*[@id='Account_body']//a[text()='Show More']");
			reportsTab = By.xpath(".//*[@id='report_Tab']/a");

			//After search
			contactsHyperlink = By.xpath(".//*[@class='truncate'][text()='Contacts']");
			showMoreLink_contactsBody = By.xpath(".//*[@id='Contact_body']//a[text()='Show More']");



	}
     public static By favOrderNameText(String value)
	 {
		 favOrderNameText=By.xpath("//span[contains(text(),'"+value+"')]");
		 return  favOrderNameText;
	 }


}