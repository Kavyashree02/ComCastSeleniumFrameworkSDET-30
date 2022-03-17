package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//step 1: declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//step 2: initialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//step 3: Utilization
	public void setCreateOrgLookUpImg(WebElement createOrgLookUpImg)
	{
		this.createOrgLookUpImg = createOrgLookUpImg;
	}
	
	//Business Library
	public void clickOnCreateOrgImg()
	{
		createOrgLookUpImg.click();
	}
	

}
