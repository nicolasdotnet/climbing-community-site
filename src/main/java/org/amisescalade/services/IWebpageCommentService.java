package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;

public interface IWebpageCommentService {
	
	/**
	 * method to register a webpageComment
	 * 
	 * @param webpageComment
	 * @return webpageComment Object save
	 * @throws Exception
	 */
	WebpageComment register(WebpageComment webpageComment) throws Exception;
	
	/**
	 * method to modify a webpageComment
	 * 
	 * @param webpageComment
	 * @return webpageComment Object modify
	 * @throws Exception
	 */
	WebpageComment edit(WebpageComment webpageComment) throws Exception;
	
	/**
	 * method to display one webpageComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param webpageComment
	 * @return webpageComment Object to display
	 * @throws Exception
	 */
	WebpageComment displayOne(Long id) throws Exception;
	
	/**
	 * method to display all webpageComments
	 * 
	 * UTILE ?
	 * 
	 * @return the webpageComment list 
	 */
	List<WebpageComment> displayAll();
	
	/**
	 * method to display one webpageComment by his webpage
	 * 
	 * @param webpage
	 * @return the webpageComment list with his webpage to display
	 * @throws Exception
	 */
	List<WebpageComment> displayByWebpage(Webpage webpage) throws Exception;

}
