package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.WebpageRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WebpageServiceImpl implements IWebpageService{
	
	private static final Logger log = LogManager.getLogger(WebpageServiceImpl.class);
	
	@Autowired
	private WebpageRepository webpageRepository;

	@Override
	public Webpage register(String title, String body, User author) throws Exception {
		
		Webpage webpageFind = webpageRepository.findByWebpageTitle(title);

		if (webpageFind != null) {

			log.error("Le titre existe déjà !");

			throw new Exception("Le titre existe déjà !");

		}
		
		// TODO check by title for no register double ?
		
		Webpage webpage = new Webpage();
		
		webpage.setWebpageTitle(title);
		webpage.setWebpageBody(body);
		webpage.setWebpageAuthor(author);
		webpage.setWebpageDate(new Date());
		
		return webpageRepository.save(webpage);
	}

	@Override
	public Webpage edit(Webpage webpage) throws Exception {
		
		Optional<Webpage> webpageFind = webpageRepository.findById(webpage.getWebpageId());
		
		if (!webpageFind.isPresent()) {
			
			log.error("Modification Impossible ! la webpage "+ webpage.getWebpageId()+" n'existe pas dans la base.");
			
			throw new Exception("La webpage n'existe pas !");	
		}
		
		// TODO check by title for no register double ?
		
		return webpageRepository.saveAndFlush(webpage);
	}
	
	@Override
	public Webpage getWebpage(Long id) throws Exception {
		
		Optional<Webpage> webpageFind = webpageRepository.findById(id);

		if (!webpageFind.isPresent()) {

			log.error("Modification Impossible ! le webpage " + id + " n'existe pas dans la base.");

			throw new Exception("Le webpage n'existe pas !");

		}
		return webpageFind.get();
	}

	@Override
	public List<Webpage> getAllWebpage() {
		
		return webpageRepository.findAll();
	}


}
