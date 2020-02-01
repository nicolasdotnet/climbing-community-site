package org.amisescalade.services;

import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.ComponentCategoryRepository;
import org.amisescalade.entity.ComponentCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComponentCategoryServiceImpl implements IComponentCategoryService {
	
	private static final Logger log = LogManager.getLogger(ComponentCategoryServiceImpl.class);
	
	@Autowired
	private ComponentCategoryRepository componentCategoryRepository;
	
	

	@Override
	public ComponentCategory register(ComponentCategory componentCategory) throws Exception {
		
		ComponentCategory categoryFind = componentCategoryRepository.findByLabelComponentCategory(componentCategory.getLabelComponentCategory());
		
		if (categoryFind != null) {
			
			log.error("La component catégorie existe déjà !");
			
			throw new Exception("La component catégorie existe déjà !");
			
		}
		
		return componentCategoryRepository.save(componentCategory);
	}

	@Override
	public ComponentCategory edit(ComponentCategory componentCategory) throws Exception {
		
		Optional<ComponentCategory> categoryFind = componentCategoryRepository.findById(componentCategory.getIdComponentCategory());
		
		if (categoryFind.isEmpty()) { 
			
			log.error("Modification Impossible ! la component categorie "+ componentCategory.getIdComponentCategory()+" n'existe pas dans la base.");
		
			throw new Exception("La component catégorie n'existe pas !");
			
		}
		
		// vérification de la saisie avec Spring Validator ?
		
		return componentCategoryRepository.saveAndFlush(componentCategory);
	}

	@Override
	public List<ComponentCategory> displayAll() {
		
		return componentCategoryRepository.findAll();
	}
	}

