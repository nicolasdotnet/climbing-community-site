package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.UserCategory;

public interface IUserCategoryController {
	
	/**
	 * method adding a user category
	 * 
	 * @param userCategoryLabel
	 * @return userCategory object added
	 */
	public UserCategory addUserCategory(String userCategoryLabel);
	
	/**
	 * method editing a user category
	 * 
	 * @param userCategory
	 * @return userCategory object modified
	 */
	public UserCategory editUserCategory(UserCategory userCategory);
	
	/**
	 * method for display a user category
	 * 
	 * @param id
	 * @return userCategory object to display
	 */
	public UserCategory displayUserCategory(Long id);
	
	/**
	 * method for display a user category by his label
	 * 
	 * @param label
	 * @return the user category list by label
	 */
	public List<UserCategory> displayUserCategoryByLabel(String label);
	
	/**
	 * method for display all user category
	 * 
	 * @return the user category list
	 */
	public List<UserCategory> displayAllUserCategory();
	
	

}
