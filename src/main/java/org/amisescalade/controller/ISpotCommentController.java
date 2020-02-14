package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;

public interface ISpotCommentController {
	
	/**
	 * method adding a comment to spot page
	 * 
	 * @param body
	 * @param author
	 * @param spot
	 * @return SpotComment object added
	 */
	public SpotComment addSpotComment(String body, User author, Spot spot);
	
	/**
	 * method to modify a spotComment
	 * 
	 * @param spotComment
	 * @return spotComment object modified
	 * @throws Exception
	 */
	public SpotComment editSectorComponent (SpotComment spotComment);
	
	/**
	 * method for display a spot page comment
	 * 
	 * @param id
	 * @return SpotComment object to display
	 */
	public SpotComment displaySpotComment(Long id);
	
	/**
	 * method for display all comments for a spot page
	 * 
	 * @param spot
	 * @return the SpotComment list by spot page
	 * @throws Exception
	 */
	public List<SpotComment> displayAllSpotCommentBySpot(Spot spot) throws Exception;

}
