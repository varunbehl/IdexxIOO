package com.Idexx.page;

import org.openqa.selenium.By;

public class ForecastPage {
	public static By productsHyperlink ;
	public static By addProduct;
	public static By priceBook;
	public static By Save;
	public static By topDisplayedCheckBox;
	public static By select;
	public static By productsSave;
	public static By Quantity;
	public static By addProductEdit;
	public static By forecastsTab;
	public static By topDisplayedCheckBox1;
	//public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");

	public void  Forecast()

	{
		//if(configProps.getProperty("platformType").equalsIgnoreCase("Web_Fullscreen"))
		{

			productsHyperlink = By.xpath(".//*[@class='listTitle'][text()='Products']");
			addProduct = By.xpath(".//*[@value='Add Product']");
			priceBook = By.xpath(".//*[@class='detailList']/tbody/tr/td[2]/select");
			Save = By.xpath(".//*[@id='bottomButtonRow']/input[@title='Save']");
			topDisplayedCheckBox = By.xpath(".//*[@id='01u21000000LF2o']");
			select = By.xpath(".//*[@value='Select']");
			productsSave = By.xpath(".//*[@id='editPage']/table/tbody/tr[1]/td/input[1]");
			Quantity = By.xpath(".//*[@id='editPage']/table/tbody/tr[5]/td[1]/input[1]");	
			addProductEdit = By.xpath(".//*[@id='topButtonRow']//input[1][@value=' Edit ']");
			forecastsTab = By.xpath(".//*[@title='Forecasts Tab']");
			topDisplayedCheckBox1=By.xpath(".//*[contains(@class,'x-grid3-row-first')]/table/tbody/tr/td[1]/div/input");
		}

	}
}
