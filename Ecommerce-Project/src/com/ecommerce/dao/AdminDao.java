package com.ecommerce.dao;

import com.ecommerce.pojo.Admin;

public interface AdminDao {
	
	boolean registerAdmin(Admin admin);
	Admin login(String email, String password);

}
