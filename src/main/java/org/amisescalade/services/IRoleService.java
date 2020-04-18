package org.amisescalade.services;


import java.util.List;

import org.amisescalade.entity.Role;

public interface IRoleService {
	
	/**
	 * method to register a userCategory
	 * 
	 * @param category
	 * @return userCategory object saved
	 * @throws Exception
	 */
	Role register(String category) throws Exception;
	
	/**
	 * method to modify a userCategory
	 * 
	 * @param userCategory
	 * @return userCategory object modified
	 * @throws Exception
	 */
	Role edit(Role userCategory) throws Exception;
	
	/**
	 * method to get all user category
	 * 
	 * @return the user category list
	 */
	List<Role> getAllUserCategory();

	/**
	 * method to get a user category
	 * 
	 * @param id
	 * @return userCategory object find
	 * @throws Exception 
	 */
	Role getUserCategory(Long id) throws Exception;
	
	/**
	 * method to get a user category list by label
	 * 
	 * @param label
	 * @return userCategory object list find by label
	 * @throws Exception 
	 */
	List<Role> getUserCategoryByLabel(String label);
	
	/**
	 * method to get the default user category
	 * 
	 * @return default category for a user
	 * @throws Exception
	 */
	Role getDefaultUserCategory() throws Exception;
}
