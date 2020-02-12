package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;

public interface ISectorService {
	
	/**
	 * method to register a sector
	 * 
	 * @param sector
	 * @return sector object saved
	 * @throws Exception
	 */
	Sector register(Sector sector) throws Exception;
	
	/**
	 * method to modify a sector
	 * 
	 * @param sector
	 * @return sector object modified
	 * @throws Exception
	 */
	Sector edit(Sector sector) throws Exception;
	
	/**
	 * method to display one sector by his id
	 * 
	 * @param sector
	 * @return sector object 
	 * @throws Exception
	 */
	Sector displayOne(Long id) throws Exception;
	
	/**
	 * method to display all sectors
	 * 
	 * @return the sector list 
	 */
	List<Sector> displayAll();
	
	
	/**
	 * method to display a sector by his name
	 * 
	 * @param sectorName
	 * @return the sector list with his name
	 * @throws Exception
	 */
	List<Sector> displayBySectorName(String sectorName) throws Exception;
	
	
	/**
	 * method to display one sector by his spot
	 * 
	 * @param spot
	 * @return the sector list with his spot to display
	 * @throws Exception
	 */
	List<Sector> displayBySpot(Spot spot) throws Exception;

}
