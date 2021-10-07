package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.dbUtility.DBUtility;
import com.ecommerce.pojo.Store;
import com.ecommerce.pojo.Wishlist;

public class StoreDaoImp implements StoreDao {

	@Override
	public boolean addStore(Store store) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into store(name,location,ownername,contact,email,password,executiveid,usertype,storeImagePath) values(?,?,?,?,?,?,?,?,?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setString(1,store.getName());
    	    stmt.setString(2,store.getLocation());
    	    stmt.setString(3,store.getOwnername());
    	    stmt.setString(4,store.getContact());
    	    stmt.setString(5,store.getEmail());
    	    stmt.setString(6,store.getPassword());
    	    stmt.setInt(7,store.getExecutiveId());
    	    stmt.setString(8,store.getUsertype());
    	    stmt.setString(9,store.getStoreImagePath());
   
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
	public Store login(String email, String password) {
		Store store=null;
		   ResultSet rs;
		   Connection con=DBUtility.getConnection();
	       String query="SELECT * FROM store where email='"+email+"' and password='"+password+"'";
	       
		   try 
		   {
			Statement stmt=con.createStatement();
		    rs=stmt.executeQuery(query);
		    while(rs.next())
			{
		    	store=new Store();
		        store.setId(rs.getInt("id"));
		        store.setName(rs.getString("name"));
		        store.setLocation(rs.getString("location"));
		        store.setContact(rs.getString("contact"));
		        store.setEmail(rs.getString("email"));
		        store.setExecutiveId(rs.getInt("executiveId"));
		        store.setOwnername(rs.getString("ownername"));
		        store.setUsertype(rs.getString("usertype"));
		        store.setStoreImagePath(rs.getString("storeImagePath"));
			}
		   }
		   catch (SQLException e) 
		   {
			e.printStackTrace();
		   }
		   
		   return store;
	}

	@Override
	public List<Store> getAllStore() {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM store";
		ResultSet rs;
		Statement stmt;
		Store store;
		List<Store> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        store=new Store();
    	        store.setId(rs.getInt("id"));
    	        store.setName(rs.getString("name"));
    	        store.setLocation(rs.getString("location"));
    	        store.setOwnername(rs.getString("ownername"));
    	        store.setContact(rs.getString("contact"));
    	        store.setEmail(rs.getString("email"));
    	        store.setExecutiveId(rs.getInt("executiveId"));
    	        store.setUsertype(rs.getString("usertype"));
    	        store.setStoreImagePath(rs.getString("storeImagePath"));
    	        li.add(store);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

	@Override
	public List<Store> getStoreByExecutiveId(int executiveId) {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM store where executiveId="+executiveId;
		ResultSet rs;
		Statement stmt;
		Store store;
		List<Store> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        store=new Store();
    	        store.setName(rs.getString("name"));
    	        store.setLocation(rs.getString("location"));
    	        store.setOwnername(rs.getString("ownername"));
    	        store.setContact(rs.getString("contact"));
    	        store.setEmail(rs.getString("email"));
    	        store.setExecutiveId(rs.getInt("executiveId"));
    	        store.setUsertype(rs.getString("usertype"));
    	        store.setStoreImagePath(rs.getString("storeImagePath"));
    	        li.add(store);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

	@Override
	public Store getStoreById(int id) {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM store where id="+id;
		ResultSet rs;
		Statement stmt;
		Store store=new Store();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        store.setId(rs.getInt("id"));
    	        store.setName(rs.getString("name"));
    	        store.setLocation(rs.getString("location"));
    	        store.setOwnername(rs.getString("ownername"));
    	        store.setContact(rs.getString("contact"));
    	        store.setEmail(rs.getString("email"));
    	        store.setExecutiveId(rs.getInt("executiveId"));
    	        store.setUsertype(rs.getString("usertype"));
    	        store.setStoreImagePath(rs.getString("storeImagePath"));
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return store;
	}

	@Override
	public boolean updateStore(Store store) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="update store set name=?, location=?, ownername=?, contact=? where id=?";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setString(1,store.getName());
    	    stmt.setString(2,store.getLocation());
    	    stmt.setString(3,store.getOwnername());
    	    stmt.setString(4,store.getContact());
    	    stmt.setInt(5,store.getId());
   
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
	public List<Store> getStoresByWishlist(List<Wishlist> listOfWishlist) {
		Connection con=DBUtility.getConnection();
		List<Store> listOfStore =new ArrayList<>();
		for(Wishlist w : listOfWishlist ) {
			int storeId = w.getStoreId();
			String query="SELECT * FROM store where id="+storeId;
			ResultSet rs;
			Statement stmt;
			Store store=new Store();
			
			try
	    	{
	    	    stmt=con.createStatement();
	    	    rs=stmt.executeQuery(query);
	    	    
	    	    while(rs.next())
	    	    {
	    	        store.setId(rs.getInt("id"));
	    	        store.setName(rs.getString("name"));
	    	        store.setLocation(rs.getString("location"));
	    	        store.setOwnername(rs.getString("ownername"));
	    	        store.setContact(rs.getString("contact"));
	    	        store.setEmail(rs.getString("email"));
	    	        store.setExecutiveId(rs.getInt("executiveId"));
	    	        store.setUsertype(rs.getString("usertype"));
	    	        store.setStoreImagePath(rs.getString("storeImagePath"));
	    	    }
	    	    
	    	    listOfStore.add(store);
	    	}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
    	return listOfStore;
	}

	@Override
	public int getCountOfStore() {
		Connection con=DBUtility.getConnection();
		String query="SELECT count(*) as totalstore from store";
		ResultSet rs;
		Statement stmt;
		int count=0;
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	        count = rs.getInt("totalstore");
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
		System.out.println("total no of store => " +count);

    	return count;
	}

	@Override
	public List<Store> getStoreByName(String storeName) {
		Connection con=DBUtility.getConnection();
		List<Store> listOfStore =new ArrayList<>();
		String query="SELECT * FROM store where name like'%"+storeName+"%'";
		ResultSet rs;
		Statement stmt;
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	    	Store store=new Store();
    	        store.setId(rs.getInt("id"));
    	        store.setName(rs.getString("name"));
    	        store.setLocation(rs.getString("location"));
    	        store.setOwnername(rs.getString("ownername"));
    	        store.setContact(rs.getString("contact"));
    	        store.setEmail(rs.getString("email"));
    	        store.setExecutiveId(rs.getInt("executiveId"));
    	        store.setUsertype(rs.getString("usertype"));
    	        store.setStoreImagePath(rs.getString("storeImagePath"));
    	        listOfStore.add(store);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return listOfStore;
	}

}
