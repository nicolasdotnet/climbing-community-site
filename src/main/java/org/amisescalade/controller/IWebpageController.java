package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;

public interface IWebpageController {
	
	
	/**
	 * @param title
	 * @param body
	 * @param author
	 * @return
	 */
	public Webpage addWebpage(String title, String body, User author);
	
	/**
	 * @param webpage
	 * @return
	 */
	public Webpage editWebpage(Webpage webpage);
	
	/**
	 * @param id
	 * @return
	 */
	public Webpage displayWebpage(Long id);
	
	/**
	 * @return
	 */
	public List<Webpage> displayAllWebpage();

}
