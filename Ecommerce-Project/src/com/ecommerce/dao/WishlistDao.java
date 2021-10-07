package com.ecommerce.dao;

import java.util.List;
import com.ecommerce.pojo.Wishlist;

public interface WishlistDao {
	
	boolean addToWishlist(Wishlist wishlist);
	List<Wishlist> getWishListByCustomerId(int customerId);

}
