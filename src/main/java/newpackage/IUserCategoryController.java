package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Role;

public interface IUserCategoryController {
	
	/**
	 * method adding a user category
	 * 
	 * @param userCategoryLabel
	 * @return userCategory object added
	 */
	public Role addUserCategory(String userCategoryLabel);
	
	/**
	 * method editing a user category
	 * 
	 * @param userCategory
	 * @return userCategory object modified
	 */
	public Role editUserCategory(Role userCategory);
	
	/**
	 * method for display a user category
	 * 
	 * @param id
	 * @return userCategory object to display
	 */
	public Role displayUserCategory(Long id);
	
	/**
	 * method for display a user category by his label
	 * 
	 * @param label
	 * @return the user category list by label
	 */
	public List<Role> displayUserCategoryByLabel(String label);
	
	/**
	 * method for display all user category
	 * 
	 * @return the user category list
	 */
	public List<Role> displayAllUserCategory();
	
	

}
