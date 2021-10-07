package com.ecommerce.pojo;

public class Store {
	
	private int id;
	private String name;
	private String location;
	private String ownername;
	private String contact;
	private String email;
	private String password;
	private int executiveId;
	private String usertype;
	private String storeImagePath;
	
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Store( String name, String location, String ownername, String contact, String email, String password,
			int executiveId, String usertype, String storeImagePath) {
		super();
		this.name = name;
		this.location = location;
		this.ownername = ownername;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.executiveId = executiveId;
		this.usertype = usertype;
		this.storeImagePath = storeImagePath;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getExecutiveId() {
		return executiveId;
	}
	public void setExecutiveId(int executiveId) {
		this.executiveId = executiveId;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getStoreImagePath() {
		return storeImagePath;
	}

	public void setStoreImagePath(String storeImagePath) {
		this.storeImagePath = storeImagePath;
	}
	
	
	
}
