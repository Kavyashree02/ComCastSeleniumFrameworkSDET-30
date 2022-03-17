package com.crm.PRACTICE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class DataProviderContact {
	
	//Create Obj for all utilities
			PropertyFileUtility pLib = new PropertyFileUtility();
			ExcelFileUtility eLib = new ExcelFileUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			JavaUtility jLib = new JavaUtility();
			
			@Test(dataProvider = "Contacts")
			public void createOrgWithMltipleData(String lastName) throws Throwable
			{
				
				
				//read data 
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");
				
				String lastname = lastName+jLib.getRandomNumber();
			
				//launch the application
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver = new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("FIREFOX"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					System.out.println("invalid browser");
				}
				
				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);
				
				//login to application
				LoginPage lp = new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				Reporter.log("login successful",true);
				
				//navigate to contact
				HomePage hp = new HomePage(driver);
				hp.ClickOnContactLnk();
				Reporter.log("navigated to contact link",true);
				
				//create Org
			    ContactsPage cp = new ContactsPage(driver);
			    cp.clickOnCreateContactImg();
				Reporter.log("click on create contact link",true);
				
				//create new contact
				CreateContactPage ccp = new CreateContactPage(driver);
				ccp.createNewContact(lastname);
				Reporter.log("create org with insustry type",true);
				
				//validate
				ContactInfoPage cip = new ContactInfoPage(driver);
				String actHeader = cip.contactNameInfo();
				if (actHeader.contains(lastname)) {
					System.out.println("passed");
				}
				else
				{
					System.out.println("failed");
				}
				Reporter.log("verification successful",true);		
				
				//logout
				hp.signOutOfApp(driver);
				
				driver.quit();
			}
			
			@DataProvider(name = "Contacts")
			public Object[][] getData() throws Throwable
			{
				Object[][] data = eLib.readmultipleDataFromExcel("ContactData");
				return data;
			}

	}

	


