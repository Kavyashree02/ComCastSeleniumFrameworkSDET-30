package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleNextCalendar {
	
	@Test
	public void calendar()
	{
		String monthAndYear = "September 2022";
		String day = "12";
		
		WebDriver driver= new ChromeDriver();
					
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		String month = "//span[@aria-label='Next Month']";
		String path = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']";
		
		for(;;)
		{
			try {
			driver.findElement(By.xpath(path)).click();
			break;
			}
			
			catch (Exception e) {
				
			driver.findElement(By.xpath(month)).click();
		}
		}
	}
}
		
		
		
		

