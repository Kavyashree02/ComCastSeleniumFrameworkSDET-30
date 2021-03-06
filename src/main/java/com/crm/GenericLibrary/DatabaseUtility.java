package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to read data from db
 * @author Kavyashree
 *
 */
public class DatabaseUtility {
	
	//globally declare to get connection
	Connection con = null;
	
	/**
	 * this method will register the driver and establish connection with database
	 * @throws Throwable
	 */
	
	public void connectToDb() throws Throwable 
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dBURL, IPathConstants.dBUsername, IPathConstants.dBPassword);
		}
	
	/**
	 * this method will close databse connection
	 * @throws Throwable
	 */
	
	public void closeDB() throws Throwable
	{
		con.close();
	}
	
	/**
	 * This method will execute the query and return the matching data to the suer
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable
	{
		String data = null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag = true; //flag rising
				break;
			}
		}
	
	if(flag)
	{
		System.out.println(data+"----> data verified");
		return expData;
		
	}
	else
	{
		System.out.println("data not verified");
		return "";
	}

}
}
