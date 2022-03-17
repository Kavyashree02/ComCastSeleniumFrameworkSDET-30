package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
	
	//step 1: Declaration
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//step 2: Initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: Utilization
	public WebElement getHeaderText()
	{
		return headerText;
	}
	
	//Business library
	public String CampaignInfo()
	{ 
		String CampInfo = headerText.getText();
		return CampInfo;
		
	}
	
	
	

}
