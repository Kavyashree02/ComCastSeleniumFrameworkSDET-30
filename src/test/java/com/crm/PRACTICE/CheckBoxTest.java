package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckBoxTest extends BaseClass {
	@Test
	public void contact()
	{
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		//ContactsPage cp = new ContactsPage(driver);
	
		
		
	}
	
	
	
	
	

}
