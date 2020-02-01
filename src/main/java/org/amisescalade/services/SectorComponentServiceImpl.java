package org.amisescalade.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.amisescalade.dao.SectorComponentRepository;
import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;
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
	public SectorComponent register(SectorComponent sectorComponent) throws Exception {
		
		// check by title for no register double ?
		
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
	public SectorComponent displayOne(Long id) throws Exception {
		
		Optional<SectorComponent> sectorComponent = sectorComponentRepository.findById(id);

		if (sectorComponent.isEmpty()) {

			log.error("Modification Impossible ! le sectorComponent " + id + " n'existe pas dans la base.");

			throw new Exception("Le sectorComponent n'existe pas !");

		}
		return sectorComponent.get();
	}

	@Override
	public List<SectorComponent> displayAll() {
		
		return sectorComponentRepository.findAll();
	}

	@Override
	public List<SectorComponent> displayBySectorComponentName(String sectorComponentName) throws Exception {
		
		return sectorComponentRepository.findByComponentNameContainingIgnoreCase(sectorComponentName);
	}

	@Override
	public List<SectorComponent> displayBySectorComponentCategory(ComponentCategory ComponentCategory)
			throws Exception {
		
		return sectorComponentRepository.findByComponentCategory(ComponentCategory);
	}

	@Override
	public List<SectorComponent> displayBySector(Sector sector) throws Exception {
		
		return sectorComponentRepository.findBySector(sector);
	}


}
