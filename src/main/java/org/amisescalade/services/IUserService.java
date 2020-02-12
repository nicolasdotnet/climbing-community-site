package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;

public interface IUserService {
	
	/**
	 * method to register a user by default
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * 
	 * @return user object saved
	 * @throws Exception
	 */
	User registerByDefault(String firstname, String lastname, String username, String password) throws Exception;
	
	/**
	 * method to modify a user
	 * 
	 * @param user
	 * @return user object modified
	 * @throws Exception
	 */
	User edit(User user) throws Exception;
	
	/**
	 * method to get a user
	 * 
	 * @param id
	 * @return user object find
	 * @throws Exception
	 */
	User getUser(Long id) throws Exception;
	
	/**
	 * method to get all users
	 * 
	 * @return the users list 
	 */
	List<User> getAllUsers();
	
	/**
	 * method sample to user login
	 * 
	 * @param username
	 * @param password
	 * @return login status : login (true) or no login (false)
	 * @throws Exception
	 */
	Boolean sampleLogin(String username, String password) throws Exception;
	
	/**
	 * method to get all users for a category
	 * 
	 * @param UserCategory
	 * @return the list users from UserCategory label
	 */
	List<User> getUsersByCategory(UserCategory UserCategory);
	
	
	

}
