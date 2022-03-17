package com.crm.OrganizationTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrganizationWithPropertyFileTest extends BaseClass{
	@Test
	public void createOrganizationTest() throws Throwable
	{
				
		String orgName = eLib.readDataFromExcel("OrgName", 4, 2)+jLib.getRandomNumber();
				
		//step 3: navigate to organizations link
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		//step 4: click on create organizations link
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
		Assert.fail();
		
		// step 5: create new organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		
		
	 }
	}

