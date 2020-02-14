package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;
import org.amisescalade.services.ISpotComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpotComponentControllerImpl implements ISpotComponentController {

	@Autowired
	private ISpotComponentService iSpotComponentService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public SpotComponent addSpotComponent(String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory, Spot spot) {

		SpotComponent spotComponentSave = new SpotComponent();

		// vérifier si le spot n'est pas rattaché à un sector

		if (spot.getSector() != null) {
			// s'ajoute component

			try {
				spotComponentSave = iSpotComponentService.register(componentCode, componentName, componentRate,
						componentDescription, componentCategory, spot);
			} catch (Exception e) {

				this.errorMessage = e.getMessage();
			}

		} else {
			
			this.errorMessage = "ajout d'un composant impossible. Le spot contient un secteur";
		}

		return spotComponentSave;
	}

	@Override
	public SpotComponent editSpotComponent(SpotComponent spotComponent) {

		SpotComponent spotComponentEdit = new SpotComponent();

		try {
			spotComponentEdit = iSpotComponentService.edit(spotComponent);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return spotComponentEdit;
	}

	@Override
	public SpotComponent displaySpotComponent(Long id) {

		SpotComponent spotComponentFind = new SpotComponent();

		try {
			spotComponentFind = iSpotComponentService.getSpotComponent(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotComponentFind;
	}

	@Override
	public List<SpotComponent> displayAllSpotComponentByName(String spotComponentName) {
		
		List<SpotComponent> spotComponentList = null;
		
		try {
			spotComponentList = iSpotComponentService.getAllSpotComponentByName(spotComponentName);
		} catch (Exception e) {
			
			this.errorMessage = e.getMessage();
		}
		return spotComponentList;
	}

	@Override
	public List<SpotComponent> displayAllSpotComponentBySpot(Spot spot) {
		
		List<SpotComponent> spotComponentList = null;
		try {
			spotComponentList = iSpotComponentService.getAllSpotComponentBySpot(spot);
		} catch (Exception e) {
			
			this.errorMessage = e.getMessage();
	}
		return spotComponentList;}

}
