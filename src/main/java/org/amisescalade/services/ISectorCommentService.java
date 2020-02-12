package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;

public interface ISectorCommentService {
	
	/**
	 * method to register a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment object saved
	 * @throws Exception
	 */
	SectorComment register(SectorComment sectorComment) throws Exception;
	
	/**
	 * method to modify a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment object modified
	 * @throws Exception
	 */
	SectorComment edit(SectorComment sectorComment) throws Exception;
	
	/**
	 * method to display a sectorComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param sectorComment
	 * @return sectorComment object
	 * @throws Exception
	 */
	SectorComment displayOne(Long id) throws Exception;
	
	/**
	 * method to display all sectorComments
	 * 
	 * UTILE ?
	 * 
	 * @return the sectorComment list 
	 */
	List<SectorComment> displayAll();
	
	/**
	 * method to display all sectorComment for a sector
	 * 
	 * @param sector
	 * @return the sectorComment list from a sector
	 * @throws Exception
	 */
	List<SectorComment> displayBySector(Sector sector) throws Exception;

}
