package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunitiesPage extends WebDriverUtility{
	
	// step 1: Declaration
	@FindBy(name = "potentialname")
	private WebElement OpportunityNameEdt;
	
	@FindBy(id="related_to_type")
	private WebElement relatedToDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img[@alt='Select']")
	private WebElement selectLookUpImg;
	
	@FindBy(id = "search_txt")
	private WebElement searchEdt;
	
	@FindBy(name= "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img")
	private WebElement select1LookUpImg;
	
	
	//step 2: Initialization
	public CreateOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//step 3:  Utilization
	public WebElement getOpportunityNameEdt() 
	{
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToDropDown() 
	{
		return relatedToDropDown;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	
		
	public WebElement getSelectLookUpImg() {
		return selectLookUpImg;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	

	public WebElement getCampaignSourceLookUpImg() {
		return select1LookUpImg;
	}


	//Business Library
	/**
	 * This method create new opportunity
	 * @param OppurtunityName
	 */
	public void createNewOpportunity(String OppurtunityName )
	{
		OpportunityNameEdt.sendKeys(OppurtunityName);
		saveBtn.click();
	}
	
	public void createNewOpportunity(String OppurtunityName, String lastName, WebDriver driver,String CampaignName,String RelatedTo, String LeadSource )
	{
		OpportunityNameEdt.sendKeys(OppurtunityName);
		select(RelatedTo, relatedToDropDown);
		selectLookUpImg.click();
		switchToWindow(driver, "Contacts");
		searchEdt.sendKeys(lastName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.=' "+lastName+"']")).click();
		switchToWindow(driver, "Potentials");
		select(LeadSource,leadSourceDropDown);
		select1LookUpImg.click();
		switchToWindow(driver, "Campaigns");
		searchEdt.sendKeys(CampaignName);
		searchBtn.click();
		driver.findElement(By.linkText(""+CampaignName+"")).click();
		switchToWindow(driver, "Potentials");	
		saveBtn.click();
		
			
	}
	
	

}
