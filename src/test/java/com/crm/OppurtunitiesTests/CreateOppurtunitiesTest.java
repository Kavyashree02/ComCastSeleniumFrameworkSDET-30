package com.crm.OppurtunitiesTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOpportunitiesPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OpportunitiesPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOppurtunitiesTest extends BaseClass {
	
	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	public void createOppurtunitiesTest() throws Throwable 
	{
		
		String LastName = eLib.readDataFromExcel("Contact", 3, 2)+"_"+jLib.getRandomNumber();
		String CampaignName = eLib.readDataFromExcel("Campaign", 1, 3)+"_"+jLib.getRandomNumber();
		String OppurtunityName = eLib.readDataFromExcel("Oppurtunity", 1, 1);
		String RelatedTo = eLib.readDataFromExcel("Oppurtunity", 1, 2);
		String LeadSource = eLib.readDataFromExcel("Oppurtunity", 1, 3);
			
		/*step 4: navigate to the contacts link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		/* step 5: create contact with mandatory fields*/
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(LastName);
		
		/*validation for contact */
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actCon = cip.contactNameInfo();
		if(actCon.contains(LastName))
		{
			System.out.println(actCon +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}
		
		/* step 6 : navigate to campaign*/
		hp.ClickOnMore();
		hp.ClickOnCampaignnLnk();
		
		
		/*step 7: create a campaign with mandatory fields*/
		CampaignPage cp1 = new CampaignPage(driver);
		cp1.clickOnCreateCampImg();
		
		CreateCampaignPage ccp1 = new CreateCampaignPage(driver);
		ccp1.createNewCamp(CampaignName);
		
		/* step 8: validation for campaign*/
		CampaignInfoPage cip1 = new CampaignInfoPage(driver);
		String actCamp = cip1.CampaignInfo();
		if(actCamp.contains(CampaignName))
		{
			System.out.println(actCamp +" campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
				 
		
		/* step 6: navigate to oppurtunities link*/
		
		hp.ClickOnOpportunitiesLnk();
		
		OpportunitiesPage op1 = new OpportunitiesPage(driver);
		op1.clickOnCreateOpportImg();
		
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.createNewOpportunity(OppurtunityName, LastName, driver, CampaignName, RelatedTo, LeadSource);
			
	}

}
