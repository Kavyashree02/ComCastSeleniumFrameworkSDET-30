package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//step 1: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy( linkText ="Sign Out")
	private WebElement signoutLnk;
	
	@FindBy(linkText ="Leads")
	private WebElement leadsLnk;
	
	
	//step 2: initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//step 3: generate Getters

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOppurtunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCampaignsLnk() {
		return campaignsLnk;
	}

	public WebElement getAdministartorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
		
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}
	

	// business library
	public void ClickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void ClickOnContactLnk()
	{
		contactsLnk.click();
	}
	
	public void ClickOnProductLnk()
	{
		productsLnk.click();
	}
	
	public void ClickOnMore()
	{
		moreLnk.click();
	}
	
	public void ClickOnCampaignnLnk()
	{
		campaignsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signoutLnk.click();
	}
	
	public void ClickOnLeadsLnk()
	{
		leadsLnk.click();
	}
	
	public void ClickOnOpportunitiesLnk()
	{
		opportunitiesLnk.click();
	}
	

}
