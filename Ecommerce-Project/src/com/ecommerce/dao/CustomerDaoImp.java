package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbUtility.DBUtility;
import com.ecommerce.pojo.Customer;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public boolean registerCustomer(Customer customer) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into customer(firstname,lastname,email,contact,password,usertype) values(?,?,?,?,?,?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setString(1,customer.getFirstname());
    	    stmt.setString(2,customer.getLastname());
    	    stmt.setString(3,customer.getEmail());
    	    stmt.setString(4,customer.getContact());
    	    stmt.setString(5,customer.getPassword());
    	    stmt.setString(6,customer.getUsertype());
    	    
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
	public Customer login(String email, String password) {
		Customer customer=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM customer where email='"+email+"' and password='"+password+"'";
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	customer=new Customer();
		    	customer.setId(rs.getInt("id"));
		    	customer.setFirstname(rs.getString("firstname"));
		    	customer.setLastname(rs.getString("lastname"));
		    	customer.setEmail(rs.getString("email"));
		    	customer.setContact(rs.getString("contact"));	
		    	customer.setUsertype(rs.getString("usertype"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return customer;
	}
	
	@Override
	public int getCountOfCustomer() {
		Connection con=DBUtility.getConnection();
		String query="SELECT count(*) as totalcustomer from customer";
		ResultSet rs;
		Statement stmt;
		int count=0;
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        count = rs.getInt("totalcustomer");
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	System.out.println("total no of customer => " +count);
    	return count;
	}

	@Override
	public boolean updateVisitorCounter(int id, int count) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="update visitorDetail set visitorcount=? where id=?";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setInt(1,count);
    	    stmt.setInt(2, id);
    	    
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
	public int getVisitorCounter() {
		Connection con=DBUtility.getConnection();
		String query="SELECT visitorcount from visitorDetail where id=1";
		ResultSet rs;
		Statement stmt;
		int count=0;
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        count = rs.getInt("visitorcount");
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return count;
	}

	@Override
	public boolean addVisitorCounter() {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into visitorDetail(visitorcount) values(?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setInt(1,1);
    	    
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
	public int getCountOfVisitorDetail() {
		Connection con=DBUtility.getConnection();
		String query="SELECT count(*) from visitorDetail";
		ResultSet rs;
		Statement stmt;
		int count=0;
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        count = rs.getInt("count(*)");
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return count;
	}

	public List<Customer> getAllCustomers() {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM customer";
		ResultSet rs;
		Statement stmt;
		Customer customer;
		List<Customer> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	    	customer=new Customer();
    	    	customer.setId(rs.getInt("id"));
		    	customer.setFirstname(rs.getString("firstname"));
		    	customer.setLastname(rs.getString("lastname"));
		    	customer.setEmail(rs.getString("email"));
		    	customer.setContact(rs.getString("contact"));	
		    	customer.setUsertype(rs.getString("usertype"));
    	        li.add(customer);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer customer=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM customer where id="+id;
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	customer=new Customer();
		    	customer.setId(rs.getInt("id"));
		    	customer.setFirstname(rs.getString("firstname"));
		    	customer.setLastname(rs.getString("lastname"));
		    	customer.setEmail(rs.getString("email"));
		    	customer.setContact(rs.getString("contact"));	
		    	customer.setUsertype(rs.getString("usertype"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return customer;
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		Customer customer=null;
		List<Customer> customers = new ArrayList<>();
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM customer where firstname like '%"+name+"%'";
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	customer=new Customer();
		    	customer.setId(rs.getInt("id"));
		    	customer.setFirstname(rs.getString("firstname"));
		    	customer.setLastname(rs.getString("lastname"));
		    	customer.setEmail(rs.getString("email"));
		    	customer.setContact(rs.getString("contact"));	
		    	customer.setUsertype(rs.getString("usertype"));
		    	customers.add(customer);

			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return customers;
	}

}
