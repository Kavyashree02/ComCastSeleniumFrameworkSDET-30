package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoibiboCalendarTest {
	@Test
	public void goibibo()
	{
		String monYear = "June 2022";
		String day = "12";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		String month = "//span[@aria-label='Next Month']";
		String xpath = "//div[.='"+monYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+day+"']";
		
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath(xpath)).click();
				driver.findElement(By.xpath("//span[.='Done']")).click();
				break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath(month)).click();
			}
		}
		
	}

}
