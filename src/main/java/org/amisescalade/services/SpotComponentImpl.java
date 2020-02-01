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
public class SpotComponentImpl implements ISpotComponentService{
	
	private static final Logger log = LogManager.getLogger(SpotComponentImpl.class);
	
	@Autowired
	private SpotComponentRepository spotComponentRepository;

	@Override
	public SpotComponent register(SpotComponent spotComponent) throws Exception {
		// check by title for no register double ?
		
		spotComponent.setComponentDate(new Date());
		return spotComponentRepository.save(spotComponent);
	}

	@Override
	public SpotComponent edit(SpotComponent spotComponent) throws Exception {
		
		Optional<SpotComponent> componentFind = spotComponentRepository.findById(spotComponent.getComponentId());

		if (componentFind.isEmpty()) {

			log.error("Modification Impossible ! le spotComponent " + spotComponent.getComponentId() + " n'existe pas dans la base.");

			throw new Exception("Le spotComponent n'existe pas !");

		}
		spotComponent.setComponentDate(new Date());
		return spotComponentRepository.saveAndFlush(spotComponent);
	}

	@Override
	public SpotComponent displayOne(Long id) throws Exception {
		
		Optional<SpotComponent> spotComponent = spotComponentRepository.findById(id);

		if (spotComponent.isEmpty()) {

			log.error("Modification Impossible ! le spotComponent " + id + " n'existe pas dans la base.");

			throw new Exception("Le spotComponent n'existe pas !");

		}
		return spotComponent.get();
	}

	@Override
	public List<SpotComponent> displayAll() {
		
		return spotComponentRepository.findAll();
	}

	@Override
	public List<SpotComponent> displayBySpotComponentName(String spotComponentName) throws Exception {
		
		return spotComponentRepository.findByComponentNameContainingIgnoreCase(spotComponentName);
	}

	@Override
	public List<SpotComponent> displayBySpotComponentCategory(ComponentCategory ComponentCategory) throws Exception {
		
		return spotComponentRepository.findByComponentCategory(ComponentCategory);
	}

	@Override
	public List<SpotComponent> displayBySpot(Spot spot) throws Exception {
		
		return spotComponentRepository.findBySpot(spot);
	}

}
