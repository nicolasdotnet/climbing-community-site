package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;

public interface IUserService {
	
	/**
	 * method to register a user
	 * 
	 * @param user
	 * @return user Object save
	 * @throws Exception
	 */
	User register(User user) throws Exception;
	
	/**
	 * method to modify a user
	 * 
	 * @param user
	 * @return user Object modify
	 * @throws Exception
	 */
	User edit(User user) throws Exception;
	
	/**
	 * method to display one user
	 * 
	 * @param user
	 * @return user Object to display
	 * @throws Exception
	 */
	User displayOne(User user) throws Exception;
	
	/**
	 * method to display all users
	 * 
	 * @return the user list 
	 */
	List<User> displayAll();
	
	
	/**
	 * method sample to user login
	 * 
	 * @param user
	 * @throws Exception
	 */
	void sampleLogin(User user) throws Exception;
	
	/**
	 * method to display all users by category
	 * 
	 * @param UserCategory
	 * @return the list users with UserCategory label
	 */
	List<User> displayByCategory(UserCategory UserCategory);
	
	
	

}
