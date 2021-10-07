package com.ecommerce.pojo;

public class Wishlist {
	
	private int id;
	private int storeId;
	private int customerId;
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Wishlist(int storeId, int customerId) {
		super();
		this.storeId = storeId;
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
