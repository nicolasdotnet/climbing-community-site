package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.User;

public interface ISectorCommentService {
	
	/**
	 * method to register a sectorComment
	 * 
	 * @param body
	 * @param author
	 * @param sector
	 * @return sectorComment object saved
	 * @throws Exception
	 */
	SectorComment register(String body, User author, Sector sector)throws Exception;
	
	/**
	 * method to modify a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment object modified
	 * @throws Exception
	 */
	SectorComment edit(SectorComment sectorComment) throws Exception;
	
	/**
	 * method to get a sectorComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param sectorComment
	 * @return sectorComment object
	 * @throws Exception
	 */
	SectorComment getSectorComment(Long id) throws Exception;
	
	/**
	 * method to get all sectorComments
	 * 
	 * UTILE ?
	 * 
	 * @return the sectorComment list 
	 */
	List<SectorComment> getAllSectorComments();
	
	/**
	 * method to get all sectorComments for a sector
	 * 
	 * @param sector
	 * @return the sectorComment list from a sector
	 * @throws Exception
	 */
	List<SectorComment> getCommentBySector(Sector sector) throws Exception;

}
