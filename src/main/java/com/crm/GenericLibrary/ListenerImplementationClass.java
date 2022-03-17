package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"----testscript execution started");
		test = report.createTest(MethodName);
		
		
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"----testscript execution sucessfull-PASS");
		test.log(Status.PASS, MethodName+"---->passed");
	}

	public void onTestFailure(ITestResult result)
	{
		
				
		String MethodName = result.getMethod().getMethodName()+"_";
		
		//Reporter.log(MethodName+"----testscript Failed", true);
		
		//step 1: Configure screenshot name
		String screenshotName = MethodName+new JavaUtility().getSystemDateInFormat();
		System.out.println(screenshotName);
		
		//step 2: using screenshot method from webdriver utility
		
		try {
			new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			/*EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/Screenshot/"+screenshotName;
			path = ".Screenshot/"+screenshotName+".png";
			File dst = new File(path);
			Files.copy(src, dst);*/
			
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, MethodName+"--->failed");
		//it will capture the exception and log it in the report
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(".Screenshot/"+screenshotName+".png");

	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"----testscript Skipped");
		test.log(Status.SKIP, MethodName+"---->skipped");
		
		//it will capture the exception and log it in the report
		test.log(Status.SKIP, result.getThrowable());
		

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//Execution will start here
		/*Configure the report*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReport/Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Kavyashree");
		
		
	}

	public void onFinish(ITestContext context)
	{
		report.flush();
	}
	
	

}
