package org.amisescalade.services;


import org.amisescalade.entity.UserCategory;

public interface IUserCategoryService {
	
	/**
	 * method to register a user
	 * 
	 * @param userCategory
	 * @return userCategory Object save
	 * @throws Exception
	 */
	UserCategory register(UserCategory userCategory) throws Exception;

}
