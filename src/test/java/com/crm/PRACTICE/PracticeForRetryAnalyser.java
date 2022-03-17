package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeForRetryAnalyser {
	
	@Test(retryAnalyzer=com.crm.GenericLibrary.RetryAnalyzerImplementation.class)
	public void practiceForRetry()
	{
		System.out.println("This is test1");
		Assert.fail();
		System.out.println("This is passes");
	}

}
