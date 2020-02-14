package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.TopoComment;
import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.services.ITopoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TopoCommentControllerImpl implements ITopoCommentController{
	
	@Autowired
	private ITopoCommentService iTopoCommentService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public TopoComment addTopoComment(String body, User author, Topo topo) {
		
		TopoComment topoCommentSave = new TopoComment();

		try {
			topoCommentSave = iTopoCommentService.register(body, author, topo);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return topoCommentSave;
	}

	@Override
	public TopoComment editTopoComment(TopoComment topoComment) {
		
		TopoComment topoCommentEdit = new TopoComment();

		try {
			topoCommentEdit = iTopoCommentService.edit(topoComment);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return topoCommentEdit;
	}

	@Override
	public TopoComment displayTopoComment(Long id) {
		
		TopoComment topoCommentFind = new TopoComment();

		try {
			topoCommentFind = iTopoCommentService.getTopoComment(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return topoCommentFind;
	}

	@Override
	public List<TopoComment> displayAllTopoCommentByTopo(Topo topo) {
		
		List<TopoComment> topoCommentList = null;

		try {
			topoCommentList = iTopoCommentService.getAllTopoCommentsByTopo(topo);
		} catch (Exception e) {
			
			this.errorMessage = e.getMessage();
		}
		return topoCommentList;
	}


}
