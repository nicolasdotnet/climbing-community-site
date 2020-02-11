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
	 * @return
	 */
	public Webpage addWebpage(String title, String body, User author);
	
	/**
	 * method editing a web page
	 * 
	 * @param webpage
	 * @return
	 */
	public Webpage editWebpage(Webpage webpage);
	
	/**
	 * method for display a web page
	 * 
	 * @param id
	 * @return
	 */
	public Webpage displayWebpage(Long id);
	
	/**
	 * method for display all web page
	 * 
	 * @return
	 */
	public List<Webpage> displayAllWebpage();

}
