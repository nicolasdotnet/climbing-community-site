package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.entity.User;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.services.ISpotCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpotCommentControllerImpl implements ISpotCommentController {

	@Autowired
	private ISpotCommentService iSpotCommentService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public SpotComment addSpotComment(String body, User author, Spot spot) {

		SpotComment spotCommentSave = new SpotComment();

		try {
			spotCommentSave = iSpotCommentService.register(body, author, spot);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotCommentSave;
	}

	@Override
	public SpotComment editSectorComponent(SpotComment spotComment) {

		SpotComment spotCommentEdit = new SpotComment();

		try {
			spotCommentEdit = iSpotCommentService.edit(spotComment);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return spotCommentEdit;
	}

	@Override
	public SpotComment displaySpotComment(Long id) {

		SpotComment spotCommentFind = new SpotComment();

		try {
			spotCommentFind = iSpotCommentService.getSpotComment(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotCommentFind;
	}

	@Override
	public List<SpotComment> displayAllSpotCommentBySpot(Spot spot) {

		List<SpotComment> spotCommentList = null;

		try {
			spotCommentList = iSpotCommentService.getAllCommentBySpot(spot);
		} catch (Exception e) {
			
			this.errorMessage = e.getMessage();
		}
		return spotCommentList;
	}

}
