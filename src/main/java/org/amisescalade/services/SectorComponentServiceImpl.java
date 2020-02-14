package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SectorComponentRepository;
import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;
import org.amisescalade.entity.SpotComponent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SectorComponentServiceImpl implements ISectorComponentService {
	
	private static final Logger log = LogManager.getLogger(SectorComponentServiceImpl.class);
	
	@Autowired
	private SectorComponentRepository sectorComponentRepository;

	@Override
	public SectorComponent register(String componentCode, String componentName, String componentRate, String componentDescription, ComponentCategory componentCategory,Sector sector) throws Exception {
		
		// TODO check by title for no register double ?
		
		SectorComponent sectorComponent = new SectorComponent();
		
		sectorComponent.setComponentCode(componentCode);
		sectorComponent.setComponentName(componentName);
		sectorComponent.setComponentRate(componentRate);
		sectorComponent.setComponentDescription(componentDescription);
		sectorComponent.setComponentCategory(componentCategory);
		sectorComponent.setSector(sector);
		
		sectorComponent.setComponentDate(new Date());
		return sectorComponentRepository.save(sectorComponent);
	}

	@Override
	public SectorComponent edit(SectorComponent sectorComponent) throws Exception {
		
		Optional<SectorComponent> componentFind = sectorComponentRepository.findById(sectorComponent.getComponentId());

		if (componentFind.isEmpty()) {

			log.error("Modification Impossible ! le sectorComponent " + sectorComponent.getComponentId() + " n'existe pas dans la base.");

			throw new Exception("Le sectorComponent n'existe pas !");

		}
		sectorComponent.setComponentDate(new Date());
		return sectorComponentRepository.saveAndFlush(sectorComponent);
	}

	@Override
	public SectorComponent getSectorComponent(Long id) throws Exception {
		
		Optional<SectorComponent> sectorComponent = sectorComponentRepository.findById(id);

		if (sectorComponent.isEmpty()) {

			log.error("Modification Impossible ! le sectorComponent " + id + " n'existe pas dans la base.");

			throw new Exception("Le sectorComponent n'existe pas !");

		}
		return sectorComponent.get();
	}

	@Override
	public List<SectorComponent> getAllSectorComponent() {
		
		return sectorComponentRepository.findAll();
	}

	@Override
	public List<SectorComponent> getAllSectorComponentByName(String sectorComponentName) throws Exception {
		
		return sectorComponentRepository.findByComponentNameContainingIgnoreCase(sectorComponentName);
	}

	@Override
	public List<SectorComponent> getAllSectorComponentByCategory(ComponentCategory ComponentCategory)
			throws Exception {
		
		return sectorComponentRepository.findByComponentCategory(ComponentCategory);
	}

	@Override
	public List<SectorComponent> getAllSectorComponentBySector(Sector sector) throws Exception {
		
		return sectorComponentRepository.findBySector(sector);
	}


}
