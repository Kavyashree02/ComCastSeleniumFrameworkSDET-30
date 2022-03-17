package com.crm.ContactTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)

public class CreateContactTest extends BaseClass {
	@Test(groups = "regressionSuite")
	public void createContactTest() throws Throwable
	{
				
		
		String lastName = eLib.readDataFromExcel("Contact", 3, 2)+"_"+jLib.getRandomNumber();

				
		/*step 4: navigate to the contacts link and create contact with mandatory fields*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(lastName);
		
		
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actHeader = cip.contactNameInfo();
		if(actHeader.contains(lastName))
		{
			System.out.println(actHeader+"----> contact created");
			
		}
		else
		{
			System.out.println("contact not created");
		}		
		
		
	
	}
}
