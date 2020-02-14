package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;


public interface ISpotComponentService {
	
	/**
	 * method to register a spotComponent
	 * 
	 * @param componentCode
	 * @param componentName
	 * @param componentRate
	 * @param componentDescription
	 * @param spot
	 * @return spotComponent object saved
	 * @throws Exception
	 */
	SpotComponent register(String componentCode, String componentName, String componentRate, String componentDescription,ComponentCategory componentCategory, Spot spot) throws Exception;
	
	/**
	 * method to modify a spotComponent
	 * 
	 * @param spotComponent
	 * @return spotComponent object modified
	 * @throws Exception
	 */
	SpotComponent edit(SpotComponent spotComponent) throws Exception;
	
	/**
	 * method to get a spotComponent by his id
	 * 
	 * @param spotComponent
	 * @return spotComponent object
	 * @throws Exception
	 */
	SpotComponent getSpotComponent(Long id) throws Exception;
	
	/**
	 * method to get all spotComponents
	 * 
	 * UTILE ?
	 * 
	 * @return the spotComponent list 
	 */
	List<SpotComponent> getAllSpotComponents();
	
	
	/**
	 * method to get all spotComponent by his name / Mot clé ?
	 * 
	 * @param spotComponentName
	 * @return the spotComponent list with his name to display
	 * @throws Exception
	 */
	List<SpotComponent> getAllSpotComponentByName(String spotComponentName) throws Exception;
	
	
	/**
	 * method to get all spotComponent by his ComponentCategory
	 * 
	 * @param ComponentCategory
	 * @return the spotComponent list from a ComponentCategory
	 * @throws Exception
	 */
	List<SpotComponent> getAllSpotComponentByCategory(ComponentCategory ComponentCategory) throws Exception;
	
	
	/**
	 * method to get all spotComponent by his spot
	 * 
	 * @param spot
	 * @return the spotComponent list from a spot
	 * @throws Exception
	 */
	List<SpotComponent> getAllSpotComponentBySpot(Spot spot) throws Exception;


}
