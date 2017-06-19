package com.Idexx.page;

import org.openqa.selenium.By;

public class OpportunityPage {
	public static By AccountTab ;
	public static By Acconts_Display;
	public static By Account_Go_cigniti1_title;
	public static By New_Opp;
	public static By New_Opp_Title;
	public static By Opportunity_Name;
	public static By Opportunity_Type;
	public static By Opportunity_Desc;
	public static By Opportunity_Stage_menu;
	public static By Opportunity_closeDate;
	public static By Opportunity_AcctName;
	public static By Opportunity_save;
	public static By Opportunity_Detail;
	public static By Opportunity_Probability;
	public static By Opportunity_Amount;
	public static By Opportunity_LeadSource;
	public static By Opportunity_NextStep;
	public static By newOpportunity;
	public static By newOpportunityNameVerify;
	public static By PrimaryCampaignSource;
	public static By lostReason;
	public static By LeadSource;
	public static By nextStep;
	
	//tender
	
	public static By TenderOpportunity_Name;
	public static By TenderOpportunity_Type;
	public static By TenderStartDate;
	public static By TendercloseDate;
	
	public static By TenderOpportunity_Stage;
	public static By TenderOpportunity_Probability;
	public static By TenderPrimaryCampaignSource;
	public static By TenderCurrency;
	public static By TenderAmount;	
	public static By TenderOpportunity_EndDate;
	public static By TenderOpportunity_AcctName;
	public static By TenderOpportunityLostReason;
	public static By TenderOpportunityPeroid;
	public static By TenderOpportunity_syncCommitments;
	public static By Submit;
	public static By OpportunityHeader;
	public static By OpportunityCreateError;
	
	
	//Negative
	
	public static By Type;
	public static By Save;
	
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void  Opportunity()

	{
		//if(configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen"))
		{
			
			AccountTab = By.xpath(".//*[@id='Account_Tab']/a");
			Acconts_Display = By.xpath(".//*[@class='list']/tbody/tr[2]/th/a");
			Account_Go_cigniti1_title = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
			New_Opp = By.xpath(".//*[@id='00128000002TiYc_RelatedOpportunityList']/div[1]/div/div[1]/table/tbody/tr/td[2]/input");
			New_Opp_Title = By.xpath(".//*[@class='pageType']");
			Opportunity_Name = By.xpath(".//label[contains(text(),'Opportunity Name')]/parent::th/following-sibling::td[1]//input");
			Opportunity_Type = By.xpath(".//label[contains(text(),'Type')]/parent::th/following-sibling::td[1]//select");
			Opportunity_Desc = By.xpath(".//*[@class='detailList']/tbody/tr[2]/td[1]/textarea");
			Opportunity_Stage_menu = By.xpath(".//label[contains(text(),'Stage')]/parent::th/following-sibling::td//select");
			Opportunity_closeDate = By.xpath(".//*[@class='dateFormat']/a");
			Opportunity_AcctName = By.id(".//*[@class='detailList']/tbody/tr[2]/td/div/span[@class='lookupInput']/input[1]");
			Opportunity_save = By.xpath(".//*[@class='pbButtonb ']/input[1]");
			Opportunity_Detail = By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2");
			Opportunity_Probability = By.xpath(".//label[contains(text(),'Probability (%)')]/parent::th/following-sibling::td[1]//input");
			Opportunity_Amount = By.xpath(".//label[contains(text(),'Amount')]/parent::th/following-sibling::td[1]//input");
			Opportunity_LeadSource = By.xpath(".//label[contains(text(),'Lead Source')]/parent::th/following-sibling::td[1]//select");
			Opportunity_NextStep = By.xpath(".//*[@id='opp10']");
			newOpportunity = By.xpath(".//*[@value='New Opportunity']");
			newOpportunityNameVerify  = By.xpath(".//*[@id='opp3_ilecell']']");
			PrimaryCampaignSource  = By.xpath(".//*[@class='detailList']/tbody/tr[4]/td/span/input");
			lostReason  = By.xpath(".//*[@class='detailList']/tbody/tr[5]/td[2]/select");
			LeadSource  = By.xpath(".//label[contains(text(),'Lead Source')]/parent::th/following-sibling::td[1]//select");
			nextStep  = By.xpath(".//label[contains(text(),'Next Step')]/parent::th/following-sibling::td[1]//input");
			
			//Tender
			
			TenderOpportunity_Name = By.xpath(".//label[contains(text(),'Opportunity Name')]/parent::th/following-sibling::td[1]//input");
			TenderOpportunity_Type = By.xpath(".//label[contains(text(),'Opportunity Type')]/parent::th/following-sibling::td[1]//select");
			TenderStartDate = By.xpath(".//label[contains(text(),'Tender Start Date')]/parent::th/following-sibling::td[1]//span[@class='dateFormat']/a");
			TendercloseDate = By.xpath(".//label[contains(text(),'Tender Targeted Close Date')]/parent::th/following-sibling::td[1]//span[@class='dateFormat']/a");
			TenderOpportunity_Stage = By.xpath(".//label[contains(text(),'Stage')]/parent::th/following-sibling::td//select");
			TenderOpportunity_Probability = By.xpath(".//label[contains(text(),'Probability (%)')]/parent::th/following-sibling::td[1]//input");
			TenderPrimaryCampaignSource = By.xpath(".//label[contains(text(),'Primary Campaign Source')]/parent::th/following-sibling::td[1]//span[@class='lookupInput']/input");
			TenderOpportunity_AcctName = By.xpath(".//label[contains(text(),'Account Name')]/parent::th/following-sibling::td[1]//span[@class='lookupInput']/input");
		//	TenderCurrency = By.id(".//label[contains(text(),'Opportunity Currency')]/parent::th/following-sibling::td[1]//select");
			TenderAmount = By.xpath(".//label[contains(text(),'Amount')]/parent::th/following-sibling::td[1]//input");
			TenderOpportunity_EndDate = By.xpath(".//label[contains(text(),'Tender End Date')]/parent::th/following-sibling::td[1]//span[@class='dateFormat']/a");
			TenderOpportunityLostReason = By.xpath(".//label[contains(text(),'Lost Reason')]/parent::th/following-sibling::td[1]//select");
			TenderOpportunityPeroid= By.xpath(".//label[contains(text(),'Period')]/parent::th/following-sibling::td[1]//*[@role='presentation']/tbody/tr/td[2]/input");
			TenderOpportunity_syncCommitments= By.xpath(".//*[@value='Sync Commitments']");
			Submit = By.xpath(".//*[@value='Submit']");
			
			
			//negative
			
			Type = By.xpath(".//label[contains(text(),'Type')]/parent::th/following-sibling::td[1]//select");
			Save = By.xpath(".//*[@value='Save']");
			OpportunityHeader = By.xpath(".//*[@class='pageDescription']");
			OpportunityCreateError = By.xpath(".//*[@class='messageTable']/tbody/tr[1]/td[2]/div");
		}

	}
}
