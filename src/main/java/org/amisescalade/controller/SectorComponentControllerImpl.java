package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.Sector;
import org.amisescalade.entity.SectorComponent;
import org.amisescalade.entity.SectorComponent;
import org.amisescalade.services.ISectorComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SectorComponentControllerImpl implements ISectorComponentController {

	@Autowired
	private ISectorComponentService iSectorComponentService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public SectorComponent addSectorComponent(String componentCode, String componentName, String componentRate,
			String componentDescription, ComponentCategory componentCategory,Sector sector) {

		SectorComponent sectorComponentSave = new SectorComponent();

		try {
			sectorComponentSave = iSectorComponentService.register(componentCode, componentName, componentRate,
					componentDescription, componentCategory, sector);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sectorComponentSave;
	}

	@Override
	public SectorComponent editSectorComponent(SectorComponent sectorComponent) {

		SectorComponent sectorComponentEdit = new SectorComponent();

		try {
			sectorComponentEdit = iSectorComponentService.edit(sectorComponent);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return sectorComponentEdit;
	}

	@Override
	public SectorComponent displaySectorComponent(Long id) {

		SectorComponent sectorComponentFind = new SectorComponent();

		try {
			sectorComponentFind = iSectorComponentService.getSectorComponent(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorComponentFind;
	}

	@Override
	public List<SectorComponent> displaySectorComponentByName(String sectorComponentName) {

		List<SectorComponent> sectorComponentList = null;

		try {
			sectorComponentList = iSectorComponentService.getAllSectorComponentByName(sectorComponentName);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorComponentList;
	}

	@Override
	public List<SectorComponent> displayAllSectorComponentBySector(Sector sector) throws Exception {
		List<SectorComponent> sectorComponentList = null;
		try {
			sectorComponentList = iSectorComponentService.getAllSectorComponentBySector(sector);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return sectorComponentList;
	}

}
