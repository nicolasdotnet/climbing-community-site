package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Spot;

public interface ISpotService {
	
	/**
	 * method to register a spot
	 * 
	 * @param spot
	 * @return spot object saved
	 * @throws Exception
	 */
	Spot register(Spot spot) throws Exception;
	
	/**
	 * method to modify a spot
	 * 
	 * @param spot
	 * @return spot object modified
	 * @throws Exception
	 */
	Spot edit(Spot spot) throws Exception;
	
	/**
	 * method to display a spot by his id
	 * 
	 * @param spot
	 * @return spot object
	 * @throws Exception
	 */
	Spot displayOne(Long id) throws Exception;
	
	/**
	 * method to display all spots
	 * 
	 * @return the spot list 
	 */
	List<Spot> displayAll();
	
	
	/**
	 * method to display one spot by his name
	 * 
	 * @param spotname
	 * @return the spot list with his title
	 * @throws Exception
	 */
	List<Spot> displayBySpotname(String spotname) throws Exception;
	
}
