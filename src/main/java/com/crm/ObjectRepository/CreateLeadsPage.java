package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility{
	
	//step1: Declaration
	@FindBy(name = "firstname")
	private WebElement firstnameEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "company")
	private WebElement companyEdt;
	
	@FindBy(name = "designation")
	private WebElement titleEdt;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(id = "noofemployees")
	private WebElement noofemployeesEdt;
	
	@FindBy(name = "annualrevenue")
	private WebElement annualrevenueEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 2: initialization
	public CreateLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//step 3: utilization
	public WebElement getFirstnameEdt() {
		return firstnameEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getNoofemployeesEdt() {
		return noofemployeesEdt;
	}

	public WebElement getAnnualrevenueEdt() {
		return annualrevenueEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Business Library
	
	/**
	 * This method will create leads with mandatory fields
	 * @param lastName
	 * @param company
	 */
	public void createNewLead(String lastName, String company)
	{
		lastnameEdt.sendKeys(lastName);
		companyEdt.sendKeys(company);
		saveBtn.click();
		
	}
	
	/**
	 * this method will create lead with lastname, company, firstname, title
	 * @param lastName
	 * @param company
	 * @param firstName
	 * @param title
	 */
	public void createNewLead(String lastName, String company, String firstName, String title)
	{
		firstnameEdt.sendKeys(firstName);
		lastnameEdt.sendKeys(lastName);
		companyEdt.sendKeys(company);
		titleEdt.sendKeys(title);
		
	}
	
	

}
