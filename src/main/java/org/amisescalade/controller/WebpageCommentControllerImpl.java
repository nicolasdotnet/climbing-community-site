package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;
import org.amisescalade.services.IWebpageCommentService;
import org.amisescalade.services.IWebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class WebpageCommentControllerImpl implements IWebpageCommentController{
	
	@Autowired
	private IWebpageCommentService iWebpageCommentService;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public WebpageComment addWebpageComment(String body, User author, Webpage webpage) {
		
		WebpageComment webpageCommentSave = new WebpageComment();

		try {
			webpageCommentSave = iWebpageCommentService.register(body, author, webpage);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return webpageCommentSave;
		
	}

	@Override
	public WebpageComment displayWebpageComment(Long id) {
		
		WebpageComment webpageCommentFind = new WebpageComment();

		try {
			webpageCommentFind = iWebpageCommentService.getWebpageComment(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return webpageCommentFind;
	}

	@Override
	public List<WebpageComment> displayAllWebpageComment() {
		return iWebpageCommentService.getAllWebpageComment();
	}

	@Override
	public List<WebpageComment> displayAllWebpageCommentByWebpage(Webpage webpage) throws Exception {
		
		return iWebpageCommentService.getCommentByWebpage(webpage);
	}

}
