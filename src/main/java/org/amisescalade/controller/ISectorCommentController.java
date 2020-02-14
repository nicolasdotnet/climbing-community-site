package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.User;

public interface ISectorCommentController {
	
	/**
	 * method adding a comment to sector page
	 * 
	 * @param body
	 * @param author
	 * @param sector
	 * @return SectorComment object added
	 */
	public SectorComment addSectorComment(String body, User author, Sector sector);
	
	/**
	 * method to modify a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment object modified
	 * @throws Exception
	 */
	public SectorComment editSectorComponent (SectorComment sectorComment);
	
	/**
	 * method for display a sector page comment
	 * 
	 * @param id
	 * @return SectorComment object to display
	 */
	public SectorComment displaySectorComment(Long id);
	
	/**
	 * method for display all comments for a sector page
	 * 
	 * @param sector
	 * @return the SectorComment list by sector page
	 * @throws Exception
	 */
	public List<SectorComment> displayAllSectorCommentBySector(Sector sector) throws Exception;

}
