package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;

public interface IWebpageCommentController {
	
	/**
	 * method adding a comment to web page
	 * 
	 * @param body
	 * @param author
	 * @param webpage
	 * @return WebPageComment object added
	 */
	public WebpageComment addWebpageComment(String body, User author, Webpage webpage);
	
	/**
	 * method to modify a webpageComment
	 * 
	 * @param webpageComment
	 * @return webpageComment object modified
	 * @throws Exception
	 */
	public WebpageComment editWebpageComment (WebpageComment webpageComment);
	
	/**
	 * method for display a web page comment
	 * 
	 * @param id
	 * @return WebPageComment object to display
	 */
	public WebpageComment displayWebpageComment(Long id);
	
	/**
	 * method for display all web page comments
	 * 
	 * @return the WebPageComment list
	 */
	public List<WebpageComment> displayAllWebpageComment();
	
	/**
	 * method for display all comments for a web page
	 * 
	 * @param webpage
	 * @return the WebPageComment list by web page
	 * @throws Exception
	 */
	public List<WebpageComment> displayAllWebpageCommentByWebpage(Webpage webpage) throws Exception;

}
