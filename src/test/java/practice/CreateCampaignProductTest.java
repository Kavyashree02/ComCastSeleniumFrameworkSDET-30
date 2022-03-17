package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateCampaignProductTest {
	@Test
	public void createCampaignProductTest() throws Throwable
	{
		
		/*generate random number*/
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		/*step 1: read all the necessary data*/
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Campaign");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(2);
		
		String ProductName = cel.getStringCellValue();
		String ProductNameRan = ProductName +" "+random;
		
		Cell cel2 = ro.getCell(3);
		//String CampaignName = cel2.getStringCellValue();
		String CampaignNameRan = cel2.getStringCellValue()+random;
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitbutton")).click();
		
		/*step 4: navigate to products link*/
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(ProductNameRan);
		
		/* step 5: create a product*/
		driver.findElement(By.name("button")).click();
		
		/* step 6 : navigate to campaign*/
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		
		/*step 7: create a campaign & choose the product*/
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampaignNameRan);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		/* step 8: choose the product */
		Set<String> win = driver.getWindowHandles();
		for(String winId:win)
		{
			driver.switchTo().window(winId);
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(ProductNameRan);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[.='"+ProductNameRan+"']")).click();
		
		Set<String> wind1 = driver.getWindowHandles();
		
		for(String wn:wind1)
		{
			driver.switchTo().window(wn);
		}
		
		/* step 9: save*/
		driver.findElement(By.name("button")).click();
		
		/*  step 10: verify the Campaign name */
		String Campaign1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Campaign1.contains(CampaignNameRan))
		{
			System.out.println(Campaign1 +" campaign created");
		}
		else
		{
			System.out.println("campaign not created");
		}
		
		/*step 11: navigate to products link*/
		//driver.findElement(By.xpath("//a[.='Products']")).click();
		//driver.findElement(By.xpath("//a[.='"ProductNameRan"']")).click();

		/*Step 12: logout and close the browser*/
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
			
		/* close the browser*/
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
		
		}

}


