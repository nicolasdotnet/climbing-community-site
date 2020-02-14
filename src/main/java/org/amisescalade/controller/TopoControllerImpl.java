package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Topo;
import org.amisescalade.entity.User;
import org.amisescalade.services.ITopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TopoControllerImpl implements ITopoController{
	
	@Autowired
	private ITopoService iTopoService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Topo addTopo(String topoArea, String topoTitle, String topoDescription, User topoOwner) {
		
		Topo topoSave = new Topo();

		try {
			topoSave = iTopoService.register(topoArea, topoTitle, topoDescription, topoOwner);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return topoSave;
	}

	@Override
	public Topo editTopo(Topo topo) {
		
		Topo topoEdit = new Topo();

		try {
			topoEdit = iTopoService.edit(topo);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return topoEdit;
	}

	@Override
	public Topo displayTopo(Long id) {
		
		Topo topoFind = new Topo();

		try {
			topoFind = iTopoService.getTopo(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return topoFind;
	}

	@Override
	public List<Topo> displayAllTopos() {

		return iTopoService.getAllTopos();
	}

	@Override
	public List<Topo> displayTopoByTitle(String topoTitle) {
		
		List<Topo> topoComponentList = null;

		try {
			topoComponentList = iTopoService.getTopoByTitle(topoTitle);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return topoComponentList;
	}

}
