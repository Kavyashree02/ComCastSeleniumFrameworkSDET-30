package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCUpdateQuery {

	public static void main(String[] args) throws Throwable {
		Connection con = null;
		try{
			
		//Step 1: register the database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get connection from database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection established");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute query
		//insert into student value(4,'Adarsh','Male');
		int result = state.executeUpdate("insert into student value(14,'harsha','Male');");
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else
		{
			System.out.println("data not added");
		}
		}
		
		finally
		{
			//Step 5: close the database
			con.close();
			System.out.println("connection closed");
		}
	

	}

}
