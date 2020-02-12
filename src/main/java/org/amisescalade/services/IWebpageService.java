package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;

public interface IWebpageService {
	
	/**
	 * method to register a webpage
	 * 
	 * @param title
	 * @param body 
	 * @param author 
	 * @return webpage object saved
	 * @throws Exception
	 */
	Webpage register(String title, String body, User author) throws Exception;
	
	
	/**
	 * method to modify a webpage
	 * 
	 * @param webpage
	 * @return webpage object modified
	 * @throws Exception
	 */
	Webpage edit(Webpage webpage) throws Exception;
	
	
	/**
	 * method to get a webpage by his id
	 * 
	 * 
	 * @param webpage id
	 * @return webpageComment object to display
	 * @throws Exception
	 */
	Webpage getWebpage(Long id) throws Exception;
	
	/**
	 * method to get all webpages
	 * 
	 * @return the webpage list 
	 */
	List<Webpage> getAllWebpage();

}
