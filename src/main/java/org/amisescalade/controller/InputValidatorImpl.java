package org.amisescalade.controller;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class InputValidatorImpl implements IInputValidator{

	private static final Logger log = LogManager.getLogger(InputValidatorImpl.class);
	
	// regex 
	private String character = "[^A-Za-z]";
	private String number = "[^0-9]";
	private String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";

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

	public Boolean ValidateCharacter(String input) throws Exception {
		
		Boolean validate = false;
		
		if(input != null) {
						
			if(input.matches(character)) {
			
				validate = true;
			
			}else {
				
				log.error("que des caractere A-z");

				throw new Exception("que des caractere A-z");
			}
			
		}else {
			
			log.error("Champ vide");

			throw new Exception("champ vide !");
			
		}
		
		
		return validate;

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
