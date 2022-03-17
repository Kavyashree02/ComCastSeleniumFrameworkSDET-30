package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	//step 1: Declaration
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadLookUpImg;
	
	//step 2: initialization
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: utilization
	public WebElement getCreateLeadLookUpImg() 
	{
		return createLeadLookUpImg;
	}
	
	//Business Library
	public void clickOnCreateLeadImg()
	{
		createLeadLookUpImg.click();
	}
	

}
