package com.Idexx.page;

import org.openqa.selenium.By;

public class ActivityPage {
	public static By AccountTab ;
	public static By AccountTab_new;
	public static By ActivityPage_Stage_menu;
	public static By ActivityPage_closeDate;
	public static By ActivityPage_AcctName;
	public static By ActivityPage_save;

	public static By Accountstab;
	public static By view;
	public static By gobtn;
	public static By Accountname;
	public static By newcontactbtn;
	public static By Contact_Firstname;
	public static By Contact_Lastname;
	public static By Contact_savebtn;
	public static By newtaskbtn;
	public static By cancelbtn;
	public static By logacallbtn;
	public static By log_subject;
	public static By log_Name;
	public static By log_Comments;
	public static By log_subject1;
	public static By log_Comments1;
	public static By log_savebtn;
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
	public static By Opportunity_detailpage;
	public static By Opportunity_logacall;
	public static By Opportunity_taskEditPage;
	public static By Opportunity_taskname;
	public static By Opportunity_subject;
	public static By Opportunity_createdActivity;
	public static By Opportunity_contactName;
	public static By contact_logacall;
	public static By contact_contactName;

	public static By searchBox;
	public static By searchButton;
	public static By acctName;
	public static By newEvent;
	public static By newEventSubject;
	public static By lookupicon;
	public static By find;
	public static By contact1;
	public static By contact2;
	public static By contact3;
	public static By add;
	public static By done;
	public static By status;
	public static By taskInformation_subject;
	public static By newTask;




	public static By continueButton;
	public static By activitiesText;
	public static By continueOpp;
	public static By Opportunity_edit;
	public static By Opportunity_probability;


	public static By searchBox2;

	public static By openActivitiesText;
	public static By openEventsText;
	public static By saveButton;
	public static By topsaveButton;

	public static By droplst;
	public static By continuebtn;
	public static By task_subjecttxt;
	public static By task_savebtn;
	public static By selectAccountDropdown;


//new
	
	public static By Account_Name;
	public static By ParentAccount;
	public static By AccountNumber;
	public static By AccountSite;
	public static By Type;
	public static By Industry;
	public static By AnnualRevenue;
	public static By Rating;
	public static By Phone;
	public static By MainCompetitor;
	public static By Fax;
	public static By Website;
	public static By TickerSymbol;
	public static By Ownership;
	public static By Employees;
	public static By SICCode;
	public static By BillingStreet;
	public static By BillingCity;
	public static By Province;
	public static By PostalCode;
	public static By BillingCountry;
	public static By ShippingStreet;
	public static By ShippingCity;
	public static By Province1;
	public static By PostalCode1;
	public static By ShippingCountry;
	public static By CustomerPriority;
	public static By SLAExpirationDate;
	public static By NumberofLocations;
	public static By Active;
	public static By SLA;
	public static By SLASerialNumber;
	public static By UpsellOpportunity;
	public static By Description;
	public static By Save_Sales;
	public static By AccountDetail_Page;
	public static By Open_Activity_NewTask;
	public static By NewTask_Title;
	public static By Subject;
	public static By DueDate;
	public static By Priority;
	public static By Status;
	public static By Name_DropDown;
	public static By Name;
	public static By RelatedTo;
	public static By Comments;
	public static By NewTask_Save;
	public static By NewTask_Table;
	public static By Name1;
	public static By BusinessUnit;
	public static By ActIndustry;
	public static By ActDetail;
	public static By ActnewTask;
	public static By NewTaskTitle;
	public static By NewRecord;
	public static By Continue;
	public static By Sub;
	public static By save;
	public static By newTaskRequestPage;
	public static By eventName_lookUp;
	public static By lookUpSearch;
	public static By lookUpfind;
	public static By contactUserListItem;
	//public static By contactUser2;
	public static By Useradd;
	public static By userDone;
	public static By contactName;
	public static By logaCallComments;
	public static By ActivitiesHistoryHyperlink;
	public static By Activities_subjectOnMouseHover;
	public static By logAcallStatus;
	
	public static By InteractionOrigin;
	public static By RelatedTo_mouseHover;
	public static By relatedTo;
	public static By logAcall_Subject;
	public static By logAnInteractionbtn;


	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void  Activity_Page()

