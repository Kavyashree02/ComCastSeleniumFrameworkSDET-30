package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {
	
	//step1: Declaration
	@FindBy(name = "productname")
	private WebElement productnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 2: initialization
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		}

	//step 3: utilization
	public WebElement getProductnameEdt() 
	{
		return productnameEdt;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	
	//Business library
	
	/**
	 * this method will create new product
	 * @param ProductName
	 */
	public void createNewProduct(String ProductName)
	{
		productnameEdt.sendKeys(ProductName);
		saveBtn.click();
	}

	
	
	
	

}
