package org.amisescalade.dao;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotComponentRepository extends JpaRepository<SpotComponent, Long>{
	
	List<SpotComponent> findByComponentNameContainingIgnoreCase (String componentName);
	
	List<SpotComponent> findByComponentCategory (ComponentCategory componentCategory);

	List<SpotComponent> findBySpot(Spot spot);

}
