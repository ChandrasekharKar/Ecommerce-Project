package com.ecommerce.dbUtility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility 
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mapper","postgres","admin");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;	
	}
  
}
