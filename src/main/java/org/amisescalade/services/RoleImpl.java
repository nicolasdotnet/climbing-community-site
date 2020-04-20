package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.UserCategoryRepository;
import org.amisescalade.entity.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleImpl implements IRoleService {

	private static final Logger log = LogManager.getLogger(RoleImpl.class);

	@Autowired
	private UserCategoryRepository userCategoryRepository;

	@Override
	public Role register(String category) throws Exception {

		if (userCategoryRepository.findByRoleNameIgnoreCase(category) != null) {

			log.error("La catégorie existe déjà !");

			throw new Exception("La catégorie existe déjà !");

		}
		
		Role userCategory = new Role();
		
		userCategory.setRoleName(category);
		userCategory.setRoleDate(new Date());

		return userCategoryRepository.save(userCategory);
	}

	@Override
	public Role edit(Role userCategory) throws Exception {

		Optional<Role> categoryFind = userCategoryRepository.findById(userCategory.getRoleId());

		if (!categoryFind.isPresent()) {

			log.error("Modification Impossible ! la categorie " + userCategory.getRoleId()
					+ " n'existe pas dans la base.");

			throw new Exception("La catégorie n'existe pas !");

		}

		// vérification de la saisie avec Spring Validator ?

		return userCategoryRepository.saveAndFlush(userCategory);
	}

	@Override
	public List<Role> getAllUserCategory() {

		return userCategoryRepository.findAll();
	}

	@Override
	public Role getUserCategory(Long id) throws Exception {

		Optional<Role> categoryFind = userCategoryRepository.findById(id);

		if (!categoryFind.isPresent()) {

			log.error("Modification Impossible ! la categorie " + id
					+ " n'existe pas dans la base.");

			throw new Exception("La catégorie n'existe pas !");

		}
		return categoryFind.get();
	}

	@Override
	public Role getDefaultUserCategory() throws Exception {

		Optional<Role> defaultCategory = userCategoryRepository.findById(1L);

		if (!defaultCategory.isPresent()) {

			log.error("La categorie par défault n'existe pas dans la base.");

			throw new Exception("La catégorie par défault n'existe pas !");

		}

		return defaultCategory.get();
	}

	@Override
	public List<Role> getUserCategoryByLabel(String label) {
		
		return userCategoryRepository.findByRoleNameContainingIgnoreCase(label);
	}

}
