package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.User;

public interface ISpotCommentService {
	
	/**
	 * method to register a spotComment
	 * 
	 * @param body
	 * @param author
	 * @param spot
	 * @return spotComment object saved
	 * @throws Exception
	 */
	SpotComment register(String body, User author, Spot spot) throws Exception;
	
	/**
	 * method to modify a spotComment
	 * 
	 * @param spotComment
	 * @return spotComment object modified
	 * @throws Exception
	 */
	SpotComment edit(SpotComment spotComment) throws Exception;
	
	/**
	 * method to get a spotComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param spotComment
	 * @return spotComment object
	 * @throws Exception
	 */
	SpotComment getSpotComment(Long id) throws Exception;
	
	/**
	 * method to get all spotComments
	 * 
	 * UTILE ?
	 * 
	 * @return the spotComment list 
	 */
	List<SpotComment> getAllSpotComments();
	
	/**
	 * method to get all spotComments by his spot
	 * 
	 * @param spot
	 * @return the spotComment list with his spot
	 * @throws Exception
	 */
	List<SpotComment> getAllCommentBySpot(Spot spot) throws Exception;


}
