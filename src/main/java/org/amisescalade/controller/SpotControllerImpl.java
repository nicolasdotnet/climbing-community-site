package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Spot;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComment;
import org.amisescalade.services.ISpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SpotControllerImpl implements ISpotController {

	@Autowired
	private ISpotService iSpotService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Spot addSpot(String spotName, String spotRate, String spotDescription, String spotAccessPath,
			String departement, String country) {

		Spot spotSave = new Spot();

		try {
			spotSave = iSpotService.register(spotName, spotRate, spotDescription, spotAccessPath, departement, country);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotSave;
	}

	@Override
	public Spot editSpot(Spot spot) {

		Spot spotEdit = new Spot();

		try {
			spotEdit = iSpotService.edit(spot);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return spotEdit;
	}

	@Override
	public Spot displaySpot(Long id) {

		Spot spotFind = new Spot();

		try {
			spotFind = iSpotService.getSpot(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotFind;
	}

	@Override
	public List<Spot> displaySpotByName(String spotName) {

		List<Spot> spotList = null;

		try {
			spotList = iSpotService.getAllSpotsByName(spotName);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return spotList;
	}

	@Override
	public List<Spot> displayAllSpots() {
		
		return iSpotService.getAllSpots();
	}

    @Override
    public void removeSpot(Long id) {
        
        iSpotService.delete(id);
        
    }

    @Override
    public List<Spot> searchSpots(String spotName, String spotRate, String departement) {
        return iSpotService.getAllSpotsByNameRateDepartement(spotName,spotRate,departement);
    }
}
