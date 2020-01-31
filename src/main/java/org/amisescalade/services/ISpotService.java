package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Spot;

public interface ISpotService {
	
	/**
	 * method to register a spot
	 * 
	 * @param spot
	 * @return spot Object save
	 * @throws Exception
	 */
	Spot register(Spot spot) throws Exception;
	
	/**
	 * method to modify a spot
	 * 
	 * @param spot
	 * @return spot Object modify
	 * @throws Exception
	 */
	Spot edit(Spot spot) throws Exception;
	
	/**
	 * method to display one spot by his id
	 * 
	 * @param spot
	 * @return spot Object to display
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
	 * @return the spot list with his title to display
	 * @throws Exception
	 */
	List<Spot> displayBySpotname(String spotname) throws Exception;

}
