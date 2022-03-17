package com.crm.OrganizationTests;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws Throwable
	{
		
			
		String OrgName = eLib.readDataFromExcel("OrgName",4 ,2)+"_"+jLib.getRandomNumber();
		
				
				//step 3: navigate to organizations link
				HomePage hp = new HomePage(driver);
				hp.ClickOnOrgLnk();
				
				
				//step 4: click on create organizations link
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrgImg();
				
				//step 5: create org with mandatory fields and save
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				cop.createNewOrg(OrgName);
								 			
				

			}

	}

