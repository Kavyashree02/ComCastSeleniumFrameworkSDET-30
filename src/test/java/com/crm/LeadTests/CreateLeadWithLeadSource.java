package com.crm.LeadTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LeadsPage;
import com.crm.ObjectRepository.LoginPage;

public class CreateLeadWithLeadSource {
	
	@Test
	public void createLeadWithLeadSource() throws Throwable
	{
		/* read all necessary data from property file*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		/* READ DATA FROM EXCEL SHEET*/
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Lead");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(2);
		String LeadSource = cel.getStringCellValue();
		Cell cel1 = ro.getCell(3);
		String Industry = cel1.getStringCellValue();
		//Cell cel2 = ro.getCell(4);
		 //double AnnualRevenue = cel2.getNumericCellValue();
		//Cell cel3 = ro.getCell(5);
		//double NoofEmployees = cel3.getNumericCellValue();
		
		
		/*step 2: launch the browser*/
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*step 3 :login to application*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		/*driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitbutton")).click();*/
		

		/* step 4: navigate to leads link and click on create lead*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnLeadsLnk();
		
		
		/*step 5: enter all valid details in all fields*/
		LeadsPage lp1 = new LeadsPage(driver);
		lp1.clickOnCreateLeadImg();
		
		driver.findElement(By.name("firstname")).sendKeys("hello");
		driver.findElement(By.name("lastname")).sendKeys("hello");
		driver.findElement(By.name("company")).sendKeys("ABC");
		driver.findElement(By.id("designation")).sendKeys("TE");
		
		/* step 6: choose Leadsource and industry */
		WebElement ele1 = driver.findElement(By.name("leadsource"));
		Select sel = new Select(ele1);
		sel.selectByValue(LeadSource);
		
		WebElement ele = driver.findElement(By.name("industry"));
		Select sel1 = new Select(ele);
		sel1.selectByValue(Industry);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//driver.findElement(By.name("annualrevenue")).sendKeys(AnnualRevenue);
		//driver.findElement(By.id("noofemployees")).sendKeys(NoofEmployees);
				
		
		
	}

}
