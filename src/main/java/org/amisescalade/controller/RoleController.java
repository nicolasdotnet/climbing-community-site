package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.amisescalade.services.IRoleService;

@Component
@Transactional
public class RoleController {

	@Autowired
	private IRoleService iUserCategoryService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public Role addUserCategory(String userCategoryLabel) {
		// TODO check saisie !

		Role userCategorySave = new Role();

		try {
			userCategorySave = iUserCategoryService.register(userCategoryLabel);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return userCategorySave;
	}
	
	public Role editUserCategory(Role userCategory) {
		Role userCategoryEdit = new Role();

		try {
			userCategoryEdit = iUserCategoryService.edit(userCategory);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return userCategoryEdit;
	}

	public Role displayUserCategory(Long id) {

		Role userCategoryFind = new Role();

		try {
			userCategoryFind = iUserCategoryService.getUserCategory(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return userCategoryFind;
	}

	public List<Role> displayAllUserCategory() {

		return iUserCategoryService.getAllUserCategory();
	}

	public List<Role> displayUserCategoryByLabel(String label) {

		return iUserCategoryService.getUserCategoryByLabel(label);
	}
}
