package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB {

	public static void main(String[] args) throws Throwable {
		String expData = "Mahesh";
		
		//step 1: register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: get connector from database - provide db name
		Connection con = DriverManager.getConnection("jdbc:mysq"+ "l://localhost:3306/students", "root", "root");
		
		//step 3: issue create statement
		Statement state = con.createStatement();
		
		//step 4:execute query----provide table name
		ResultSet result = state.executeQuery("select * from student");
		while(result.next())
		{
			String actData = result.getString(2);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData + "   data is verified");
				break;
			}
		}
		

	}

}
