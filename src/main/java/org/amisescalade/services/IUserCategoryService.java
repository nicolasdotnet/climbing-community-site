package org.amisescalade.services;


import java.util.List;

import org.amisescalade.entity.UserCategory;

public interface IUserCategoryService {
	
	/**
	 * method to register a userCategory
	 * 
	 * @param userCategory
	 * @return userCategory Object save
	 * @throws Exception
	 */
	UserCategory register(UserCategory userCategory) throws Exception;
	
	/**
	 * method to modify a userCategory
	 * 
	 * @param userCategory
	 * @return userCategory Object modify
	 * @throws Exception
	 */
	UserCategory edit(UserCategory userCategory) throws Exception;
	
	/**
	 * method to display all user category
	 * 
	 * @return
	 */
	List<UserCategory> displayAll();

}
