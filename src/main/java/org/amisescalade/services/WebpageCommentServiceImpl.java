package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.WebpageCommentRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.amisescalade.entity.WebpageComment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WebpageCommentServiceImpl implements IWebpageCommentService{
	
private static final Logger log = LogManager.getLogger(WebpageCommentServiceImpl.class);
	
	
	@Autowired
	private WebpageCommentRepository webpageCommentRepository;

	@Override
	public WebpageComment register(String body, User author, Webpage webpage) throws Exception {		
		
		WebpageComment webpageComment = new WebpageComment();
		
		webpageComment.setCommentBody(body);
		webpageComment.setCommentAuthor(author);
		webpageComment.setCommentDate(new Date());
		webpageComment.setCommentStatus(true);
		webpageComment.setWebpage(webpage);
		return webpageCommentRepository.save(webpageComment);
	}

	@Override
	public WebpageComment edit(WebpageComment webpageComment) throws Exception {
		
		Optional<WebpageComment> commentFind = webpageCommentRepository.findById(webpageComment.getCommentId());

		if (commentFind.isEmpty()) {

			log.error("Modification Impossible ! le webpageComment " + webpageComment.getCommentId() + " n'existe pas dans la base.");

			throw new Exception("Le webpageComment n'existe pas !");

		}
		webpageComment.setCommentDate(new Date());
		return webpageCommentRepository.saveAndFlush(webpageComment);
	}

	@Override
	public WebpageComment getWebpageComment(Long id) throws Exception {
		
		Optional<WebpageComment> webpageCommentFind = webpageCommentRepository.findById(id);

		if (webpageCommentFind.isEmpty()) {

			log.error("Modification Impossible ! le webpageComment " + id + " n'existe pas dans la base.");

			throw new Exception("Le webpageComment n'existe pas !");

		}
		return webpageCommentFind.get();
	}

	@Override
	public List<WebpageComment> getAllWebpageComment() {
		
		return webpageCommentRepository.findAll();
	}
	

	@Override
	public List<WebpageComment> getCommentByWebpage(Webpage webpage) throws Exception {
		
		return webpageCommentRepository.findByWebpage(webpage);
	}


}
