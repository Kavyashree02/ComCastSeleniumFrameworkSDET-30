package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	public static void main(String [] args) throws Throwable{
		
		//Step 1: register the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get connection from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
				
		//Step 4: execute query---provide tablename
		ResultSet result = state.executeQuery("select * from student; ");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
				
		//Step 5 : close database
		con.close();
	}
	
	

}
