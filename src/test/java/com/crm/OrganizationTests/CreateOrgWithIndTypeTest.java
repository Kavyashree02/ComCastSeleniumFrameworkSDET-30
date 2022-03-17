package com.crm.OrganizationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;
@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)

public class CreateOrgWithIndTypeTest extends BaseClass {
	@Test
	public void createOrgWithIndTypeTest() throws Throwable
	{
				
		/* read all necessary data*/		
				
		String OrgName = eLib.readDataFromExcel("OrgName", 4, 2)+"_"+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("OrgName", 4, 3);
				
			
		/*step4: navigate to organization link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		/*step 5: click on create Organization btn*/
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
						
		/*step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName, indType);
		
		
		/* step 7: verification*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		if(actHeader.contains(OrgName))
		{
			System.out.println(actHeader +"-----> organization created");
		}
		else
		{
			System.out.println("Organization creation failed");
		}
	}
		
					
		 
	
}
