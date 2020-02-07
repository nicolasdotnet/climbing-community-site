package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;

public interface IUserController {
	
	/**
	 * 
	 * 
	 * @return error message
	 */
	public String getErrorMessage();
	
	/**
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @return
	 */
	public User signUpByDefault(String firstname, String lastname, String username, String password);
	
	/**
	 * @param id
	 * @return
	 */
	public User displayUser(Long id);
	
	/**
	 * @param user
	 * @return
	 */
	public User editUser(User user);
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean signInUser(String username, String password);
	
	/**
	 * @return
	 */
	public List<User> displayAllUsers();

	/**
	 * @param userCategory
	 * @return
	 */
	public List<User> displayAllUsersByUserCategory(UserCategory userCategory);

}
