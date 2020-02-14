package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;

public interface IComponentCategoryController {
	
	/**
	 * method adding a component category
	 * 
	 * @param componentCategoryLabel
	 * @return componentCategory object added
	 */
	public ComponentCategory addComponentCategory(String componentCategoryLabel);
	
	/**
	 * method editing a component category
	 * 
	 * @param componentCategory
	 * @return componentCategory object modified
	 */
	public ComponentCategory editComponentCategory(ComponentCategory componentCategory);
	
	/**
	 * method for display a component category
	 * 
	 * @param id
	 * @return componentCategory object to display
	 */
	public ComponentCategory displayComponentCategory(Long id);
	
	/**
	 * method for display all components category by his label
	 * 
	 * @param label
	 * @return the component category list by label
	 */
	public List<ComponentCategory> displayComponentCategoryByLabel(String label);
	
	/**
	 * method for display all components category
	 * 
	 * @return the component category list
	 */
	public List<ComponentCategory> displayAllComponentCategory();
	
	

}
