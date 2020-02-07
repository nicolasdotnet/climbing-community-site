package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.UserCategory;

public interface IUserCategoryController {
	
	/**
	 * @param userCategoryLabel
	 * @return
	 */
	public UserCategory addUserCategory(String userCategoryLabel);
	
	/**
	 * @param userCategory
	 * @return
	 */
	public UserCategory editUserCategory(UserCategory userCategory);
	
	/**
	 * @param id
	 * @return
	 */
	public UserCategory displayUserCategory(Long id);
	
	/**
	 * @param label
	 * @return
	 */
	public List<UserCategory> displayUserCategoryByLabel(String label);
	
	/**
	 * @return
	 */
	public List<UserCategory> displayAllUserCategory();
	
	

}
