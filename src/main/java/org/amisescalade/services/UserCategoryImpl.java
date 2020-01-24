package org.amisescalade.services;


import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.entity.UserCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCategoryImpl implements IUserCategoryService{
	
	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserCategoryRepository userCategoryRepository;

	@Override
	public UserCategory register(UserCategory userCategory) throws Exception {

		UserCategory userFind = userCategoryRepository.findByUserCategoryLabel(userCategory.getUserCategoryLabel());
		
		if (userFind != null) {
			
			log.error("La catégorie existe déjà !");
			
		}
		
		return userCategoryRepository.save(userCategory);
	}
	
	

}
