package org.amisescalade.services;

import java.util.List;

import org.amisescalade.entity.ComponentCategory;
import org.amisescalade.entity.UserCategory;

public interface IComponentCategoryService {
	
	/**
	 * method to register a componentCategory
	 * 
	 * @param componentCategoryLabel
	 * @return componentCategory object saved
	 * @throws Exception
	 */
	ComponentCategory register(String componentCategoryLabel) throws Exception;
	
	/**
	 * method to modify a componentCategory
	 * 
	 * @param componentCategory
	 * @return componentCategory object modified
	 * @throws Exception
	 */
	ComponentCategory edit(ComponentCategory componentCategory) throws Exception;
	
	/**
	 * method to get a component category
	 * 
	 * @param id
	 * @return componentCategory object find
	 * @throws Exception 
	 */
	ComponentCategory getComponentCategory(Long id) throws Exception;
	
	/**
	 * method to get all components category
	 * 
	 * @return the component category list
	 */
	List<ComponentCategory> getAllComponentCategory();
	
	/**
	 * method to get a component category list by label
	 * 
	 * @param label
	 * @return ComponentCategory object list find by label
	 */
	List<ComponentCategory> getComponentCategoryByLabel(String label);


}
