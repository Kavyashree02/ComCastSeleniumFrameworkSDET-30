package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	//step 1: declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headerText;
	
	//step 2: initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: utilization
	public WebElement getHeaderText() 
	{
		return headerText;
	}
	
	//Business library
	public String ProductInfo()
	{
		String ProInfo = headerText.getText();
		return ProInfo;
	}
	

}
