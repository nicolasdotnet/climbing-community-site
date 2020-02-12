package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;

public interface IWebpageController {
	
	
	/**
	 * method adding a web page to site
	 * 
	 * @param title
	 * @param body
	 * @param author
	 * @return Webpage object added
	 */
	public Webpage addWebpage(String title, String body, User author);
	
	/**
	 * method editing a web page
	 * 
	 * @param webpage
	 * @return Webpage object modified
	 */
	public Webpage editWebpage(Webpage webpage);
	
	/**
	 * method for display a web page
	 * 
	 * @param id
	 * @return Wepage object to display
	 */
	public Webpage displayWebpage(Long id);
	
	/**
	 * method for display all web page
	 * 
	 * @return the web page list
	 */
	public List<Webpage> displayAllWebpage();

}
