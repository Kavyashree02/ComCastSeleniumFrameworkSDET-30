package com.crm.OrganizationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgDropDownTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createOrgDropDown() throws Throwable {
				
			/* step 4: navigate to organization link*/
		HomePage hp = new HomePage(driver);
		
		
		/*step 5: navigate to create organization*/
		hp.ClickOnOrgLnk();
		
		/* step 6: navigate to type dropdown*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg();
		
		
		
		
	}

	}


