package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorComponentRepository extends JpaRepository<SectorComponent, Long>{
	
	List<SectorComponent> findByComponentNameContainingIgnoreCase (String componentName);
	
	List<SectorComponent> findByComponentCategory (ComponentCategory componentCategory);

	List<SectorComponent> findBySector(Sector sector);
	

}