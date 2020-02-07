package org.amisescalade.controller;

import java.util.List;

import org.amisescalade.entity.User;
import org.amisescalade.entity.Webpage;
import org.amisescalade.services.IWebpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class WebpageControllerImpl implements IWebpageController {

	@Autowired
	private IWebpageService iWebpageService;

	@Autowired
	private IInputValidator inputValidator;

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public Webpage addWebpage(String title, String body, User author) {

		Webpage webpageSave = new Webpage();

		try {
			webpageSave = iWebpageService.register(title, body, author);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return webpageSave;

	}

	@Override
	public Webpage editWebpage(Webpage webpage) {

		Webpage webpageEdit = new Webpage();

		try {
			webpageEdit = iWebpageService.edit(webpage);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}

		return webpageEdit;
	}

	@Override
	public Webpage displayWebpage(Long id) {

		Webpage webpageFind = new Webpage();

		try {
			webpageFind = iWebpageService.getWebpage(id);
		} catch (Exception e) {

			this.errorMessage = e.getMessage();
		}
		return webpageFind;
	}

	@Override
	public List<Webpage> displayAllWebpage() {

		return iWebpageService.getAllWebpage();
	}
}
