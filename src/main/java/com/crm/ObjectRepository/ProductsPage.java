package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	//step 1: Declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createProdLookUpImg;
	
	//step 2: initialization
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: utilization
	public WebElement getCreateProdLookUpImg()
	{
		return createProdLookUpImg;
	}
	
	//Business libraries
	public void clickOnCreateProdImg()
	{
		createProdLookUpImg.click();
	}
	
	

}
