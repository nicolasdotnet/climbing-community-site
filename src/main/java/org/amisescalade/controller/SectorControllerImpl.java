package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.Sector;
import org.amisescalade.entity.Spot;
import org.amisescalade.entity.SpotComponent;
import org.amisescalade.entity.Webpage;
import org.amisescalade.services.ISectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SectorControllerImpl implements ISectorController {

	@Autowired
	private ISectorService iSectorService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Sector addSectorBySpot(String sectorName, String sectorRate, String sectorDescription,
			String sectorAccessPath, Spot spot) {

		Sector sectorSave = new Sector();

		try {
			sectorSave = iSectorService.registerBySpot(sectorName, sectorRate, sectorDescription, sectorAccessPath,
					spot);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorSave;
	}

	@Override
	public Sector addSectorByDefault(String sectorName, String sectorRate, String sectorDescription,
			String sectorAccessPath) {

		Sector sectorSave = new Sector();

		try {
			sectorSave = iSectorService.registerByDefault(sectorName, sectorRate, sectorDescription, sectorAccessPath);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorSave;
	}

	@Override
	public Sector editSector(Sector sector) {

		Sector sectorEdit = new Sector();

		try {
			sectorEdit = iSectorService.edit(sector);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return sectorEdit;
	}

	@Override
	public Sector displaySector(Long id) {

		Sector sectorFind = new Sector();

		try {
			sectorFind = iSectorService.getSector(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorFind;
	}

	@Override
	public List<Sector> displayAllSectorsByName(String sectorName) {

		List<Sector> sectorList = null;

		try {
			sectorList = iSectorService.getAllSectorsByName(sectorName);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorList;
	}

	@Override
	public List<Sector> displayAllSectorsBySpot(Spot spot) {

		List<Sector> sectorList = null;

		try {
			sectorList = iSectorService.getAllSectorsBySpot(spot);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorList;
	}

	@Override
	public List<Sector> displayAllSectors() {

		return iSectorService.getAllSectors();
	}

}
