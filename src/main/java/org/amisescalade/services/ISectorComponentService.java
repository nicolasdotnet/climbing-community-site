package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;

public interface ISectorComponentService {
	
	/**
	 * method to register a sectorComponent
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object saved
	 * @throws Exception
	 */
	SectorComponent register(String componentCode, String componentName, String componentRate, String componentDescription, ComponentCategory componentCategory,Sector sector) throws Exception;
	
	/**
	 * method to modify a sectorComponent
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object modified
	 * @throws Exception
	 */
	SectorComponent edit(SectorComponent sectorComponent) throws Exception;
	
	/**
	 * method to get a sectorComponent by his id
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object
	 * @throws Exception
	 */
	SectorComponent getSectorComponent(Long id) throws Exception;
	
	/**
	 * method to get all sectorComponents
	 * 
	 * UTILE ?
	 * 
	 * @return the sectorComponent list 
	 */
	List<SectorComponent> getAllSectorComponent();
	
	
	/**
	 * method to get all sectorComponents by his name
	 * 
	 * @param sectorComponentName
	 * @return the sectorComponent list with his name
	 * @throws Exception
	 */
	List<SectorComponent> getAllSectorComponentByName(String sectorComponentName) throws Exception;
	
	
	/**
	 * method to get all sectorComponents by his ComponentCategory
	 * 
	 * @param ComponentCategory
	 * @return the sectorComponent list from a ComponentCategory
	 * @throws Exception
	 */
	List<SectorComponent> getAllSectorComponentByCategory(ComponentCategory ComponentCategory) throws Exception;
	
	
	/**
	 * method to get all sectorComponents by his sector
	 * 
	 * @param sector
	 * @return the sectorComponent list with his sector
	 * @throws Exception
	 */
	List<SectorComponent> getAllSectorComponentBySector(Sector sector) throws Exception;

}
