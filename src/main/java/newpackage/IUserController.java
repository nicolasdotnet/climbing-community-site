package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;

public interface IUserController {
	
	/**
	 * method to display the methods error message
	 * 
	 * @return error message
	 */
	public String getErrorMessage();
	
	/**
	 * example of user registration method
	 * 
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @return user object saved
	 */
	public User signUpByDefault(String firstname, String lastname, String username, String password);
	
	/**
	 * method for display a user
	 * 
	 * @param id
	 * @return user object find
	 */
	public User displayUser(Long id);
	
	/**
	 * method editing a user profile
	 * 
	 * @param user
	 * @return user object modified
	 */
	public User editUser(User user);
	
	/**
	 * example of user login method
	 * 
	 * @param username
	 * @param password
	 * @return login status : login (true) or no login (false)
	 */
	public Boolean signInUser(String username, String password);
	
	/**
	 * method for display all users
	 * 
	 * @return the users list 
	 */
	public List<User> displayAllUsers();

	/**
	 * method for display all users for a category
	 * 
	 * @param userCategory
	 * @return the list users from Role label
	 */
	public List<User> displayAllUsersByUserCategory(Role userCategory);

}
