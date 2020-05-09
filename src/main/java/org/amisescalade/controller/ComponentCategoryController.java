package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.services.interfaces.IComponentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional
public class ComponentCategoryController{
	
	@Autowired
	private IComponentCategoryService iComponentCategoryService;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

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

	public ComponentCategory editComponentCategory(ComponentCategory componentCategory) {
		
		ComponentCategory componentCategoryEdit = new ComponentCategory();

		try {
			componentCategoryEdit = iComponentCategoryService.edit(componentCategory);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return componentCategoryEdit;
	}

	public ComponentCategory displayComponentCategory(Long id) {

		ComponentCategory componentCategoryFind = new ComponentCategory();

		try {
			componentCategoryFind = iComponentCategoryService.getComponentCategory(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return componentCategoryFind;
	}

	public List<ComponentCategory> displayComponentCategoryByLabel(String label) {
		
		return iComponentCategoryService.getComponentCategoryByLabel(label);
	}

	public List<ComponentCategory> displayAllComponentCategory() {
		
		return iComponentCategoryService.getAllComponentCategory();
	}

}
