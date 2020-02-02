package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;

public interface ISpotCommentService {
	
	/**
	 * method to register a spotComment
	 * 
	 * @param spotComment
	 * @return spotComment Object save
	 * @throws Exception
	 */
	SpotComment register(SpotComment spotComment) throws Exception;
	
	/**
	 * method to modify a spotComment
	 * 
	 * @param spotComment
	 * @return spotComment Object modify
	 * @throws Exception
	 */
	SpotComment edit(SpotComment spotComment) throws Exception;
	
	/**
	 * method to display one spotComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param spotComment
	 * @return spotComment Object to display
	 * @throws Exception
	 */
	SpotComment displayOne(Long id) throws Exception;
	
	/**
	 * method to display all spotComments
	 * 
	 * UTILE ?
	 * 
	 * @return the spotComment list 
	 */
	List<SpotComment> displayAll();
	
	/**
	 * method to display one spotComment by his spot
	 * 
	 * @param spot
	 * @return the spotComment list with his spot to display
	 * @throws Exception
	 */
	List<SpotComment> displayBySpot(Spot spot) throws Exception;


}
