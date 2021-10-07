package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.pojo.Executive;

public interface ExecutiveDao {
	
	boolean registerExecutive(Executive executive);
    Executive login(String email, String password);
    int getCountOfExecutive();
    List<Executive> getAllExecutives();
    Executive getExecutiveById(int executiveId);
    List<Executive> getExecutiveByName(String executiveName);

}
