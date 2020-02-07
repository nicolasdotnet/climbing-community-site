package org.amisescalade.services;

import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserCategoryImpl implements IUserCategoryService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserCategoryRepository userCategoryRepository;

	@Override
	public UserCategory register(UserCategory userCategory) throws Exception {

		UserCategory userFind = userCategoryRepository.findByUserCategoryLabel(userCategory.getUserCategoryLabel());

		if (userFind != null) {

			log.error("La catégorie existe déjà !");

			throw new Exception("La catégorie existe déjà !");

		}

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
	public List<UserCategory> displayAll() {

		return userCategoryRepository.findAll();
	}

	@Override
	public UserCategory displayOneUserCategory(String label) {

		return userCategoryRepository.findByUserCategoryLabel(label);
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

}
