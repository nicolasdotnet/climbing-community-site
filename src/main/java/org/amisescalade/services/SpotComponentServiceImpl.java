package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SpotComponentRepository;
import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SpotComponentServiceImpl implements ISpotComponentService{
	
	private static final Logger log = LogManager.getLogger(SpotComponentServiceImpl.class);
	
	@Autowired
	private SpotComponentRepository spotComponentRepository;

	@Override
	public SpotComponent register(String componentCode, String componentName, String componentRate, String componentDescription, ComponentCategory componentCategory, Spot spot) throws Exception {
		// TODO check by title for no register double ?
		
		SpotComponent spotComponent = new SpotComponent();
		
		spotComponent.setComponentCode(componentCode);
		spotComponent.setComponentName(componentName);
		spotComponent.setComponentRate(componentRate);
		spotComponent.setComponentDescription(componentDescription);
		spotComponent.setComponentCategory(componentCategory);
		spotComponent.setSpot(spot);
		
		spotComponent.setComponentDate(new Date());
		return spotComponentRepository.save(spotComponent);
	}

	@Override
	public SpotComponent edit(SpotComponent spotComponent) throws Exception {
		
		Optional<SpotComponent> componentFind = spotComponentRepository.findById(spotComponent.getComponentId());

		if (!componentFind.isPresent()) {

			log.error("Modification Impossible ! le spotComponent " + spotComponent.getComponentId() + " n'existe pas dans la base.");

			throw new Exception("Le spotComponent n'existe pas !");

		}
		spotComponent.setComponentDate(new Date());
		return spotComponentRepository.saveAndFlush(spotComponent);
	}

	@Override
	public SpotComponent getSpotComponent(Long id) throws Exception {
		
		Optional<SpotComponent> spotComponent = spotComponentRepository.findById(id);

		if (!spotComponent.isPresent()) {

			log.error("Modification Impossible ! le spotComponent " + id + " n'existe pas dans la base.");

			throw new Exception("Le spotComponent n'existe pas !");

		}
		return spotComponent.get();
	}

	@Override
	public List<SpotComponent> getAllSpotComponents() {
		
		return spotComponentRepository.findAll();
	}

	@Override
	public List<SpotComponent> getAllSpotComponentByName(String spotComponentName) throws Exception {
		
		return spotComponentRepository.findByComponentNameContainingIgnoreCase(spotComponentName);
	}

	@Override
	public List<SpotComponent> getAllSpotComponentByCategory(ComponentCategory ComponentCategory) throws Exception {
		
		return spotComponentRepository.findByComponentCategory(ComponentCategory);
	}

	@Override
	public List<SpotComponent> getAllSpotComponentBySpot(Spot spot) throws Exception {
		
		return spotComponentRepository.findBySpot(spot);
	}

}
