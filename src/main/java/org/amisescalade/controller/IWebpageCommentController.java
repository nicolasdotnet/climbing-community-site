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
	 * @return
	 */
	public WebpageComment addWebpageComment(String body, User author, Webpage webpage);
	
	/**
	 * @param id
	 * @return
	 */
	public WebpageComment displayWebpageComment(Long id);
	
	/**
	 * @return
	 */
	public List<WebpageComment> displayAllWebpageComment();
	
	/**
	 * @param webpage
	 * @return
	 * @throws Exception
	 */
	public List<WebpageComment> displayAllWebpageCommentByWebpage(Webpage webpage) throws Exception;

}
