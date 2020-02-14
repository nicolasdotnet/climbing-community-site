package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComment;
import org.amisescalade.entity.User;
import org.amisescalade.services.ISectorCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SectorCommentControllerImpl implements ISectorCommentController{
	
	@Autowired
	private ISectorCommentService iSectorCommentService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public SectorComment addSectorComment(String body, User author, Sector sector) {
		
		SectorComment sectorCommentSave = new SectorComment();

		try {
			sectorCommentSave = iSectorCommentService.register(body, author, sector);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorCommentSave;
	}

	@Override
	public SectorComment editSectorComponent(SectorComment sectorComment) {
		
		SectorComment sectorCommentEdit = new SectorComment();

		try {
			sectorCommentEdit = iSectorCommentService.edit(sectorComment);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return sectorCommentEdit;
	}

	@Override
	public SectorComment displaySectorComment(Long id) {
		
		SectorComment sectorCommentFind = new SectorComment();

		try {
			sectorCommentFind = iSectorCommentService.getSectorComment(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorCommentFind;
	}

	@Override
	public List<SectorComment> displayAllSectorCommentBySector(Sector sector) throws Exception {
		
		List<SectorComment> sectorCommentList = null;

		try {
			sectorCommentList = iSectorCommentService.getCommentBySector(sector);
		} catch (Exception e) {
			
			this.errorMessage = e.getMessage();
		}
		return sectorCommentList;
	}


}
