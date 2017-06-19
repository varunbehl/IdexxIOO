package com.Idexx.libs;

import java.util.Hashtable;

import org.openqa.selenium.By;

import com.Idexx.page.ForecastPage;
import com.Idexx.page.OpportunityPage;



public class ForecastLib extends IdexxLib {
	
	public int sleep = 2000;
	
	public void addProduct(Hashtable<String, String> data) throws Throwable
	{
		Thread.sleep(sleep);
		new ForecastPage().Forecast();
		click(ForecastPage.addProduct, "Successfully Clicked on add Product Button");
		Thread.sleep(sleep);
		selectByVisibleText(ForecastPage.priceBook, data.get("priceBook"), "Selected priceBook from drop down");
		click(ForecastPage.Save, "Successfully Clicked on Save Button");
		Thread.sleep(sleep);
		
		Driver.findElement(By.xpath(".//*[contains(@class,'x-grid3-row-first')]/table/tbody/tr/td[1]/div/input")).click();
	//	driver.findElement(By.xpath(".//*[@value='Select']")).click();
		
		click(ForecastPage.select, "Successfully Clicked on Save Button");

		Thread.sleep(5000);
		type(ForecastPage.Quantity, data.get("Quantity"), "Successfully entered into Quantity field");
		click(ForecastPage.productsSave, "Successfully Clicked on products Save Button");
		Thread.sleep(sleep);
		click(ForecastPage.addProductEdit, "Successfully Clicked on edit Button");
		Thread.sleep(sleep);
		new OpportunityPage().Opportunity();
		selectByVisibleText(OpportunityPage.Opportunity_Stage_menu, data.get("StageEdit"), "Selectd 4 Commitment from drop down");
		click(OpportunityPage.Opportunity_save, "Successfully Clicked on save Btn");
		Thread.sleep(sleep);
		goToForecastsTab();

	}


}
