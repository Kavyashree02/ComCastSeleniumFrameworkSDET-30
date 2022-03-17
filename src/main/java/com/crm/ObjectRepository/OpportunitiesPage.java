package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	//step 1: Declaration
		@FindBy(xpath = "//img[@alt='Create Opportunity...']")
		private WebElement createOpportLookUpImg;
		
		//step 2: initialization
		public OpportunitiesPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//step 3: utilization
		public WebElement getCreateProdLookUpImg()
		{
			return createOpportLookUpImg;
		}
		
		//Business libraries
		public void clickOnCreateOpportImg()
		{
			createOpportLookUpImg.click();
		}

}
