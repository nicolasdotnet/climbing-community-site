package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.User;
import org.springframework.data.domain.Page;

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
	 * method sample to user login
	 * 
	 * @param user
	 * @throws Exception
	 */
	void sampleLogin(User user) throws Exception;

	/**
	 * method to display all users
	 * 
	 * @return
	 */
	List<User> displayAll();
	
	
	

}
