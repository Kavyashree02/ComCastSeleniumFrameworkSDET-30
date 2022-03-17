package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationsPage;

public class CreateOrgDropDownTest {
	@Test
	public void createOrgDropDown() throws Throwable {
	
	
	/*step 1: read all data from property file*/
	PropertyFileUtility pLib = new PropertyFileUtility();
	
	WebDriverUtility wLib = new WebDriverUtility();
	
	
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	
		
	/*step 2: launch the browser*/
	WebDriver driver= null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	/*step 3: login to application*/
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	/* step 4: navigate to organization link*/
	HomePage hp = new HomePage(driver);
	
	
	/*step 5: navigate to create organization*/
	hp.ClickOnOrgLnk();
	
	/* step 6: navigate to type dropdown*/
	OrganizationsPage op = new OrganizationsPage(driver);
	op.clickOnCreateOrgImg();
	
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.createOrg();
	
	
	/* step 7: logout of application*/
	hp.signOutOfApp(driver);
	
	
}

}


