package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;

public interface IComponentCategoryService {
	
	/**
	 * method to register a componentCategory
	 * 
	 * @param componentCategory
	 * @return componentCategory Object save
	 * @throws Exception
	 */
	ComponentCategory register(ComponentCategory componentCategory) throws Exception;
	
	/**
	 * method to modify a componentCategory
	 * 
	 * @param componentCategory
	 * @return componentCategory Object modify
	 * @throws Exception
	 */
	ComponentCategory edit(ComponentCategory componentCategory) throws Exception;
	
	/**
	 * method to display all component category
	 * 
	 * @return the component category list
	 */
	List<ComponentCategory> displayAll();

}
