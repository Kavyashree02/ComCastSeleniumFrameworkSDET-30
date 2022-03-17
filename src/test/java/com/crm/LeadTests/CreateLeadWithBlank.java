package com.crm.LeadTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;

@Listeners(com.crm.GenericLibrary.ListenerImplementationClass.class)
public class CreateLeadWithBlank extends BaseClass {
	
	@Test
	public void createLeadWithBlank() throws Throwable
	{
		
		/* step 3: navigate to leads link and click on create lead*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnLeadsLnk();
		
		LeadsPage lp1 = new LeadsPage(driver);
		lp1.clickOnCreateLeadImg();
		
		
		
		/*step 4: click on save without any inputs*/
		
		driver.findElement(By.name("button")).click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		
		
		
	}

}
