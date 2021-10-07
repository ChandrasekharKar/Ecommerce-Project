package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbUtility.DBUtility;
import com.ecommerce.pojo.Executive;

public class ExecutiveDaoImp implements ExecutiveDao{

	@Override
	public boolean registerExecutive(Executive executive) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into executive(firstname,lastname,email,contact,password,usertype) values(?,?,?,?,?,?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setString(1,executive.getFirstname());
    	    stmt.setString(2,executive.getLastname());
    	    stmt.setString(3,executive.getEmail());
    	    stmt.setString(4,executive.getContact());
    	    stmt.setString(5,executive.getPassword());
    	    stmt.setString(6,executive.getUsertype());
    	    
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
	public Executive login(String email, String password) {
		Executive executive=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="select * from executive where email='"+email+"' and password='"+password+"'";
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	executive=new Executive();
		    	executive.setId(rs.getInt("id"));
		    	executive.setFirstname(rs.getString("firstname"));
		    	executive.setLastname(rs.getString("lastname"));
		    	executive.setEmail(rs.getString("email"));
		    	executive.setContact(rs.getString("contact"));	
		    	executive.setUsertype(rs.getString("usertype"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return executive;
	}
	
	@Override
	public int getCountOfExecutive() {
		Connection con=DBUtility.getConnection();
		String query="SELECT count(*) as totalexecutive from executive";
		ResultSet rs;
		Statement stmt;
		int count=0;
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        count = rs.getInt("totalexecutive");
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
		System.out.println("total no of executive => " +count);
    	return count;
	}

	public List<Executive> getAllExecutives() {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM executive";
		ResultSet rs;
		Statement stmt;
		Executive executive;
		List<Executive> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	    	executive=new Executive();
    	    	executive.setId(rs.getInt("id"));
    	    	executive.setFirstname(rs.getString("firstname"));
    	    	executive.setLastname(rs.getString("lastname"));
    	    	executive.setContact(rs.getString("contact"));
    	    	executive.setEmail(rs.getString("email"));
    	    	executive.setUsertype(rs.getString("usertype"));
    	        li.add(executive);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

	@Override
	public Executive getExecutiveById(int executiveId) {
		Executive executive=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM executive where id="+executiveId;
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	executive=new Executive();
		    	executive.setId(rs.getInt("id"));
		    	executive.setFirstname(rs.getString("firstname"));
		    	executive.setLastname(rs.getString("lastname"));
		    	executive.setEmail(rs.getString("email"));
		    	executive.setContact(rs.getString("contact"));	
		    	executive.setUsertype(rs.getString("usertype"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return executive;
	}

	@Override
	public List<Executive> getExecutiveByName(String executiveName) {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM executive where firstname like '%"+executiveName+"%'";
		ResultSet rs;
		Statement stmt;
		Executive executive;
		List<Executive> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	    	executive=new Executive();
    	    	executive.setId(rs.getInt("id"));
    	    	executive.setFirstname(rs.getString("firstname"));
    	    	executive.setLastname(rs.getString("lastname"));
    	    	executive.setContact(rs.getString("contact"));
    	    	executive.setEmail(rs.getString("email"));
    	    	executive.setUsertype(rs.getString("usertype"));
    	        li.add(executive);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

	

}
