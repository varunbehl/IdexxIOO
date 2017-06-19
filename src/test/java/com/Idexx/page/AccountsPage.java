package com.Idexx.page;

import org.openqa.selenium.By;

public class AccountsPage {
	public static By accountsDetailSection;
	public static By editBtn;
	public static By lpdBusinessPlanTextArea;
	public static By save;
	public static By lpdBussinessAreaTextAfterSave;
	public static By Hierarchy_Row;
	public static By accountTeamHyperlink;
	public static By teamMember;
	public static By teamRole;
	public static By topNameDisplayedOnContactHeader;
	public static By openActivitiesHyperlink;
	public static By openActivities_subjectOnMouseHover;
	public static By openActivities_relatedTo;
	public static By baseAccount;
	public static By viewHierarchy_ParentAccount;
	public static By viewHierarchy_GrandParentAccount;
	public static By competitorProductsName;
	public static By competitorProductDetailPageTitle;
	public static By competitorProductsNameOnCompetitorsPage;
	public static By contactsHyperlink;
	public static By contacts_contactNameOnMouseHover;
	public static By opportunitiesHyperlink;
	public static By opportunity_nameOnMouseHover;
	public static By opportunity_stageOnMouseHover;
	public static By accountsTab;
	public static By listview;
	public static By goButton;
	public static By accountData;
	public static By accountName;
	public static By accountDetail;
	public static By edit;
	public static By postalZip;
	public static By territoriesSave;
	public static By billingCountry;
	public static By shippingCountry;
	public static By newContactButton;
	public static By accountDetail_AccountName;
	public static By view_Hierarchy;
	public static By newAccount;
	public static By name = By.xpath(".//label[text()='Account Name']/parent::td/following-sibling::td[1]//input");
	public static By industry = By.xpath(".//label[text()='Industry']/parent::td/following-sibling::td[1]//select");
	public static By businessUnit = By.xpath(".//label[text()='Business Unit']/parent::td/following-sibling::td[1]//select");
	public static By type = By.xpath(".//*[@id='acc6']");
	public static By descText = By.xpath(".//*[@id='ep']/div[2]/div[2]/table/tbody/tr/td[2]/div");
	public static By AccountTab = By.xpath(".//*[@id='Account_Tab']/a");
	public static By AccountTitle = By.xpath(".//*[@class='pageType']");
	public static By Acconts_DropDown = By.xpath(".//*[@title='View:']");
	public static By GoBtn = By.xpath(".//*[@title='Go!']");
	public static By Account_Go_cigniti1 = By.xpath(".//*[@id='00128000002TiYc_Name']/a/span");
	public static By Account_Go_cigniti1_title = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
	public static By newAccount_title = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
	
	public void AccountsPage()

	{
		//if(configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen"))
		{
			accountsDetailSection = By.xpath("//h2[@class='mainTitle'][text()='Account Detail']");
			editBtn = By.xpath(".//*[@id='topButtonRow']//*[@name='edit']");
			lpdBusinessPlanTextArea =  By.xpath(".//label[text()='LPD Business Plan']/parent::span/parent::td/following-sibling::td[1]/textarea");
			save = By.xpath(".//td[@id='topButtonRow']/*[@title='Save']");
			lpdBussinessAreaTextAfterSave = By.xpath(".//span[text()='LPD Business Plan']//parent::td//following-sibling::td[1]/div");
			Hierarchy_Row = By.xpath(".//*[@class='detailList']/tbody/tr[2]/td[4]/div");
			accountTeamHyperlink = By.xpath(".//*[@class='listTitle'][text()='Account Team']");
            teamMember = By.xpath(".//*[contains(@id,'RelatedAccountSalesTeam_body')]/table/tbody/tr[2]/th/a");
            teamRole = By.xpath(".//*[contains(@id,'RelatedAccountSalesTeam_body')]/table/tbody/tr[2]/td[2]");
            topNameDisplayedOnContactHeader = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
            openActivitiesHyperlink = By.xpath(".//*[@class='listTitle'][text()='Open Activities']");
            openActivities_subjectOnMouseHover = By.xpath(".//*[contains(@id,'RelatedActivityList_body')]/table/tbody/tr[2]/th/a");
            openActivities_relatedTo= By.xpath(".//*[contains(@id,'RelatedActivityList_body')]/table/tbody/tr[2]/td[3]/a");
            baseAccount = By.xpath(".//div[@class='relatedAccountHierarchy']//div[2]/table/tbody/tr[4]/th[1]/a");
            viewHierarchy_ParentAccount = By.xpath(".//div[@class='relatedAccountHierarchy']//div[2]/table/tbody/tr[3]/th[1]/a");
            viewHierarchy_GrandParentAccount = By.xpath(".//div[@class='relatedAccountHierarchy']//div[2]/table/tbody/tr[2]/th[1]/a");
            competitorProductsName = By.xpath(".//h3[text()='Competitor Products']//ancestor::div[@class='pbHeader']//following-sibling::div[1]//tr[2]/th[1]/a");
            competitorProductDetailPageTitle = By.xpath(".//h2[@class='mainTitle'][text()='Competitor Product Detail']");
            competitorProductsNameOnCompetitorsPage = By.xpath(".//td[text()='Competitor Products Name']/following-sibling::td[1]/div");
            contactsHyperlink = By.xpath(".//*[@class='listTitle'][text()='Contacts']");
            contacts_contactNameOnMouseHover = By.xpath(".//*[contains(@id,'RelatedContactList_body')]/table/tbody/tr[2]/th/a");
            opportunitiesHyperlink = By.xpath(".//*[@class='listTitle'][text()='Opportunities']");
            opportunity_nameOnMouseHover = By.xpath(".//*[contains(@id,'RelatedOpportunityList_body')]/table/tbody/tr[2]/th/a");
            opportunity_stageOnMouseHover = By.xpath(".//*[contains(@id,'RelatedOpportunityList_body')]/table/tbody/tr[2]/td[2]");
            accountsTab = By.xpath("//a[text()='Accounts']");
			listview = By.xpath(".//*[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']");
			goButton = By.xpath(".//*[@title='Go!']");
			accountData = By.xpath(".//*[@id='ext-gen24']");
			
			accountName = By.xpath(".//*[@id='00121000002LlPb_Name']/a/span");
			accountDetail = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
			
			edit = By.xpath(".//*[@id='topButtonRow']/input[3]");
			postalZip = By.xpath(".//*[@id='acc17zip']");
			territoriesSave = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
			billingCountry = By.id("acc17country");
			shippingCountry = By.id("acc18country");
			newContactButton= By.xpath(".//*[@value='New Contact']");
			 accountDetail_AccountName = By.xpath(".//a[text()='[View Hierarchy]']/parent::div");
			 view_Hierarchy = By.xpath(".//a[text()='[View Hierarchy]']");
			 newAccount = By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input");
		}

	}
}
