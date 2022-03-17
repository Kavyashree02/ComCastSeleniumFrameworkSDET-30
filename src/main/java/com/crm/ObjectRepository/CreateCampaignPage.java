package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignPage extends WebDriverUtility {
	
	//step 1: Declaration
	@FindBy(name = "campaignname")
	private WebElement campaignnameEdt;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement productLookUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement search_txtEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 2: Initialization
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//step 3: utilization
	public WebElement getCampaignnameEdt() 
	{
		return campaignnameEdt;
	}

	public WebElement getProductLookUpImg()
	{
		return productLookUpImg;
	}

	public WebElement getSearch_txtEdt() 
	{
		return search_txtEdt;
	}

	public WebElement getSearchBtn() 
	{
		return searchBtn;
	}
	
	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
	//Business library
	
	/**
	 * This method will create campaign
	 * @param CampaignName
	 */
	public void createNewCamp(String CampaignName)
	{
		campaignnameEdt.sendKeys(CampaignName);
		saveBtn.click();
		
		
	}
	
	
	/**
	 * This method will create campaign name with product name
	 * @param driver
	 * @param CampaignName
	 * @param ProductName
	 */
	public void createNewCamp(WebDriver driver, String CampaignName, String ProductName)
	{
		campaignnameEdt.sendKeys(CampaignName);
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		search_txtEdt.sendKeys(ProductName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ProductName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
		
	}
	
	
	
	
	
	

}
