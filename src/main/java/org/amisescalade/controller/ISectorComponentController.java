package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;

public interface ISectorComponentController {

	
	/**
	 * method to adding a sectorComponent
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object added
	 * @throws Exception
	 */
	public SectorComponent addSectorComponent (String componentCode, String componentName, String componentRate, String componentDescription, ComponentCategory componentCategory,Sector sector);

	/**
	 * method to modify a sectorComponent
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object modified
	 * @throws Exception
	 */
	public SectorComponent editSectorComponent (SectorComponent sectorComponent);
	
	
	/**
	 * method to display a sectorComponent by his id
	 * 
	 * @param sectorComponent
	 * @return sectorComponent object to display
	 * @throws Exception
	 */
	public SectorComponent displaySectorComponent (Long id);
	
	/**
	 * method to display all sectorComponents by his name
	 * 
	 * @param sectorComponentName
	 * @return the sectorComponent list with his name to display
	 * @throws Exception
	 */
	public List<SectorComponent> displaySectorComponentByName (String sectorComponentName);
	
	/**
	 * method to display all sectorComponents from a sector
	 * 
	 * @param sector
	 * @return the sectorComponent list to display
	 * @throws Exception
	 */
	public List<SectorComponent> displayAllSectorComponentBySector(Sector sector) throws Exception;
}
