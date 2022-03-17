package com.crm.LeadTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateLeadTest extends BaseClass{
	
	@Test
	public void createLead() throws Throwable
	
	{
		
		/* step 3: navigate to leads link and click on create lead*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnLeadsLnk();
		
		LeadsPage lp1= new LeadsPage(driver);
		lp1.clickOnCreateLeadImg();
		Assert.fail();
		
		}

}
