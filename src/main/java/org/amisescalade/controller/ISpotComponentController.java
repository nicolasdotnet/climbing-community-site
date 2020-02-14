package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;

public interface ISpotComponentController {

	
	/**
	 * method to adding a spotComponent
	 * @param spotComponent
	 * 
	 * @return spotComponent object added
	 * @throws Exception
	 */
	public SpotComponent addSpotComponent (String componentCode, String componentName, String componentRate, String componentDescription, ComponentCategory componentCategory, Spot spot);

	/**
	 * method to modify a spotComponent
	 * 
	 * @param spotComponent
	 * @return spotComponent object modified
	 * @throws Exception
	 */
	public SpotComponent editSpotComponent (SpotComponent spotComponent);
	
	
	/**
	 * method to display a spotComponent by his id
	 * 
	 * @param spotComponent
	 * @return spotComponent object to display
	 * @throws Exception
	 */
	public SpotComponent displaySpotComponent (Long id);
	
	/**
	 * method to display all spotComponents by his name
	 * 
	 * @param spotComponentName
	 * @return the spotComponent list with his name to display
	 * @throws Exception
	 */
	public List<SpotComponent>displayAllSpotComponentByName (String spotComponentName);
	
	/**
	 * method to display all spotComponents from a spot
	 * 
	 * @param spot
	 * @return the spotComponent list to display
	 * @throws Exception
	 */
	public List<SpotComponent> displayAllSpotComponentBySpot(Spot spot) throws Exception;
}
