package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Webpage;

public interface IWebpageService {
	
	/**
	 * method to register a webpage
	 * 
	 * @param webpage
	 * @return webpage Object save
	 * @throws Exception
	 */
	Webpage register(Webpage webpage) throws Exception;
	
	
	/**
	 * method to modify a webpage
	 * 
	 * @param webpage
	 * @return webpage Object modify
	 * @throws Exception
	 */
	Webpage edit(Webpage webpage) throws Exception;
	
	/**
	 * method to display all webpages
	 * 
	 * @return the webpage list 
	 */
	List<Webpage> displayAll();

}
