package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.Topo;

public interface ISpotController {
	
	/**
	 * method to adding a spot
	 * 
	 * @param spot
	 * @return spot object added
	 * @throws Exception
	 */	
	public Spot addSpot (String spotName, String spotRate, String spotDescription, String spotAccessPath, String departement, String country);

	/**
	 * method to modify a spot
	 * 
	 * @param spot
	 * @return spot object modified
	 * @throws Exception
	 */
	public Spot editSpot (Spot spot);
	
	
	/**
	 * method to display a spot by his id
	 * 
	 * @param spot
	 * @return spot object to display
	 * @throws Exception
	 */
	public Spot displaySpot (Long id);
	
	/**
	 * method to display all spots by his name
	 * 
	 * @param spotName
	 * @return the spot list with his name to display
	 * @throws Exception
	 */
	public List<Spot> displaySpotByName (String spotName);
	
	/**
	 * method to display all spots
	 * 
	 * @return the spot list 
	 */
	public List<Spot> displayAllSpots();

    	/**
	 * method to delete a spot
	 * 
	 * 
	 */
        
        public void removeSpot(Long id);

    public List<Spot> searchSpots(String spotName, String spotRate, String departement);

}
