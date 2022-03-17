package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice1 {
	@Test(dataProvider= "getData")
	public void sampleDataProvider(String College, String Branches)
	{
		System.out.println(College+"----"+Branches);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[6][2];
		
		obj[0][0]="Sambhram";
		obj[0][1]="ECE";
		
		obj[1][0]="Sambhram";
		obj[1][1]="CSE";
		
		obj[2][0]="Sambhram";
		obj[2][1]="TE";
		
		obj[3][0]="Sambhram";
		obj[3][1]="ISE";
		
		obj[4][0]="Sambhram";
		obj[4][1]="Civil";
		
		obj[5][0]="Sambhram";
		obj[5][1]="Mech";
		
			
		return obj;
	}

}
