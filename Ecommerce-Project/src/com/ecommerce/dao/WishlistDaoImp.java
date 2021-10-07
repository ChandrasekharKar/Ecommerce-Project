package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.dbUtility.DBUtility;
import com.ecommerce.pojo.Wishlist;

public class WishlistDaoImp implements WishlistDao{

	@Override
	public boolean addToWishlist(Wishlist wishlist) {
		int row=0;
    	Connection con=DBUtility.getConnection();
    	String query="insert into wishlist(customerId, storeId) values(?,?)";
    	try
    	{
    	    PreparedStatement stmt= con.prepareStatement(query);
    	    stmt.setInt(1,wishlist.getCustomerId());
    	    stmt.setInt(2,wishlist.getStoreId());
    	      
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
	public List<Wishlist> getWishListByCustomerId(int customerId) {
		Connection con=DBUtility.getConnection();
		String query="SELECT * FROM wishlist where customerId="+customerId;
		ResultSet rs;
		Statement stmt;
		Wishlist wishlist;
		List<Wishlist> li=new ArrayList<>();
		
		try
    	{
    	    stmt=con.createStatement();
    	    rs=stmt.executeQuery(query);
    	    
    	    while(rs.next())
    	    {
    	    	wishlist=new Wishlist();
    	    	wishlist.setCustomerId(rs.getInt("customerId"));
    	    	wishlist.setStoreId(rs.getInt("storeId"));
    	    	wishlist.setId(rs.getInt("id"));
    	        li.add(wishlist);
    	    }
    	}
    	
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
    	
    	return li;
	}

}
