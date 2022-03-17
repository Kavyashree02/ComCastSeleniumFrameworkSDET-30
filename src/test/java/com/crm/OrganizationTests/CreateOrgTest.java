
package com.crm.OrganizationTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateOrgTest extends BaseClass {
	
	@Test(groups = "smokeSuite")
	public void createOrgTest() throws Throwable
	{
				
		String orgName = eLib.readDataFromExcel("OrgName", 4, 2)+"_"+jLib.getRandomNumber();
						
		/*step4: navigate to organization link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		Assert.fail();
		
		/*step 5: click on create Organization link*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgImg();
				
		/*step 6: create org with mandatory fields and save*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName);
		
		/* step 7 : verification/=*/
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.OrgNameInfo();
		if(actOrgName.contains(orgName))
		{
			System.out.println(actOrgName+"----> data verified");
		}
		else
		{
			System.out.println("data invalid");
		}
		 
		 
		
	}

}
