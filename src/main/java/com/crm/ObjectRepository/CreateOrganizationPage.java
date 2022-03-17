
package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility{
	
	//step 1: declaration
	@FindBy(name= "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name= "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 2: Initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 3: Utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	/**
	 * This method will create new organization
	 * @param orgName
	 */
	public void createNewOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	
	/**
	 * This method will create new organization with industry dropdown
	 * @param orgName
	 * @param indType
	 */
	public void createNewOrg(String orgName, String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(indType, industryDropDown);
		saveBtn.click();
	}
	
	public void createOrg()
	{
		typeDropDown.click();
	}
	
	
	
	
	
	

}