	{
		//if(configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen"))
		{

			AccountTab = By.xpath(".//*[@id='Account_Tab']/a");
			AccountTab_new = By.xpath(".//*[@title='New']");

			Accountstab=By.xpath(".//*[@id='Account_Tab']/a");
			view =By.xpath(".//*[@id='fcf']");
			gobtn =By.name("go");
			Accountname =By.id("00128000008utd2_Name");
			newcontactbtn=By.name("newContact");
			Contact_Firstname=By.id("name_firstcon2");
			Contact_Lastname=By.id("name_lastcon2");
			Contact_savebtn=By.name("save");
			newtaskbtn=By.name("task");
			cancelbtn =By.name("cancel");
			logacallbtn=By.xpath(".//*[@value='Log a Call']");
			logAnInteractionbtn=By.xpath(".//*[@name='log_an_interaction']");
			log_subject =By.id("tsk5");
			log_Name =By.id("tsk2");
			log_Comments=By.id("tsk6");
			log_subject1=By.id("tsk5_fu");
			log_Comments1 = By.xpath(".//*[@id='tsk6_fu']");
			log_savebtn=By.xpath(".//*[@class='pbButtonb ']/input[1]");

			AccountTab = By.xpath(".//*[@id='Account_Tab']/a");
			Acconts_Display = By.xpath(".//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a");
			Account_Go_cigniti1_title = By.xpath(".//*[@id='contactHeaderRow']/div[2]/h2");
			New_Opp = By.xpath(".//*[contains(@id,'RelatedOpportunityList')]/div[1]/table/tbody/tr/td[2]/input");
			New_Opp_Title = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1");
			Opportunity_Name = By.xpath(".//*[@id='opp3']");
			Opportunity_Type = By.xpath(".//*[@id='opp5']");
			Opportunity_Desc = By.xpath(".//*[@id='opp14']");
			Opportunity_Stage_menu = By.xpath(".//*[@id='opp11']");
			Opportunity_closeDate = By.xpath(".//*[@id='ep']/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a");
			Opportunity_AcctName = By.id("opp4");
			Opportunity_save = By.xpath(".//*[@id='bottomButtonRow']/input[1]");
			Opportunity_Detail = By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2");
			Opportunity_Probability = By.xpath(".//*[@id='opp12']");
			Opportunity_Amount = By.xpath(".//*[@id='opp12']");
			Opportunity_detailpage = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h1");
			Opportunity_logacall = By.xpath("..//*[contains(@id,'RelatedHistoryList')]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]");
			Opportunity_taskEditPage = By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2");
			Opportunity_taskname = By.xpath(".//*[@id='tsk2']");
			Opportunity_subject = By.xpath(".//label[text()='Subject']/parent::td/following-sibling::td[1]//input");
			Opportunity_createdActivity = By.xpath(" .//*[@id='00628000005XmKN_RelatedHistoryList_body']/table/tbody/tr[2]/th");
			Opportunity_contactName = By.xpath(".//*[@id='00128000008utgr_RelatedContactList_body']/table/tbody/tr[2]/th/a");
			contact_logacall = By.xpath(".//*[contains(@id,'RelatedHistoryList')]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]");
			contact_contactName = By.xpath(".//*[@class='listRelatedObject contactBlock']/div/div[2]/table/tbody/tr[2]/th/a");
			searchBox = By.xpath(".//*[@id='phSearchInput']");
			searchButton = By.xpath(".//*[@id='phSearchButton']");
			acctName = By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th");
			newEvent = By.xpath(".//*[@title='New Event']");
			newEventSubject = By.xpath(".//label[text()='Subject']/parent::td/following-sibling::td[1]//input");
			lookupicon = By.xpath(".//*[@id='whobtn']/img");
			find = By.xpath(".//*[@id='mw_picker_search_btn']");
			contact1 = By.xpath(".//*[@id='mw_picker_list_item_00328000007jzVx']/span/span[1]");
			contact2 = By.xpath(".//*[@id='mw_picker_list_item_00328000007bwrO']/span/span[1]");
			contact3 = By.xpath(".//*[@id='mw_picker_list_item_00328000007bwrO']/span/span[2]");
			add = By.xpath(".//*[@id='mw_picker_add_button']/div");
			done = By.xpath(".//*[@id='mw_picker_save_btn']");
			status = By.xpath(".//*[@id='ep']/div[2]/div[6]/table/tbody/tr/td[2]");
			taskInformation_subject = By.xpath(".//label[text()='Subject']/parent::td/following-sibling::td[1]//input");
			newTask = By.xpath(".//*[contains(@id,'RelatedActivityList')]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]");

			continueButton = By.xpath(".//*[@id='bottomButtonRow']/input[1]"); 
			activitiesText = By.xpath(".//*[@id='.//*[contains(@id,'RelatedActivityList']/div[1]/div");
			continueOpp = By.xpath(".//*[@value='Continue']");
			Opportunity_edit = By.xpath(".//*[@id='j_id0:tenderForm:tenderBlock0:j_id264']/div[1]");
			Opportunity_probability = By.xpath(".//*[@id='j_id0:tenderForm:tenderBlock0:j_id264:j_id295:negativeProbability']");
			openActivitiesText = By.xpath(".//*[contains(@id,'RelatedActivityList_body')]/table");
			openEventsText = By.xpath(".//*[contains(@id,'RelatedActivityList_body')]/table");
			searchBox2 = By.xpath(".//*[@id='secondSearchText']");
			saveButton = By.xpath("//div[@id='ep']/div[3]/table/tbody/tr/td[2]/input[1]");
			topsaveButton = By.xpath(".//*[@id='topButtonRow']/input[1]");

			droplst=By.xpath("//*[@id='p3']");
			continuebtn=By.xpath("//*[@title='Continue']");
			task_subjecttxt =By.name("tsk5");
			task_savebtn=By.name("save");

			selectAccountDropdown = By.xpath(".//*[@class='controls']/select");
			
			//new
			
			Account_Name = By.xpath(".//label[contains(text(),'Account Name')]/parent::td/following-sibling::td[1]//input");
			ParentAccount = By.xpath(".//*[@id='acc3']");
			AccountNumber = By.xpath(".//*[@id='acc5']");
			AccountSite = By.xpath(".//*[@id='acc23']");
			Type = By.xpath(".//*[@id='acc6']");
			Industry = By.xpath(".//*[@id='acc7']");
			AnnualRevenue = By.xpath(".//*[@id='acc8']");
			Rating = By.xpath(".//*[@id='acc9']");
			Phone = By.xpath(".//*[@id='acc10']");
			MainCompetitor = By.xpath(".//*[@id='hotlist']/table/tbody/tr/td[2]/input");
			Fax = By.xpath(".//*[@id='acc11']");
			Website = By.xpath(".//*[@id='acc12']");
			Name1 = By.xpath(".//label[contains(text(),'Name1')]/parent::td/following-sibling::td[1]//input");
			Save_Sales = By.xpath(".//*[@id='topButtonRow']/input[@title='Save']");
			BusinessUnit = By.xpath(".//label[contains(text(),'Business Unit')]/parent::td/following-sibling::td[1]//select");
			ActIndustry = By.xpath(".//label[contains(text(),'Industry')]/parent::td/following-sibling::td[1]//select");
			ActDetail = By.xpath(".//*[@id='ep']/div[1]/table/tbody/tr/td[1]/h2");
			ActnewTask = By.xpath(".//*[@value='New Task']");
			NewTaskTitle = By.xpath(".//*[@id='bodyCell']/div[1]/div[1]/div[1]/h2");
			NewRecord = By.xpath(".//*[@class='detailList']/tbody/tr/td[2]/div/select");
			Continue = By.xpath(".//*[@title='Continue']");
			Sub = By.xpath(".//label[contains(text(),'Subject')]/parent::td/following-sibling::td[1]//input");
			save = By.xpath(".//input[@value='Save']");
			newTaskRequestPage = By.xpath(".//h2[text()=' Select Task Record Type']");
			eventName_lookUp = By.xpath(".//img[@title='Name Lookup (New Window)']");
			lookUpSearch = By.xpath(".//*[@id='mw_picker_search_prefix']");
			lookUpfind = By.xpath(".//*[@name='mw_picker_search_btn']");
			contactUserListItem = By.xpath(".//*[@id='mw_picker_found_list_id']//li[1]//span[2]");
			//contactUser2 = By.xpath(".//*[@id='mw_picker_list_item_00321000002lAOL']/span/span[1]");
			Useradd = By.xpath(".//*[@id='mw_picker_add_button']/div");
			userDone = By.xpath(".//*[@id='mw_picker_save_btn']");
			contactName = By.xpath(".//*[@title='Name']/parent::span/textarea");
			logaCallComments=By.xpath(".//label[contains(text(),'Comments')]/parent::td/following-sibling::td[1]//textarea");
			ActivitiesHistoryHyperlink = By.xpath(".//*[@class='listTitle'][text()='Activity History']");
            Activities_subjectOnMouseHover = By.xpath(".//*[contains(@id,'RelatedHistoryList_body')]/table/tbody/tr[2]/th/a");
            //logAcallStatus = By.xpath(".//td[contains(text(),'Status')]/parent::tr/td[4]");
            
            InteractionOrigin = By.xpath(".//label[contains(text(),'Interaction Origin')]/parent::th/following-sibling::td[1]//select");
            RelatedTo_mouseHover = By.xpath(".//*[contains(@id,'RelatedHistoryList_body')]/table/tbody/tr[2]/td[3]/a");
            relatedTo = By.xpath(".//td[contains(text(),'Related To')]/following-sibling::td[1]//a");
            logAcallStatus = By.xpath(".//td[contains(text(),'Status')]/following-sibling::td[1]//div");
            logAcall_Subject = By.xpath(".//label[contains(text(),'Subject')]/parent::th/following-sibling::td[1]//input");
			
		}

	}
}
