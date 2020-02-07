package org.amisescalade.services;


import java.util.List;

import org.amisescalade.entity.User;
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
	 * @return the user category list
	 */
	List<UserCategory> displayAll();

	/**
	 * method to display one user category
	 * 
	 * @param category
	 * @return userCategory Object find
	 */
	UserCategory displayOneUserCategory(String category);
	
	/**
	 * method to get the default user category
	 * 
	 * @return default category for a user
	 * @throws Exception
	 */
	UserCategory getDefaultUserCategory() throws Exception;
}
