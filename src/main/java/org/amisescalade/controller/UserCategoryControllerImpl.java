package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.UserCategory;
import org.amisescalade.services.IUserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserCategoryControllerImpl implements IUserCategoryController {

	@Autowired
	private IUserCategoryService iUserCategoryService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public UserCategory addUserCategory(String userCategoryLabel) {
		// TODO check saisie !

		UserCategory userCategorySave = new UserCategory();

		try {
			userCategorySave = iUserCategoryService.register(userCategoryLabel);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return userCategorySave;
	}
	
	@Override
	public UserCategory editUserCategory(UserCategory userCategory) {
		UserCategory userCategoryEdit = new UserCategory();

		try {
			userCategoryEdit = iUserCategoryService.edit(userCategory);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return userCategoryEdit;
	}

	@Override
	public UserCategory displayUserCategory(Long id) {

		UserCategory userCategoryFind = new UserCategory();

		try {
			userCategoryFind = iUserCategoryService.getUserCategory(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return userCategoryFind;
	}

	@Override
	public List<UserCategory> displayAllUserCategory() {

		return iUserCategoryService.getAllUserCategory();
	}

	@Override
	public List<UserCategory> displayUserCategoryByLabel(String label) {

		return iUserCategoryService.getUserCategoryByLabel(label);
	}
}
