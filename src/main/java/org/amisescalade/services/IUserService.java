package org.amisescalade.services;

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
	
	
	
	
	

}
