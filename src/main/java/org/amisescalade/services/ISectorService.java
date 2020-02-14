package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;

public interface ISectorService {
	
	/**
	 * method to register a sector with a spot
	 * 
	 * @param sectorName
	 * @param sectorRate
	 * @param sectorDescription
	 * @param sectorAccessPath
	 * @param spot
	 * @return sector object saved
	 * @throws Exception
	 */
	Sector registerBySpot (String sectorName, String sectorRate, String sectorDescription, String sectorAccessPath, Spot spot) throws Exception;
	
	/**
	 * method to register a sector by default
	 * 
	 * @param sectorName
	 * @param sectorRate
	 * @param sectorDescription
	 * @param sectorAccessPath
	 * @return sector object saved
	 * @throws Exception
	 */
	Sector registerByDefault (String sectorName, String sectorRate, String sectorDescription, String sectorAccessPath) throws Exception;
	
	/**
	 * method to modify a sector
	 * 
	 * @param sector
	 * @return sector object modified
	 * @throws Exception
	 */
	Sector edit(Sector sector) throws Exception;
	
	/**
	 * method to get a sector by his id
	 * 
	 * @param sector
	 * @return sector object 
	 * @throws Exception
	 */
	Sector getSector(Long id) throws Exception;
	
	/**
	 * method to get all sectors
	 * 
	 * @return the sector list 
	 */
	List<Sector> getAllSectors();
	
	
	/**
	 * method to get all sectors by his name
	 * 
	 * @param sectorName
	 * @return the sector list with his name
	 * @throws Exception
	 */
	List<Sector> getAllSectorsByName(String sectorName) throws Exception;
	
	
	/**
	 * method to get all sectors by his spot
	 * 
	 * @param spot
	 * @return the sector list with his spot to display
	 * @throws Exception
	 */
	List<Sector> getAllSectorsBySpot(Spot spot) throws Exception;

}
