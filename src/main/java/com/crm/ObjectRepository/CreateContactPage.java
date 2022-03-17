package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	//step 1: Declaration
	@FindBy(name= "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name= "leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	
	//initialization
	public CreateContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getLastnameEdt() 
	{
		return lastnameEdt;
	}

	public WebElement getOrgNameLookUpImg() 
	{
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropdown() 
	{
		return leadSourceDropdown;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	public WebElement getSearchBtn() 
	{
		return searchBtn;
	}
	
	//Business Library
	
	/**
	 * this method will create new contact
	 * @param lastName
	 */
	public void createNewContact(String lastName)
	{
		lastnameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	/**
	 * This method will create New Contact with leadsource dropdown
	 * @param lastName
	 * @param leadSource
	 */
	public void createNewContact(String lastName, String leadSource)
	{
		lastnameEdt.sendKeys(lastName);
		select(leadSource, leadSourceDropdown);
		saveBtn.click();
	}
	
	public void createNewContact(WebDriver driver, String lastName, String orgName)
	{
		lastnameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
	

}
