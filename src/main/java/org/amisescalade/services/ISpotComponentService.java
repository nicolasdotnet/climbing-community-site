package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;


public interface ISpotComponentService {
	
	/**
	 * method to register a spotComponent
	 * 
	 * @param spotComponent
	 * @return spotComponent object saved
	 * @throws Exception
	 */
	SpotComponent register(SpotComponent spotComponent) throws Exception;
	
	/**
	 * method to modify a spotComponent
	 * 
	 * @param spotComponent
	 * @return spotComponent object modified
	 * @throws Exception
	 */
	SpotComponent edit(SpotComponent spotComponent) throws Exception;
	
	/**
	 * method to display one spotComponent by his id
	 * 
	 * @param spotComponent
	 * @return spotComponent object
	 * @throws Exception
	 */
	SpotComponent displayOne(Long id) throws Exception;
	
	/**
	 * method to display all spotComponents
	 * 
	 * UTILE ?
	 * 
	 * @return the spotComponent list 
	 */
	List<SpotComponent> displayAll();
	
	
	/**
	 * method to display a spotComponent by his name
	 * 
	 * @param spotComponentName
	 * @return the spotComponent list with his name
	 * @throws Exception
	 */
	List<SpotComponent> displayBySpotComponentName(String spotComponentName) throws Exception;
	
	
	/**
	 * method to display a spotComponent by his ComponentCategory
	 * 
	 * @param ComponentCategory
	 * @return the spotComponent list with his ComponentCategory
	 * @throws Exception
	 */
	List<SpotComponent> displayBySpotComponentCategory(ComponentCategory ComponentCategory) throws Exception;
	
	
	/**
	 * method to display a spotComponent by his spot
	 * 
	 * @param spot
	 * @return the spotComponent list with his spot
	 * @throws Exception
	 */
	List<SpotComponent> displayBySpot(Spot spot) throws Exception;


}
