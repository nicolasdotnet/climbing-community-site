package org.amisescalade.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;

public interface ISectorController {
	
	/**
	 * method to adding a sector with a spot
	 * 
	 * @param sectorName
	 * @param sectorRate
	 * @param sectorDescription
	 * @param sectorAccessPath
	 * @param spot
	 * @return sector object added
	 */
	public Sector addSectorBySpot (String sectorName, String sectorRate, String sectorDescription, String sectorAccessPath, Spot spot);

	/**
	 * method to adding a sector by default
	 * 
	 * @param sectorName
	 * @param sectorRate
	 * @param sectorDescription
	 * @param sectorAccessPath
	 * @return sector object added
	 */
	public Sector addSectorByDefault (String sectorName, String sectorRate, String sectorDescription, String sectorAccessPath);

	/**
	 * method to modify a sector
	 * 
	 * @param sector
	 * @return sector object modified
	 * @throws Exception
	 */
	public Sector editSector (Sector sector);
	
	
	/**
	 * method to display a sector by his id
	 * 
	 * @param sector
	 * @return sector object to display
	 * @throws Exception
	 */
	public Sector displaySector (Long id);
	
	/**
	 * method to display all sectors by his name
	 * 
	 * @param sectorName
	 * @return the sector list with his name to display
	 * @throws Exception
	 */
	public List<Sector> displayAllSectorsByName (String sectorName) throws Exception;
	
	/**
	 * method to display all sectors by his spot
	 * 
	 * @param sectorName
	 * @return the sector list with his name to display
	 * @throws Exception
	 */
	public List<Sector> displayAllSectorsBySpot (Spot spot) throws Exception;
	
	/**
	 * method to display all sectors
	 * 
	 * @return the sector list with his name to display
	 * @throws Exception
	 */
	public List<Sector> displayAllSectors();


}
