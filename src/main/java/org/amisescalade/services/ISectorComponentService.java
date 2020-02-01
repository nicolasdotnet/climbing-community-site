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
	 * @return sectorComponent Object save
	 * @throws Exception
	 */
	SectorComponent register(SectorComponent sectorComponent) throws Exception;
	
	/**
	 * method to modify a sectorComponent
	 * 
	 * @param sectorComponent
	 * @return sectorComponent Object modify
	 * @throws Exception
	 */
	SectorComponent edit(SectorComponent sectorComponent) throws Exception;
	
	/**
	 * method to display one sectorComponent by his id
	 * 
	 * @param sectorComponent
	 * @return sectorComponent Object to display
	 * @throws Exception
	 */
	SectorComponent displayOne(Long id) throws Exception;
	
	/**
	 * method to display all sectorComponents
	 * 
	 * UTILE ?
	 * 
	 * @return the sectorComponent list 
	 */
	List<SectorComponent> displayAll();
	
	
	/**
	 * method to display one sectorComponent by his name
	 * 
	 * @param sectorComponentName
	 * @return the sectorComponent list with his name to display
	 * @throws Exception
	 */
	List<SectorComponent> displayBySectorComponentName(String sectorComponentName) throws Exception;
	
	
	/**
	 * method to display one sectorComponent by his ComponentCategory
	 * 
	 * @param ComponentCategory
	 * @return the sectorComponent list with his ComponentCategory to display
	 * @throws Exception
	 */
	List<SectorComponent> displayBySectorComponentCategory(ComponentCategory ComponentCategory) throws Exception;
	
	
	/**
	 * method to display one sectorComponent by his sector
	 * 
	 * @param sector
	 * @return the sectorComponent list with his sector to display
	 * @throws Exception
	 */
	List<SectorComponent> displayBySector(Sector sector) throws Exception;

}