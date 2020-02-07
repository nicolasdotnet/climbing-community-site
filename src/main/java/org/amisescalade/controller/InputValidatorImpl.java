package org.amisescalade.controller;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class InputValidatorImpl implements IInputValidator{

	private static final Logger log = LogManager.getLogger(InputValidatorImpl.class);

	/**
	 * private Constructor
	 */
	public InputValidatorImpl() {
	}

	/**
	 * Single instance pre-initialized
	 */
	private static InputValidatorImpl INSTANCE = new InputValidatorImpl();

	/**
	 * Access point for singleton single instance
	 */
	public static InputValidatorImpl getInstance() {
		return INSTANCE;
	}

	public Boolean ValidateCharacter(String input) {
		return null;

	}

	public Boolean ValidateNumber(String input) {
		return null;

	}
	
	public Boolean ValidateAlphanumeric(String input) {
		return null;

	}
	
	public Boolean ValidateEmail(String input) {
		return null;

	}
	
	public Boolean ValidateEmpty (String input) {
		return null;
		
		
	}

}
