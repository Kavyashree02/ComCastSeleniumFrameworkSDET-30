package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
	
	public void createOrganizationTest()
	{
		//step 1: launch the browser
				WebDriver driver= new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("http://localhost:8888");
				
				//step 2 : login to application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//step 3: navigate to organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//step 4: click on create organizations link
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//step 5: create org with mandatory fields
				driver.findElement(By.name("accountname")).sendKeys("ALL STATES1");
				
				//step 6: save
				driver.findElement(By.name("button")).click();
				
				
				

			}

	}


