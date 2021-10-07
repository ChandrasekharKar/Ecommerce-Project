package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.pojo.Store;
import com.ecommerce.pojo.Wishlist;

public interface StoreDao {
	
	boolean addStore(Store store);
	Store login(String email, String password);
	List<Store> getAllStore();
	List<Store> getStoreByExecutiveId(int executiveId);
	Store getStoreById(int id);
	List<Store> getStoreByName(String storeName);
	boolean updateStore(Store store);
	List<Store> getStoresByWishlist(List<Wishlist> listOfWishlist);
	int getCountOfStore();

}
