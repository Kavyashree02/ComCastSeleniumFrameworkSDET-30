package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	//STEP 1: Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignLookUpImg;
	
	//step 2: Initialization
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: utilization
	public WebElement getCreateCampaignLookUpImg() 
	{
		return createCampaignLookUpImg;
	}
	
	
	//Business library
	public void clickOnCreateCampImg()
	{
		createCampaignLookUpImg.click();
	}
	

}
