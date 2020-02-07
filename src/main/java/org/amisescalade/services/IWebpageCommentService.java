package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;

public interface IWebpageCommentService {
	
	/**
	 * method to register a webpageComment
	 * 
	 * @param body
	 * @param author
	 * @param webpage
	 * @return webpageComment Object save
	 * @throws Exception
	 */
	WebpageComment register(String body, User author, Webpage webpage) throws Exception;
	
	/**
	 * method to modify a webpageComment
	 * 
	 * @param webpageComment
	 * @return webpageComment Object modify
	 * @throws Exception
	 */
	WebpageComment edit(WebpageComment webpageComment) throws Exception;
	
	/**
	 * method to get a webpageComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param webpageComment
	 * @return webpageComment Object to display
	 * @throws Exception
	 */
	WebpageComment getWebpageComment(Long id) throws Exception;
	
	/**
	 * method to get all webpageComments
	 * 
	 * UTILE ?
	 * 
	 * @return the webpageComment list 
	 */
	List<WebpageComment> getAllWebpageComment();
	
	/**
	 * method to get all webpageComment by his webpage
	 * 
	 * @param webpage
	 * @return the webpageComment list 
	 * @throws Exception
	 */
	List<WebpageComment> getCommentByWebpage(Webpage webpage) throws Exception;

}
