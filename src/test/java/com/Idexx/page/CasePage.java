package com.Idexx.page;

import org.openqa.selenium.By;

public class CasePage {

	public static By MyAccount;
	public static By Acconts_Detail;
	public static By NewContact;
	public static By NewAccount;
	
	public static By AccountName;
	public static By AccountNumber;
	public static By AccountSite;
	public static By BillingCity;
	public static By Description;
	
	public static By AccountSave;
	public static By NewCase;
	
	public static By OpportunityName;
	public static By CloseDate;
	public static By NextStep;
	public static By NewOpp_Description;
	public static By BusinessUnit;
	public static By Industry;
	public static By OpportunityRecordType;
	public static By OpportunityRecordType_Con;
	public static By Stage;
	public static By Probability ;
	
	public static By newCase;
	public static By status;
	public static By caseOrigin;
	public static By contactName; 
	public static By change;
	public static By owner;
	public static By setUp;
	public static By caseEscalations; 
	public static By caseReason;
	public static By division;
	public static By product;
	public static By caseSubReason;
	public static By createdCases;
	public static By changeOwner;
	public static By caseAction;
	public static By caseResolution;
	public static By caseSubject;
	public static By caseDesc;
	public static By caseComments;
	public static By caseError;
	public static By contactNameAfterSave;
	public static By newDealSupportRequest;
	public static By caseEditPage;
	public static By caseContactName;
	public static By dealCaseOriginError;
	public static By caseOpportunity;
	public static By caseOpportunityErrorDesc;
	public static By caseOwnerChange;
	public static By caseText;
	public static By topNameDisplayedCase;
	
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void Case_Page()

	{
		//if (configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen")) 
		{

			MyAccount = By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a");
			CloseDate = By.xpath(".//*[@class='dateFormat']/a");
			Acconts_Detail = By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2");
			NewContact = By.xpath(".//*[@name='new']");
			NewAccount = By.xpath(".//*[@name='new']");
			AccountName = By.xpath(".//*[@id='acc2']");
			AccountNumber = By.xpath(".//*[@id='acc5']");
			AccountSite = By.xpath(".//*[@id='acc23']");
			BillingCity = By.xpath(".//*[@id='acc17city']");
			
			Description = By.xpath(".//*[@id='acc20']");
			AccountSave = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
			NewCase = By.xpath(".//*[@name='newCase']");
			OpportunityName = By.xpath(".//*[@id='j_id0:tenderForm:tenderBlock0:j_id264:j_id265:j_id269']");
			NextStep = By.xpath(".//*[@id='opp10']");
			NewOpp_Description = By.xpath(".//*[@id='opp14']");
			BusinessUnit = By.xpath(".//*[@id='00N21000000Nl4N']");
			Industry = By.xpath(".//*[@id='acc7']");
			OpportunityRecordType = By.xpath(".//*[@id='j_id0:form0:j_id27:j_id31:j_id32:j_id35']/select");
			OpportunityRecordType_Con = By.xpath(".//*[@value='Continue']");
			Stage = By.xpath(".//*[@id='j_id0:tenderForm:tenderBlock0:j_id264:j_id286:negativeStageId']");
			Probability = By.xpath(".//*[@value='Continue']");
			
			newCase = By.xpath(".//*[contains(@id,'RelatedCaseList')]/div[1]/div/div[1]/table/tbody/tr/td[2]/input");
			status = By.xpath(".//*[@id='cas7']");
			caseOrigin = By.xpath(".//label[contains(text(),'Case Origin')]/parent::td/following-sibling::td[1]//select");
			contactName = By.xpath(".//label[contains(text(),'Contact Name')]/parent::td/following-sibling::td[1]//span[1]/input[1]");
			change = By.xpath(".//*[@id='cas1_ileinner']/a");
			owner = By.xpath(".//*[@id='newOwn']");
			setUp = By.xpath(".//*[@id='setupLink']");
			caseEscalations = By.xpath("//*[@id='DataManagementManageCaseEscalation_font']");
			division = By.xpath(".//label[text()='Division']/parent::td/following-sibling::td[1]//select");
			caseReason = By.xpath(".//label[text()='Case Reason']/parent::td/following-sibling::td[1]//select");
			product =By.xpath(".//label[text()='Product']/parent::td/following-sibling::td[1]//select");
			caseSubReason = By.xpath(".//label[text()='Case Sub-Reason']/parent::td/following-sibling::td[1]//select");
			createdCases = By.xpath(".//*[contains(@id,'RelatedCaseList_body')]/table");
			changeOwner = By.xpath(".//*[@id='cas1_ileinner']/a[2]");
			caseAction = By.xpath(".//label[contains(text(),'Case Actions')]/parent::td/following-sibling::td[1]//span[1]/select");
			caseResolution = By.xpath(".//label[contains(text(),'Case Resolution')]/parent::td/following-sibling::td[1]//span[1]/select");
			caseSubject = By.xpath(".//label[contains(text(),'Subject')]/parent::td/following-sibling::td[1]//input");
			caseDesc = By.xpath(".//label[contains(text(),'Description')]/parent::td/following-sibling::td[1]//textarea");
			caseComments = By.xpath(".//label[contains(text(),'Internal Comments')]/parent::td/following-sibling::td[1]//textarea");
			caseError = By.xpath(".//label[contains(text(),'Contact Name')]/parent::td/following-sibling::td[1]//div[2]");
			contactNameAfterSave = By.xpath(".//*[@class='detailList']/tbody/tr[2]/td[2]/div/a");
			newDealSupportRequest = By.xpath(".//*[@value='New Deal Support Request']");
			caseEditPage = By.xpath(".//h1[text()='Case Edit']");
			caseContactName = By.xpath(".//label[contains(text(),'Contact Name')]/parent::td/following-sibling::td[1]//span/input");
			dealCaseOriginError = By.xpath(".//label[contains(text(),'Case Origin')]/parent::td/following-sibling::td[1]//div[2]");
			caseOpportunity = By.xpath(".//label[contains(text(),'Opportunity')]/parent::td/following-sibling::td[1]//span/input[1]");
			caseOpportunityErrorDesc = By.xpath(".//*[@id='bodyTable']/tbody/tr[1]/td[2]/form/div/div[2]/div[1]");
			caseOwnerChange = By.xpath(".//td[text()='Case Owner']/parent::tr/td[2]/div/a[1]");
			caseText = By.xpath(".//h2[@class='pageDescription']");
			topNameDisplayedCase = By.xpath(".//*[@class='headerRow']/parent::tbody/tr[2]/th[1]/a");
		}
		

	}
}
