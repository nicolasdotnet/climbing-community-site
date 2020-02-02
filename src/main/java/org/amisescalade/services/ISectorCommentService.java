package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;

public interface ISectorCommentService {
	
	/**
	 * method to register a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment Object save
	 * @throws Exception
	 */
	SectorComment register(SectorComment sectorComment) throws Exception;
	
	/**
	 * method to modify a sectorComment
	 * 
	 * @param sectorComment
	 * @return sectorComment Object modify
	 * @throws Exception
	 */
	SectorComment edit(SectorComment sectorComment) throws Exception;
	
	/**
	 * method to display one sectorComment by his id
	 * 
	 * UTILE ?
	 * 
	 * @param sectorComment
	 * @return sectorComment Object to display
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
	 * method to display one sectorComment by his sector
	 * 
	 * @param sector
	 * @return the sectorComment list with his sector to display
	 * @throws Exception
	 */
	List<SectorComment> displayBySector(Sector sector) throws Exception;

}
