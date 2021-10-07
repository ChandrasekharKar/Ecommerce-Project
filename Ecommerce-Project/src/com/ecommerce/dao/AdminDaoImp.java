package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecommerce.dbUtility.DBUtility;
import com.ecommerce.pojo.Admin;

public class AdminDaoImp implements AdminDao 	{

	@Override
	public boolean registerAdmin(Admin admin) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into admin(email,password,usertype) values(?,?,?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setString(1,admin.getEmail());
    	    stmt.setString(2,admin.getPassword());
    	    stmt.setString(3,admin.getUsertype());
    	    
    	    row=stmt.executeUpdate();
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    		
    	}
    	
    	if(row>0)
    	   return true;
    	else
    	   return false;
	}

	@Override
	public Admin login(String email, String password) {
		   Admin admin=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM admin where email='"+email+"' and password='"+password+"'";
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	admin=new Admin();
		    	admin.setId(rs.getInt("id"));
		        admin.setEmail(rs.getString("email"));
		        admin.setPassword(rs.getNString("password"));
		        admin.setUsertype(rs.getString("usertype"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return admin;
 
	}

}
