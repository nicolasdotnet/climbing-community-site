package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.UserCategory;
import org.amisescalade.services.IComponentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ComponentCategoryControllerImpl implements IComponentCategoryController{
	
	@Autowired
	private IComponentCategoryService iComponentCategoryService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public ComponentCategory addComponentCategory(String componentCategoryLabel) {
		// TODO check saisie !

		ComponentCategory componentCategorySave = new ComponentCategory();

				try {
					componentCategorySave = iComponentCategoryService.register(componentCategoryLabel);
				} catch (Exception e) {

					this.errorMessage = e.getMessage();
				}
				return componentCategorySave;
			}

	@Override
	public ComponentCategory editComponentCategory(ComponentCategory componentCategory) {
		
		ComponentCategory componentCategoryEdit = new ComponentCategory();

		try {
			componentCategoryEdit = iComponentCategoryService.edit(componentCategory);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return componentCategoryEdit;
	}

	@Override
	public ComponentCategory displayComponentCategory(Long id) {

		ComponentCategory componentCategoryFind = new ComponentCategory();

		try {
			componentCategoryFind = iComponentCategoryService.getComponentCategory(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return componentCategoryFind;
	}

	@Override
	public List<ComponentCategory> displayComponentCategoryByLabel(String label) {
		
		return iComponentCategoryService.getComponentCategoryByLabel(label);
	}

	@Override
	public List<ComponentCategory> displayAllComponentCategory() {
		
		return iComponentCategoryService.getAllComponentCategory();
	}

}
