package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.entity.UserCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCategoryImpl implements IUserCategoryService {

	private static final Logger log = LogManager.getLogger(UserCategoryImpl.class);

	@Autowired
	private UserCategoryRepository userCategoryRepository;

	@Override
	public UserCategory register(String category) throws Exception {

		if (userCategoryRepository.findByUserCategoryLabelIgnoreCase(category) != null) {

			log.error("La catégorie existe déjà !");

			throw new Exception("La catégorie existe déjà !");

		}
		
		UserCategory userCategory = new UserCategory();
		
		userCategory.setUserCategoryLabel(category);
		userCategory.setUserCategoryDate(new Date());

		return userCategoryRepository.save(userCategory);
	}

	@Override
	public UserCategory edit(UserCategory userCategory) throws Exception {

		Optional<UserCategory> categoryFind = userCategoryRepository.findById(userCategory.getUserCategoryId());

		if (categoryFind.isEmpty()) {

			log.error("Modification Impossible ! la categorie " + userCategory.getUserCategoryId()
					+ " n'existe pas dans la base.");

			throw new Exception("La catégorie n'existe pas !");

		}

		// vérification de la saisie avec Spring Validator ?

		return userCategoryRepository.saveAndFlush(userCategory);
	}

	@Override
	public List<UserCategory> getAllUserCategory() {

		return userCategoryRepository.findAll();
	}

	@Override
	public UserCategory getUserCategory(Long id) throws Exception {

		Optional<UserCategory> categoryFind = userCategoryRepository.findById(id);

		if (categoryFind.isEmpty()) {

			log.error("Modification Impossible ! la categorie " + id
					+ " n'existe pas dans la base.");

			throw new Exception("La catégorie n'existe pas !");

		}
		return categoryFind.get();
	}

	@Override
	public UserCategory getDefaultUserCategory() throws Exception {

		Optional<UserCategory> defaultCategory = userCategoryRepository.findById(1L);

		if (defaultCategory.isEmpty()) {

			log.error("La categorie par défault n'existe pas dans la base.");

			throw new Exception("La catégorie par défault n'existe pas !");

		}

		return defaultCategory.get();
	}

	@Override
	public List<UserCategory> getUserCategoryByLabel(String label) {
		
		return userCategoryRepository.findByUserCategoryLabelContainingIgnoreCase(label);
	}

}
