package com.crm.ContactTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateContactWithExistOrgTest extends BaseClass {
	@Test
	public void createOrgTestWithExistOrg() throws Throwable
	{
			
		
		String lastName = eLib.readDataFromExcel("Contact", 3, 2)+jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcel("OrgName", 4, 2)+jLib.getRandomNumber();
				
		/*step3: navigate to org link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		/*step 4: navigate to the contacts link*/
		
		hp.ClickOnContactLnk();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		/* step 5: create contact with mandatory fields*/
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(driver, lastName, orgName);
		
		
	}
	

}
